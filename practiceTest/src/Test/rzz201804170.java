package Test;

public class rzz201804170 {

	public static void main(String[] args) {
     /*Thread t7 = new myThread7();
     Thread t8 = new myThread8();
     
     t7.setDaemon(true);
    // t7.start();
     //t8.start();
	 System.out.println("rose1:let me go!");

     Thread t9 = new Thread(){
    	 public void run(){
    		// System.out.println("rose:let me go!");
    		 Thread t10 = new Thread(){
    			public void run(){
    				for(int i=0;i<20;i++){ 
        				try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
        				System.out.println("jack:you jump i jump");
        			}
    			}
    		 };
    		 t10.start();
    		 try {
				t10.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 for(int i=0;i<10;i++){
    			 System.out.println("roselet me go!");
    		 }
    		 
    	 }
     };
     t9.start();*/
     
     Table table = new Table();
     Thread thread1 = new Thread(){
    	public void run(){
    		while(true){
    			Thread.yield();
    			System.out.println("任章哲拿了一个，桌子上还有："+table.getBean());
    		}
    	}
     };
     Thread thread2 = new Thread(){
    	public void run(){
    		while(true){
    			Thread.yield();
    			System.out.println("哈哈，桌上还有："+table.getBean());
    		}
    	}
     };
     thread1.start();
     thread2.start();
     
	}

}

class Table{
	private   int beans = 20;
	public synchronized int getBean(){
		if(beans==0){
            throw new RuntimeException("没有豆子");
         }
		return beans--;
	}
}
class myThread7 extends Thread{
	public void run(){
        for(int i=0;i<10000;i++){
        	System.out.println("oh jack");
        }
	}
}
class myThread8 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("oh rose");
		}
	}
}