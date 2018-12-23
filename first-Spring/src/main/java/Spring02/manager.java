package Spring02;

public class manager {

	private computer com;
	public manager(){
		System.out.println("manager()");
	}
	public manager(computer com){
		this.com=com;
		System.out.println("manager(com)");
	}
	@Override
	public String toString() {
		return "manager [com=" + com + "]";
	}
}
