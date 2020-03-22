package Test;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class FooBar {
	    private int n;
	    private static Semaphore mutex = new Semaphore(1);
	    public FooBar(int n) {
	        this.n = n;
	    }

	    public synchronized  void foo(Runnable printFoo) throws InterruptedException {
	    	//mutex.acquire();
	        //for (int i = 0; i < n; i++) {
	            
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	       // }
	       // mutex.release();
	    }

	    public synchronized  void bar(Runnable printBar) throws InterruptedException {
	    	//mutex.acquire();
	        //for (int i = 0; i < n; i++) {
	            
	            // printBar.run() outputs "bar". Do not change or remove this line.
	        	printBar.run();
	        //}
	        //mutex.release();
	    }
	    
	   
}
