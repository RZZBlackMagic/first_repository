package Test;

import java.io.*;
import java.util.*;

public class fileCopyTest {

	public static void main(String[] args) throws IOException {
       File file1 = new File("example.txt");
       File file2 = new File("result.txt");
       if(!file1.exists()){
    	   file1.createNewFile();
       }else{
    	   System.out.println("file1�Ѵ���");
       }
       if(!file2.exists()){
    	   file2.createNewFile();
       }else{
    	   System.out.println("file1�Ѵ���");
       }
       FileOutputStream fos1 = new FileOutputStream(file1);
       OutputStreamWriter osw = new OutputStreamWriter(fos1,"GBK");
       BufferedWriter bw = new BufferedWriter(osw);
       String str1 = "FileOutputStream fos = new FileOutputStreamoswд�����ַ�����ʹ�ø��ַ���ת�� osw��֧�ֵڶ�����������һ���ַ���������ָ���ַ�������ָ������ô����ʹ��Ϊ���֡�OutputStreamWriter osw = new OutputStreamWriter(fos,��GBK��);�������ֽ���תΪ�ַ�����";
       bw.write(str1);
       bw.close();
       FileOutputStream fos2 = new FileOutputStream(file2);
       OutputStreamWriter osw2 = new OutputStreamWriter(fos2,"GBK");
       BufferedWriter bw2 = new BufferedWriter(osw2);
       String str2 = "�� �����쳣Java�쳣�ṹ�ж�����Throwable�࣬Exception��Error�����������������࣬����Exception��ʾ����������ϣ��ļ��𻵣��豸�����û�����Ƿ���������µ��쳣���� Error��ʾJava����ʱ�������ֵĴ������磺JVM�ڴ���Դ�ľ��ȡ�"; 
       bw2.write(str2);
       bw2.close();
       System.out.println("������Դ�ļ���:");
       Scanner scan = new Scanner(System.in);
       String ofn = scan.nextLine();
       System.out.println("������Ŀ���ļ���:");
       String rfn = scan.nextLine();
       String regax = "+";
       String[] sofn = ofn.split("\\+");
       //��ʼ���ļ�
       FileInputStream fis1 = new FileInputStream(sofn[0]);
       InputStreamReader isr1 = new InputStreamReader(fis1);
       BufferedReader br = new BufferedReader(isr1);
       String str = null;
       String str11=null;
       while((str=br.readLine())!=null){
    	   System.out.println(str);
    	   str11=str;
       }
	   System.out.println(str11);

       FileInputStream fis2 = new FileInputStream(sofn[1]);
       InputStreamReader isr2 = new InputStreamReader(fis2);
       BufferedReader br2 = new BufferedReader(isr2);
       String str22 = null;
       while((str22=br2.readLine())!=null){
    	   //�õ������ļ�������ֵ��
    	   str11=str11+str22;
       }
       System.out.println(str11);
       File file3 = new File("finally.txt");
       if(!file3.exists()){
    	   file3.createNewFile();
       }else{
    	   System.out.println("file3�ļ��Ѵ���");
       }
       PrintWriter pw = new PrintWriter(file3);
       pw.println(str11);
       pw.close();
	}

}
