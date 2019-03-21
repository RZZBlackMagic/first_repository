package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class JsonAction {

	private String name ;
	private String sex;
	private int year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String jsonTest(){
		System.out.println("JSON≤‚ ‘");
		sex="ƒ–";
		name="»Œ’¬’‹";
		year = 22;
		return "success";
	}
}
