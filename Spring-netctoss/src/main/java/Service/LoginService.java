package Service;

import cn.tedu.netctoss.Entity.admin;

/*
 * ҵ���ӿ�
 */
public interface LoginService {

	public admin checkLogin(String adminCode,String pwd);
	public void checkcode(String admin,String pwd,String password,String officPassword);
}
