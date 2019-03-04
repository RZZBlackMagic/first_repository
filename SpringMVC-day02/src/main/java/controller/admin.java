package controller;

public class admin {

	/*
	 * 用于封装请求参数值
	 *   1 属性名和请求参数值一致（名称要一样。类型要匹配，它hi自动绑我们进行转换,比如属性是int，得到是String，会自动转换为int）
	 *   2 提供相应的get/set方法
	 */
	private String adminCode;
	private String pwd;
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
