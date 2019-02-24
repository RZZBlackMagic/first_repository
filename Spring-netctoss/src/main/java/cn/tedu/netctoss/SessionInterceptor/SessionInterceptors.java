package cn.tedu.netctoss.SessionInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 用于session验证的拦截器
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
		//先获得session对象
		HttpSession session = req.getSession();
		//从session对象当中获取特定的数据
		Object  obj = session.getAttribute("admin");
		System.out.println(1);
		if(obj==null){
			//获取不到session对象
			res.sendRedirect("/Spring-netctoss/toLogin.do");
			System.out.println(2);
			return false;
		}
		//说明登录过了，继续向后调用
		return true;		
	}


	

}
