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
	@ResponseBody//jsonע��:���Ƿ���һ��json
	public Object login(String name,String password,HttpSession session){
		
		
			User user = useService.login(name, password);
			//��¼�ɹ�,��User��Ϣ����session���棬����������������
			session.setAttribute("UserLogin", user);
			return new JsonResult(user);
	}
	/*@ExceptionHandler(Exception.class)
	@ResponseBody//jsonע�ͣ����Ƿ���һ��json����
	public Object handlerException(Exception e){
		e.printStackTrace();
		return new JsonResult(e);
	}*/

	//�û����쳣
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public Object handleUserNotFound(UserNotFoundException e){
		return new JsonResult(2,e);
	}
	//�������
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
     * ע�Ṧ��
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
	 * ����һ��ͼƬ�����ұ���ΪPNG��ʽ�����ر����Ժ������
	 * @return
	 * @throws IOException 
	 */
	private byte[] createPng() throws IOException{
		BufferedImage img = new BufferedImage(200,80,BufferedImage.TYPE_3BYTE_BGR
				);
		//��ͼƬ�ϻ��ƶ���
		img.setRGB(100, 40, 0xffffff);
		//��ͼƬ����ΪPNG
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}
	//produces��������content_type
	@RequestMapping(value="user/image.do",produces= "image/png")
	@ResponseBody
	public byte[] image() throws Exception{
		return createPng();
	}
	//����ͼƬ
	@RequestMapping(value="user/downloadImage.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadImage(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.png\"");
		return createPng();
	}
	//����Excel
	@RequestMapping(value="user/downloadExcel.do",produces="application/octet-stream")
	@ResponseBody
	public byte[] downloadExcel(HttpServletResponse res) throws IOException{
		res.setHeader("Content-Disposition", "attachment; filename=\"demo.xlsx\"");
		return createExcel();
	}
	private byte[] createExcel() throws IOException{
		//����������
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = workbook.createSheet("demo");
		//�ڹ������д���������
		HSSFRow row = sheet.createRow(0);
		//�������еĸ���
		HSSFCell cell = row.createCell(0);
		//��������������
		cell.setCellValue("hello world ");
		//��Excel�ļ�����Ϊbyte����
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        out.close();
		return out.toByteArray();
	}
	
	//�ϴ��ļ�
	@RequestMapping("user/upload.do")
	@ResponseBody
	public JsonResult upload(MultipartFile userfile1,MultipartFile userfile2) throws Exception{
		//Spring MVC �п�������MultipartFile���յ��ϴ����ļ����ļ��е�һ�����ݶ����Դ�MultipartFile�������ҵ�
		//��ȡ�ϴ���ԭʼ�ļ���
		String file1 = userfile1.getOriginalFilename();
		String file2 = userfile2.getOriginalFilename();
		System.out.println(file1);
		System.out.println(file2);
		//�����ļ���3�з�����
		// 1 transferTo(Ŀ���ļ�)
		//   ���ļ�ֱ�ӱ��浽Ŀ���ļ������Դ�����ļ�
		// 2 userfile1.getBytes()��ȡ�ļ���ȫ������
		//   ���ļ�ȫ����ȡ���ڴ棬��ʹ���С�ļ�
		// 3 userfile2.getInputStream()
		//   ��ȡ�����ļ��������ʺϴ�����ļ�
		
		//�����Ŀ���ļ���
		File file = new File("D:/demo");
		file.mkdir();
		File f1 = new File(file,file1);
		File f2 = new File(file,file2);
		//��һ�ֱ����ļ�
		userfile1.transferTo(f1);
		userfile2.transferTo(f2);
		
		//������ ���� ����������
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
