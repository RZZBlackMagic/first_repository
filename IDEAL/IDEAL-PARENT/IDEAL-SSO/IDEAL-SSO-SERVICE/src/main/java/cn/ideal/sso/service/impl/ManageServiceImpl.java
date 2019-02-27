package cn.ideal.sso.service.impl;

import cn.ideal.common.mapper.AccountManagerMapper;
import cn.ideal.common.mapper.AccountMerchantMapper;
import cn.ideal.common.mapper.AccountProductorMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.utils.JsonUtils;
import cn.ideal.jedis.JedisClient;
import cn.ideal.sso.service.ManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private AccountProductorMapper productorMapper;
    @Autowired
    private AccountManagerMapper managerMapper;
    @Autowired
    private AccountMerchantMapper merchantMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${PRODUCT_SESSION}")
    private String PRODUCT_SESSION;
    @Value("${MANAGER_SESSION}")
    private String MANAGER_SESSION;
    @Value("${MERCHANT_SESSION")
    private String MERCHANT_SESSION;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public MessageResult checkData(String user_type, int data_type, String data) {
        if (user_type.compareTo("PRODUCT") == 0) {
            AccountProductorExample example = new AccountProductorExample();
            AccountProductorExample.Criteria criteria = example.createCriteria();
            //设置查询条件
            // 1-判断用户名是否可用
            if (data_type == 1) {
                criteria.andUsernameEqualTo(data);
            }
            //2-判断手机号是否可用
            else if (data_type == 2) {
                criteria.andPhoneEqualTo(data);
            }
            //3-判断邮箱是否可以
            else if (data_type == 3) {
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
        else if(user_type.compareTo("MANAGER") == 0){
            AccountManagerExample example = new AccountManagerExample();
            AccountManagerExample.Criteria criteria = example.createCriteria();
            //设置查询条件
            // 1-判断用户名是否可用
            if (data_type == 1) {
                criteria.andUsernameEqualTo(data);
            }
            //2-判断手机号是否可用
            else if (data_type == 2) {
                criteria.andPhoneEqualTo(data);
            }
            //3-判断邮箱是否可以
            else if (data_type == 3) {
                criteria.andEmailEqualTo(data);
            }
            //返回失败
            else {
                return MessageResult.build(400, "非法数据");
            }

            //执行查询
            List<AccountManager> managerList = managerMapper.selectByExample(example);

            if (managerList != null && managerList.size() > 0) {
                //查询到数据,数据不可用
                return MessageResult.ok(false);
            }
            //数据可以使用
            return MessageResult.ok(true);

        }
        else if(user_type.compareTo("MERCHANT") == 0){
            AccountMerchantExample example = new AccountMerchantExample();
            AccountMerchantExample.Criteria criteria = example.createCriteria();
            //设置查询条件
            // 1-判断用户名是否可用
            if (data_type == 1) {
                criteria.andUsernameEqualTo(data);
            }
            //2-判断手机号是否可用
            else if (data_type == 2) {
                criteria.andPhoneEqualTo(data);
            }
            //3-判断邮箱是否可以
            else if (data_type == 3) {
                criteria.andEmailEqualTo(data);
            }
            //返回失败
            else {
                return MessageResult.build(400, "非法数据");
            }

            //执行查询
            List<AccountMerchant> merchantList = merchantMapper.selectByExample(example);

            if (merchantList != null && merchantList.size() > 0) {
                //查询到数据,数据不可用
                return MessageResult.ok(false);
            }
            //数据可以使用
            return MessageResult.ok(true);

        }
        return MessageResult.ok(false);
    }

    @Override
    public MessageResult managerRegister(AccountManager manager) {
        //检查数据的有效性
        if (StringUtils.isBlank(manager.getUsername())) {
            return MessageResult.build(400, "用户名不能为空");
        }
        //判断用户名是否重复
        MessageResult messageResult = checkData("MANAGER",1, manager.getUsername());
        if (!(boolean) messageResult.getData()) {
            return MessageResult.build(400, "用户名重复");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(manager.getPassword())) {
            return MessageResult.build(400, "密码不能为空");
        }
        if (StringUtils.isNotBlank(manager.getPhone())) {
            //是否重复校验
            messageResult = checkData("MANAGER", 2, manager.getPhone());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "电话号码重复");
            }
        }
        //如果email不为空的话进行是否重复校验
        if (StringUtils.isNotBlank(manager.getEmail())) {
            //是否重复校验
            messageResult = checkData("MANAGER", 3, manager.getEmail());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "email重复");
            }
        }
        //补全pojo的属性
        manager.setCreated(new Date());
        manager.setUpdated(new Date());
        //密码要进行md5加密
        String md5Pass = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());
        manager.setPassword(md5Pass);
        //插入数据
        managerMapper.insert(manager);
        //返回注册成功
        return MessageResult.ok();
    }

    @Override
    public MessageResult productRegister(AccountProductor product) {
        //检查数据的有效性
        if (StringUtils.isBlank(product.getUsername())) {
            return MessageResult.build(400, "用户名不能为空");
        }
        //判断用户名是否重复
        MessageResult messageResult = checkData("PRODUCT", 1, product.getUsername());
        if (!(boolean) messageResult.getData()) {
            return MessageResult.build(400, "用户名重复");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(product.getPassword())) {
            return MessageResult.build(400, "密码不能为空");
        }
        if (StringUtils.isNotBlank(product.getPhone())) {
            //是否重复校验
            messageResult = checkData("PRODUCT", 2, product.getPhone());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "电话号码重复");
            }
        }
        //如果email不为空的话进行是否重复校验
        if (StringUtils.isNotBlank(product.getEmail())) {
            //是否重复校验
            messageResult = checkData("PRODUCT", 3, product.getEmail());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "email重复");
            }
        }
        //补全pojo的属性
        product.setCreated(new Date());
        product.setUpdated(new Date());
        product.setStatus(0);
        //密码要进行md5加密
        String md5Pass = DigestUtils.md5DigestAsHex(product.getPassword().getBytes());
        product.setPassword(md5Pass);
        //插入数据
        productorMapper.insert(product);
        //返回注册成功
        return MessageResult.ok();
    }
    @Override
    public MessageResult merchantRegister(AccountMerchant merchant) {
        //检查数据的有效性
        if (StringUtils.isBlank(merchant.getUsername())) {
            return MessageResult.build(400, "用户名不能为空");
        }
        //判断用户名是否重复
        MessageResult messageResult = checkData("MERCHANT",1, merchant.getUsername());
        if (!(boolean) messageResult.getData()) {
            return MessageResult.build(400, "用户名重复");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(merchant.getPassword())) {
            return MessageResult.build(400, "密码不能为空");
        }
        if (StringUtils.isNotBlank(merchant.getPhone())) {
            //是否重复校验
            messageResult = checkData("MERCHANT", 2, merchant.getPhone());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "电话号码重复");
            }
        }
        //如果email不为空的话进行是否重复校验
        if (StringUtils.isNotBlank(merchant.getEmail())) {
            //是否重复校验
            messageResult = checkData("MERCHANT", 3, merchant.getEmail());
            if (!(boolean) messageResult.getData()) {
                return MessageResult.build(400, "email重复");
            }
        }
        //补全pojo的属性
        merchant.setCreated(new Date());
        merchant.setUpdated(new Date());
        //密码要进行md5加密
        String md5Pass = DigestUtils.md5DigestAsHex(merchant.getPassword().getBytes());
        merchant.setPassword(md5Pass);
        //插入数据
        merchantMapper.insert(merchant);
        //返回注册成功
        return MessageResult.ok();
    }
    @Override
    public MessageResult login(String username, String password, String user_type) {
        if (user_type.compareTo("PRODUCT") == 0){
            //判断用户名和密码是否正确
            AccountProductorExample example = new AccountProductorExample();
            AccountProductorExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<AccountProductor> list = productorMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                //返回登录失败
                return MessageResult.build(400, "用户名或密码不正确");
            }
            AccountProductor product = list.get(0);
            //密码要进行md5加密然后再校验
            if (!DigestUtils.md5DigestAsHex(password.getBytes())
                    .equals(product.getPassword())) {
                //返回登录失败
                return MessageResult.build(400, "用户名或密码不正确");
            }
            if (product.getStatus() != 1){
                //返回登录失败
                return MessageResult.build(400, "管理员审核未通过");
            }
            //生成token，使用uuid
            String token = UUID.randomUUID().toString();
            //清空密码
            product.setPassword(null);
            //把用户信息保存到redis，key就是token，value就是用户信息
            jedisClient.set(PRODUCT_SESSION + ":" + token, JsonUtils.objectToJson(product));
            //设置key的过期时间
            jedisClient.expire(PRODUCT_SESSION + ":" + token, SESSION_EXPIRE);
            //返回登录成功，其中要把token返回。
            return MessageResult.ok(token);
        }
        if (user_type.compareTo("MANAGER") == 0){
            //判断用户名和密码是否正确
            AccountManagerExample example = new AccountManagerExample();
            AccountManagerExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<AccountManager> list = managerMapper.selectByExample(example);
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
        if (user_type.compareTo("MERCHANT") == 0){
            //判断用户名和密码是否正确
            AccountMerchantExample example = new AccountMerchantExample();
            AccountMerchantExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<AccountMerchant> list = merchantMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                //返回登录失败
                return MessageResult.build(400, "用户名或密码不正确");
            }
            AccountMerchant merchant = list.get(0);
            //密码要进行md5加密然后再校验
            if (!DigestUtils.md5DigestAsHex(password.getBytes())
                    .equals(merchant.getPassword())) {
                //返回登录失败
                return MessageResult.build(400, "用户名或密码不正确");
            }
            //生成token，使用uuid
            String token = UUID.randomUUID().toString();
            //清空密码
            merchant.setPassword(null);
            //把用户信息保存到redis，key就是token，value就是用户信息
            jedisClient.set(MERCHANT_SESSION + ":" + token, JsonUtils.objectToJson(merchant));
            //设置key的过期时间
            jedisClient.expire(MERCHANT_SESSION + ":" + token, SESSION_EXPIRE);
            //返回登录成功，其中要把token返回。
            return MessageResult.ok(token);
        }
        return MessageResult.build(400, "参数错误");
    }

    @Override
    public MessageResult getMessageByToken(String user_type, String token) {
        if (user_type.compareTo("PRODUCT") == 0){
            String json = jedisClient.get(PRODUCT_SESSION + ":" + token);
            if (StringUtils.isBlank(json)) {
                return MessageResult.build(400, "用户登录已经过期");
            }
            //重置Session的过期时间
            jedisClient.expire(PRODUCT_SESSION + ":" + token, SESSION_EXPIRE);
            //把json转换成User对象
            AccountProductor product = JsonUtils.jsonToPojo(json, AccountProductor.class);
            return MessageResult.ok(product);
        }
        else if (user_type.compareTo("MANAGER") == 0){
            String json = jedisClient.get(MANAGER_SESSION + ":" + token);
            if (StringUtils.isBlank(json)) {
                return MessageResult.build(400, "用户登录已经过期");
            }
            //重置Session的过期时间
            jedisClient.expire(MANAGER_SESSION + ":" + token, SESSION_EXPIRE);
            //把json转换成User对象
            AccountManager manager = JsonUtils.jsonToPojo(json, AccountManager.class);
            return MessageResult.ok(manager);
        }
        else if (user_type.compareTo("MERCHANT") == 0){
            String json = jedisClient.get(MERCHANT_SESSION + ":" + token);
            if (StringUtils.isBlank(json)) {
                return MessageResult.build(400, "用户登录已经过期");
            }
            //重置Session的过期时间
            jedisClient.expire(MERCHANT_SESSION + ":" + token, SESSION_EXPIRE);
            //把json转换成User对象
            AccountMerchant merchant = JsonUtils.jsonToPojo(json, AccountMerchant.class);
            return MessageResult.ok(merchant);
        }
        return MessageResult.build(400, "参数错误");
    }

    @Override
    public MessageResult logout(String user_type, String token) {
        if (user_type.compareTo("PRODUCT") == 0) {
            jedisClient.hdel(PRODUCT_SESSION, token);
            return MessageResult.ok();
        }
        return MessageResult.build(400, "安全退出失败");
    }
}
