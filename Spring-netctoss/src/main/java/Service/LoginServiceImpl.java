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
			 * �˺Ų����ڣ�����һ��Ӧ���쳣
			 * ע��Ӧ���쳣��ָ������Ϊ�û�����ȷ�Ĳ���������쳣�������˺ţ�������д������Ҫ��ȷ��ʾ�û���ȡ��ȷ�Ĳ���
			 */
			throw new ApplicationException("�˺Ŵ���");
		}
		if((!pwd.equals(a.getPassword())&&(pwd!=null))){
			//�������
			throw new ApplicationException("�������");
		}
		if(a.getPassword().equals(pwd)){
			//��¼�ɹ�
			return a;
		}

		return a;
	}
	public void checkcode(String adminCode,String pwd,String password,String officPassword){//�˺ţ����룬��֤��
		if(password==null){
			//�������֤���ǿ�
			throw new ApplicationException();
		}else if(password.equals(officPassword)){
			//��֤����ȷ
			checkLogin(adminCode,pwd);
		}else{
			//��֤�����
			throw new ApplicationException("��֤�����");
		}
	}

}
