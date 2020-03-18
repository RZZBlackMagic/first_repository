package net.fuzui.pojo;

public class Parents {
	
	private String par_id;
	
	private String par_name;
	
	private String par_nickname;
	
	private String par_sex;
	
	private String par_phone;

	public String getPar_id() {
		return par_id;
	}

	public void setPar_id(String par_id) {
		this.par_id = par_id;
	}

	public String getPar_name() {
		return par_name;
	}

	public void setPar_name(String par_name) {
		this.par_name = par_name;
	}

	public String getPar_nickname() {
		return par_nickname;
	}

	public void setPar_nickname(String par_nickname) {
		this.par_nickname = par_nickname;
	}

	public String getPar_sex() {
		return par_sex;
	}

	public void setPar_sex(String par_sex) {
		this.par_sex = par_sex;
	}

	public String getPar_phone() {
		return par_phone;
	}

	public void setPar_phone(String par_phone) {
		this.par_phone = par_phone;
	}

	@Override
	public String toString() {
		return "Parents [par_id=" + par_id + ", par_name=" + par_name + ", par_nickname=" + par_nickname + ", par_sex="
				+ par_sex + ", par_phone=" + par_phone + "]";
	}

	public Parents(String par_id, String par_name, String par_nickname, String par_sex, String par_phone) {
		super();
		this.par_id = par_id;
		this.par_name = par_name;
		this.par_nickname = par_nickname;
		this.par_sex = par_sex;
		this.par_phone = par_phone;
	}

	public Parents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
