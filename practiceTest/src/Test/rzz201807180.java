package Test;

public class rzz201807180 {

	public static void main(String[] args) {
        Thread t1 = new Thread(){
        	public void run(){
        		System.out.println(1);
        	}
        };
        Thread t2 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				System.out.println(2);
			}
        });
        t1.start();
        t2.start();
        
	}

}
