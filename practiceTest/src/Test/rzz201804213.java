package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class rzz201804213 {

	public static void main(String[] args) {
       ExecutorService pool = Executors.newFixedThreadPool(6);
       Runnable run = new Runnable(){
    	   public void run(){
    		   for(int i=0;i<10;i++){
    	    		 System.out.println(Thread.currentThread().getName());
    	    	 }
    	   }
    	 
       };
       pool.submit(run);
       pool.submit(run);
       pool.shutdownNow();
	}

}
