package net.fuzui.pojo;

public class Attendance {

	private String att_stu_id;
	
	private String att_stu_name;
	
	private String att_cla_num;
	
	private String att_cla_name;
	
	private String att_weeks;
	
	private String att_time;
	
	private String att_status;//0：签到成功，1：旷课 ，2：请假

	public String getAtt_stu_id() {
		return att_stu_id;
	}

	public void setAtt_stu_id(String att_stu_id) {
		this.att_stu_id = att_stu_id;
	}

	public String getAtt_stu_name() {
		return att_stu_name;
	}

	public void setAtt_stu_name(String att_stu_name) {
		this.att_stu_name = att_stu_name;
	}

	public String getAtt_cla_num() {
		return att_cla_num;
	}

	public void setAtt_cla_num(String att_cla_num) {
		this.att_cla_num = att_cla_num;
	}

	public String getAtt_cla_name() {
		return att_cla_name;
	}

	public void setAtt_cla_name(String att_cla_name) {
		this.att_cla_name = att_cla_name;
	}

	public String getAtt_weeks() {
		return att_weeks;
	}

	public void setAtt_weeks(String att_weeks) {
		this.att_weeks = att_weeks;
	}

	public String getAtt_time() {
		return att_time;
	}

	public void setAtt_time(String att_time) {
		this.att_time = att_time;
	}

	public String getAtt_status() {
		return att_status;
	}

	public void setAtt_status(String att_status) {
		this.att_status = att_status;
	}

	@Override
	public String toString() {
		return "Attendance [att_stu_id=" + att_stu_id + ", att_stu_name=" + att_stu_name + ", att_cla_num="
				+ att_cla_num + ", att_cla_name=" + att_cla_name + ", att_weeks=" + att_weeks + ", att_time=" + att_time
				+ ", att_status=" + att_status + "]";
	}

	public Attendance(String att_stu_id, String att_stu_name, String att_cla_num, String att_cla_name, String att_weeks,
			String att_time, String att_status) {
		super();
		this.att_stu_id = att_stu_id;
		this.att_stu_name = att_stu_name;
		this.att_cla_num = att_cla_num;
		this.att_cla_name = att_cla_name;
		this.att_weeks = att_weeks;
		this.att_time = att_time;
		this.att_status = att_status;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
