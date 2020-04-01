package Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class test_0329 {

	static volatile int count = 1;
	static Semaphore mutex = new Semaphore(1);
	public static void main(String[] args) {
		/*System.out.println(111);
		int [] arr  = {1,2,3,3,3,4,5,9,8,7,6,4,3,5,2,7};
		int i = find_max(arr);
		System.out.println("出现最多的数据时："+arr[i]);
		Thread t1 = create_thread();
		Thread t2 = create_thread();
		Thread t3 = create_thread();
		Thread t4 = create_thread();
		Thread t5 = create_thread();
		Thread t6 = create_thread();
		Thread t7 = create_thread();
		Thread t8 = create_thread();
		Thread t9 = create_thread();
		Thread t0 = create_thread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t0.start();*/
		BigInteger n = countWay(10);
		System.out.println(n);

	}

	public static int find_max(int [] arr){
		//int [] arr_clone = arr.clone();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		int i=0;//记录值最多的数的下标
		int max =1;//记录出现的最大次数
		int num =1;
		for(int j=0;j<arr.length-1;j++){
			if(arr[j]==arr[j+1]){
				num++;
			}else{
				num=1;
			}
			if(num>max){
				i=j;
				max=num;
			}
			
		}
		
		System.out.println("最多出现了"+max+"次");
			
		return i;
	}

    public static Thread create_thread(){
    	Thread t = new Thread(){
    		public void run(){
    			add_one();
    		}
    	};
    	return t;
    }
    
    public static synchronized void add_one(){
    	count++;
    	System.out.println("当前线程是："+Thread.currentThread().getName()+",count="+count);
    }

    public static BigInteger countWay(int a){
        if(a==1){
        	return BigInteger.valueOf(0);
        }
        if(a==2){
        	return BigInteger.valueOf(1);
        }
        if(a==3){
        	return BigInteger.valueOf(2);
        }
        if(a>3){
       	  return countWay(a-1).add(countWay(a-2));
        }
        return BigInteger.valueOf(0);
        
    }
    
}


