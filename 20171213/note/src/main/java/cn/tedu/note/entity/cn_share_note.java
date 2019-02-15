package cn.tedu.note.entity;

public class cn_share_note {

	private String cn_share_id;
	private String cn_share_title;
	private String cn_share_body;
	private String cn_note_id;
	public cn_share_note() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cn_share_note(String cn_share_id, String cn_share_title, String cn_share_body, String cn_note_id) {
		super();
		this.cn_share_id = cn_share_id;
		this.cn_share_title = cn_share_title;
		this.cn_share_body = cn_share_body;
		this.cn_note_id = cn_note_id;
	}
	public String getCn_share_id() {
		return cn_share_id;
	}
	public void setCn_share_id(String cn_share_id) {
		this.cn_share_id = cn_share_id;
	}
	public String getCn_share_title() {
		return cn_share_title;
	}
	public void setCn_share_title(String cn_share_title) {
		this.cn_share_title = cn_share_title;
	}
	public String getCn_share_body() {
		return cn_share_body;
	}
	public void setCn_share_body(String cn_share_body) {
		this.cn_share_body = cn_share_body;
	}
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cn_note_id) {
		this.cn_note_id = cn_note_id;
	}
	@Override
	public String toString() {
		return "cn_share_note [cn_share_id=" + cn_share_id + ", cn_share_title=" + cn_share_title + ", cn_share_body="
				+ cn_share_body + ", cn_note_id=" + cn_note_id + "]";
	}
	
}
