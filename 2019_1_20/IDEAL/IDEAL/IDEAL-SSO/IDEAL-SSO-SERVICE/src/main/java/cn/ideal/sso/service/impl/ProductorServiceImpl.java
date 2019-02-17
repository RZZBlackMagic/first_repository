package cn.ideal.sso.service.impl;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.utils.JsonUtils;
import cn.ideal.jedis.JedisClient;
import cn.ideal.mapper.AccountProductorMapper;
import cn.ideal.pojo.AccountProductor;
import cn.ideal.pojo.AccountProductorExample;
import cn.ideal.sso.service.ProductorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductorServiceImpl implements ProductorService {

    @Autowired
    private AccountProductorMapper productorMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${PRODUCTOR_SESSION}")
    private String PRODUCTOR_SESSION;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public MessageResult checkData(String data, int type) {
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        // 1-判断用户名是否可用
        if (type == 1){
            criteria.andUsernameEqualTo(data);
        }
        //2-判断手机号是否可用
        else if (type == 2){
            criteria.andPhoneEqualTo(data);
        }
        //3-判断邮箱是否可以
        else if (type == 3){
            criteria.andEmailEqualTo(data);
        }
        //返回失败
        else {
            return MessageResult.build(400, "非法数据");
        }

        //执行查询
        List<AccountProductor> accountProductosList = productorMapper.selectByExample(example);

        if (accountProductosList != null && accountProductosList.size() > 0) {
            //查询到数据,数据不可用
            return MessageResult.ok(false);
        }
        //数据可以使用
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult register(AccountProductor productor) {
        //检查数据的有效性
        if (StringUtils.isBlank(productor.getUsername())) {
            return MessageResult.build(400, "用户名不能为空");
        }
        //判断用户名是否重复
        MessageResult messageResult = checkData(productor.getUsername(), 1);
        if (!(boolean) messageResult.getData()) {
            return MessageResult.build(400, "用户名重复");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(productor.getPassword())) {
            return MessageResult.build(400, "密码不能为空");
        }
        if (StringUtils.isNotBlank(productor.getPhone())) {
            //是否重复校验
            messageResult = checkData(productor.getPhone(), 2);
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "电话号码重复");
            }
        }
        //如果email不为空的话进行是否重复校验
        if (StringUtils.isNotBlank(productor.getEmail())) {
            //是否重复校验
            messageResult = checkData(productor.getEmail(), 3);
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "email重复");
            }
        }
        //补全pojo的属性
        productor.setCreated(new Date());
        productor.setUpdated(new Date());
        productor.setStatus(0);
        //密码要进行md5加密
        String md5Pass = DigestUtils.md5DigestAsHex(productor.getPassword().getBytes());
        productor.setPassword(md5Pass);
        //插入数据
        productorMapper.insert(productor);
        //返回注册成功
        return MessageResult.ok();
    }

    @Override
    public MessageResult login(String username, String password) {
        //判断用户名和密码是否正确
        AccountProductorExample example = new AccountProductorExample();
        AccountProductorExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AccountProductor> list = productorMapper.selectByExample(example);
        System.out.println(list);
        if (list == null || list.size() == 0) {
            //返回登录失败
            return MessageResult.build(400, "用户名或密码不正确");
        }
        AccountProductor productor = list.get(0);
        //密码要进行md5加密然后再校验
        if (!DigestUtils.md5DigestAsHex(password.getBytes())
                .equals(productor.getPassword())) {
            //返回登录失败
            return MessageResult.build(400, "用户名或密码不正确");
        }
        if (productor.getStatus() != 1){
            //返回登录失败
            return MessageResult.build(400, "管理员审核未通过");
        }
        //生成token，使用uuid
        String token = UUID.randomUUID().toString();
        //清空密码
        productor.setPassword(null);
        //把用户信息保存到redis，key就是token，value就是用户信息
        jedisClient.set(PRODUCTOR_SESSION + ":" + token, JsonUtils.objectToJson(productor));
        //设置key的过期时间
        jedisClient.expire(PRODUCTOR_SESSION + ":" + token, SESSION_EXPIRE);
        //返回登录成功，其中要把token返回。
        return MessageResult.ok(token);
    }

    @Override
    public MessageResult getProductorByToken(String token) {
        String json = jedisClient.get(PRODUCTOR_SESSION + ":" + token);
        if (StringUtils.isBlank(json)) {
            return MessageResult.build(400, "用户登录已经过期");
        }
        //重置Session的过期时间
        jedisClient.expire(PRODUCTOR_SESSION + ":" + token, SESSION_EXPIRE);
        //把json转换成User对象
        AccountProductor productor = JsonUtils.jsonToPojo(json, AccountProductor.class);
        return MessageResult.ok(productor);
    }

    @Override
    public MessageResult logout(String token) {
        jedisClient.hdel(PRODUCTOR_SESSION, token);
        return MessageResult.ok();
    }
}
