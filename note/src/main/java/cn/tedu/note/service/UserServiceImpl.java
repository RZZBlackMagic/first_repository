package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	String salt = "��������˰�";
	@Resource(name="dao")
	private UserDao dao;
	public User login(String name, String password) throws UserNotFoundException, PasswordException {
		User user = dao.findUserByName(name);
		String pwd = DigestUtils.md5Hex(salt+password);
		if(name==null){
		    throw new UserNotFoundException("������name");
		}
		if(user==null){
			throw new UserNotFoundException("name������");
		}
		if(!user.getPassword().equals(pwd)){
			throw new PasswordException("password������");
		}
		return user;
	}
	public User regist(String name, String nick, String password, String confirm)  throws UserNameException,PasswordException{
		String id = UUID.randomUUID().toString();
		password = DigestUtils.md5Hex(salt+password);
		confirm = DigestUtils.md5Hex(salt+confirm);
		//���name�������ظ�
		if(name==null){
			throw new UserNameException("����Ϊ��");
		}
		User one = dao.findUserByName(name);
		if(one!=null){
			throw new UserNameException("��ע��");
		}
		//�������
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("��������");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("ȷ������");
		}
		//���nick
		if(nick==null||nick.trim().isEmpty()){
			nick=name;
		}
		User user = new User(id,name,nick,password,confirm);
		int n = dao.addUser(user);
		return user;
	}

}