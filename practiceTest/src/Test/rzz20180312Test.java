package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rzz20180312Test {

	public static void main(String[] args) throws IOException  {
    /* File file = new File("."+File.separator+"test.txt");
     boolean isTrue = file.exists();
     System.out.println(isTrue);
     String name = file.getName();
     System.out.println("name:"+name);
     long length = file.length();
     System.out.println("���ļ���СΪ��"+length);
     
     boolean canWrite= file.canRead();
     System.out.println("�Ƿ��д��"+canWrite);
     
     boolean canRead = file.canRead();
     System.out.println("�Ƿ�ɶ���"+canRead);
     
     boolean isHidden= file.isHidden();
     System.out.println(isHidden);
      
     long time = file.lastModified();
     Date date = new Date();
     date.setTime(time);
     System.out.println(date);
     SimpleDateFormat sim= new SimpleDateFormat("yyyy��MM��dd�� HH��mm��ss");
     String str =sim.format(date);
     System.out.println(str);
		
		
		
		
	File file = new File("."+File.separator+"src"+File.separator+"Test.txt");
	 boolean isTrue = file.exists();
	 System.out.println(isTrue);
	 if(isTrue){
		 System.out.println("�ļ��Ѵ���");
	 }else{
		  file.createNewFile();
		  System.out.println("�������");
	 }
	 RandomAccessFile raf = new RandomAccessFile("."+File.separator+"src"+File.separator+"Test.txt","r");
	raf.write(1);
      String d = raf.readLine();
     System.out.println(d);
		
		
		
		
		
   File file = new File("."+File.separator+"a"+File.separator+"b"+File.separator+"c");
   if(!file.exists()){
	   file.mkdirs();
	   System.out.println("�������");
   }else{
	   System.out.println("Ŀ¼����");
   }
    file.delete();
    System.out.println("ɾ�����");
		
   System.out.println(file.isDirectory());
   System.out.println(file.isFile());*/
		
		
	 File file = new File("."+File.separator+"a");
	 boolean istrue= file.isDirectory();
	 System.out.println(istrue);
    /// istrue =file.isFile();
    // System.out.println(istrue);
     if(istrue){
    	 File[] sub = file.listFiles();
    	 for(File sub1:sub){
    		 System.out.println(sub1.getName());
    		 sub1.delete();
    		 System.out.println("ɾ�����");
    	 }
     }
		
		
	}

}
