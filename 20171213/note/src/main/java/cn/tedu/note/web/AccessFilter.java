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
        //放过log_in.html
		if(path.endsWith(login)){
			System.out.println("直接访问的登录页面");
			//放过该请求,一次请求执行一次下面这句，所以每次这个执行后就return
			chain.doFilter(request, response);
            return;
		}
		//放过alter_error.html页面
		if(path.endsWith("alter_error.html")){
			chain.doFilter(request, response);
            return ;
		}
		//检查用户是否登录，
        User user = (User)session.getAttribute("UserLogin");
		if(user==null){
			//未登录，重定向到登录页面
			System.out.println("未登录跳转到登录页面");
			res.sendRedirect(req.getContextPath()+login);
			return ;
		}
		//用户已经登录了
		System.out.println("已经登录了");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
