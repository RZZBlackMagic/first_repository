package net.fuzui.pojo;

import javax.persistence.Entity;
import java.util.List;

import net.fuzui.pojo.Course;


@Entity

public class User {
	private String id;		//�û�id
	private String name;		//�û�����
	protected String username;		//��¼�û�
	private String password;
	private String role;
	private String phonenumber;
	private int state;
	private String sex;
	private List<Course> courselist;
	
	public User() {
		
	}
	public User(String id,String name,String username,String password,String role,String phonenumber,int state,String sex) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.phonenumber = phonenumber;
		this.state = state;
		this.sex=sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<Course> getCourselist() {
	    return courselist;
	}
	public void setCourselist(List<Course> courselist) {
	    this.courselist=courselist;
	}
}
