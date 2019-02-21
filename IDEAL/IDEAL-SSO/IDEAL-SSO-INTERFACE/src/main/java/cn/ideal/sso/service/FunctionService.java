package cn.ideal.sso.service;

import cn.ideal.common.pojo.AccountManager;
import cn.ideal.common.pojo.AccountProductor;
import cn.ideal.common.results.MessageResult;

public interface FunctionService {
    /**
     * 判断用户数据类型
     * @param data 数据
     * @param data_type 类型 1-用户名 2-手机 3-邮箱
     * @return MessageResult
     */
    MessageResult checkData(String data, int data_type, String user_type);

    /**
     * 注册
     * @param manager 用户数据
     * @return MessageResult
     */
    MessageResult managerRegister(AccountManager manager);

    /**
     * 注册
     * @param product 用户数据
     * @return MessageResult
     */
    MessageResult productRegister(AccountProductor product);

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return MessageResult
     */
    MessageResult login(String username, String password, String user_type);

    /**
     * 通过令牌取得用户信息
     * @param token 令牌
     * @param user_type 用户类型
     * @return MessageResult
     */
    MessageResult getMessageByToken(String user_type, String token);

    /**
     * 安全退出
     * @param user_type 用户类型
     * @param token 令牌
     * @return MessageResult
     */
    MessageResult logout(String user_type, String token);
}
