package net.fuzui.pojo;

public class Tags {

	String tag_user_id;
	String tag_filename;
	String tag_md5;
	public String getTag_user_id() {
		return tag_user_id;
	}
	public void setTag_user_id(String tag_user_id) {
		this.tag_user_id = tag_user_id;
	}
	public String getTag_filename() {
		return tag_filename;
	}
	public void setTag_filename(String tag_filename) {
		this.tag_filename = tag_filename;
	}
	public String getTag_md5() {
		return tag_md5;
	}
	public void setTag_md5(String tag_md5) {
		this.tag_md5 = tag_md5;
	}
	@Override
	public String toString() {
		return "Tags [tag_user_id=" + tag_user_id + ", tag_filename=" + tag_filename + ", tag_md5=" + tag_md5 + "]";
	}
	public Tags(String tag_user_id, String tag_filename, String tag_md5) {
		super();
		this.tag_user_id = tag_user_id;
		this.tag_filename = tag_filename;
		this.tag_md5 = tag_md5;
	}
	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
