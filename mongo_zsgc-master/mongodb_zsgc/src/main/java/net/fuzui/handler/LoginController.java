package net.fuzui.handler;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fuzui.pojo.User;
import net.fuzui.pojo.StudentUser;
import net.fuzui.pojo.ParentsUser;
import net.fuzui.pojo.Student;
import net.fuzui.pojo.TeacherUser;
import net.fuzui.pojo.Attendance;
import net.fuzui.pojo.Attendance1;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller


public class LoginController {
	
	
	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 登录页面
	 * */
	@RequestMapping(value= {"login"})
	public String login() {
		System.out.println("进入login");
		return "/login";
	}
	/**
	 * 用户登录
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping(value= {"loginUser"})
	public String loginUser(Model model,@RequestParam String username,
			@RequestParam String password,@RequestParam String status) throws UnsupportedEncodingException {
		System.out.println("进入loginUser");
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		query.addCriteria(Criteria.where("password").is(password));
		if((mongoTemplate.count(query, StudentUser.class)>0) && (status.equals("student"))) {
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("studentname").is(username));
			List<Attendance1> attendanceList11 = mongoTemplate.find(query1,Attendance1.class);
			model.addAttribute("attendance1Info",attendanceList11);
			System.out.println("学生用户登录成功");
			return "/space-stu";
		}else if((mongoTemplate.count(query, ParentsUser.class)>0) && (status.equals("parent"))) {
			System.out.println("家长用户登录成功");
			return "/index";
		}
		else if((mongoTemplate.count(query, TeacherUser.class)>0) && (status.equals("teacher"))) {
			System.out.println("教师用户登录成功");
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("teachername").is(username));
			List<Attendance1> attendanceList11 = mongoTemplate.find(query1,Attendance1.class);
			model.addAttribute("attendance1Info",attendanceList11);
			return "/space-tch";
		}
		else if ("admin".equals(username) && "admin".equals(password)){
            List<User> userList = mongoTemplate.find(new Query(),User.class);
            model.addAttribute("userinfo",userList);
			return "/management";
		}
		System.out.println("登录错误");
		return "/error";
	}
	/**
     * 用户删除
     * */
	@RequestMapping(value="userinfo/{name}",method = RequestMethod.DELETE)

	public String deleteUser(@PathVariable(value = "name") String name,Model model){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        if(mongoTemplate.remove(query,User.class)!= null){
            System.out.println(name+"删除成功");

			return "redirect:/query";
        }else {
            System.out.println(name+"删除失败");
            return "redirect:/query";
        }

    }
    /**
	 * 查询全部
	 * */
	@RequestMapping(value= {"query"})
	public String queryAll(Model model) {
			System.out.println("查询全部");

			List<User> userList = mongoTemplate.find(new Query(),User.class);
			model.addAttribute("userinfo",userList);
			return "/management";
		}




    /**
	 * 进入修改界面
	 * */
    @RequestMapping(value = "queryuser/{name}",method = RequestMethod.GET)
	public String update(@PathVariable(value = "name") String name,Model model){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<User> userList= mongoTemplate.find(query,User.class);
		User user = userList.get(0);//将查询到的第一条数据放在实体中
		model.addAttribute("user",user);

		return "/update";
	}
	/*
	 * 修改/添加用户
	 */
	@RequestMapping(value="addUser/{name}",method=RequestMethod.GET)
	public String addUser(@PathVariable(value="name") String name,Model model) {
		User user = new User();
		Query query = new Query();
		System.out.println("进入test");

		if(!"0".equals(name)) {
			//根据姓名查找
			query.addCriteria(Criteria.where("name").is(name));
			List<User> userList = mongoTemplate.find(query,User.class);

			user = userList.get(0);

		}
		model.addAttribute("user", user);

		return "/update";
	}

	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doAddShop(User user) {
		System.out.println("添加...");
		mongoTemplate.insert(user);
		return "redirect:/query";


	}

	/*
	 * 修改用户信息
	 */
	@RequestMapping(value="update",method=RequestMethod.PUT)
	public String modityShop(User user) {
		System.out.println("修改...");
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(user.getName()));

		Update update = new Update();
		update = Update.update("name",user.getName()).set("username",user.getUsername()).set("password",user.getPassword());
		mongoTemplate.upsert(query,update,User.class);

		return "redirect:/query";

	}

	@RequestMapping(value= {"test"})
	public String test() {
		System.out.println("测试代码：");
		Query query = new Query();
        List<Student> userList1 = mongoTemplate.find(query,Student.class);
        System.out.println(userList1.toString());
		return "/login";
	}
	
}
