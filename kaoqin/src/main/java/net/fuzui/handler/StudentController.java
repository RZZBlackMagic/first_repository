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

import net.fuzui.pojo.Classes;
import net.fuzui.pojo.JsonResult;
import net.fuzui.pojo.Rela_stu_cla;
import net.fuzui.pojo.Student;

@Controller
public class StudentController {

	@Autowired
	MongoTemplate mongoTemplate;
	

	/** 
	 * http://localhost:8080/kaoqin/createClasses?cla_name=毕业设计&cla_tea_id=12354&cla_tea_name=图图
	 * 学生添加课程 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/addClasses?stu_id=1586323085756&cla_num=0002
	 * */ 
	@RequestMapping(value= {"addClasses"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addClasses(Model model,@RequestParam String stu_id,@RequestParam String cla_num
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_num").is(cla_num));
	    List<Classes> userList1 = mongoTemplate.find(query,Classes.class);
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该班级还没有创建").toString());
	    }
	    Query query1 = new Query();
		query1.addCriteria(Criteria.where("rela_stu_num").is(stu_id));
		query1.addCriteria(Criteria.where("rela_cla_num").is(cla_num));
	    List<Rela_stu_cla> userList = mongoTemplate.find(query1,Rela_stu_cla.class);
	    if(userList.size()>0){
	    	return (new JsonResult(302,"您已经添加该班级").toString());
	    }
	    String rela_cla_name = userList1.get(0).getCla_name();
	    String rela_tea_name = userList1.get(0).getCla_tea_name();
		Rela_stu_cla rela_stu_cla = new Rela_stu_cla();
		rela_stu_cla.setRela_cla_num(cla_num);
		rela_stu_cla.setRela_cla_score("0");
		rela_stu_cla.setRela_stu_num(stu_id);
		rela_stu_cla.setRela_cla_name(rela_cla_name);
		rela_stu_cla.setRela_tea_name(rela_tea_name);
		mongoTemplate.insert(rela_stu_cla);
		return (new JsonResult(200,rela_stu_cla).toString());
	}
	

	/** 
	 * http://localhost:8080/kaoqin/findClassesById?cla_num=0007
	 * 学生通过班号查找班级 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/addClasses?cla_num=0001
	 * */ 
	@RequestMapping(value= {"findClassesById"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findClassesById(Model model,@RequestParam String cla_num
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("cla_num").is(cla_num));
	    List<Classes> userList1 = mongoTemplate.find(query,Classes.class);
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该班级还没有创建").toString());
	    }
		return (new JsonResult(200,userList1.get(0)).toString());
	}
	
	/** 
	 * http://localhost:8080/kaoqin/findAllSelectedClasses?stu_id=1583675290261
	 * 学生查找所有已选择的班级2343423 
	 * @throws UnsupportedEncodingException
	 *     http://localhost:8080/kaoqin/addClasses?cla_num=0001
	 * */ 
	@RequestMapping(value= {"findAllSelectedClasses"},produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllSelectedClasses(Model model,@RequestParam String stu_id
			) throws UnsupportedEncodingException {
		System.out.println("......");
		Query query = new Query();
		query.addCriteria(Criteria.where("rela_stu_num").is(stu_id));
	    List<Rela_stu_cla> userList1 = mongoTemplate.find(query,Rela_stu_cla.class);
	    if(userList1.size()==0){
	    	return (new JsonResult(302,"该学生还没有添加班级。").toString());
	    }
		return (new JsonResult(200,userList1).toString());
	}
	
}
