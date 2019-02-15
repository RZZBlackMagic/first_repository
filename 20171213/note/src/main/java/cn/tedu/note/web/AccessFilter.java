package cn.tedu.note.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.note.entity.User;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {

	private String login = "/log_in.html";
    /**
     * Default constructor. 
     */
    public AccessFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		String path = req.getRequestURI();
        //�Ź�log_in.html
		if(path.endsWith(login)){
			System.out.println("ֱ�ӷ��ʵĵ�¼ҳ��");
			//�Ź�������,һ������ִ��һ��������䣬����ÿ�����ִ�к��return
			chain.doFilter(request, response);
            return;
		}
		//�Ź�alter_error.htmlҳ��
		if(path.endsWith("alter_error.html")){
			chain.doFilter(request, response);
            return ;
		}
		//����û��Ƿ��¼��
        User user = (User)session.getAttribute("UserLogin");
		if(user==null){
			//δ��¼���ض��򵽵�¼ҳ��
			System.out.println("δ��¼��ת����¼ҳ��");
			res.sendRedirect(req.getContextPath()+login);
			return ;
		}
		//�û��Ѿ���¼��
		System.out.println("�Ѿ���¼��");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
