package Spring03;

public class Car {

	private Engineer eng;
	public  Car(){
	   System.out.println("Car()");	
	}
	public void setB(Engineer e){
		this.eng=e;
		System.out.println("setB()");
	}
	@Override
	public String toString() {
		return "Car [eng=" + eng + "]";
	}
	
}
