package cn.tedu.note.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping()
public class userController extends AbatractController{

	@Resource(name="userService")
	private UserService useService;
	@RequestMapping("/login.do")
	@ResponseBody//json注解:就是返回一个json
	public Object login(String name,String password,HttpSession session){
			User user = useService.login(name, password);
			//登录成功,将User信息放在session里面，用于拦截器的拦截
			session.setAttribute("UserLogin", user);
			return new JsonResult(user);
	}
	/*@ExceptionHandler(Exception.class)
	@ResponseBody//json注释：就是返回一个json对象
	public Object handlerException(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}*/

	//用户名异常
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public Object handleUserNotFound(UserNotFoundException e){
		return new JsonResult(2,e);
	}
	//密码错误
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public Object handlePasswordException(PasswordException e){
		e.printStackTrace();
		return new JsonResult(3,e);
	}
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public Object Exception(PasswordException e){
		e.printStackTrace();
		return new JsonResult(4,e);
	}
    /**
     * 注册功能
     * @param name
     * @param nick
     * @param password
     * @param confirm
     * @return
     */
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult regist(String name,String nick,String password,String confirm){
		User user = useService.regist(name, nick, password, confirm);
		return new JsonResult(user);
	}
	
	@RequestMapping("/changePassword.do")
	@ResponseBody
	public JsonResult changePassword(String user_id,String last_password,String new_password,String final_password){
		Map<String,Object> map = useService.changePassword(user_id, last_password, new_password, final_password);
		return new JsonResult(map);
	}

	
	
}
