package net.fuzui.handler;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.util.LinkedNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.WriteResult;

import net.fuzui.pojo.Attendance;
import net.fuzui.pojo.Classes;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Student;
import net.fuzui.pojo.Teacher;

@Controller
public class bluetoothController {
	
	@Autowired
	MongoTemplate mongoTemplate;


	/** 
	 * 学生检查老师的蓝牙是否打开
	 * 0:关闭
	 * 1:打开
	 * @throws UnsupportedEncodingException
	 *     http://116.62.222.40:8080/kaoqin/checkBluetooth?cla_num=0002
	 * */ 
	@RequestMapping(value= {"checkBluetooth"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkBluetooth(Model model,@RequestParam String cla_num
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_num").is(cla_num));
		List<Classes> list = mongoTemplate.find(query, Classes.class);
		String tea_id = list.get(0).getCla_tea_id();
		Query query1 = new Query();
		query.addCriteria(Criteria.where("tea_id").is(tea_id));
		List<Teacher> list1 = mongoTemplate.find(query1, Teacher.class);
		System.out.println(list1.get(0).getTea_blu_status());
		if(list1.get(0).getTea_blu_status().equals("1")){
			return (new JsonResult(200,"该老师的蓝牙已经打开").toString());
		}else{
			return (new JsonResult(302,"该老师的蓝牙还为打开，请少等片刻").toString());
		}
	}
	
	
	/** 
	 * 教师打开蓝牙
	 * 0:关闭
	 * 1:打开
	 * @throws UnsupportedEncodingException
	 *     http://116.62.222.40:8080/kaoqin/openBluetooth?tea_id=1584627250335
	 * */ 
	@RequestMapping(value= {"openBluetooth"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String openBluetooth(Model model,@RequestParam String tea_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("tea_id").is(tea_id));
		List<Teacher> list = mongoTemplate.find(query, Teacher.class);
		Update update = new Update();
		Teacher t = list.get(0);
		//t.setTea_blu_status("1");
		update.set("tea_id", t.getTea_id());
		update.set("tea_phone", t.getTea_phone());
		update.set("tea_school", t.getTea_school());
		update.set("tea_academy", t.getTea_academy());
		update.set("tea_name", t.getTea_name());
		update.set("tea_nickname", t.getTea_nickname());
		update.set("tea_sex", t.getTea_sex());
		update.set("tea_isAssisance", t.getTea_isAssisance());
		update.set("tea_picutre", t.getTea_picutre());
		update.set("tea_bluetooth", t.getTea_bluetooth());
		update.set("tea_blu_status", "1");
		
		WriteResult result = mongoTemplate.upsert(query, update, Teacher.class);
	    int i = result.getN();
	    if(i==1){
	    	List<Teacher> list1 = mongoTemplate.find(query, Teacher.class);
			return (new JsonResult(200,list1.get(0)).toString());
	    }else{
	    	return (new JsonResult(302,"更新失败").toString());
	    }
	}
	
	
	/** 
	 * 老师关闭蓝牙
	 * @throws UnsupportedEncodingException
	 *    http://116.62.222.40:8080/kaoqin/closeBluetooth?tea_id=1584627250335
	 * */ 
	@RequestMapping(value= {"closeBluetooth"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String closeBluetooth(Model model,@RequestParam String tea_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("tea_id").is(tea_id));
		List<Teacher> list = mongoTemplate.find(query, Teacher.class);
		Update update = new Update();
		Teacher t = list.get(0);
		//t.setTea_blu_status("1");
		update.set("tea_id", t.getTea_id());
		update.set("tea_phone", t.getTea_phone());
		update.set("tea_school", t.getTea_school());
		update.set("tea_academy", t.getTea_academy());
		update.set("tea_name", t.getTea_name());
		update.set("tea_nickname", t.getTea_nickname());
		update.set("tea_sex", t.getTea_sex());
		update.set("tea_isAssisance", t.getTea_isAssisance());
		update.set("tea_picutre", t.getTea_picutre());
		update.set("tea_bluetooth", t.getTea_bluetooth());
		update.set("tea_blu_status", "0");
		
		WriteResult result = mongoTemplate.upsert(query, update, Teacher.class);
	    int i = result.getN();
	    if(i==1){
	    	List<Teacher> list1 = mongoTemplate.find(query, Teacher.class);
			return (new JsonResult(200,list1.get(0)).toString());
	    }else{
	    	return (new JsonResult(302,"更新失败").toString());
	    }
	}
	
	/** 
	 * 学生完成打卡
	 * 0:关闭
	 * 1:打开
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/impleBluetooth?cla_num=0002&stu_id=1583675290261&att_status=0
	 * */ 
	@RequestMapping(value= {"impleBluetooth"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String impleBluetooth(Model model,@RequestParam String cla_num,String stu_id,String att_status
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_num").is(cla_num));
		List<Classes> list = mongoTemplate.find(query, Classes.class);
		String cla_name = list.get(0).getCla_name();
		
		Query query1 = new Query();
		query.addCriteria(Criteria.where("stu_id").is(stu_id));
		List<Student> list1 = mongoTemplate.find(query1, Student.class);
		String stu_name = list1.get(0).getStu_name();
		
		Criteria criteria = new Criteria();
		criteria.orOperator(
		Criteria.where("att_stu_id").is(stu_id),
		Criteria.where("att_cla_num").is(cla_num));
		Query query2 = new Query();
		query2.addCriteria(criteria);
		long count = mongoTemplate.count(query2, Attendance.class);
		System.out.println(count);
		List<Attendance> l= mongoTemplate.find(query2, Attendance.class,"attendance");
		
		System.out.println(l.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String data = year+"-"+month+"-"+day;
		Attendance a = new Attendance();
		a.setAtt_cla_name(cla_name);
		a.setAtt_cla_num(cla_num);
		a.setAtt_stu_id(stu_id);
		a.setAtt_stu_name(stu_name);
		a.setAtt_weeks(String.valueOf(count+1));
		a.setAtt_status(att_status);
		a.setAtt_time(data);
		mongoTemplate.save(a);
		return (new JsonResult(200,"打卡成功").toString());
	}
	
	/** 
	 * 老师关闭蓝牙
	 * @throws UnsupportedEncodingException
	 *    http://116.62.222.40:8080/kaoqin/test?att_cla_num=0002&att_stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"test"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String test(Model model,@RequestParam String att_cla_num,String att_stu_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("att_stu_id").is(att_stu_id));
		query.addCriteria(Criteria.where("att_cla_num").is(att_cla_num));
		List<Attendance> list = mongoTemplate.find(query, Attendance.class);
		
		
		return (new JsonResult(200,list).toString());
	}
	
	/** 
	 * 学生去查找老师的蓝牙地址
	 * @throws UnsupportedEncodingException
	 *    http://116.62.222.40:8080/kaoqin/test?att_cla_num=0002&att_stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"findBluetooth"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findBluetooth(Model model,@RequestParam String cla_num,String stu_id
			) throws UnsupportedEncodingException {
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_num").is(cla_num));
		List<Classes> list = mongoTemplate.find(query, Classes.class);
		if(list.size()==0){
			return (new JsonResult(302,"没有找到该班级，请确认班级号").toString());
		}
		Query query1 = new Query();
		query.addCriteria(Criteria.where("tea_id").is(list.get(0).getCla_tea_id()));
		List<Teacher> list1 = mongoTemplate.find(query1, Teacher.class);
		if(list1.size()==0){
			return (new JsonResult(302,"没有找到该老师的蓝牙").toString());
		}
		return (new JsonResult(200,"蓝牙地址查找成功",list1.get(0).getTea_bluetooth()).toString());
	}
}
