package Test;

public class rzz201804171 {

	public static void main(String[] args) throws InterruptedException {
	 System.out.println("���߳�����ִ��");
     shop person1 = new shop();
     shop person2 = new shop();
     shop person3 = new shop();
     Thread pt1 = new Thread(){
    	public void run(){
    		Thread pt3 = new Thread(){
    			public void run(){
                    person3.buy();
    			}
    		};
    		pt3.start();
    		try {
				pt3.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		person1.buy();

    		}
     };
     Thread pt2 = new Thread(){
    	public void run(){
    		person2.buy();
    	}
     };
     pt1.start();
     pt1.join();
     pt2.start();
     pt2.join();
     System.out.println("���߳̽���");
	}

}
class shop{
	public void buy(){
        Thread t = Thread.currentThread();
		System.out.println(t.getName()+"�������·�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this){
			for(int i=0;i<10;i++){
				System.out.println(t.getName()+"�������·�");
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(t.getName()+"���ڽ���");
	}
}