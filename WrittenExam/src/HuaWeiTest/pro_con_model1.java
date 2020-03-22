package HuaWeiTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class pro_con_model1 {
	 //初始容量
     static final int N = 10;

   /***
    * full 产品容量
    * empty 空余容量
    * mutex 读写锁
    */
    static Semaphore full,empty,mutex;
   //记录当前的产品数量
    static volatile int count = 0 ;

    static {
        /**
         * full 初始化0个产品
         * empty 初始化有N个空余位置放置产品
         * mutex 初始化每次最多只有一个线程可以读写
         * */
        full = new Semaphore(0);
        empty = new Semaphore(N);
        mutex = new Semaphore(1);
    }


   public static void main(String []args){
        //生产线线程
       new Thread(new Producer()).start();
       //消费者线程
       new Thread(new Consumer()).start();
   }

   //生产者类
   static class Producer implements Runnable{

       @Override
       public void run() {
           while (true){
               try {
                   empty.acquire();//等待空位
                   mutex.acquire();//等待读写锁
                   count++;
                   System.out.println("生产者生产了一个，还剩："+count);
                   mutex.release();//释放读写锁
                   full.release();//放置产品
                   //随机休息一段时间，让生产者线程有机会抢占读写锁
                   Thread.sleep(((int)Math.random())%10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }

   //消费者类
   static class Consumer implements Runnable{

       @Override
       public void run() {
           while (true){
               try {
                   full.acquire();//等待产品
                   mutex.acquire();//等待读写锁
                   count--;
                   System.out.println("消费者消费了一个，还剩："+count);
                   mutex.release();//释放读写锁
                   empty.release();//释放空位
                   //随机休息一段时间，让消费者线程有机会抢占读写锁
                   Thread.sleep(((int)Math.random())%10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }
}
