package Test;

public class rzz201807220 {

	public static void main(String[] args) {
      Aoo o1 = new Boo();
      o1.show();
//      o1.show2();����ֻ�ܵ�����������͵ģ�
      Boo o2 = (Boo)o1;
  
      o2.show1();
      
      Aoo o3 = new Aoo();
      Boo o4 =(Boo) o3;
      inter in = new Boo();
      Boo o5 = (Boo)in;
	}

}
class Aoo{
	public void show(){
		System.out.println("����Aoo");
	}
}
class Boo extends Aoo implements inter{
	public void show2(){
		System.out.println("����Boo");
	}

	@Override
	public void show1() {
      System.out.println("�ӿ�");		
	}
}
interface inter{
	public void show1();
}