package cn.tedu.note.service;

import java.util.Map;

import cn.tedu.note.entity.User;

public interface UserService {

	/**
	 * ��¼���ܣ���¼�ɹ��򷵻��û���Ϣ����¼ʧ�����׳��쳣
	 * @param name�û���
	 * @param password����
	 * @return �����¼�ɹ��ͷ��ص�¼��Ϣ
	 * @throws UserNotFoundException �û�������
	 * @throws PasswordException �������
	 */
	public User login(String name,String password) throws UserNotFoundException,PasswordException;
    /**
     * UserService �����ע�Ṧ��
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
