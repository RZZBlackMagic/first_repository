package Spring02;

public class A {

	private IB b1;
	public void setB(IB b2){
		System.out.println("setB()");
		this.b1=b2;
		System.out.println(b1);
	}
	public A(){
		System.out.println("A()");
	}
	public void execute(){
		b1.f1();
		System.out.println("execute()");
		System.out.println(1);
	}
	
}
