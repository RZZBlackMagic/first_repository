package net.fuzui.pojo;

public class Classes {
	
	private String cla_num;
	
	private String cla_name;
	
	private String cla_tea_id;
	
	private String cla_tea_name;
	
	private String cla_time;

	public String getCla_num() {
		return cla_num;
	}

	public void setCla_num(String cla_num) {
		this.cla_num = cla_num;
	}

	public String getCla_name() {
		return cla_name;
	}

	public void setCla_name(String cla_name) {
		this.cla_name = cla_name;
	}

	public String getCla_tea_id() {
		return cla_tea_id;
	}

	public void setCla_tea_id(String cla_tea_id) {
		this.cla_tea_id = cla_tea_id;
	}

	public String getCla_tea_name() {
		return cla_tea_name;
	}

	public void setCla_tea_name(String cla_tea_name) {
		this.cla_tea_name = cla_tea_name;
	}

	public String getCla_time() {
		return cla_time;
	}

	public void setCla_time(String cla_time) {
		this.cla_time = cla_time;
	}

	@Override
	public String toString() {
		return "Classes [cla_num=" + cla_num + ", cla_name=" + cla_name + ", cla_tea_id=" + cla_tea_id
				+ ", cla_tea_name=" + cla_tea_name + ", cla_time=" + cla_time + "]";
	}

	public Classes(String cla_num, String cla_name, String cla_tea_id, String cla_tea_name, String cla_time) {
		super();
		this.cla_num = cla_num;
		this.cla_name = cla_name;
		this.cla_tea_id = cla_tea_id;
		this.cla_tea_name = cla_tea_name;
		this.cla_time = cla_time;
	}

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
