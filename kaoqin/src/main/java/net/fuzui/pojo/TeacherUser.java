package net.fuzui.pojo;

import javax.persistence.Entity;
import net.fuzui.pojo.User;

@Entity

public class TeacherUser extends User{
	private String schoolname;
	private String bluetooth;
	
	public String getSchoolname(){
        return schoolname;
    }
	
	public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
	
	public String getBluetooth(){
        return bluetooth;
    }
	
	public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }
}
