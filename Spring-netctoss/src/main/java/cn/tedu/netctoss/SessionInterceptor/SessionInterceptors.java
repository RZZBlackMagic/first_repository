package cn.tedu.netctoss.SessionInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * ����session��֤��������
 */
public class SessionInterceptors implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		System.out.println("SessionInterceptor's perHandler()");
		//�Ȼ��session����
		HttpSession session = req.getSession();
		//��session�����л�ȡ�ض�������
		Object  obj = session.getAttribute("admin");
		System.out.println(1);
		if(obj==null){
			//��ȡ����session����
			res.sendRedirect("/Spring-netctoss/toLogin.do");
			System.out.println(2);
			return false;
		}
		//˵����¼���ˣ�����������
		return true;		
	}


	

}
