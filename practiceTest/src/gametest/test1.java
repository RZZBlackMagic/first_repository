package gametest;

import java.util.LinkedList;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 long start = System.currentTimeMillis();
	      int d = scan.nextInt();
	      int[] a= new int[d];
	      int[] b = new int[d];
	      for(int i=0;i<d;i++){
	    	   a[i] =scan.nextInt();
	    	   b[i]=scan.nextInt();
	    	   a[i]=fun(a[i],b[i]);
	      }
	      for(int u :a){
	    	  System.out.println(u);
	      }
	      long end = System.currentTimeMillis();
	      System.out.println(end-start);
     	}
    public static  int  fun(int a,int b){
    	return a*b;
    }
}
