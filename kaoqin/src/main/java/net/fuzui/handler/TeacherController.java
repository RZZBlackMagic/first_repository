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

import net.fuzui.pojo.Attendance;
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
	
	/** 
	 * 教师处理旷课的同学
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/handleAbsence?cla_num=0002&stu_id=1586323085756
	 */ 
	@RequestMapping(value= {"handleAbsence"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String handleAbsence(Model model,@RequestParam String cla_num,@RequestParam String stu_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("stu_id").is(stu_id));
	    List<Student> userList1 = mongoTemplate.find(query,Student.class);
	    System.out.println(userList1.toString());
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该学生还没有注册。").toString());
	    }
	    Query query1 = new Query();
		query1.addCriteria(Criteria.where("cla_num").is(cla_num));
	    List<Classes> userList = mongoTemplate.find(query1,Classes.class);
	    System.out.println(userList.toString());
		if(userList.size()==0){
			return (new JsonResult(302,"该班级还没有创建").toString());
		}
		Attendance att = new Attendance();
		att.setAtt_cla_name(userList.get(0).getCla_name());
		att.setAtt_cla_num(cla_num);
		att.setAtt_status("1");
		att.setAtt_stu_id(stu_id);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);

		month++;
		att.setAtt_time(year+"-"+month+"-"+day);
		att.setAtt_stu_name(userList1.get(0).getStu_name());
	    Query query2 = new Query();
	    query2.addCriteria(Criteria.where("att_cla_num").is(cla_num));
		query2.addCriteria(Criteria.where("att_stu_id").is(stu_id));
		long count = mongoTemplate.count(query2, Attendance.class);
		count++;
		att.setAtt_weeks(String.valueOf(count));
		mongoTemplate.save(att);
		return (new JsonResult(200,att).toString());
	}
	

	/** 
	 * 教师处理旷课的同学
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/handleAbsence?cla_tea_id=1583335307020
	 */ 
	@RequestMapping(value= {"handleLeave"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String handleLeave(Model model,@RequestParam String cla_num,@RequestParam String stu_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("stu_id").is(stu_id));
	    List<Student> userList1 = mongoTemplate.find(query,Student.class);
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该学生还没有注册。").toString());
	    }
	    Query query1 = new Query();
		query1.addCriteria(Criteria.where("cla_num").is(cla_num));
	    List<Classes> userList = mongoTemplate.find(query1,Classes.class);
		if(userList.size()==0){
			return (new JsonResult(302,"该班级还没有创建").toString());
		}
		Attendance att = new Attendance();
		att.setAtt_cla_name(userList.get(0).getCla_name());
		att.setAtt_cla_num(cla_num);
		att.setAtt_status("2");
		att.setAtt_stu_id(stu_id);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
		month++;
		att.setAtt_time(year+"-"+month+"-"+day);
		att.setAtt_stu_name(userList1.get(0).getStu_name());
		Criteria criteria = new Criteria();
		criteria.orOperator(
		Criteria.where("att_stu_id").is(stu_id),
		Criteria.where("att_cla_num").is(cla_num));
		Query query2 = new Query();
		query2.addCriteria(criteria);
		long count = mongoTemplate.count(query2, Attendance.class);
		count++;
		att.setAtt_weeks(String.valueOf(count));
		mongoTemplate.save(att);
		return (new JsonResult(200,att).toString());
	}
}
