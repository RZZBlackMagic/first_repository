package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;

public class rzz20180320 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file = new  File("t.txt");
    if(file.exists()){
    	System.out.println("文件已存在");
    }else{
    	file.createNewFile();
    	System.out.println("文件创建完毕");
    }
    
    FileOutputStream os = new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(os);
  //  osw.write("abc");
    BufferedWriter bw = new BufferedWriter(osw);
    bw.write("abcdef");
    bw.close();
    
    FileInputStream is = new FileInputStream(file);
    //InputStreamReader isw = new InputStreamReader(is);
    byte[] data = new byte[100];
    String str =is.toString();
    data = str.getBytes();
   // System.out.println(data);
    /*int length  = str.length();
    int d =isw.read();
    System.out.println(d);
    
    int d1 = isw.read();
    System.out.println(d1);*/
    int d1 =-1;
    while(( d1 =is.read())!=-1){
    	System.out.println(d1);
    
    //	int d2 = is.read();
    	//System.out.println(d2);
    }
    
    /*BufferedReader  br = new BufferedReader(isw);
   String  str = br.readLine();
    System.out.println(str);
      PrintWriter pw = new PrintWriter(os);
      pw.println();
      pw.close();
      
      M man = new M (13,"任章哲",1);
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(man);

      
     FileInputStream fis =new FileInputStream(file);
     ObjectInputStream ois = new ObjectInputStream(fis);
     M m = (M)ois.readObject();
     String s = m.toString();
     System.out.println(s);*/
	}
}

class M implements Serializable{
	int age;
	String name;
	long length;
	M(int age,String name,long length){
		this.age=age;
		this.name=name;
	}
	
}