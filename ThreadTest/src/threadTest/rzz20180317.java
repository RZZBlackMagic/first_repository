package threadTest;

import java.io.IOException;

public class rzz20180317 {
	public static void main(String[] args)   {
	 /*MyThread1 t1 = new MyThread1();
	 MyThread2 t2 = new MyThread2();
	 t1.start();
	 t2.start();
	 
	 MyThread3 mr3 = new MyThread3();
	 Thread t3 = new Thread(mr3);
	 MyThread4 mr4 = new MyThread4();
	 Thread t4 = new Thread(mr4);
	 t3.start();
	 t4.start();
	 
	 Thread t5 = new Thread(){
		public void run(){ 
			for(int i=0;i<10;i++){
				System.out.println("5");
			}
		}
	 };
	 Thread t6 = new Thread(){
		 public void run(){
			 for(int i=0;i<10;i++){
				 System.out.println("6");
			 }
		 }
	 };
	 t5.start();
	 t6.start();
		Thread t7 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("7");
				}
			}
		};
		Thread t8 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("8");
				}
			}
		};
		t7.setPriority(Thread.MAX_PRIORITY);
		t8.setPriority(Thread.MIN_PRIORITY);
		t7.start();
		t8.start();
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("let me go !");
					try{
						Thread.sleep(1000);
						}catch(InterruptedException e){
						 e.printStackTrace();
					}
				}
				System.out.println("啊啊啊啊");
				System.out.println("噗通");
			}
		};
		Thread jack = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("you jump i jump");
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		rose.start();
		jack.setDaemon(true);//设置守护线程
		jack.start();
		System.out.println("main完了");
		
		while(true){
			
		}*/
		table Table  = new table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = Table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
         
		
	}

}
class table{
	private int beans = 20;
	public int getBean(){
		if(beans == 0){
			throw new RuntimeException("没有豆子了");
		}
		Thread.yield();
		return beans--;
	}
}
/*class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("1");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("2");
		}
	}
}
class MyThread3 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("3");
		}
	}
}
class MyThread4 implements Runnable{
	public void run(){
			for(int i=0;i<10;i++){
				System.out.println("4");
			
		     }
	}
}*/