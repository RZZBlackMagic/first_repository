package HuaWeiTest;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import HuaWeiTest.pro_con_model1.Consumer;
import HuaWeiTest.pro_con_model1.Producer;

public class pro_con_model {
	// 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();
     static  int count = 0 ;
	// 仓库的最大容量
     static volatile Semaphore notFull = new Semaphore(10);
    // 将线程挂起，等待其他来触发
     static volatile Semaphore notEmpty = new Semaphore(0);
    // 互斥锁
     static volatile Semaphore mutex = new Semaphore(1);

    public static void main(String []args){
        //生产线线程
       //new Thread(new Producer()).start();
       //消费者线程
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
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + count);
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
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + count);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}
