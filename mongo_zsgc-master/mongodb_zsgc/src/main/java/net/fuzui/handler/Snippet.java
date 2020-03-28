package net.fuzui.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Snippet {
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
}

