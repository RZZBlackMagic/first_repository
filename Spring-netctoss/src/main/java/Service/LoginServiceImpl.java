package Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.Dao.AdminDao;
import cn.tedu.netctoss.Entity.admin;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="adminDao")
	private AdminDao aDao;
	public admin checkLogin(String adminCode, String pwd) {
		admin a = aDao.fingByAdminCode(adminCode);
		if((a.getAdmin_code()==null)&&(adminCode!=null)){
			/*
			 * 账号不存在，就跑一个应用异常
			 * 注：应用异常：指的是因为用户不正确的操作引起的异常，比如账号，密码填写错误。需要明确提示用户采取正确的操作
			 */
			throw new ApplicationException("账号错误");
		}
		if((!pwd.equals(a.getPassword())&&(pwd!=null))){
			//密码错误
			throw new ApplicationException("密码错误");
		}
		if(a.getPassword().equals(pwd)){
			//登录成功
			return a;
		}

		return a;
	}
	public void checkcode(String adminCode,String pwd,String password,String officPassword){//账号，密码，验证码
		if(password==null){
			//输入的验证码是空
			throw new ApplicationException();
		}else if(password.equals(officPassword)){
			//验证码正确
			checkLogin(adminCode,pwd);
		}else{
			//验证码错误
			throw new ApplicationException("验证码错误");
		}
	}

}
