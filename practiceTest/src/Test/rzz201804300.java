package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rzz201804300 {

	public static void main(String[] args) {
		/*CopyOfThreadSafe run = new CopyOfThreadSafe();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		t1.start();
		t2.start();
		t3.start();
		t4.start();*/
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("语文", 99);
		m.put("数学", 96);
		m.put("物理", 98);
		m.put("化学", 97);
		m.put("英语", 100);
	    Set<String> key = m.keySet();
	    System.out.println(key);
	    Collection<Integer> c = m.values();
	    System.out.println(c);
	    for(Integer a:c){
	    	System.out.println(a);
	    }
	    for(String str:key){
	    	System.out.println(str);
	    }
	    Set<Entry<String,Integer>> entry= m.entrySet();
	   
	    for(Entry<String,Integer> e:entry){
	    	System.out.println(e);
	    }
		System.out.println(m.size());
	}
}























class CopyOfThreadSafe implements Runnable{
	int num=20;
	public void run(){
		synchronized(this){
		    if(num>0){
				try {
					Thread.sleep(1000);
					num--;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"取走车车票,剩余车票："+num);

		    }	
		}
	}
}