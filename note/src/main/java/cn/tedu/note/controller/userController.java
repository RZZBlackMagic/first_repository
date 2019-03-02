package cn.tedu.note.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
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

public class UserController extends AbatractController{

	@Resource(name="userService")
	private UserService useService;
	@RequestMapping("/login.do")
	@ResponseBody//json注锟斤拷:锟斤拷锟角凤拷锟斤拷一锟斤拷json
	public Object login(String name,String password,HttpSession session){
			User user = useService.login(name, password);
			//锟斤拷录锟缴癸拷,锟斤拷User锟斤拷息锟斤拷锟斤拷session锟斤拷锟芥，锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			session.setAttribute("UserLogin", user);
			return new JsonResult(user);
	}
	/*@ExceptionHandler(Exception.class)
	@ResponseBody//json注锟酵ｏ拷锟斤拷锟角凤拷锟斤拷一锟斤拷json锟斤拷锟斤拷
	public Object handlerException(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}*/

	//锟矫伙拷锟斤拷锟届常
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public Object handleUserNotFound(UserNotFoundException e){
		return new JsonResult(2,e);
	}
	//锟斤拷锟斤拷锟斤拷锟�
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
     * 注锟结功锟斤拷
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
	 * 锟斤拷锟斤拷一锟斤拷图片锟斤拷锟斤拷锟揭憋拷锟斤拷为PNG锟斤拷式锟斤拷锟斤拷锟截憋拷锟斤拷锟皆猴拷锟斤拷锟斤拷锟�
	 * @return
	 * @throws IOException 
	 */
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR
				);
		//锟斤拷图片锟较伙拷锟狡讹拷锟斤拷
		img.setRGB(100, 40, 0xffffff);
		//锟斤拷图片锟斤拷锟斤拷为PNG
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}
	//produces锟斤拷锟斤拷锟斤拷锟斤拷content_type
	@RequestMapping(value="user/image.do",produces= "image/png")
	@ResponseBody
	public byte[] image() throws Exception{
		return createPng();
	}
	//锟斤拷锟斤拷图片
	@RequestMapping(value="user/downloadImage.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadImage(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.png\"");
		return createPng();
	}
	//锟斤拷锟斤拷Excel
	@RequestMapping(value="user/downloadExcel.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadExcel(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.xlsx\"");
		return createExcel();
	}
	private byte[] createExcel() throws IOException{
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		HSSFWorkbook workbook = new HSSFWorkbook();
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		HSSFSheet sheet = workbook.createSheet("demo");
		//锟节癸拷锟斤拷锟斤拷锟叫达拷锟斤拷锟斤拷锟斤拷锟斤拷
		HSSFRow row = sheet.createRow(0);
		//锟斤拷锟斤拷锟斤拷锟叫的革拷锟斤拷
		HSSFCell cell = row.createCell(0);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		cell.setCellValue("hello world ");
		//锟斤拷Excel锟侥硷拷锟斤拷锟斤拷为byte锟斤拷锟斤拷
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        out.close();
		return out.toByteArray();
	}
	
	//锟较达拷锟侥硷拷
	@RequestMapping("user/upload.do")
	@ResponseBody
	public JsonResult upload(MultipartFile userfile1,MultipartFile userfile2) throws Exception{
		//Spring MVC 锟叫匡拷锟斤拷锟斤拷锟斤拷MultipartFile锟斤拷锟秸碉拷锟较达拷锟斤拷锟侥硷拷锟斤拷锟侥硷拷锟叫碉拷一锟斤拷锟斤拷锟捷讹拷锟斤拷锟皆达拷MultipartFile锟斤拷锟斤拷锟斤拷锟揭碉拷
		//锟斤拷取锟较达拷锟斤拷原始锟侥硷拷锟斤拷
		String file1 = userfile1.getOriginalFilename();
		String file2 = userfile2.getOriginalFilename();
		System.out.println(file1);
		System.out.println(file2);
		
		File file = new File("D:/demo");
		file.mkdir();
		File f1 = new File(file,file1);
		File f2 = new File(file,file2);
		/*//锟斤拷一锟街憋拷锟斤拷锟侥硷拷
		userfile1.transferTo(f1);
		userfile2.transferTo(f2);*/
		
		InputStream in1 = userfile1.getInputStream();
		
		byte[] data = new byte[200];
		String fileName = f1.getPath();
		System.out.println(fileName);
		RandomAccessFile raf = new RandomAccessFile(fileName,"r");
		int len = raf.read(data);
		String string = new String(data,0,len,"utf-8");
		System.out.println(string);
		raf.close();
		
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
