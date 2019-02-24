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
		//��ȡ�˺�����
		String adminCode = req.getParameter("adminCode");
		String pwd = req.getParameter("pwd");
		//��ȡ�û��������֤��
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
			//Ӧ���쳣����ȷ��ʾ�û�
			req.setAttribute("login_failed", e.getMessage());
			return "login";
		}else{
			req.setAttribute("msg", "ϵͳ�쳣���Ժ�����");
			return "error1";
		}
		//return "redirect:toIndex.do";
	}
	@RequestMapping("/checkcode.do")
	public void checkcode(HttpServletResponse res,HttpSession session) throws IOException{
		//�õ���֤��
		Object[] arr = ImageUtil.createImage();
		session.setAttribute("pass",arr[0].toString() );
		System.out.println(arr[0].toString());
		//������֤���ͼƬ
		BufferedImage image = (BufferedImage)arr[1];
		//��ͼƬ���͸������
		OutputStream os = res.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
	}
}
