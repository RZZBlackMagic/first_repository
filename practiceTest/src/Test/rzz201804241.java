package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class rzz201804241 {

	public static void main(String[] args) throws InterruptedException {
      pDate p = new pDate();
      Thread t = new Thread(p);
      t.start();
	}

}
class pDate implements Runnable{
	public void run(){
		
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
		          System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS").format(new Date()));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//long t = System.currentTimeMillis();
			
			
			//System.out.println(d);
	          //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");
			//System.out.println(t);
		}
		
	}
}