package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class rzz20180315 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
    /*if(!file.exists()){
    	file.createNewFile();
    	System.out.println("文件创建完毕");
    }else{
    	System.out.println("文件已存在");
    }
    
    FileOutputStream fos = new FileOutputStream(file);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    String str = "你在二环路的里面想着你";
    byte[] data = new byte[100000];
    data= str.getBytes();
    bos.write(data);
    
    str = "在远方的山上春风十里";
    data = str.getBytes();
    bos.write(data);
    
    String Str = "你是好人";
    data = new byte[100000];
    data = Str.getBytes();
    bos.write(data);
    bos.close();
    
    
    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    bis.read(data);
    int len = bis.read();
    str =  new String(data,0,len );
    System.out.println(str);
    bis.close();*/
   /*FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    int len = bis.read(data);
    Str= "nizai ma ";
    data = Str.getBytes();
    bos.write(data,0,len);
    bos.close();
    FileInputStream fis = new FileInputStream(file);

    FileOutputStream fos1 = new FileOutputStream(file);
    String str1 = "abcdefghtlimnksaksncasncasncanclkasnclasnclkan";
    byte[] data2 = new byte[100000];
    data2= str1.getBytes();
    fos1.write(data2);
    
    fis = new FileInputStream(file);
    String  str = "xyz";
       int len =fis.read(data2);
     System.out.println(len);
     data2 = new byte[1000000];
     data2 = str.getBytes();
     fos1.write(data2, 0, 1);
     fos1.close();
    
    String Str = new String(data2,0,2);
    System.out.println(Str);
	
	File file = new File("t.txt");
	FileOutputStream fos = new FileOutputStream(file);
    String str = "我在二环路的里面想着你";
    byte[] data = new byte[1000];
    data=str.getBytes();
    fos.write(data);
    str = "你在远方的山上春风十里";
    OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
    BufferedWriter bw = new BufferedWriter(osw);
    bw.write(str);
    bw.close();
    
    FileInputStream fis = new FileInputStream(file);
    InputStreamReader isr  = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);
     str = br.readLine();
    System.out.println(str);
	
	File file = new File("t.txt");
	FileInputStream fis = new FileInputStream(file);
	InputStreamReader isr = new InputStreamReader(fis);
	BufferedReader br = new BufferedReader(isr);
	
	File file1= new File("tt.txt");
	FileOutputStream fos = new FileOutputStream(file1);
	OutputStreamWriter osw = new OutputStreamWriter(fos);
	BufferedWriter bw = new BufferedWriter(osw);
	int d=-1;
	long startTime = System.currentTimeMillis();
	while((d=br.read())!=-1){
		bw.write(d);
	}
	System.out.println("复制完毕");
	long endTime= System.currentTimeMillis();
	long time =endTime - startTime;
	System.out.println(time );
	
    File file = new File("t.txt");
    RandomAccessFile raf = new RandomAccessFile(file,"rw");
    raf.write(4);
    String s= "abcdef";
    byte[] data= new byte[100];
    data = s.getBytes();
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(data);
    int len = data.length;
    String str =raf.readLine();
    String Str = new String(data, 0,len);
    raf.close();
	System.out.println(str);
	System.out.println(Str);
	
		System.out.println("程序开始了");
	try{
		String str = "1";
		System.out.println(str.length());
		System.out.println(str.charAt(1));
		System.out.println("!!!");
	}catch(Exception e ){
		e.printStackTrace();
		String str = e.getMessage();
		System.out.println(str);
		System.out.println("就是有个错");
	}*/
	
	File file = new File("t.txt");
	FileOutputStream fos = new FileOutputStream(file);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	Man m= new Man();
	m.setName("你好");
	m.setAge(18);
	m.setHeight(1.2);
	System.out.println(m.toString());
	oos.writeObject(m);
	oos.close();
	System.out.println("已将对象输出至文件");	
	
	
	FileInputStream fis = new FileInputStream("t.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Man mm = (Man)ois.readObject();
	System.out.println(mm);
	ois.close();
	
	}
}
class Man implements Serializable{
	private String name;
	private int age;
	private double height;
	void setName(String name){
		this.name=name;
	}
	void  setAge(int age){
		this.age=age;
	}
	void setHeight(double height){
		this.height=height;
	}
	public String toString(){
		return name+","+age+","+height;
	}
}