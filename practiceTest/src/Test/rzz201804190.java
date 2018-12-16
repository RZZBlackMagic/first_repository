package Test;

import java.util.Arrays;

public class rzz201804190 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("主线程开始");
      int[]  arr = new int[10];
      for(int i=0;i<arr.length;i++){
    	  arr[i]=(int)(Math.random()*100);
      }
      Thread thread1 = new Thread(){

    	public void run(){
    		sort sort1 = new sort();
    	      int[] arrs=sort1.arrsort(arr);
    	      System.out.println("sort开始");
    	      for(int i=0;i<arrs.length;i++){
    	    	  System.out.print(arrs[i]);
    	    	  System.out.print(" ");
    	      }
    	      System.out.println();
    	      	System.out.println("sort结束");

    	}
      };
      Thread thread2 = new Thread(){
    	public void run(){
    		System.out.println("冒泡开始");
    		bubsort bubsort1 = new bubsort();
    	      bubsort1.arrssort(arr);
    	      System.out.println("冒泡结束");
    	}
      };
      Thread thread3 = new Thread(){
    	public void run(){  
    		fun();
    	}
      };
      thread1.start();
      thread1.join();

      thread2.start();
      thread2.join();

      thread3.start();

      System.out.println("主线程结束");
	}
	public static  void fun(){
		for(int i=0;i<3;i++){
			System.out.println("哈哈哈");
		}
	}

}
class sort{
	public int[] arrsort(int[] arr){
		Arrays.sort(arr);
		return arr;
	}
}
class bubsort{
	public void arrssort(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				if(arr[j]>arr[j+1]){
					int flag = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=flag;
				}
				
			}
		}
		for(int i=0;i<arr.length;i++){
             System.out.print(arr[i]);
       	  System.out.print(" ");
		}
 	      System.out.println();

	}
}