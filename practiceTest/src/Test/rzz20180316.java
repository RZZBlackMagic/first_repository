package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class rzz20180316 {

	public static void main(String[] args) throws IOException  {
   /* System.out.println("please input a char :");
    int r = System.in.read();
   
    System.out.println("输入的字符："+(char)r);
    System.out.println("please input a int :");
    int d = System.in.read();
    System.out.println(d);
	System.out.println("请输入一行数据，并按enter来结束");
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String r = br.readLine();
	System.out.println("输入的字符串："+r);
		
		
	RandomAccessFile raf = new RandomAccessFile("t.txt", "rw");
	byte[] data = new byte[1000];
	String str = "你在二环路的里面想着我";
	data = str.getBytes();
	raf.write(data);
	System.out.println("写入完毕");
	//raf.close();
	
	int len = raf.read(data);
	String str1= new String(data,4,6);
	System.out.println(str1);
	
	String Str = raf.readLine();
	System.out.println(Str);
	raf.close();
		
		
    File  file = new File("t.txt");
    if(file.exists()){
    	System.out.println("文件已存在");
    }else {
    	file.createNewFile();
    	System.out.println("文件创建完毕");
    }
    
    FileOutputStream fos = new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(fos);
    BufferedWriter bw = new BufferedWriter(osw);
    byte[] data = new byte[1000];
    String str ="abcdef";
    data = str.getBytes();
    bw.write(str);
    bw.close();
    
    FileInputStream fis = new FileInputStream ("t.txt");
    int s = fis.read();
    int w = fis.read();
    System.out.println(s);
    System.out.println(w);
    InputStreamReader isr = new InputStreamReader(fis);
    //InputStreamReader isr1 = new InputStreamReader(fis);
    int d = isr.read();  
    int d1 = isr.read();
    System.out.println(d);
    System.out.println(d1);
    isr.close();
    isr.close();*/
	
		 Thread min = new Thread(){
		        public void run(){
		           for(int i=0;i<1000;i++){
		              System.out.println("min");
		           }
		        }
		     };
		    Thread max = new Thread(){
		        public void run(){
		           for(int i=0;i<1000;i++){
		              System.out.println("max");
		           }
		        }
		     };
		   Thread nor = new Thread(){
		        public void run(){
		           for(int i=0;i<1000;i++){
		              System.out.println("nor");
		           }
		        }
		     };
		   max.setPriority(Thread.MAX_PRIORITY);
		   min.setPriority(Thread.MIN_PRIORITY);
		   nor.setPriority(Thread.NORM_PRIORITY);
		  
		   min.start();
		   max.start();
		   nor.start();
		
	}

}
