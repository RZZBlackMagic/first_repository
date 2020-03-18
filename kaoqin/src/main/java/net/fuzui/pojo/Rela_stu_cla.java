package net.fuzui.pojo;

public class Rela_stu_cla {

	private String rela_stu_num;
	
	private String rela_cla_num;
	
	private String rela_cla_score;
	
	private String rela_cla_name;
	
	private String rela_tea_name;

	public String getRela_stu_num() {
		return rela_stu_num;
	}

	public void setRela_stu_num(String rela_stu_num) {
		this.rela_stu_num = rela_stu_num;
	}

	public String getRela_cla_num() {
		return rela_cla_num;
	}

	public void setRela_cla_num(String rela_cla_num) {
		this.rela_cla_num = rela_cla_num;
	}

	public String getRela_cla_score() {
		return rela_cla_score;
	}

	public void setRela_cla_score(String rela_cla_score) {
		this.rela_cla_score = rela_cla_score;
	}

	public String getRela_cla_name() {
		return rela_cla_name;
	}

	public void setRela_cla_name(String rela_cla_name) {
		this.rela_cla_name = rela_cla_name;
	}

	public String getRela_tea_name() {
		return rela_tea_name;
	}

	public void setRela_tea_name(String rela_tea_name) {
		this.rela_tea_name = rela_tea_name;
	}

	@Override
	public String toString() {
		return "Rela_stu_cla [rela_stu_num=" + rela_stu_num + ", rela_cla_num=" + rela_cla_num + ", rela_cla_score="
				+ rela_cla_score + ", rela_cla_name=" + rela_cla_name + ", rela_tea_name=" + rela_tea_name + "]";
	}

	public Rela_stu_cla(String rela_stu_num, String rela_cla_num, String rela_cla_score, String rela_cla_name,
			String rela_tea_name) {
		super();
		this.rela_stu_num = rela_stu_num;
		this.rela_cla_num = rela_cla_num;
		this.rela_cla_score = rela_cla_score;
		this.rela_cla_name = rela_cla_name;
		this.rela_tea_name = rela_tea_name;
	}

	public Rela_stu_cla() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
