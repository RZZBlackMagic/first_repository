package cn.tedu;

public class HelloAction {
	
	private String name ;
//EL���ʽʹ�����Ա�������JavaBean��������get��set����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * ������Ĭ��Ϊexecute
	 */
	public String execute(){
		name = "������";
		System.out.println("HelloWorld!");
		return "success";
	}
}
