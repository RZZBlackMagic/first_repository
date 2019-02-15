package cn.tedu.note.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.note.entity.User;
import cn.tedu.note.util.JsonResult;
@Component
public class AccessInterceptor implements HandlerInterceptor {

	public AccessInterceptor() {
		// TODO Auto-generated constructor stub
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		String path = req.getRequestURI();
		System.out.println("interceptor:"+path);
		//���û�е�¼�����ش�����Ϣ
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("UserLogin");
		if(user==null){
			//δ��¼
			JsonResult result = new JsonResult("��Ҫ���µ�¼");
			//����res������Ϣ
			res.setContentType("application/json;charset=UTF-8");
			res.setCharacterEncoding("UTF-8");
			//���������ǽ�JAVAbean����ת����json����
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			
			res.getWriter().println(json);
			res.flushBuffer();
			return false;
		}
		//�Ź�����
		return true;
	}

}
