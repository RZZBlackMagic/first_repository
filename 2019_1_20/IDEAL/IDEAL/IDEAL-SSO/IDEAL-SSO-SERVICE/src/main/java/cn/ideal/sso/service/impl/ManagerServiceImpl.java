package cn.ideal.sso.service.impl;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.utils.JsonUtils;
import cn.ideal.jedis.JedisClient;
import cn.ideal.mapper.AccountManagerMapper;
import cn.ideal.pojo.AccountManager;
import cn.ideal.pojo.AccountManagerExample;
import cn.ideal.sso.service.ManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private AccountManagerMapper accountManagerMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${MANAGER_SESSION}")
    private String MANAGER_SESSION;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public MessageResult checkData(String data, int type) {
        AccountManagerExample example = new AccountManagerExample();
        AccountManagerExample.Criteria criteria = example.createCriteria();
        //数据可以使用
        return MessageResult.ok(true);
    }

    @Override
    public MessageResult register(AccountManager manager) {
        //检查数据的有效性
        if (StringUtils.isBlank(manager.getUsername())) {
            return MessageResult.build(400, "用户名不能为空");
        }
        //判断用户名是否重复
        MessageResult messageResult = checkData(manager.getUsername(), 1);
        if (!(boolean) messageResult.getData()) {
            return MessageResult.build(400, "用户名重复");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(manager.getPassword())) {
            return MessageResult.build(400, "密码不能为空");
        }

        //补全pojo的属性
        manager.setCreated(new Date());
        manager.setUpdated(new Date());
        //密码要进行md5加密
        String md5Pass = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
        manager.setPassword(md5Pass);
        //插入数据
        accountManagerMapper.insert(manager);
        //返回注册成功
        return MessageResult.ok();
    }

    @Override
    public MessageResult login(String username, String password) {
        //判断用户名和密码是否正确
        AccountManagerExample example = new AccountManagerExample();
        AccountManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AccountManager> list = accountManagerMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            //返回登录失败
            return MessageResult.build(400, "用户名或密码不正确");
        }
        AccountManager manager = list.get(0);
        //密码要进行md5加密然后再校验
        if (!DigestUtils.md5DigestAsHex(password.getBytes())
                .equals(manager.getPassword())) {
            //返回登录失败
            return MessageResult.build(400, "用户名或密码不正确");
        }
        //生成token，使用uuid
        String token = UUID.randomUUID().toString();
        //清空密码
        manager.setPassword(null);
        //把用户信息保存到redis，key就是token，value就是用户信息
        jedisClient.set(MANAGER_SESSION + ":" + token, JsonUtils.objectToJson(manager));
        //设置key的过期时间
        jedisClient.expire(MANAGER_SESSION + ":" + token, SESSION_EXPIRE);
        //返回登录成功，其中要把token返回。
        return MessageResult.ok(token);
    }

    @Override
    public MessageResult getManagerByToken(String token) {
        String json = jedisClient.get(MANAGER_SESSION + ":" + token);
        if (StringUtils.isBlank(json)) {
            return MessageResult.build(400, "用户登录已经过期");
        }
        //重置Session的过期时间
        jedisClient.expire(MANAGER_SESSION + ":" + token, SESSION_EXPIRE);
        //把json转换成User对象
        AccountManager user = JsonUtils.jsonToPojo(json, AccountManager.class);
        return MessageResult.ok(user);
    }

    @Override
    public MessageResult logout(String token){
        jedisClient.hdel(MANAGER_SESSION, token);
        return MessageResult.ok();
    }
}
