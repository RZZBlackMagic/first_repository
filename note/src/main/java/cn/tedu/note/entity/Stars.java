package cn.tedu.note.entity;

import java.io.Serializable;

public class Stars implements Serializable{

	private String cn_star_id;
	private String cn_user_id;
	private Integer cn_stars;
	public String getCn_star_id() {
		return cn_star_id;
	}
	public void setCn_star_id(String cn_star_id) {
		this.cn_star_id = cn_star_id;
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	public Integer getCn_stars() {
		return cn_stars;
	}
	public void setCn_stars(Integer cn_stars) {
		this.cn_stars = cn_stars;
	}
	public Stars(String cn_star_id, String cn_user_id, Integer cn_stars) {
		super();
		this.cn_star_id = cn_star_id;
		this.cn_user_id = cn_user_id;
		this.cn_stars = cn_stars;
	}
	public Stars() {
		super();
	}
	@Override
	public String toString() {
		return "Stars [cn_star_id=" + cn_star_id + ", cn_user_id=" + cn_user_id + ", cn_stars=" + cn_stars + "]";
	}
	

}
