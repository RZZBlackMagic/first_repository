package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	String salt = "今天你丑了啊";
	@Resource(name="dao")
	private UserDao dao;
	public User login(String name, String password) throws UserNotFoundException, PasswordException {
		User user = dao.findUserByName(name);
		String pwd = DigestUtils.md5Hex(salt+password);
		if(name==null){
		    throw new UserNotFoundException("请输入name");
		}
		if(user==null){
			throw new UserNotFoundException("name出错了");
		}
		if(!user.getPassword().equals(pwd)){
			throw new PasswordException("password出错了");
		}
		return user;
	}
	public User regist(String name, String nick, String password, String confirm)  throws UserNameException,PasswordException{
		String id = UUID.randomUUID().toString();
		password = DigestUtils.md5Hex(salt+password);
		confirm = DigestUtils.md5Hex(salt+confirm);
		//检查name，不能重复
		if(name==null){
			throw new UserNameException("不能为空");
		}
		User one = dao.findUserByName(name);
		if(one!=null){
			throw new UserNameException("已注册");
		}
		//检查密码
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("不能诶空");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码");
		}
		//检查nick
		if(nick==null||nick.trim().isEmpty()){
			nick=name;
		}
		User user = new User(id,name,nick,password,confirm);
		int n = dao.addUser(user);
		return user;
	}

}
