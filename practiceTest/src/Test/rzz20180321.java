package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class rzz20180321 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
     /*File file = new File("T.txt");
     if(file.exists()){
    	 System.out.println("文件已存在");
     }else{
    	 file.createNewFile();
    	 System.out.println("文件创建成功");
     }
     
     Manssss man = new Manssss(18,"任章哲",1.8);
     FileOutputStream fos = new FileOutputStream(file);
     ObjectOutputStream oos = new ObjectOutputStream(fos);
     oos.writeObject(man);
     oos.close();
     
     FileInputStream fis = new FileInputStream(file);
     ObjectInputStream ois = new ObjectInputStream(fis);
    Manssss mans =(Manssss) ois.readObject();
    System.out.println(mans);
		
		int flag=0;
		System.out.println("please input String:");
	Scanner scan1 = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	String str1 =scan1.nextLine();
	System.out.println("please input String2:");
	String str2 = scan2.nextLine();
	int len1=str1.length();
	int len2= str2.length();
	System.out.println(len1);
	System.out.println(len2);
	if(len1!=len2){
		System.out.println("不相等");
	}else{
	    for(int i=0;i<len1;i++){
	    	if(str1.charAt(i)!=str2.charAt(i)){
	    		break;
	    	}else{
	    		flag++;
	    		System.out.println(flag);
	    	}
	    }
	   
	}
	System.out.println(flag);
	 if(flag==len1){
         System.out.println("相等");
   	}else{
   		System.out.println("不相等");
   	}
	*/
		System.out.println("please input String:");
	Scanner scan = new Scanner(System.in);
	String string = scan.nextLine();
	StringTricks st = new StringTricks();
	String str = st.Lower(string);
	System.out.println(str);
		
		
		
		
		
	}

}
class StringTricks{
	String str1;
	public String Lower(String str){
		int len = str.length();
		char[] data = new char[len];
		for(int i=0;i<len;i++){
		data[i] =(char)(str.charAt(i)+32);
			System.out.println(data[i]);
		}
		byte[] bytes = new byte[len];
		for(int i=0;i<len;i++){
			bytes[i] = (byte)str.charAt(i);
		}
		String s =str1.valueOf(data);
		System.out.println(s);
		String s1 = data.toString();
		System.out.println(s1);
		str1 =(Arrays.toString(bytes));
		System.out.println(str1);
		return str1;
	}
}
/*
class Manssss implements Serializable{
	private int age;
	private String name;
	private double length;
	Manssss(int age,String name,double length){
		this.age=age;
		this.length=length;
		this.name=name;
	}
	public int getAge(){
		return this.age;
	}
	public String getName(){
		return this.name;
	}
	public double getLength(){
		return this.length;
	}
}*/