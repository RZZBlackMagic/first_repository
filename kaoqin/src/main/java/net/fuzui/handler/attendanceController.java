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
import net.fuzui.pojo.Classes;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Teacher;

@Controller
public class attendanceController {

	@Autowired
	MongoTemplate mongoTemplate;
	
	/** 
	 * 学生查询当前学期对应班级的打卡情况
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://116.62.222.40:8080/kaoqin/selectRecordByClassNum?cla_num=0002&stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"selectRecordByClassNum"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectRecordByClassNum(Model model,@RequestParam String cla_num,@RequestParam String stu_id
			) throws UnsupportedEncodingException {
		int count=0;//总打卡数
		int normal_count=0;//正常出席
		int qingjia_count = 0;
		int taoke_count = 0;
		Query query = new Query();
		query.addCriteria(Criteria.where("att_cla_num").is(cla_num));
		query.addCriteria(Criteria.where("att_stu_id").is(stu_id));
	    List<Attendance> userList1 = mongoTemplate.find(query,Attendance.class);
	    System.out.println(userList1.toString());
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该同学还有打卡记录").toString());
	    }
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		month++;
		System.out.println(year);
		if(month<3&&month>=9){
			//查询上半年的打卡情况
			for(int i=0;i<userList1.size();i++){
				String [] date = userList1.get(i).getAtt_time().split("-");
				if((Integer.valueOf(date[1])<3&&Integer.valueOf(date[0])==year)||((Integer.valueOf(date[1])>=9)&&(Integer.valueOf(date[1])==(year-1)))){
					if(userList1.get(i).getAtt_status().equals("0")){
						normal_count++;
					}else if(userList1.get(i).getAtt_status().equals("1")){
						taoke_count++;
					}else{
						qingjia_count++;
					}
					count++;
				}
			}
		}
		if(month>=3&&month<9){
			//查询下半年的打卡情况
			for(int i=0;i<userList1.size();i++){
				System.out.println("1");
				String [] date = userList1.get(i).getAtt_time().split("-");
				if(Integer.valueOf(date[0])==year&&Integer.valueOf(date[1])>=3&&Integer.valueOf(date[1])<9){
					if(userList1.get(i).getAtt_status().equals("0")){
						normal_count++;
					}else if(userList1.get(i).getAtt_status().equals("1")){
						taoke_count++;
					}else{
						qingjia_count++;
					}
					count++;
				}
			}
		}
		return (new JsonResult(200,"该学生一共打卡"+count+"次，正常签到"+normal_count+"次，请假"+qingjia_count+"次，旷课"+taoke_count+"次")).toString();
	}
	
	
	/** 
	 * 学生查询所有的打卡视频
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://116.62.222.40:8080/kaoqin/selectAllRecord?stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"selectAllRecord"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllRecord(Model model,@RequestParam String stu_id
			) throws UnsupportedEncodingException {
		int count=0;//总打卡数
		int normal_count=0;//正常出席
		int qingjia_count = 0;
		int taoke_count = 0;
		Query query = new Query();
		query.addCriteria(Criteria.where("att_stu_id").is(stu_id));

	    List<Attendance> userList1 = mongoTemplate.find(query,Attendance.class);
	    System.out.println(userList1.toString());
	    
	    for(int i=0;i<userList1.size();i++){
	    	count++;
	    	if(userList1.get(i).getAtt_status().equals("0")){
	    		normal_count++;
	    	}else if(userList1.get(i).getAtt_status().equals("1")){
	    		taoke_count++;
	    	}else{
	    		qingjia_count++;
	    	}
	    }
		return (new JsonResult(200,"该学生一共打卡"+count+"次，正常签到"+normal_count+"次，请假"+qingjia_count+"次，旷课"+taoke_count+"次")).toString();
	}
	
	/** 
	 * 学生查询对应班级的打卡情况
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/selectAllRecordByClass?cla_num=0002&stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"selectAllRecordByClass"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllRecordByClass(Model model,@RequestParam String stu_id,@RequestParam String cla_num
			) throws UnsupportedEncodingException {
		int count=0;//总打卡数
		int normal_count=0;//正常出席
		int qingjia_count = 0;
		int taoke_count = 0;
		Query query = new Query();
		query.addCriteria(Criteria.where("att_stu_id").is(stu_id));
		query.addCriteria(Criteria.where("att_cla_num").is(cla_num));
	    List<Attendance> userList1 = mongoTemplate.find(query,Attendance.class);
	    System.out.println(userList1.toString());
	    for(int i=0;i<userList1.size();i++){
	    	count++;
	    	if(userList1.get(i).getAtt_status().equals("0")){
	    		normal_count++;
	    	}else if(userList1.get(i).getAtt_status().equals("1")){
	    		taoke_count++;
	    	}else{
	    		qingjia_count++;
	    	}
	    }
		return (new JsonResult(200,"该学生一共打卡"+count+"次，正常签到"+normal_count+"次，请假"+qingjia_count+"次，旷课"+taoke_count+"次")).toString();
	}
	
	

	/** 
	 * 学生查询谋一学期的打卡情况
	 * 
	 * @throws UnsupportedEncodingException
	 *     http://116.62.222.40:8080/kaoqin/selectAllRecordByDate?date=2020-1&stu_id=1583675290261
	 * */ 
	@RequestMapping(value= {"selectAllRecordByDate"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllRecordByDate(Model model,@RequestParam String stu_id,@RequestParam String date
			) throws UnsupportedEncodingException {
		//date:2018-1
		String [] str = date.split("-");
		int count=0;//总打卡数
		int normal_count=0;//正常出席
		int qingjia_count = 0;
		int taoke_count = 0;
		Query query = new Query();
		query.addCriteria(Criteria.where("att_stu_id").is(stu_id));
	    List<Attendance> userList1 = mongoTemplate.find(query,Attendance.class);
	    System.out.println(userList1.toString());
	    for(int i=0;i<userList1.size();i++){
	    	String [] arr = userList1.get(i).getAtt_time().split("-");
	    	if(arr[0].equals(str[0])){
	    		if(Integer.valueOf(str[1])==1){
	    			//对应年份的下半年
	    			count++;
	    	    	if(userList1.get(i).getAtt_status().equals("0")){
	    	    		normal_count++;
	    	    	}else if(userList1.get(i).getAtt_status().equals("1")){
	    	    		taoke_count++;
	    	    	}else{
	    	    		qingjia_count++;
	    	    	}
	    		}else if(Integer.valueOf(str[1])==0){
	    			//对应年份的上半年
	    			count++;
	    	    	if(userList1.get(i).getAtt_status().equals("0")){
	    	    		normal_count++;
	    	    	}else if(userList1.get(i).getAtt_status().equals("1")){
	    	    		taoke_count++;
	    	    	}else{
	    	    		qingjia_count++;
	    	    	}
	    		}else{
	    			return (new JsonResult(302,"请检查你的日期格式").toString());
	    		}
	    	}
	    	
	    }
		return (new JsonResult(200,"该学生一共打卡"+count+"次，正常签到"+normal_count+"次，请假"+qingjia_count+"次，旷课"+taoke_count+"次")).toString();
	}
}
