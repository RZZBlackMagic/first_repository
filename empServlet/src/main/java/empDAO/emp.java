package empDAO;

import java.io.Serializable;

public class emp  implements Serializable{
     private String name;
     private int stu;
     private String sex;
     private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStu() {
		return stu;
	}
	public void setStu(int stu) {
		this.stu = stu;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
     
}
