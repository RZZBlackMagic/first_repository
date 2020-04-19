package net.fuzui.pojo;

public class Comment {
	
	String com_user_id;
	String com_filename;
	String com_md5;
	String com_ment;
	String com_time;
	public String getCom_time() {
		return com_time;
	}
	public void setCom_time(String com_time) {
		this.com_time = com_time;
	}
	public String getCom_user_id() {
		return com_user_id;
	}
	public void setCom_user_id(String com_user_id) {
		this.com_user_id = com_user_id;
	}
	public String getCom_filename() {
		return com_filename;
	}
	public void setCom_filename(String com_filename) {
		this.com_filename = com_filename;
	}
	public String getCom_md5() {
		return com_md5;
	}
	public void setCom_md5(String com_md5) {
		this.com_md5 = com_md5;
	}
	public String getCom_ment() {
		return com_ment;
	}
	public void setCom_ment(String com_ment) {
		this.com_ment = com_ment;
	}
	
	@Override
	public String toString() {
		return "Comment [com_user_id=" + com_user_id + ", com_filename=" + com_filename + ", com_md5=" + com_md5
				+ ", com_ment=" + com_ment + ", com_time=" + com_time + "]";
	}
	public Comment(String com_user_id, String com_filename, String com_md5, String com_ment, String com_time) {
		super();
		this.com_user_id = com_user_id;
		this.com_filename = com_filename;
		this.com_md5 = com_md5;
		this.com_ment = com_ment;
		this.com_time = com_time;
	}
	
	public Comment() {
		super();
	}
	
	

}
