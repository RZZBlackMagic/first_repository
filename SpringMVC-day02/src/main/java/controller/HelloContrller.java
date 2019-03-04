package controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/*
 * 处理器类
 *   1 不用实现Controller
 *   2 方法名不做要求,返回值可以是ModelAndView,也可以是String
 *   3 可以添加多个方法
 *   4 使用注解：@Controller
 *   5 可以在方法前或者类前加@RequestMapping(相当于HandlerMapping)
 */ 
  
@Controller
public class HelloContrller {
	
	@RequestMapping("/hello.do")
	public String  hello(){
		System.out.println("hello()");
		//返回视图名
		return "hello";
	}
	
	@RequestMapping("toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "toLogin";
	}
	@RequestMapping("login.do")
	public String Login(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("utf-8");
		String adminCode = req.getParameter("adminCode");
		System.out.println("adminCode:"+adminCode);
		System.out.println("Login()");
		return "Login";
	}
	@RequestMapping("login2.do")
	public String Login2(String adminCode,@RequestParam("pwd")String password){
		System.out.println("adminCode:"+adminCode);
		System.out.println("password:"+password);
		return "Login";
	}
	@RequestMapping("login3.do")
	public String Login3(admin a){
		System.out.println("Login3()");
		System.out.println(a.getAdminCode());
		System.out.println(a.getPwd());
		return "Login";
	}
	@RequestMapping("login4.do")
	public String Login4(admin a,HttpServletRequest req){
		System.out.println("Login4()");
		String adminCode = a.getAdminCode();
		req.setAttribute("adminCode", adminCode);
		return "Login";//默认情况下就是转发
	}
	@RequestMapping("login5.do")
	public ModelAndView Login5(admin a){
		System.out.println("Login5()");
		String adminCode = a.getAdminCode();
		Map<String,Object> data = new  HashMap<String,Object>();
		data.put("adminCode",adminCode);
		ModelAndView mad = new ModelAndView("Login",data);
		return mad;
	}
	@RequestMapping("login6.do")
	public String login6(admin a,ModelMap mm){
		String adminCode = a.getAdminCode();
		//相当于执行了req.setAttribute("adminCode", adminCode);
		mm.addAttribute("adminCode", adminCode);
		return "Login";
	}
	@RequestMapping("login7.do")
	public  String login7(admin a,HttpSession session){
		System.out.println("login7()");
		String adminCode = a.getAdminCode();
		session.setAttribute("adminCode", adminCode);
		return "Login";
	}
	@RequestMapping("login8.do")
	public String login8(){
		System.out.println("login8()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "Login";
	}
	@RequestMapping("login9.do")
	public ModelAndView login9(){
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		ModelAndView mav = new ModelAndView(rv);
		return mav;
	}

}
