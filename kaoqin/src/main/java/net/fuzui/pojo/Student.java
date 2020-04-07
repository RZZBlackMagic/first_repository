package net.fuzui.pojo;

public class Student {
	
	private String stu_id;

    private String stu_phone;//手机号
    
    private String stu_school;//学校
    
    private String stu_num;//学号
    
    private String stu_academy;//学院
    
    private String stu_name;//姓名
    
    private String stu_nickname;//昵称
    
    private String stu_sex;//性别
    
    private String stu_class;//班级
    
    private String stu_identity_num;//身份证号码
    
    private String stu_mom_phone;
    
    private String stu_dad_phone;
    
    private String stu_password;

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public String getStu_school() {
		return stu_school;
	}

	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getStu_academy() {
		return stu_academy;
	}

	public void setStu_academy(String stu_academy) {
		this.stu_academy = stu_academy;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_nickname() {
		return stu_nickname;
	}

	public void setStu_nickname(String stu_nickname) {
		this.stu_nickname = stu_nickname;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

	public String getStu_identity_num() {
		return stu_identity_num;
	}

	public void setStu_identity_num(String stu_identity_num) {
		this.stu_identity_num = stu_identity_num;
	}

	public String getStu_mom_phone() {
		return stu_mom_phone;
	}

	public void setStu_mom_phone(String stu_mom_phone) {
		this.stu_mom_phone = stu_mom_phone;
	}

	public String getStu_dad_phone() {
		return stu_dad_phone;
	}

	public void setStu_dad_phone(String stu_dad_phone) {
		this.stu_dad_phone = stu_dad_phone;
	}

	

	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_phone=" + stu_phone + ", stu_school=" + stu_school + ", stu_num="
				+ stu_num + ", stu_academy=" + stu_academy + ", stu_name=" + stu_name + ", stu_nickname=" + stu_nickname
				+ ", stu_sex=" + stu_sex + ", stu_class=" + stu_class + ", stu_identity_num=" + stu_identity_num
				+ ", stu_mom_phone=" + stu_mom_phone + ", stu_dad_phone=" + stu_dad_phone + ", stu_password="
				+ stu_password + "]";
	}

	public Student(String stu_id, String stu_phone, String stu_school, String stu_num, String stu_academy,
			String stu_name, String stu_nickname, String stu_sex, String stu_class, String stu_identity_num,
			String stu_mom_phone, String stu_dad_phone, String stu_password) {
		super();
		this.stu_id = stu_id;
		this.stu_phone = stu_phone;
		this.stu_school = stu_school;
		this.stu_num = stu_num;
		this.stu_academy = stu_academy;
		this.stu_name = stu_name;
		this.stu_nickname = stu_nickname;
		this.stu_sex = stu_sex;
		this.stu_class = stu_class;
		this.stu_identity_num = stu_identity_num;
		this.stu_mom_phone = stu_mom_phone;
		this.stu_dad_phone = stu_dad_phone;
		this.stu_password = stu_password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    

	
}
