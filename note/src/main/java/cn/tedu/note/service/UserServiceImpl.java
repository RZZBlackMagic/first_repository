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
		System.out.println("login.do");
		String s = null;
		//s.charAt(0);
		
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
	//�޸����룬
	public String changePassword(String user_id,String last_password, String new_password, String final_password) {
		User user = dao.findUserById(user_id);
		System.out.println(final_password);
		System.out.println(last_password);
		System.out.println(new_password);
		String salt = "��������˰�";
		last_password = DigestUtils.md5Hex(salt+last_password);
		new_password = DigestUtils.md5Hex(salt+new_password);
		final_password = DigestUtils.md5Hex(salt+final_password);
        //���ж�ԭʼ�����Ƿ���ȷ����ȷ�ڽ�����һ��
		if(!last_password.equals(user.getPassword())){
			//��һ���������
			throw new PasswordException("ԭʼ���벻��ȷ�������³��ԣ�");
		}
		//���ж�new_password��final_password�Ƿ�һ����һ���ڽ����޸�
		if(!new_password.equals(final_password)){
			//��һ��������
            throw new PasswordException("���ٴ�ȷ���������Ƿ�һ�£�");
		}
		//�޸�����
		System.out.println("��ʼ�޸�����");
		user.setPassword(final_password);
		//ͨ��user_id��user��������޸�
		int row = dao.updatePassword(user);
		if(row==0){
			throw new PasswordException("�����޸�ʧ�ܣ�");
		}
		//�޸���ɺ���м��
		User user1 = dao.findUserById(user_id);
		System.out.println(user1.getPassword());
		System.out.println("final_password:"+final_password);
        System.out.println("new_password:"+new_password);
		if(new_password.equals(user1.getPassword())){
    		return "�����޸ĳɹ�";
        }else{
        	return "�����޸�ʧ��";
        }
	}

}
