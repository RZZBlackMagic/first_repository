package base_accc;
import java.lang.Math;
import java.util.Scanner;
public class test1 {

	public static void main(String[] args) {
     System.out.println("please input :");
     Scanner scan = new Scanner(System.in);
     int a = scan.nextInt();
     oper o = new oper();
     System.out.println(o.fun(a));
     
     
     
	}

}
  class oper{
	public int fun(int a ){
		int d = 4*a*a+1;
		return d;
	}
}