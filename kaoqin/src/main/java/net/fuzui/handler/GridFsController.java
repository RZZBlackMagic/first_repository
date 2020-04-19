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
import net.fuzui.pojo.Comment;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Parents;
import net.fuzui.pojo.Tags;
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
	
	
	/** 
	 * 点赞
	 * http://localhost:8080/kaoqin/tag?user_id=1583675290261&filename=1582788755063.mp4
	 * @throws Exception 
	 * */ 
	@RequestMapping(value= {"tag"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String tag(Model model,@RequestParam String user_id,@RequestParam String filename
			) throws Exception {
		Tags t = Mon_GridFS.getShuxing(user_id, filename);
		if(t==null){
			return new JsonResult(302,"没有该视频或者视频名冲突").toString();
		}
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("tag_md5").is(t.getTag_md5()));
		query1.addCriteria(Criteria.where("tag_user_id").is(user_id));
        List<Tags> userList1 = mongoTemplate.find(query1,Tags.class);
        if(userList1.size()>0){
        	return (new JsonResult(302,"您已经点赞过了").toString());
        }
        mongoTemplate.save(t);
 		return (new JsonResult(200,t)).toString();
	}
	
	/** 
	 * 评论
	 * 	 * http://localhost:8080/kaoqin/comment?user_id=1583675290261&filename=1582788755063.mp4&com_ment=好棒呀

	 * @throws Exception 
	 * */ 
	@RequestMapping(value= {"comment"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String comment(Model model,@RequestParam String user_id,@RequestParam String filename,@RequestParam String com_ment
			) throws Exception {
		Comment com = Mon_GridFS.comment(user_id, filename, com_ment);
		if(com==null){
			return new JsonResult(302,"没有该视频或者视频名冲突").toString();
		}
        mongoTemplate.save(com);
 		return (new JsonResult(200,com)).toString();
	}
	/** 
	 * 获取所有的点赞
	 * 	 * http://localhost:8080/kaoqin/comment?user_id=1583675290261&filename=1582788755063.mp4&com_ment=好棒呀

	 * @throws Exception 
	 * */ 
	@RequestMapping(value= {"getAllTag"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAllTag(Model model,@RequestParam String filename
			) throws Exception {
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("tag_filename").is(filename));
        List<Tags> userList1 = mongoTemplate.find(query1,Tags.class);
 		return (new JsonResult(200,userList1)).toString();
	}
	/** 
	 * 获取所有的评论
	 * 	 * http://localhost:8080/kaoqin/comment?user_id=1583675290261&filename=1582788755063.mp4&com_ment=好棒呀

	 * @throws Exception 
	 * */ 
	@RequestMapping(value= {"getAllComment"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAllComment(Model model,@RequestParam String filename
			) throws Exception {
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("com_filename").is(filename));
        List<Comment> userList1 = mongoTemplate.find(query1,Comment.class);
 		return (new JsonResult(200,userList1)).toString();
	}
	
}
