package net.fuzui.handler;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;

import net.fuzui.pojo.Classes;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Teacher;
import net.fuzui.video.Mon_GridFS;

@Controller
public class GridFsController {
	@Autowired
	MongoTemplate mongoTemplate;

	/** 
	 * 用户上传视频
	 *
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/uploadFile?user_id=1583675290261&user_name=任一鸣&path=D:/test/1582788755063.mp4
	 * */ 
	@RequestMapping(value= {"uploadFile"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadFile(Model model,@RequestParam String user_id,@RequestParam String user_name,@RequestParam String path
			) throws UnsupportedEncodingException {
		try {
			Mon_GridFS.saveFile(user_id, user_name, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (new JsonResult(302,"请检查源文件是否在对应目录")).toString();
		}
		return (new JsonResult(200,"上传成功")).toString();
	}
	/** 
	 * 用户下载视频
	 *
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/downloadFile?user_id=1583675290261&filename=1582788755063.mp4
	 * */ 
	@RequestMapping(value= {"downloadFile"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String downloadFile(Model model,@RequestParam String user_id,@RequestParam String filename
			) throws UnsupportedEncodingException {
		String result=null;
			try {
				 result = Mon_GridFS.readFile(filename, user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	     		return (new JsonResult(302,"视频获取失败，请确认文件名称")).toString();
			}
		if(result==null){
     		return (new JsonResult(302,"下载出现异常，请重新尝试")).toString();

		}
 		return (new JsonResult(200,result)).toString();
	}
	
	/** 
	 * 用户所有下载视频
	 *
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/downloadAllFile?user_id=1583675290261
	 * */ 
	@RequestMapping(value= {"downloadAllFile"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String downloadAllFile(Model model,@RequestParam String user_id
			) throws UnsupportedEncodingException {
		String result =null;
			try {
				result = Mon_GridFS.readALLFile(user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 		return (new JsonResult(302,"视频获取失败，请确认文件名称")).toString();
			}
		if(result==null){
	 		return (new JsonResult(302,"下载出现异常，请重新尝试")).toString();
		}
 		return (new JsonResult(200,result)).toString();
	}
	
}
