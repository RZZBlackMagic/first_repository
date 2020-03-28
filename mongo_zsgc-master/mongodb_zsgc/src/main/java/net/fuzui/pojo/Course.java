package net.fuzui.pojo;

import java.util.List;

import javax.persistence.Entity;

import net.fuzui.pojo.StudentUser;
@Entity

public class Course {
	private String coursename;
    private String accesscode;
    private String time;
    private String schoolname;
    private String teachername;
    private String studentname;
    private String bluetooth;
    private String state;
    private List<StudentUser> studentlist;

    public Course() {
		
	}
    public String getBluetooth() {
        return bluetooth;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public String getAccesscode() {
        return accesscode;
    }

    public String getTeachername() {
        return teachername;
    }

    public String getTime() {
        return time;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getStudentname() {
        return studentname;
    }

    public String getState() {
        return state;
    }
    
    public List<StudentUser> getStudentlist() {
        return studentlist;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public void setAccesscode(String accesscode) {
        this.accesscode = accesscode;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    
    public void setStudentlist(List<StudentUser> studentlist) {
        this.studentlist = studentlist;
    }

}
