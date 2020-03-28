package net.fuzui.pojo;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Attendance1 {
	private String coursename;
    private String accesscode;
    private String teachername;
    private String studentname;
    List<String> statelist=new ArrayList<String>();  
    
    public Attendance1() {
		
	}
    
    public String getCoursename() {
        return coursename;
    }
    
    public String getAccesscode() {
        return accesscode;
    }
    
    public String getTeachername() {
        return teachername;
    }
    
    public String getStudentname() {
        return studentname;
    }
    
    public List<String> getStatelist() {
        return statelist;
    }
    
    
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    
    public void setAccesscode(String accesscode) {
        this.accesscode = accesscode;
    }
    
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
    
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    
    public void setStatelist(List<String> statelist) {
        this.statelist = statelist;
    }
}
