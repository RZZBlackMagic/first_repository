package cn.tedu.note.service;

import java.util.Map;

import cn.tedu.note.entity.User;

public interface UserService {

	/**
	 * 登录功能，登录成功则返回用户信息，登录失败则抛出异常
	 * @param name用户名
	 * @param password密码
	 * @return 如果登录成功就返回登录信息
	 * @throws UserNotFoundException 用户不存在
	 * @throws PasswordException 密码错误
	 */
	public User login(String name,String password) throws UserNotFoundException,PasswordException;
    /**
     * UserService 中添加注册功能
     * @param name
     * @param nick
     * @param password
     * @param confirm
     * @return
     * @throws UserNameException
     * @throws PasswordException
     */
	public User regist(String name,String nick,String password,String confirm) throws UserNameException,PasswordException;
    public Map<String,Object> changePassword(String user_id,String last_password,String new_password,String final_password);
}
