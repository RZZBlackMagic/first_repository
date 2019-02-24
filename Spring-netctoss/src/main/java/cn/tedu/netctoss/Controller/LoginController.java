package cn.tedu.netctoss.Controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.ApplicationException;
import Service.LoginService;
import cn.tedu.netctoss.Entity.admin;
import cn.tedu.netctoss.Util.ImageUtil;

@Controller
public class LoginController {

	@Resource(name="LoginService")
	private LoginService loginService;
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/Login.do")
	public String Login(HttpServletRequest req,HttpSession session){
		//读取账号密码
		String adminCode = req.getParameter("adminCode");
		String pwd = req.getParameter("pwd");
		//读取用户输入的验证码
		String password = req.getParameter("password");
		String officPassword = (String)session.getAttribute("pass");
        loginService.checkcode(adminCode, pwd, password, officPassword);
		return "index";
	}
	@RequestMapping("toIndex.do")
	public String Index(){
		System.out.println("index()");
		return "index";
	}
	@ExceptionHandler
	public String handlerEx(Exception e,HttpServletRequest req){
		if(e instanceof ApplicationException){
			//应用异常，明确提示用户
			req.setAttribute("login_failed", e.getMessage());
			return "login";
		}else{
			req.setAttribute("msg", "系统异常，稍后重试");
			return "error1";
		}
		//return "redirect:toIndex.do";
	}
	@RequestMapping("/checkcode.do")
	public void checkcode(HttpServletResponse res,HttpSession session) throws IOException{
		//得到验证码
		Object[] arr = ImageUtil.createImage();
		session.setAttribute("pass",arr[0].toString() );
		System.out.println(arr[0].toString());
		//返回验证码的图片
		BufferedImage image = (BufferedImage)arr[1];
		//将图片发送给浏览器
		OutputStream os = res.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
	}
}
