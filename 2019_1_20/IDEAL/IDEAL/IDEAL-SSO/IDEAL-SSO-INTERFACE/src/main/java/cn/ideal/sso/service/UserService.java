package cn.ideal.sso.service;


import cn.ideal.common.pojo.MessageResult;
import cn.ideal.pojo.AccountUser;

public interface UserService {

    /**
     * 判断用户数据类型
     * @param data 数据
     * @param type 类型 1-用户名 2-手机 3-邮箱
     * @return MessageResult
     */
    MessageResult checkData(String data, int type);

    /**
     * 注册
     * @param user 用户数据
     * @return MessageResult
     */
    MessageResult register(AccountUser user);

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return MessageResult
     */
    MessageResult login(String username, String password);

    /**
     * 通过令牌取得用户信息
     * @param token 令牌
     * @return MessageResult
     */
    MessageResult getUserByToken(String token);

    /**
     * 安全退出
     * @param token 令牌
     * @return MessageResult
     */
    MessageResult logout(String token);
}
