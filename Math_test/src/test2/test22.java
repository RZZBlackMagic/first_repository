package test2;

import java.util.Scanner;

public class test22 {

	public static void main(String[] args) {
		System.out.println("please input :");
	     Scanner scan = new Scanner(System.in);
	     int a = scan.nextInt();
	     base_accc.oper o = new  base_accc.oper();
	     System.out.println(o.fun(a));
	}

}
