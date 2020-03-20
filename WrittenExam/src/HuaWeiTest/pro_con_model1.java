package HuaWeiTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class pro_con_model1 {
	 List<Object> list = new LinkedList<Object>();
	 Semaphore notFull = new Semaphore(10);
	 Semaphore noEmpty = new Semaphore(0);
	 Semaphore mutex = new Semaphore(1);
	 public static void main(String[] args) {
		 Thread t1 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().produce("?");
					 //System.out.println(1);
				 }
			 }
		 };
		 Thread t2 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().produce("?");
					// System.out.println(2);
				 }			 }
		 };
		 Thread t3 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().produce("?");
					 //System.out.println(3);

				 }			 }
		 };
		 Thread t4 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().consume("?");
					 System.out.println(4);

				 }			 
			 }
		 };
		 Thread t5 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().consume("?");
					 System.out.println(5);

				 }		
			 }
		 };
		 Thread t6 = new Thread(){
			 public void run(){
				 for(int i=0;i<5;i++){
					 new pro_con_model1().consume("?");
					 System.out.println(6);

				 }		
			 }
		 };
		 
		 t4.start();
		 t5.start();
		 t6.start();
		 t1.start();
		 t2.start();
		 t3.start();

	 }
	 public void produce(String i){
		 try {
			notFull.acquire();
			mutex.acquire();
			list.add(i);
			System.out.println("生产者"+Thread.currentThread().getName()+"生产了1个商品，现存商品"+list.size()+"个");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("仓库已满");
			e.printStackTrace();
		}finally{
			noEmpty.release();
			mutex.release();
		}
		 
	 }
	 public void consume(String  i ){
		 try {
			noEmpty.acquire();
			mutex.acquire();
			list.remove(i);
			System.out.println("消费者"+Thread.currentThread().getName()+"消费了一个商品，剩余商品："+list.size()+"个");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("仓库已空");
			e.printStackTrace();
		}finally{
			notFull.release();
			mutex.release();
		}
		 
		 
	 }
}
