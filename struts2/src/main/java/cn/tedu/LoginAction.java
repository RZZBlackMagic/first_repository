package cn.tedu;

import entity.user;

public class LoginAction {

	private user u ;
	
	
	public user getU() {
		return u;
	}


	public void setU(user u) {
		this.u = u;
	}


	public String execute(){
		System.out.println(u.toString());
		return "success";
	}
}
