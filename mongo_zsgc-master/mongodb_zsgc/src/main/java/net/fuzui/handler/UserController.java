package net.fuzui.handler;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.fuzui.pojo.User;
import net.fuzui.pojo.StudentUser;
import net.fuzui.pojo.ParentsUser;
import net.fuzui.pojo.TeacherUser;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Controller

public class UserController {
	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * 注册页面
	 * */
	@RequestMapping(value= {"register"})
	public String register() {
		
		return "/register";
	}
	
	@RequestMapping(value= {"signup"})
	public String signup() {
		
		return "/signup";
	}
	/**
	 * 注册用户
	 * */
	@RequestMapping(value= "saveUser",method=RequestMethod.POST)
	public String saveUser(Model model,@RequestParam String name,@RequestParam String username,
			@RequestParam String password) {
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhonenumber(password);
		/**
		 * 一、save方法
		 * 遍历插入
		 * 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作
		 * */
		mongoTemplate.save(user);
		
		return "/login";
	}
	
	@RequestMapping(value= {"signupUser"},method=RequestMethod.POST)
	public String signup(Model model,@RequestParam String userStatus,@RequestParam String username,
			@RequestParam String userRealname,@RequestParam String userPhone,@RequestParam String userPassword,
			@RequestParam String userRePassword,@RequestParam String userGender,@RequestParam String userUniversity,
			@RequestParam String userSchool,@RequestParam String userMajor,@RequestParam String userNumber) throws UnsupportedEncodingException {
		
		if(userStatus.equals("parent")) {
			System.out.println("web端家长用户注册");
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("username").is(username));
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("phonenumber").is(userPhone));
			if(mongoTemplate.count(query1, ParentsUser.class)>0) {
				System.out.println("用户名重复");
				return "/error_username";
			}else if(mongoTemplate.count(query2, ParentsUser.class)>0) {
				System.out.println("手机号重复");
				return "/error_phonenumber";
			}else if(!userPassword.equals(userRePassword)) {
				System.out.println("两次密码输入不一致");
				return "/error_password";
			}
			else {
				System.out.println("检测通过");
				ParentsUser parentsUser1=new ParentsUser();
				parentsUser1.setUsername(username);
				parentsUser1.setName(userRealname);		
				parentsUser1.setPhonenumber(userPhone);
				parentsUser1.setRole(userStatus);
				parentsUser1.setPassword(userPassword);
				mongoTemplate.save(parentsUser1);
				System.out.println("家长用户注册成功");
				return "/index";
			}			
		}
		else if(userStatus.equals("teacher")) {
			System.out.println("web端教师用户注册");
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("username").is(username));
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("phonenumber").is(userPhone));
			if(mongoTemplate.count(query1, TeacherUser.class)>0) {
				System.out.println("用户名重复");
				return "/error_username";
			}else if(mongoTemplate.count(query2, TeacherUser.class)>0) {
				System.out.println("手机号重复");
				return "/error_phonenumber";
			}else if(!userPassword.equals(userRePassword)) {
				System.out.println("两次密码输入不一致");
				return "/error_password";
			}
			else {
				System.out.println("检测通过");
				TeacherUser teacherUser1=new TeacherUser();
				teacherUser1.setUsername(username);
				teacherUser1.setName(userRealname);		
				teacherUser1.setPhonenumber(userPhone);
				teacherUser1.setRole(userStatus);
				teacherUser1.setSchoolname(userUniversity);
				teacherUser1.setPassword(userPassword);
				teacherUser1.setSex(userGender);
				mongoTemplate.save(teacherUser1);
				System.out.println("教师用户注册成功");
				return "/index";
			}			
		}
		else {
			System.out.println("web端学生用户注册");
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("username").is(username));
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("phonenumber").is(userPhone));
			if(mongoTemplate.count(query1, StudentUser.class)>0) {
				System.out.println("用户名重复");
				return "/error_username";
			}else if(mongoTemplate.count(query2, StudentUser.class)>0) {
				System.out.println("手机号重复");
				return "/error_phonenumber";
			}else if(!userPassword.equals(userRePassword)) {
				System.out.println("两次密码输入不一致");
				return "/error_password";
			}
			else {
				System.out.println("检测通过");
				StudentUser studentUser1=new StudentUser();
				studentUser1.setUsername(username);
				studentUser1.setName(userRealname);		
				studentUser1.setPhonenumber(userPhone);
				studentUser1.setRole(userStatus);
				studentUser1.setSchoolname(userUniversity);
				studentUser1.setCollegename(userSchool);
				studentUser1.setMajorname(userMajor);
				studentUser1.setPassword(userPassword);
				studentUser1.setStudentnumber(userNumber);
				studentUser1.setSex(userGender);
				mongoTemplate.save(studentUser1);
				System.out.println("学生用户注册成功");
				return "/index";
			}			
		}
	}
	/**
	 * 插入用户
	 * */
	@RequestMapping(value= "springsubmit",method=RequestMethod.POST)
	public String insertUser(Model model,@RequestParam String phoneNumber,
			@RequestParam String password) {
		User user = new User();
		user.setName(phoneNumber);
		user.setUsername(phoneNumber);
		user.setPassword(password);
		
		/**
		 * 一、insert方法
		 * 一次性插入一整个列表，而不用进行遍历操作，效率相对较高
		 * 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
		 * */
		mongoTemplate.insert(user);
		return "/login";
	}
}
