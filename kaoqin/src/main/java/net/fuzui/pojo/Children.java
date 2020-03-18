package net.fuzui.pojo;

public class Children {
	
	private String ch_phone;
	
	private String ch_name;
	
	private String ch_school;
	
	private String ch_academy;
	
	private String ch_sex;
	
	private String ch_stu_identity_num;
	
	private String ch_par_id;//确定父母

	public String getCh_phone() {
		return ch_phone;
	}

	public void setCh_phone(String ch_phone) {
		this.ch_phone = ch_phone;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

	public String getCh_school() {
		return ch_school;
	}

	public void setCh_school(String ch_school) {
		this.ch_school = ch_school;
	}

	public String getCh_academy() {
		return ch_academy;
	}

	public void setCh_academy(String ch_academy) {
		this.ch_academy = ch_academy;
	}

	public String getCh_sex() {
		return ch_sex;
	}

	public void setCh_sex(String ch_sex) {
		this.ch_sex = ch_sex;
	}

	public String getCh_stu_identity_num() {
		return ch_stu_identity_num;
	}

	public void setCh_stu_identity_num(String ch_stu_identity_num) {
		this.ch_stu_identity_num = ch_stu_identity_num;
	}

	public String getCh_par_id() {
		return ch_par_id;
	}

	public void setCh_par_id(String ch_par_id) {
		this.ch_par_id = ch_par_id;
	}

	@Override
	public String toString() {
		return "Children [ch_phone=" + ch_phone + ", ch_name=" + ch_name + ", ch_school=" + ch_school + ", ch_academy="
				+ ch_academy + ", ch_sex=" + ch_sex + ", ch_stu_identity_num=" + ch_stu_identity_num + ", ch_par_id="
				+ ch_par_id + "]";
	}

	public Children(String ch_phone, String ch_name, String ch_school, String ch_academy, String ch_sex,
			String ch_stu_identity_num, String ch_par_id) {
		super();
		this.ch_phone = ch_phone;
		this.ch_name = ch_name;
		this.ch_school = ch_school;
		this.ch_academy = ch_academy;
		this.ch_sex = ch_sex;
		this.ch_stu_identity_num = ch_stu_identity_num;
		this.ch_par_id = ch_par_id;
	}

	public Children() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
