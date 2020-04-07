package net.fuzui.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fuzui.pojo.Attendance1;
import net.fuzui.pojo.Children;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Parents;
import net.fuzui.pojo.ParentsUser;
import net.fuzui.pojo.Student;
import net.fuzui.pojo.StudentUser;
import net.fuzui.pojo.Teacher;
import net.fuzui.pojo.TeacherUser;
import net.fuzui.pojo.User;
@Controller
public class LoginController {
	
	@Autowired
	MongoTemplate mongoTemplate;

	

	/**
	 * 学生注册
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value= {"studentRegister"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String studentRegister(Model model,@RequestParam String stu_phone
			) throws UnsupportedEncodingException {
		System.out.println("......"+stu_phone);
		//return stu_phone1;
		//先去查询该手机号是否注册过了
		Query query = new Query();
		query.addCriteria(Criteria.where("stu_phone").is(stu_phone));
		if(mongoTemplate.count(query, Student.class)>0){
	        List<Student> userList1 = mongoTemplate.find(query,Student.class);
            System.out.println(new JsonResult(userList1.get(0)).toString());
    		return (new JsonResult(302,stu_phone+"该手机号已经被注册")).toString();
		}
		
		return (new JsonResult(200,stu_phone+"该手机号注册成功")).toString();

	}
	
	/**
	 * 学生完善信息    http://localhost:8080/kaoqin/studentInfo?stu_phone=15592296549&stu_academy=信息&stu_class=课程&stu_dad_phone=15512365445&stu_identity_num=156487&stu_mom_phone=16545896547&stu_name=任一鸣&stu_school=四川大学&stu_sex=女&stu_nickname=网名&stu_num=2012112226
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value= {"studentInfo"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String studentInfo(Model model,@RequestParam String stu_phone,@RequestParam String stu_academy,@RequestParam String stu_class,
			@RequestParam String stu_dad_phone,@RequestParam String stu_identity_num,@RequestParam String stu_mom_phone,
			@RequestParam String stu_name,@RequestParam String stu_school,
			@RequestParam String stu_sex,@RequestParam String stu_nickname,@RequestParam String stu_num
			) throws UnsupportedEncodingException {
		
		Long time = System.currentTimeMillis();
		String stu_id = String.valueOf(time);
		Student student = new Student();
		student.setStu_id(stu_id);
		student.setStu_academy(stu_academy);
		student.setStu_class(stu_class);
		student.setStu_dad_phone(stu_dad_phone);
		student.setStu_identity_num(stu_identity_num);
		student.setStu_mom_phone(stu_mom_phone);
		student.setStu_name(stu_name);
		student.setStu_nickname(stu_nickname);
		student.setStu_num(stu_num);
		student.setStu_phone(stu_phone);
		student.setStu_school(stu_school);
		student.setStu_sex(stu_sex);
		mongoTemplate.save(student);
		System.out.println(student);
		return (new JsonResult(200,student).toString());
	}
	
	/**
	 * 教师注册
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value= {"teacherRegister"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String teacherRegister(Model model,@RequestParam String tea_phone
			) throws UnsupportedEncodingException {
		Query query = new Query();
		query.addCriteria(Criteria.where("tea_phone").is(tea_phone));
		if(mongoTemplate.count(query, Teacher.class)>0){
			 List<Teacher> userList1 = mongoTemplate.find(query,Teacher.class);
	            System.out.println(userList1.get(0));
	    		return (new JsonResult(302,tea_phone+"该手机号已经被注册")).toString();
		}
		
		return (new JsonResult(200,tea_phone+"该手机号注册成功")).toString();
	}
	/**
	  *    http://localhost:8080/kaoqin/teacherInfo?tea_phone=15592296549&tea_academy=信息&tea_school=西南交大&tea_name=徐图&tea_nickname=网名&tea_sex=男&tea_isAssisance=否&tea_picutre=略

	 * 教师完善信息
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value= {"teacherInfo"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String teacherInfo(Model model,@RequestParam String tea_phone,@RequestParam String tea_school,@RequestParam String tea_academy,
			@RequestParam String tea_name,@RequestParam String tea_nickname,@RequestParam String tea_sex,@RequestParam String tea_isAssisance,
			@RequestParam String tea_picutre
			) throws UnsupportedEncodingException {
		Long time=System.currentTimeMillis();
		String tea_id = String.valueOf(time);
		Teacher teacher = new Teacher();
		teacher.setTea_isAssisance(tea_isAssisance);
		teacher.setTea_id(tea_id);
		teacher.setTea_academy(tea_academy);
		teacher.setTea_name(tea_name);
		teacher.setTea_nickname(tea_nickname);
		teacher.setTea_phone(tea_phone);
		teacher.setTea_picutre(tea_picutre);
		teacher.setTea_school(tea_school);
		teacher.setTea_sex(tea_sex);
		teacher.setTea_blu_status("0");
		//teacher.setTea_bluetooth("1234567890");
		mongoTemplate.save(teacher);
		System.out.println(teacher);
		return (new JsonResult(200,teacher)).toString();
	}

	/** 
	 * 家长注册 
	 * @throws UnsupportedEncodingException 
	 * */ 
	@RequestMapping(value= {"parentRegister"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String parentRegister(Model model,@RequestParam String par_phone
			) throws UnsupportedEncodingException {
		System.out.println("......"+par_phone);
		//return stu_phone1
		//先去查询该手机号是否注册过了
		Query query = new Query();
		query.addCriteria(Criteria.where("par_phone").is(par_phone));
		if(mongoTemplate.count(query, Parents.class)>0){
	        List<Parents> userList1 = mongoTemplate.find(query,Parents.class);
            System.out.println(new JsonResult(userList1.get(0)).toString());
    		return (new JsonResult(302,par_phone+"该手机号已经被注册").toString());
		}
		
		return (new JsonResult(200,par_phone+"注册成功，请跳转到完善信息页面").toString());

	}
	
	/** 
	 * 家长完善信息 
	 * @throws UnsupportedEncodingException 
	 * */ 
	@RequestMapping(value= {"parentInfo"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String parentInfo(Model model,@RequestParam String par_phone,@RequestParam String par_name
			,@RequestParam String par_nickname,@RequestParam String par_sex
			) throws UnsupportedEncodingException {
		long time = System.currentTimeMillis();
		String par_id = String.valueOf(time);
		Parents parent = new Parents();
		parent.setPar_id(par_id);
		parent.setPar_name(par_name);
		parent.setPar_nickname(par_nickname);
		parent.setPar_phone(par_phone);
		parent.setPar_sex(par_sex);
		mongoTemplate.save(parent);
		System.out.println(parent);
		return (new JsonResult(200,parent).toString());
	}
	/** 
	 * 孩子注册 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/childrenRegister?ch_phone=13262365469&ch_name=任章哲&ch_school=清华大学&ch_academy=土木&ch_sex=女&ch_stu_identity_num=123645&ch_par_id=123654854
	 * */ 
	@RequestMapping(value= {"childrenRegister"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String childrenRegister(Model model,@RequestParam String ch_phone,@RequestParam String ch_name,@RequestParam String ch_school,
			@RequestParam String ch_academy,@RequestParam String ch_sex,@RequestParam String ch_stu_identity_num,@RequestParam String ch_par_id
			) throws UnsupportedEncodingException {
		System.out.println("......"+ch_phone);
		
		Children children = new Children();
		children.setCh_academy(ch_academy);
		children.setCh_name(ch_name);
		children.setCh_par_id(ch_par_id);
		children.setCh_phone(ch_phone);
		children.setCh_school(ch_school);
		children.setCh_sex(ch_sex);
		children.setCh_stu_identity_num(ch_stu_identity_num);
		mongoTemplate.save(children);
		System.out.println(children);
		return (new JsonResult(200,children).toString());
	}
	/** 
	 * 学生登录登录
	 * http://localhost:8080/kaoqin/studentLogin?stu_phone=13541197180&stu_password=rzz
	 * @throws UnsupportedEncodingException 
	 * */ 
	@RequestMapping(value= {"studentLogin"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String studentLogin(Model model,@RequestParam String stu_phone,@RequestParam String stu_password
			) throws UnsupportedEncodingException {
		Query query = new Query();
		query.addCriteria(Criteria.where("stu_phone").is(stu_phone));
		List<Student> list = mongoTemplate.find(query,Student.class);
		if(list.size()==0){
			return (new JsonResult(302,"该手机号还没有注册").toString());
		}
		if(list.get(0).getStu_password().equals(stu_password)){
			return (new JsonResult(200,"登录成功",list.get(0)).toString());
		}else{
			return (new JsonResult(302,"登录失败").toString());
		}
	}
	
	/** 
	 * 教师登录登录
	 * 	 * http://localhost:8080/kaoqin/teacherLogin?tea_phone=15592296549&tea_password=2414234 
	 * @throws UnsupportedEncodingException 
	 * */ 
	@RequestMapping(value= {"teacherLogin"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String teacherLogin(Model model,@RequestParam String tea_phone,@RequestParam String tea_password
			) throws UnsupportedEncodingException {
		Query query = new Query();
		query.addCriteria(Criteria.where("tea_phone").is(tea_phone));
		List<Teacher> list = mongoTemplate.find(query,Teacher.class);
		if(list.size()==0){
			return (new JsonResult(302,"该手机号还没有注册").toString());
		}
		if(list.get(0).getTea_password().equals(tea_password)){
			return (new JsonResult(200,"登录成功",list.get(0)).toString());
		}else{
			return (new JsonResult(302,"登录失败").toString());
		}
	}
	
	/** 
	 *  http://localhost:8080/kaoqin/parentsLogin?par_phone=13541187191&par_password=1234
	 * 家长登录登录 
	 * @throws UnsupportedEncodingException 
	 * */ 
	@RequestMapping(value= {"parentsLogin"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String parentsLogin(Model model,@RequestParam String par_phone,@RequestParam String par_password
			) throws UnsupportedEncodingException {
		Query query = new Query();
		query.addCriteria(Criteria.where("par_phone").is(par_phone));
		List<Parents> list = mongoTemplate.find(query,Parents.class);
		if(list.size()==0){
			return (new JsonResult(302,"该手机号还没有注册").toString());
		}
		if(list.get(0).getPar_password().equals(par_password)){
			return (new JsonResult(200,"登录成功",list.get(0)).toString());
		}else{
			return (new JsonResult(302,"登录失败").toString());
		}
	}
}
