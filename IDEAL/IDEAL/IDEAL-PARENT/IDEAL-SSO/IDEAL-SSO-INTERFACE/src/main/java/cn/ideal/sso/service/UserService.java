package cn.ideal.sso.service;

import cn.ideal.common.pojo.AccountUser;
import cn.ideal.common.results.MessageResult;

public interface UserService {

    /**
     * 判断用户数据类型
     * @param data 数据
     * @param data_type 类型 1-用户名 2-手机 3-邮箱
     * @return MessageResult
     */
    MessageResult checkData(String data, int data_type);

    /**
     * 注册
     * @param user 用户数据
     * @return MessageResult
     */
    MessageResult userRegister(AccountUser user);


    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return MessageResult
     */
    MessageResult loginForWeChat(String username, String password);

    /**
     * 通过令牌取得用户信息
     * @param token 令牌
     * @return MessageResult
     */
    MessageResult getMessageByToken(String token);

    /**
     * 安全退出
     * @param token 令牌
     * @return MessageResult
     */
    MessageResult logout(String token);
}
