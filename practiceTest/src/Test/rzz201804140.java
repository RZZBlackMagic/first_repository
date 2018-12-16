package Test;

public class rzz201804140 {

	public static void main(String[] args) {
     Runnable run5 = new myThread5();
     Runnable run6 = new myThread6();
     Thread t5 = new Thread(run5);
     Thread t6 = new Thread(run6);
     t5.start();
     t6.setDaemon(true);
     t6.start();
     //System.out.println("main结束了");
	}

}
class myThread5 implements Runnable{

	@Override
	public void run() {
       for(int i=0;i<10;i++){		
    	   System.out.println("图片加载中，别急");
       }
	}
	
}
class myThread6 implements Runnable{

	@Override
	public void run() {
      for(int i=0;i<1000;i++){		
    	  System.out.println("图片显示中...");
    	  System.out.println(i);
      }
	}
	
}