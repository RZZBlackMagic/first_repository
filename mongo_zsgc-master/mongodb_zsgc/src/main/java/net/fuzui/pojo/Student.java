package net.fuzui.pojo;

public class Student {

    private String stuName;
    
    private int stuAge;
    
    private String stuClass;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuAge=" + stuAge + ", stuClass=" + stuClass + "]";
	}

	public Student(String stuName, int stuAge, String stuClass) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuClass = stuClass;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
