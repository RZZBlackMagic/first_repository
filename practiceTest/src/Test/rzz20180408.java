package Test;

public class rzz20180408 {

	public static void main(String[] args) {
	System.out.println("������");
    Thread t1= new myThread1();
    Thread t2 = new myThread2();
    t1.start();
    t2.start();
    Runnable run1 = new myThread3();
    Runnable run2 = new myThread4();
    Thread t3 = new Thread(run1);
    Thread t4 = new Thread(run2);
    t3.start();
    t4.start();
	}

}
class myThread1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("����˭����");
		}
	}
}
class myThread2 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("���ǲ�ˮ���");
		}
	}
}
class myThread3 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
	     	System.out.println("��ð�����˿");
	    }
	}
}
class myThread4 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("�һ��У��ܿ�");
		}
		
	}
}