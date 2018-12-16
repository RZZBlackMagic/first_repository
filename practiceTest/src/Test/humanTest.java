package Test;

public class humanTest {
	public static void main(String[] args) {

	}
}
interface work1{
	public void goClass();
}

abstract class person1{
	String name;
	String sex;
	int age;
	public void eat(){
		
	}
	public void sleep(){
		
	}
	public void drink(){
		
	}
	abstract public void alterHomework();
}
class teacher extends person1 {
	int jobNum;
	public void alterHomework() {
		
	}
}
class chargeTeacher extends person1 implements work1{
	int jobNum;
    public void goClass(){
		
	}
	public void arrangeStu(){
		
	}
	public void alterHomework() {
		
	}
	
}
class student1 extends person1 implements work1{
	int stuNum;
	 public void doHomework(){
		 
	 }
	public void goClass() {
		
	}
	public void alterHomework() {
		
	}
}