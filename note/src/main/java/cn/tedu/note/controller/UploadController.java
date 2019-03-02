package cn.tedu.note.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.tedu.note.util.JsonResult;

@Controller
public class UploadController {

	@RequestMapping("/upload.do")
	@ResponseBody
	public JsonResult uploadNote(@RequestParam("uploadFile") MultipartFile uploadFile,MultipartHttpServletRequest mreq) throws IOException{
		String path = mreq.getContextPath();
		System.out.println("上传文件的路径:"+path);
		System.setProperty("file.encoding", "GBK");
		System.setProperty("sun.jnu.encoding", "GBK");
		System.out.println("文件内容的编码："+System.getProperty("file.encoding"));
		String file = uploadFile.getOriginalFilename();
		System.out.println("上传文件名称："+file);
		InputStream fis = uploadFile.getInputStream();
		byte[] data = new byte[100];
		int len = fis.read(data);
		   
		String str = new String (data,0,len,"GBK");
		System.out.println(str);
		fis.close();
		
		return new JsonResult("上传成功");
	}
}
