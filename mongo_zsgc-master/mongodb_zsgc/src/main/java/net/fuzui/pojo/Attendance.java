package net.fuzui.pojo;

import java.util.List;
import javax.persistence.Entity;
import net.fuzui.pojo.StudentUser;

@Entity
public class Attendance {
	private String coursename;
    private String accesscode;
    private String time;
    private String endtime;
    private long count;
    private String teachername;
    private String studentname;
    private List<StudentUser> studentlist;
    private String state;
    
    public Attendance() {
		
	}
    
    public String getCoursename() {
        return coursename;
    }
    public String getAccesscode() {
        return accesscode;
    }
    public String getTime() {
        return time;
    }
    public String getEndtime() {
        return endtime;
    }
    public long getCount() {
        return count;
    }
    public String getTeachername() {
        return teachername;
    }
    public String getStudentname() {
        return studentname;
    }
    public List<StudentUser> getStudentlist() {
        return studentlist;
    }
    public String getState() {
        return state;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public void setAccesscode(String accesscode) {
        this.accesscode = accesscode;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    public void setStudentlist(List<StudentUser> studentlist) {
        this.studentlist = studentlist;
    }
    public void setState(String state) {
        this.state = state;
    }
}
