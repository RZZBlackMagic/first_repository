package net.fuzui.handler;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fuzui.pojo.User;
import net.fuzui.pojo.StudentUser;
import net.fuzui.pojo.ParentsUser;
import net.fuzui.pojo.TeacherUser;
import net.fuzui.pojo.Course;
import net.fuzui.pojo.Attendance;
import net.fuzui.pojo.Attendance1;

@Controller
@RequestMapping("/login")
public class JsonController {
	@Autowired
	MongoTemplate mongoTemplate;
	
	//获取json格式 从Android端传来的json格式，如果不是json格式，这里就接收不到数据
	
		@RequestMapping("/toJsonMain")//安装端用户登录控制器
		public @ResponseBody User toJsonMain(@RequestBody User  user ) throws Exception{
				
			String username=user.getUsername();
			String password=user.getPassword();
			String role=user.getRole();
			
			System.out.println("安卓端用户登入");
			
			User user1=new User();
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("username").is(username));
			query1.addCriteria(Criteria.where("password").is(password));
			
			if(role.equals("student")) {
				if(mongoTemplate.count(query1, StudentUser.class)>0) {
					List<StudentUser> studentuserList = mongoTemplate.find(query1,StudentUser.class);
					user1 = studentuserList.get(0);//将查询到的第一条数据放在实体中
					System.out.println("学生用户成功登录");
					return user1;
				}else {
					System.out.println("学生用户登录失败");
					return user1;
				}
			}else if(role.equals("parent")){
				if(mongoTemplate.count(query1, ParentsUser.class)>0) {
					List<ParentsUser> parentsuserList = mongoTemplate.find(query1,ParentsUser.class);
					user1 = parentsuserList.get(0);//将查询到的第一条数据放在实体中
					System.out.println("家长用户成功登录");
					return user1;
				}else {
					System.out.println("家长用户登录失败");
					return user1;
				}
			}
			else if(role.equals("teacher")){
				if(mongoTemplate.count(query1, TeacherUser.class)>0) {
					List<TeacherUser> teacheruserList = mongoTemplate.find(query1,TeacherUser.class);
					user1 = teacheruserList.get(0);//将查询到的第一条数据放在实体中
					System.out.println("教师用户成功登录");
					return user1;
				}else {
					System.out.println("教师用户登录失败");
					return user1;
				}
			}
			else {
				System.out.println("出错");
				return user1;
			}
		}
		
		@RequestMapping("/toStudentUserRegister")
		public @ResponseBody StudentUser toStudentUserRegister(@RequestBody StudentUser  studentUser ) throws Exception{
			System.out.println("安卓端学生用户注册");
			
			int state=studentUser.getState();

			if(state == 2) {
				System.out.println("state为2");
				String username=studentUser.getUsername();
				String phonenumber=studentUser.getPhonenumber();
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("username").is(username));
				Query query2 = new Query();
				query2.addCriteria(Criteria.where("phonenumber").is(phonenumber));
				if(mongoTemplate.count(query1, StudentUser.class)>0) {
					studentUser.setState(102);
					System.out.println("用户名重复");
					return studentUser;
				}else if(mongoTemplate.count(query2, StudentUser.class)>0) {
					studentUser.setState(101);
					System.out.println("手机号重复");
					return studentUser;
				}else {
					studentUser.setState(1);
					System.out.println("用户名、手机号检测通过");
					return studentUser;
				}
			}else if(state == 1) {
				System.out.println("state为1");
				String username=studentUser.getUsername();
				String name=studentUser.getName();
				String phonenumber=studentUser.getPhonenumber();
				String role=studentUser.getRole();
				String schoolname=studentUser.getSchoolname();
				String collegename=studentUser.getCollegename();
				String majorname=studentUser.getMajorname();
				String password=studentUser.getPassword();
				String studentnumber=studentUser.getStudentnumber();
				String sex=studentUser.getSex();
				
				StudentUser studentUser1=new StudentUser();
				studentUser1.setUsername(username);
				studentUser1.setName(name);		
				studentUser1.setPhonenumber(phonenumber);
				studentUser1.setRole(role);
				studentUser1.setSchoolname(schoolname);
				studentUser1.setCollegename(collegename);
				studentUser1.setMajorname(majorname);
				studentUser1.setPassword(password);
				studentUser1.setStudentnumber(studentnumber);
				studentUser1.setSex(sex);
				mongoTemplate.save(studentUser1);
				studentUser.setState(0);
				System.out.println("学生用户注册成功");
				return studentUser;
			}else {
				System.out.println("出错");
				return studentUser;
			}		
		}
		
		@RequestMapping("/toParentUserRegister")
		public @ResponseBody ParentsUser toParentUserRegister(@RequestBody ParentsUser  parentsUser ) throws Exception{
			System.out.println("安卓端家长用户注册");
			
			int state=parentsUser.getState();

			if(state == 2) {
				System.out.println("state为2");
				String username=parentsUser.getUsername();
				String phonenumber=parentsUser.getPhonenumber();
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("username").is(username));
				Query query2 = new Query();
				query2.addCriteria(Criteria.where("phonenumber").is(phonenumber));
				if(mongoTemplate.count(query1, ParentsUser.class)>0) {
					parentsUser.setState(202);
					System.out.println("用户名重复");
					return parentsUser;
				}else if(mongoTemplate.count(query2, ParentsUser.class)>0) {
					parentsUser.setState(201);
					System.out.println("手机号重复");
					return parentsUser;
				}else {
					parentsUser.setState(1);
					System.out.println("用户名、手机号检测通过");
					return parentsUser;
				}
			}else if(state == 1) {
				System.out.println("state为1");
				String username=parentsUser.getUsername();
				String name=parentsUser.getName();
				String phonenumber=parentsUser.getPhonenumber();
				String role=parentsUser.getRole();
				String password=parentsUser.getPassword();
				
				ParentsUser parentsUser1=new ParentsUser();
				parentsUser1.setUsername(username);
				parentsUser1.setName(name);		
				parentsUser1.setPhonenumber(phonenumber);
				parentsUser1.setRole(role);
				parentsUser1.setPassword(password);
				mongoTemplate.save(parentsUser1);
				parentsUser.setState(0);
				System.out.println("家长用户注册成功");
				return parentsUser;
			}else {
				System.out.println("出错");
				return parentsUser;
			}		
		}
		
		@RequestMapping("/toTeacherUserRegister")
		public @ResponseBody TeacherUser toTeacherUserRegister(@RequestBody TeacherUser  teacherUser ) throws Exception{
			System.out.println("安卓端教师用户注册");
			
			int state=teacherUser.getState();

			if(state == 2) {
				System.out.println("state为2");
				String username=teacherUser.getUsername();
				String phonenumber=teacherUser.getPhonenumber();
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("username").is(username));
				Query query2 = new Query();
				query2.addCriteria(Criteria.where("phonenumber").is(phonenumber));
				if(mongoTemplate.count(query1, TeacherUser.class)>0) {
					teacherUser.setState(302);
					System.out.println("用户名重复");
					return teacherUser;
				}else if(mongoTemplate.count(query2, TeacherUser.class)>0) {
					teacherUser.setState(301);
					System.out.println("手机号重复");
					return teacherUser;
				}else {
					teacherUser.setState(1);
					System.out.println("用户名、手机号检测通过");
					return teacherUser;
				}
			}else if(state == 1) {
				System.out.println("state为1");
				String username=teacherUser.getUsername();
				String name=teacherUser.getName();
				String phonenumber=teacherUser.getPhonenumber();
				String role=teacherUser.getRole();
				String schoolname=teacherUser.getSchoolname();
				String password=teacherUser.getPassword();
				String sex=teacherUser.getSex();
				String bluetooth=teacherUser.getBluetooth();
				
				TeacherUser teacherUser1=new TeacherUser();
				teacherUser1.setUsername(username);
				teacherUser1.setName(name);		
				teacherUser1.setPhonenumber(phonenumber);
				teacherUser1.setRole(role);
				teacherUser1.setSchoolname(schoolname);
				teacherUser1.setPassword(password);
				teacherUser1.setSex(sex);
				teacherUser1.setBluetooth(bluetooth);
				mongoTemplate.save(teacherUser1);
				teacherUser.setState(0);
				System.out.println("教师用户注册成功");
				return teacherUser;
			}else {
				System.out.println("出错");
				return teacherUser;
			}		
		}
		
		@RequestMapping("/toCourseCreate")
		public @ResponseBody Course toCourseCreate(@RequestBody Course  course ) throws Exception{
			System.out.println("安卓端教师创建课程");
			
			String coursename=course.getCoursename();
			String accesscode=course.getAccesscode();
			String teachername=course.getTeachername();
			
			Course course1=new Course();
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("coursename").is(coursename));
			query2.addCriteria(Criteria.where("accesscode").is(accesscode));
			if(mongoTemplate.count(query2, Course.class)>0) {
				course.setState("402");
				System.out.println("课程名的密码重复");
				return course;
			}
			else {
				TeacherUser teacherUser1=new TeacherUser();
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("username").is(teachername));
				List<TeacherUser> teacheruserList = mongoTemplate.find(query1,TeacherUser.class);
				teacherUser1 = teacheruserList.get(0);//将查询到的第一条数据放在实体中
				String schoolname=teacherUser1.getSchoolname();
				String bluetooth=teacherUser1.getBluetooth();
				if(bluetooth == null) {
					course.setState("401");
					System.out.println("教师蓝牙地址为空");
					return course;
				}
				course1.setCoursename(coursename);
				course1.setAccesscode(accesscode);
				course1.setSchoolname(schoolname);
				course1.setTeachername(teachername);
				course1.setBluetooth(bluetooth);
				course1.setState("1");
				mongoTemplate.save(course1);
				System.out.println("创建课程成功");
				System.out.println(coursename);
				return course1;
			}
		}
		
		@RequestMapping("/toCourseAdd")
		public @ResponseBody Course toCourseAdd(@RequestBody Course  course ) throws Exception{
			System.out.println("安卓端学生加入课程");
			
			String coursename=course.getCoursename();
			String accesscode=course.getAccesscode();
			String studentname=course.getStudentname();
			
			Course course1=new Course();
			Query query2 = new Query();
			query2.addCriteria(Criteria.where("coursename").is(coursename));
			query2.addCriteria(Criteria.where("accesscode").is(accesscode));
			if(mongoTemplate.count(query2, Course.class)>0) {
				StudentUser studentUser1=new StudentUser();
				Query query1 = new Query();
				query1.addCriteria(Criteria.where("username").is(studentname));
				List<StudentUser> studentuserList = mongoTemplate.find(query1,StudentUser.class);
				studentUser1 = studentuserList.get(0);//将查询到的第一条数据放在实体中
				List<Course> courseList = mongoTemplate.find(query2,Course.class);
				course1 = courseList.get(0);//将查询到的第一条数据放在实体中
				Update update = new Update(); 
				List<StudentUser> studentlist=course1.getStudentlist();
				if((studentlist==null) || (studentlist.size()==0)) {
					List<StudentUser> studentlist1=new ArrayList<StudentUser>();
					studentlist1.add(studentUser1);
					update = Update.update("studentlist",studentlist1);
					mongoTemplate.upsert(query2, update,Course.class);
					System.out.println("学生第一次加入课程");
					return course1;
				}
				else if(!studentlist.contains(studentUser1)) {
					studentlist.add(studentUser1);
					update = Update.update("studentlist",studentlist);
					mongoTemplate.upsert(query2, update,Course.class);
					System.out.println("加入课程成功");
					return course1;
				}		
				else {
					return course1;
				}
			}
			else {
				System.out.println("无此课程");
				return course1;
			}
		}
		
		@RequestMapping("/toCourseShow")
		public @ResponseBody User toCourseShow(@RequestBody User  user ) throws Exception{
			System.out.println("安卓端显示课程");
			
			String username=user.getUsername();
			String role=user.getRole();
			User user1=new User();
			user1.setUsername(username);
			user1.setRole(role);
			
			Query query2 = new Query();
			if(role.equals("teacher")) {
				query2.addCriteria(Criteria.where("teachername").is(username));
				List<Course> courselist =mongoTemplate.find(query2,Course.class);
				user1.setCourselist(courselist);
				System.out.println("安卓端教师显示课程成功");
				return user1;
			}
			else if(role.equals("student")) {
				query2.addCriteria(Criteria.where("studentlist.username").is(username));
				List<Course> courselist =mongoTemplate.find(query2,Course.class);
				user1.setCourselist(courselist);
				System.out.println("安卓端学生显示课程成功");
				return user1;
			}
			else {
				return user1;
			}	
		}			
		
		@RequestMapping("/toTeacherAttendanceStart")
		public @ResponseBody Course toTeacherAttendanceStart(@RequestBody Attendance  attendance ) throws Exception{
			System.out.println("安卓端教师开始考勤");
			
			String coursename=attendance.getCoursename();
			String accesscode=attendance.getAccesscode();
			String time=attendance.getTime();
			String teachername=attendance.getTeachername();
			Course course=new Course();
			
			Attendance	attendance1=new Attendance();
			attendance1.setCoursename(coursename);
			attendance1.setAccesscode(accesscode);
			attendance1.setTeachername(teachername);
			attendance1.setTime(time);
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("coursename").is(coursename));
			query1.addCriteria(Criteria.where("accesscode").is(accesscode));
			long count=mongoTemplate.count(query1, Attendance.class)+1;
			attendance1.setCount(count);
			attendance1.setState("on");
			attendance1.setEndtime("未结束");
			course.setState("1");
			mongoTemplate.save(attendance1);
			return course;
		}
		
		@RequestMapping("/toTeacherAttendanceEnd")
		public @ResponseBody Course toTeacherAttendanceEnd(@RequestBody Attendance  attendance ) throws Exception{
			System.out.println("安卓端教师结束考勤");
			
			String coursename=attendance.getCoursename();
			String accesscode=attendance.getAccesscode();
			String endtime=attendance.getTime();
			String teachername=attendance.getTeachername();
			Course course=new Course();
			Course course1=new Course();
			Attendance attendance1=new Attendance();
			
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("coursename").is(coursename));
			query1.addCriteria(Criteria.where("accesscode").is(accesscode));
			List<Course> courselist =mongoTemplate.find(query1,Course.class);
			course1=courselist.get(0);
			long count=mongoTemplate.count(query1, Attendance.class);
			query1.addCriteria(Criteria.where("count").is(count));
			List<Attendance> attendancelist =mongoTemplate.find(query1,Attendance.class);
			attendance1=attendancelist.get(0);
			List<StudentUser> studentlist1=attendance1.getStudentlist();
			Update update = new Update(); 
			update = Update.update("endtime",endtime);
			mongoTemplate.upsert(query1, update,Attendance.class);
			update = Update.update("state","off");
			course.setState("1");
			mongoTemplate.upsert(query1, update,Attendance.class);			
			
			List<StudentUser> studentlist=course1.getStudentlist();
			if((studentlist==null) || (studentlist.size()==0)) {
				return course;
			}
			if((studentlist1==null) || (studentlist1.size()==0)) {
				List<StudentUser> studentlist2=new ArrayList<StudentUser>();
				for(int i=0;i<studentlist.size();i++){
					StudentUser studentUser1=new StudentUser();
					StudentUser studentUser2=new StudentUser();
					studentUser2=studentlist.get(i);
					studentUser1.setUsername(studentUser2.getUsername());
					studentUser1.setAttendancestate("未签到");
					studentUser1.setAttendancetime("未签到");
					studentlist2.add(studentUser1);
				}
				update = Update.update("studentlist",studentlist2);
				mongoTemplate.upsert(query1, update,Attendance.class);
				System.out.println("无学生签到");
			}
			else {
				for(int i=0;i<studentlist.size();i++){
					if(!studentlist1.contains(studentlist.get(i))) {
						StudentUser studentUser1=new StudentUser();
						StudentUser studentUser2=new StudentUser();
						studentUser2=studentlist.get(i);
						studentUser1.setUsername(studentUser2.getUsername());
						studentUser1.setAttendancestate("未签到");
						studentUser1.setAttendancetime("未签到");
						studentlist1.add(studentUser1);
					}
				}
				update = Update.update("studentlist",studentlist1);
				mongoTemplate.upsert(query1, update,Attendance.class);
				System.out.println("有学生签到");
			}
			
			List<Attendance> attendancelist1 =mongoTemplate.find(query1,Attendance.class);
			attendance1=attendancelist1.get(0);
			studentlist1=attendance1.getStudentlist();
			Attendance1 attendance11=new Attendance1();
			Attendance1 attendance12=new Attendance1();
			attendance11.setCoursename(coursename);
			attendance11.setAccesscode(accesscode);
			attendance11.setTeachername(teachername);
			for(int i=0;i<studentlist1.size();i++){
				attendance11.setStudentname(studentlist1.get(i).getUsername());
				Query query2 = new Query();
				query2.addCriteria(Criteria.where("coursename").is(coursename));
				query2.addCriteria(Criteria.where("accesscode").is(accesscode));
				query2.addCriteria(Criteria.where("studentname").is(studentlist1.get(i).getUsername()));
				if(mongoTemplate.count(query2, Attendance1.class)<=0) {
					List<String> statelist=new ArrayList<String>();  
					statelist.add(studentlist1.get(i).getAttendancestate());
					attendance11.setStatelist(statelist);
					mongoTemplate.save(attendance11);
				}
				else {
					List<Attendance1> attendance1list =mongoTemplate.find(query2,Attendance1.class);
					attendance12=attendance1list.get(0);
					List<String> statelist=attendance12.getStatelist();
					statelist.add(studentlist1.get(i).getAttendancestate());
					update = Update.update("statelist",statelist);
					mongoTemplate.upsert(query2, update,Attendance1.class);
				}
			}
			return course;
		}
		
		@RequestMapping("/toStudentAttendanceStart")
		public @ResponseBody User toStudentAttendanceStart(@RequestBody Attendance  attendance ) throws Exception{
			System.out.println("安卓端学生考勤");
			
			String coursename=attendance.getCoursename();
			String accesscode=attendance.getAccesscode();
			String attendancetime=attendance.getTime();
			String studentname=attendance.getStudentname();
			User user=new User();
			
			Attendance	attendance1=new Attendance();
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("coursename").is(coursename));
			query1.addCriteria(Criteria.where("accesscode").is(accesscode));
			long count=mongoTemplate.count(query1, Attendance.class);
			query1.addCriteria(Criteria.where("count").is(count));
			query1.addCriteria(Criteria.where("state").is("on"));
			if(mongoTemplate.count(query1, Attendance.class)<=0) {		
				System.out.println("安卓端学生考勤失败");
				return user;
			}
			List<Attendance> attendanceList = mongoTemplate.find(query1,Attendance.class);
			attendance1 = attendanceList.get(0);	
			String time=attendance1.getTime();
			long time1=Long.parseLong(attendancetime);
			long time2=Long.parseLong(time);
			if(time1<time2) {
				System.out.println("安卓端学生考勤失败");
				return user;
			}
			List<StudentUser> studentlist=attendance1.getStudentlist();
			StudentUser studentUser1=new StudentUser();
			studentUser1.setUsername(studentname);
			studentUser1.setAttendancestate("已签到");
			studentUser1.setAttendancetime(attendancetime);
			user.setUsername(studentname);
			Update update = new Update(); 
			if((studentlist==null) || (studentlist.size()==0)) {
				List<StudentUser> studentlist1=new ArrayList<StudentUser>();
				studentlist1.add(studentUser1);
				update = Update.update("studentlist",studentlist1);
				mongoTemplate.upsert(query1, update,Attendance.class);
				System.out.println("学生第一次签到");
				return user;
			}
			else if(!studentlist.contains(studentUser1)) {
				studentlist.add(studentUser1);
				update = Update.update("studentlist",studentlist);
				mongoTemplate.upsert(query1, update,Attendance.class);
				System.out.println("学生签到成功");
				return user;
			}	
			else {
				return user;
			}
		}
		
		@RequestMapping("/toBluetoothAdd")
		public @ResponseBody User toBluetoothAdd(@RequestBody TeacherUser  teacheruser ) throws Exception{
			System.out.println("安卓端教师添加蓝牙地址");
			
			String username=teacheruser.getUsername();
			String bluetooth=teacheruser.getBluetooth();
			
			User user=new User();
			TeacherUser teacheruser1=new TeacherUser();
			Query query1 = new Query();
			query1.addCriteria(Criteria.where("username").is(username));
			List<TeacherUser> teacheruserList = mongoTemplate.find(query1,TeacherUser.class);
			teacheruser1=teacheruserList.get(0);
			teacheruser1.setBluetooth(bluetooth);
			mongoTemplate.save(teacheruser1);
			user.setUsername(username);
			System.out.println("安卓端教师添加蓝牙地址成功");
			return user;
		}
}
