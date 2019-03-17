package entity;

public class user {

	private String username;
	private String password;
	
	public user() {
		super();
	}
	public user(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUser() {
		return username;
	}
	public void setUser(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
