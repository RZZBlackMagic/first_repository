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
		System.out.println("login.do");
		String s = null;
		//s.charAt(0);
		
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
	//修改密码，
	public String changePassword(String user_id,String last_password, String new_password, String final_password) {
		User user = dao.findUserById(user_id);
		System.out.println(final_password);
		System.out.println(last_password);
		System.out.println(new_password);
		String salt = "今天你丑了啊";
		last_password = DigestUtils.md5Hex(salt+last_password);
		new_password = DigestUtils.md5Hex(salt+new_password);
		final_password = DigestUtils.md5Hex(salt+final_password);
        //先判断原始密码是否正确，正确在进行下一步
		if(!last_password.equals(user.getPassword())){
			//不一样，则结束
			throw new PasswordException("原始密码不正确，请重新尝试！");
		}
		//先判断new_password和final_password是否一样，一样在进行修改
		if(!new_password.equals(final_password)){
			//不一样，结束
            throw new PasswordException("请再次确认新密码是否一致！");
		}
		//修改密码
		System.out.println("开始修改密码");
		user.setPassword(final_password);
		//通过user_id将user的面进行修改
		int row = dao.updatePassword(user);
		if(row==0){
			throw new PasswordException("密码修改失败！");
		}
		//修改完成后进行检查
		User user1 = dao.findUserById(user_id);
		System.out.println(user1.getPassword());
		System.out.println("final_password:"+final_password);
        System.out.println("new_password:"+new_password);
		if(new_password.equals(user1.getPassword())){
    		return "密码修改成功";
        }else{
        	return "密码修改失败";
        }
	}

}
