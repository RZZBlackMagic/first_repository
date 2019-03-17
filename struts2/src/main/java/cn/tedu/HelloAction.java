package cn.tedu;

public class HelloAction {
	
	private String name ;
//EL表达式使用属性必须满足JavaBean即就是有get和set方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 方法名默认为execute
	 */
	public String execute(){
		name = "任章哲";
		System.out.println("HelloWorld!");
		return "success";
	}
}
