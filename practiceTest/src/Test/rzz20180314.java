package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

public class rzz20180314 {

	public static void main(String[] args) throws IOException {
	
	/*
	 * ���ļ�д����
	 *
	FileOutputStream fos = new FileOutputStream("t.txt");
	 String str = "���ڶ���·������������";
	byte[] data = str.getBytes("UTF-8");
	fos.write(data);
	/*
	 * ���ļ�������
	 *
	FileInputStream fis = new FileInputStream("t.txt");
	data = new byte[1000];
	len = fis.read(data);
	str = new String(data,0,len,"UTF-8");
	System.out.println(str);
   
    /*
     * �����ļ�
     *FileInputStream fis = new FileInputStream("t.txt");

    fos = new FileOutputStream("tt.txt");
    len =-1;
    long startTime = System.currentTimeMillis();
    data = new byte[1000*10000];
    while((len=fis.read(data))!=-1){
    	fos.write(data,0,len);
    }
    long endTime = System.currentTimeMillis();
    long time = endTime-startTime;
    System.out.println(time);
    fos.close();
    fis.close();    
    
    /*
     * ���뻺�����ĸ�ֵ����
     *    FileInputStream fis = new FileInputStream("t.txt");
    BufferedInputStream bis = new BufferedInputStream(fis);
    fos = new FileOutputStream("tt.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    len =-1;
    long startTime = System.currentTimeMillis();
    data = new byte[1000*10000];
    while((len=bis.read(data))!=-1){
    	bos.write(data,0,len);
    }
    long endTime = System.currentTimeMillis();
    long time = endTime-startTime;
    System.out.println(time);
    fos.close();
    fis.close();    
    */
    
    
	
		/*
		 * �ַ���Ҫ�����ֽ�������Ҫ��OutputStreamWriter��InputStreamReader��ת��
		 *
	   FileOutputStream fos = new FileOutputStream("t.txt");
       OutputStreamWriter  osw = new OutputStreamWriter(fos,"UTF-8");
       osw.write("1");
       osw.write("2");
       osw.write("3");
       System.out.println("д�����");
       osw.close();
    
       FileInputStream fis = new FileInputStream("t.txt");
       InputStreamReader isr = new InputStreamReader(fis);
       int d=-1;
       while(((d=fis.read())!=-1)){
    	      System.out.println(d);
       }
    PrintWriter pw = new PrintWriter("t.txt");  
    pw.print("��С��");
    pw.println("��Ϩ������˵���ǰ");
    System.out.println("д�����");
    pw.close();
    
    FileInputStream fis = new FileInputStream("t.txt");
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);
    String str = null;
    while(((str=br.readLine())!=null)){
    	System.out.println(str);
    }
   // br.close();
    FileOutputStream fos = new FileOutputStream("t.txt");
    OutputStreamWriter  osw = new OutputStreamWriter(fos);
    BufferedWriter bs = new BufferedWriter(osw);
    bs.write("��ð�");
    bs.write("������");
    System.out.println("д�����");
    
     bs.close();*/
		File file = new File("t.txt");
		int len =-1;
		if(file.exists()){
			System.out.println("�ļ��Ѵ���");
		}else{
			file.createNewFile();
			System.out.println("�ļ��������");
		}
	    FileOutputStream fos = new FileOutputStream(file);
	    OutputStreamWriter osw = new OutputStreamWriter(fos);
	    BufferedWriter bw = new BufferedWriter(osw);
	    bw.write("���");
	    bw.write("����");
        System.out.println("д�����");
        bw.close();
        
	}

}
