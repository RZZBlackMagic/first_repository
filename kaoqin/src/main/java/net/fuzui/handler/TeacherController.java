package net.fuzui.handler;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
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

import net.fuzui.pojo.Children;
import net.fuzui.pojo.Classes;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Rela_stu_cla;
import net.fuzui.pojo.Student;
@Controller
public class TeacherController {

	@Autowired
	MongoTemplate mongoTemplate;

	
	/** 
	 * http://localhost:8080/kaoqin/createClasses?cla_name=数据库&cla_tea_id=1583335307020&cla_tea_name=佳
	 * 教师注册班级 
	 * @throws UnsupportedEncodingException
	 * */ 
	@RequestMapping(value= {"createClasses"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String createClasses(Model model,@RequestParam String cla_name,@RequestParam String cla_tea_id,
			@RequestParam String cla_tea_name
			) throws UnsupportedEncodingException {
		System.out.println("......");
		
		Query query = new Query();
		//query.addCriteria(Criteria.where("stu_phone").is(stu_phone));
		Long count = mongoTemplate.count(query, Classes.class);
		count = count+1;
		System.out.println(count);
		//处理班号为四位数
		String cla_num;
		if(count<10){
			cla_num = "000"+count;
		}else if(count<100&&count>9){
			cla_num = "00"+count;
		}else if(count>99&&count<1000){
			cla_num = "0"+count;
		}else{
			cla_num = String.valueOf(count);
		}
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		if(month<8){
			month=3;
		}else{
			month=9;
		}
		String cla_time = year + "_" + month;
		Classes classes = new Classes();
		classes.setCla_name(cla_name);
		classes.setCla_tea_id(cla_tea_id);
		classes.setCla_tea_name(cla_tea_name);
		classes.setCla_num(cla_num);
		classes.setCla_time(cla_time);
		mongoTemplate.insert(classes);
		return (new JsonResult(200,classes).toString());
	}
	/** 
	 * 教师查找自己创建的班级
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/findAllCreatededClasses?cla_tea_id=1583335307020
	 * */ 
	@RequestMapping(value= {"findAllCreatededClasses"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllCreatededClasses(Model model,@RequestParam String cla_tea_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_tea_id").is(cla_tea_id));
	    List<Classes> userList1 = mongoTemplate.find(query,Classes.class);
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该老师还没有添加班级。").toString());
	    }
		return (new JsonResult(200,userList1).toString());
	}
}
