package HuaWeiTest;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import HuaWeiTest.pro_con_model1.Consumer;
import HuaWeiTest.pro_con_model1.Producer;

public class pro_con_model {
	// �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<Object>();
     static  int count = 0 ;
	// �ֿ���������
     static volatile Semaphore notFull = new Semaphore(10);
    // ���̹߳��𣬵ȴ�����������
     static volatile Semaphore notEmpty = new Semaphore(0);
    // ������
     static volatile Semaphore mutex = new Semaphore(1);

    public static void main(String []args){
        //�������߳�
       //new Thread(new Producer()).start();
       //�������߳�
       //new Thread(new Consumer()).start();
    	Thread t1 = new Thread(){
    		public void run(){
    			while(true){
    				new pro_con_model().produce();
    			}
    		}
    	};
    	Thread t2 = new Thread(){
    		public void run(){
    			while(true){
    				new pro_con_model().consume();
    			}
    		}
    	};
    	t2.start();
    	t1.start();
   }
    
    public void produce()
    {
        try {
            notFull.acquire();
            mutex.acquire();
            //list.add(new Object());
            count++;
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + count);
            Thread.sleep(100);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

    public void consume()
    {
        try {
            notEmpty.acquire();
            mutex.acquire();
            //list.remove();
            count--;
            System.out.println("��������" + Thread.currentThread().getName()
                    + "������һ����Ʒ���ֿ��" + count);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}
