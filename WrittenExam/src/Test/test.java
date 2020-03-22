package Test;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		System.out.println("...");
		FooBar f = new FooBar(n);
		
		Thread t1 = new Thread(){
			public void run(){ 
				try {
					for(int i=0;i<n;i++){
						f.bar(new print_bar());
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				try {
					for(int i=0;i<n;i++){
						f.foo(new print_foo());
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t2.start();
		t1.start();
	}
}
class print_foo implements Runnable{

	@Override
	public   void run() {
		System.out.print("foo");
	}
	
}

class print_bar implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("bar");
	}
	
}
