package cn.tedu.note.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping()
public class UserController extends AbatractController{

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
	/**
	 * 
	 * 创建一个图片，并且编码为PNG格式，返回编码以后的数据
	 * @return
	 * @throws IOException 
	 */
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR
				);
		//在图片上绘制东西
		img.setRGB(100, 40, 0xffffff);
		//将图片编码为PNG
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}
	//produces用于设置content_type
	@RequestMapping(value="user/image.do",produces= "image/png")
	@ResponseBody
	public byte[] image() throws Exception{
		return createPng();
	}
	//下载图片
	@RequestMapping(value="user/downloadImage.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadImage(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.png\"");
		return createPng();
	}
	//下载Excel
	@RequestMapping(value="user/downloadExcel.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadExcel(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.xlsx\"");
		return createExcel();
	}
	private byte[] createExcel() throws IOException{
		//创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet("demo");
		//在工作表中创建数据行
		HSSFRow row = sheet.createRow(0);
		//创建行中的格子
		HSSFCell cell = row.createCell(0);
		//向格子中添加数据
		cell.setCellValue("hello world ");
		//将Excel文件保存为byte数组
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        out.close();
		return out.toByteArray();
	}
	
	//上传文件
	@RequestMapping("user/upload.do")
	@ResponseBody
	public JsonResult upload(MultipartFile userfile1,MultipartFile userfile2) throws Exception{
		//Spring MVC 中可以利用MultipartFile接收到上传的文件！文件中的一切数据都可以从MultipartFile对象中找到
		//获取上传是原始文件名
		String file1 = userfile1.getOriginalFilename();
		String file2 = userfile2.getOriginalFilename();
		System.out.println(file1);
		System.out.println(file2);
		//保存文件的3中方法：
		// 1 transferTo(目标文件)
		//   将文件直接保存到目标文件，可以处理大文件
		// 2 userfile1.getBytes()获取文件的全部数据
		//   将文件全部读取到内存，社和处理小文件
		// 3 userfile2.getInputStream()
		//   获取上载文件的流，适合处理大文件
		
		//保存的目的文件夹
		File file = new File("D:/demo");
		file.mkdir();
		File f1 = new File(file,file1);
		File f2 = new File(file,file2);
		//第一种保存文件
		userfile1.transferTo(f1);
		userfile2.transferTo(f2);
		
		//第三种 利用 流复制数据
		InputStream in1 = userfile1.getInputStream();
		FileOutputStream out1 = new FileOutputStream(f1);
		int b;
		while((b=in1.read())!=-1){
			out1.write(b);
		}
		in1.close();
		out1.close();
		
		InputStream in2 = userfile2.getInputStream();
		FileOutputStream out2 = new FileOutputStream(f2);
		byte[] buf = new byte[8*1024];
		int n ;
		while((n=in2.read(buf))!=-1){
			out2.write(buf, 0, n);
		}
		in2.close();
		out2.close();
		return new JsonResult(true);
	}
	
}
