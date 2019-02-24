package Service;

import cn.tedu.netctoss.Entity.admin;

/*
 * 业务层接口
 */
public interface LoginService {

	public admin checkLogin(String adminCode,String pwd);
	public void checkcode(String admin,String pwd,String password,String officPassword);
}
