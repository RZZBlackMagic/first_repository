package net.fuzui.pojo;

public class Teacher {

	private String tea_id;
	
	private String tea_phone;
	
	private String tea_school;
	
	private String tea_academy;
	
	private String tea_name;
	
	private String tea_nickname;
	
	private String tea_sex;
	
	private String tea_isAssisance;
	
	private String tea_picutre;
	
	private String tea_bluetooth;
	
	private String tea_blu_status;
	
	private String tea_password;

	public String getTea_password() {
		return tea_password;
	}

	public void setTea_password(String tea_password) {
		this.tea_password = tea_password;
	}

	
	@Override
	public String toString() {
		return "Teacher [tea_id=" + tea_id + ", tea_phone=" + tea_phone + ", tea_school=" + tea_school
				+ ", tea_academy=" + tea_academy + ", tea_name=" + tea_name + ", tea_nickname=" + tea_nickname
				+ ", tea_sex=" + tea_sex + ", tea_isAssisance=" + tea_isAssisance + ", tea_picutre=" + tea_picutre
				+ ", tea_bluetooth=" + tea_bluetooth + ", tea_blu_status=" + tea_blu_status + ", tea_password="
				+ tea_password + "]";
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

	public String getTea_phone() {
		return tea_phone;
	}

	public void setTea_phone(String tea_phone) {
		this.tea_phone = tea_phone;
	}

	public String getTea_school() {
		return tea_school;
	}

	public void setTea_school(String tea_school) {
		this.tea_school = tea_school;
	}

	public String getTea_academy() {
		return tea_academy;
	}

	public void setTea_academy(String tea_academy) {
		this.tea_academy = tea_academy;
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	public String getTea_nickname() {
		return tea_nickname;
	}

	public void setTea_nickname(String tea_nickname) {
		this.tea_nickname = tea_nickname;
	}

	public String getTea_sex() {
		return tea_sex;
	}

	public void setTea_sex(String tea_sex) {
		this.tea_sex = tea_sex;
	}

	public String getTea_isAssisance() {
		return tea_isAssisance;
	}

	public void setTea_isAssisance(String tea_isAssisance) {
		this.tea_isAssisance = tea_isAssisance;
	}

	public String getTea_picutre() {
		return tea_picutre;
	}

	public void setTea_picutre(String tea_picutre) {
		this.tea_picutre = tea_picutre;
	}

	public String getTea_bluetooth() {
		return tea_bluetooth;
	}

	public void setTea_bluetooth(String tea_bluetooth) {
		this.tea_bluetooth = tea_bluetooth;
	}

	public String getTea_blu_status() {
		return tea_blu_status;
	}

	public void setTea_blu_status(String tea_blu_status) {
		this.tea_blu_status = tea_blu_status;
	}

	

	public Teacher(String tea_id, String tea_phone, String tea_school, String tea_academy, String tea_name,
			String tea_nickname, String tea_sex, String tea_isAssisance, String tea_picutre, String tea_bluetooth,
			String tea_blu_status, String tea_password) {
		super();
		this.tea_id = tea_id;
		this.tea_phone = tea_phone;
		this.tea_school = tea_school;
		this.tea_academy = tea_academy;
		this.tea_name = tea_name;
		this.tea_nickname = tea_nickname;
		this.tea_sex = tea_sex;
		this.tea_isAssisance = tea_isAssisance;
		this.tea_picutre = tea_picutre;
		this.tea_bluetooth = tea_bluetooth;
		this.tea_blu_status = tea_blu_status;
		this.tea_password = tea_password;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
