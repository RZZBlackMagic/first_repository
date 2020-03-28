package net.fuzui.pojo;

import javax.persistence.Entity;
import net.fuzui.pojo.User;

@Entity

public class StudentUser extends User{
     private String schoolname;
     private String collegename;
     private String majorname;
     private String studentnumber;
     private String attendancestate;
     private String attendancetime;

     public StudentUser() {
 		
 	 }
    
     public String getSchoolname(){
         return schoolname;
     }

     public String getCollegename() {
         return collegename;
     }

     public String getMajorname(){
         return majorname;
     }
     
     public String getStudentnumber(){
         return studentnumber;
     }
     
     public String getAttendancestate(){
         return attendancestate;
     }
     public String getAttendancetime(){
         return attendancetime;
     }

     public void setSchoolname(String schoolname) {
         this.schoolname = schoolname;
     }

     public void setCollegename(String collegename) {
         this.collegename = collegename;
     }

     public void setMajorname(String majorname) {
         this.majorname = majorname;
     }
     
     public void setStudentnumber(String studentnumber) {
         this.studentnumber = studentnumber;
     }
     
     public void setAttendancestate(String attendancestate) {
         this.attendancestate = attendancestate;
     }
     public void setAttendancetime(String attendancetime) {
         this.attendancetime = attendancetime;
     }
     
     @Override
     public boolean equals(Object object) {
         
         if (this == object) {
             return true;
         }
         if (object instanceof StudentUser) {
        	 StudentUser studentUser = (StudentUser) object;
             return this.username.equals(studentUser.username);                     
         }
         return super.equals(object);
     }
}
