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
import java.io.Writer;

import javax.xml.transform.OutputKeys;

public class rzz20180331 {

	public static void main(String[] args) throws IOException {
     File file = new File("t.txt");
     if(file.exists()){
    	 System.out.println("�ļ��Ѵ���");
     }else{
    	 file.createNewFile();
    	 System.out.println("�ļ��������");
     }
     FileOutputStream fos = new FileOutputStream(file);
     
     OutputStreamWriter osw = new OutputStreamWriter(fos);
     osw.write("����");
     osw.close();
     //BufferedWriter bw = new BufferedWriter(osw);
   //  bw.write("������");
     PrintWriter pw = new PrintWriter(fos);
     pw.write("���ڶ���·������������");
     pw.write("����Զ����ɽ�ϴ���ʮ��");
     pw.close();
     
     FileInputStream fis = new FileInputStream(file);
    // int d=fis.read();
     //System.out.println(d);
      //char c = (char)d;
      //System.out.println(c);
     InputStreamReader isr =new InputStreamReader(fis);
     BufferedReader br = new BufferedReader(isr);
     String str=br.readLine();
     System.out.println(str);
     System.out.println(isr.read());
     int i =isr.read();
     //System.out.println(i);
     //c=(char)i;
    // System.out.println(c);
     
     //InputStreamReader br = new InputStreamReader(fis);
    // d=fis.read();
   //  System.out.println(d);
    
     
	}

}
