package cn.tedu.note.service;

import java.util.HashMap;
import java.util.Map;
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
	public Map<String,Object> changePassword(String user_id,String last_password, String new_password, String final_password) {
		Map<String,Object> map = new HashMap<String,Object>();
		//string ������ֵ����һ�����޸�״̬����ֵ��0���޸ĳɹ����ڶ������޸Ľ�������ء��޸ĳɹ���
		               //�޸�״̬Ϊ1���޸�ʧ�ܣ����ء��޸�ʧ�ܡ�
		               //�޸�״̬Ϊ2���޸�ʧ�ܣ�ԭ�������볤�ȹ���
		               //�޸�״̬Ϊ3���޸�ʧ�ܣ�ԭ����������������벻һ��
		               //�޸�״̬Ϊ4���޸�ʧ�ܣ�ԭ����ԭʼ�����������
		if(new_password.length()<4){
			map.put("�޸�״̬", 2);
			map.put("�޸Ľ��","�޸�ʧ��");
			return map;
		}
		User user = dao.findUserById(user_id);
		//System.out.println(final_password);
		//System.out.println(last_password);
		//System.out.println(new_password);
		String salt = "��������˰�";
		last_password = DigestUtils.md5Hex(salt+last_password);
		new_password = DigestUtils.md5Hex(salt+new_password);
		final_password = DigestUtils.md5Hex(salt+final_password);
        //���ж�ԭʼ�����Ƿ���ȷ����ȷ�ڽ�����һ��
		System.out.println("�����ԭ���룺"+last_password);
		System.out.println("���ݿ��ԭ���룺"+user.getPassword());
		if(!last_password.equals(user.getPassword())){
			//��һ���������
			map.put("�޸�״̬", 4);
			map.put("�޸Ľ��","�޸�ʧ��");
			return map;
		}
		//���ж�new_password��final_password�Ƿ�һ����һ���ڽ����޸�
		if(!new_password.equals(final_password)){
			//��һ��������
			map.put("�޸�״̬", 3);
			map.put("�޸Ľ��","�޸�ʧ��");
			return map;
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
		System.out.println("�޸ĺ�����룺"+user1.getPassword());
		System.out.println("final_password:"+final_password);
        System.out.println("new_password:"+new_password);
        
		if(new_password.equals(user1.getPassword())){
			map.put("�޸�״̬", 0);
			map.put("�޸Ľ��","�޸ĳɹ�");
    		return map;
        }else{
        	map.put("�޸�״̬", 1);
			map.put("�޸Ľ��","�޸�ʧ��");
    		return map;
        	
        }
	}

}
