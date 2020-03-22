package HuaWeiTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class pro_con_model1 {
	 //��ʼ����
     static final int N = 10;

   /***
    * full ��Ʒ����
    * empty ��������
    * mutex ��д��
    */
    static Semaphore full,empty,mutex;
   //��¼��ǰ�Ĳ�Ʒ����
    static volatile int count = 0 ;

    static {
        /**
         * full ��ʼ��0����Ʒ
         * empty ��ʼ����N������λ�÷��ò�Ʒ
         * mutex ��ʼ��ÿ�����ֻ��һ���߳̿��Զ�д
         * */
        full = new Semaphore(0);
        empty = new Semaphore(N);
        mutex = new Semaphore(1);
    }


   public static void main(String []args){
        //�������߳�
       new Thread(new Producer()).start();
       //�������߳�
       new Thread(new Consumer()).start();
   }

   //��������
   static class Producer implements Runnable{

       @Override
       public void run() {
           while (true){
               try {
                   empty.acquire();//�ȴ���λ
                   mutex.acquire();//�ȴ���д��
                   count++;
                   System.out.println("������������һ������ʣ��"+count);
                   mutex.release();//�ͷŶ�д��
                   full.release();//���ò�Ʒ
                   //�����Ϣһ��ʱ�䣬���������߳��л�����ռ��д��
                   Thread.sleep(((int)Math.random())%10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }

   //��������
   static class Consumer implements Runnable{

       @Override
       public void run() {
           while (true){
               try {
                   full.acquire();//�ȴ���Ʒ
                   mutex.acquire();//�ȴ���д��
                   count--;
                   System.out.println("������������һ������ʣ��"+count);
                   mutex.release();//�ͷŶ�д��
                   empty.release();//�ͷſ�λ
                   //�����Ϣһ��ʱ�䣬���������߳��л�����ռ��д��
                   Thread.sleep(((int)Math.random())%10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }
}
