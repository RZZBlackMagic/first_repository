package Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rzz20180414 {

	public static void main(String[] args) throws IOException {
      /*List<String> c = new ArrayList<String>();
	  c.add("ren");
	  c.add("zhang");
	  c.add("ahe");
	  System.out.println(c);
	  myComparator3 mc3 = new myComparator3();
	  Collections.sort(c,mc3);
	  System.out.println(c);
	File file = new File("D:"+File.separator+"filetest"+File.separator+"ts.txt");
	if(file.exists()){
		System.out.println("文件已存在");
	}else{
		file.createNewFile();
		System.out.println("文件已创建");
	}*/
	myThread04140 t1 = new myThread04140();
	myThread04141 t0 = new myThread04141();
   // t1.start();
   // t0.start();
	Runnable run2 = new myThread04142();
	Runnable run3 = new myThread04143();
	Thread t2 = new Thread(run2);
	Thread t3 = new Thread(run3);
	t2.setPriority(10);
	t3.setPriority(10);
	t2.setDaemon(true);
	//t2.start();
	//t3.setDaemon(true);
	//t3.start();
	/*
	 * 编译器会根据创建先后从0给线程分次序，所以这里就是Thread-1
	 */
	String str =t2.getName();
	//System.out.println(str);
	/*
	 * 获取优先级，默认是5
	 */
	int d = t3.getPriority();
	//System.out.println(d);
	
	boolean b =t2.isInterrupted();
	//System.out.println(b);

	
	Thread rose = new Thread(){
		public void run(){
			for(int i=0;i<10;i++){
                try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("let me go!");
				
				System.out.println("aaaaaa");
			}
		}
	};
	Thread jack = new Thread(){
		public void run(){
        while(true){
			System.out.println("you jump,i jump");
			}
		}
	};
	//rose.setDaemon(true);
	rose.start();
	jack.setDaemon(true);
	jack.start();
	System.out.println("main结束了");
	
	}

	

}
class myComparator3 implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
      int len = o1.length()-o2.length();
		return len;
	}
	
}
class myThread04140 extends Thread{
    public void run(){
    	for(int i=0;i<10;i++){
    	   System.out.println("你是SEI？");
    	}
    }
}
class myThread04141 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
		    System.out.println("我是查水表的");
		}
	}
}
class myThread04142 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
		       System.out.println("oh，jack");		

		}
	}
	
	
}
class myThread04143 implements Runnable{

	@Override
	public void run() {
        while(true){
		System.out.println("oh,rose");		
		}
	}
	
}