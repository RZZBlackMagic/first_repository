package Test;

public class rzz201804200 {

	public static void main(String[] args) throws InterruptedException {
       System.out.println("主线程开始");
       Thread t1 = Thread.currentThread();
       String str = t1.getName();
       System.out.println(str);
       t1.sleep(5000);
       n run = new n();
       Thread t = new Thread(run);
       t.start();
       t.join();

       System.out.println("主线程结束");
	}

}
class n implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
		       System.out.println(i);		
		}
	}
}
