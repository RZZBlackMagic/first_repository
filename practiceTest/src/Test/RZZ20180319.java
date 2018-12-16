package Test;

public class RZZ20180319 {

	public static void main(String[] args) {
    /* Thread t1 = new MyThread1();
     Thread t2 = new MyThread2();
     t1.start();
     t2.start();
     
     Thread t3 = new Thread(){
    	public void run(){ 
    		for(int i=0;i<5;i++){
    			System.out.println("3");
    		}
    	}
     };
     Thread t4 = new Thread(){
    	 public void run(){
    		 for(int i=0;i<5;i++){
    			 System.out.println("4");
    		 }
    	 }
     };
     t3.start();
     t4.start();
     
     MyRunnable5 run5 = new MyRunnable5();
 	Runnable run6 = new MyRunnable6();
 	Thread t5 = new Thread(run5);
 	Thread t6 = new Thread(run6);
 	t5.start();
 	t6.start();
		 Table table = new Table();
		 Thread t7 = new Thread(){
			public void run(){ 
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(bean);
				}
			}
		 };
		 Thread t8 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					//Thread.yield();
					System.out.println(bean);
				}
			}
		 };
		 t7.start();
		// t8.start();
     
     
		long startTime = System.currentTimeMillis();
		Thread9 t9 = new Thread9();
		Thread9 t10 = new Thread9();
		t9.start();
		t10.start();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println(time);*/
	}
	
	
}


/*class Thread9 extends Thread{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println(getName()+":"+1);
			//Thread.yield();
			try{
				sleep(100);
			}catch(InterruptedException e){
				
			}
		}
	}
}
/*class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("1");
		}
	}
}class MyThread2 extends Thread{
	 public void run(){
		 for(int i=0;i<5;i++){
			 System.out.println("2");
		 }
	 }
}


class MyRunnable6 implements Runnable{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("6");
        }
   }
}
class MyRunnable5 implements Runnable{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("5");
		}
	}
}
class Table{
	private int  beans = 20;
	public synchronized int getBean(){
		if(beans ==0){
			throw new RuntimeException("Ã»ÓÐ¶¹×Ó");
		}
		Thread.yield();
		return beans--;
	}
}*/