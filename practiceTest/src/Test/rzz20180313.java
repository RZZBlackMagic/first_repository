package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class rzz20180313 {

	public static void main(String[] args) throws IOException {
	/*File file = new File("."+File.separator+"raf.txt");
	if(!file.exists()){
		file.createNewFile();
		System.out.println("�������");
	}else{
		System.out.println("�ļ��Ѵ���");
	}
    
    RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");
    //raf.writeBytes("��������������ð���");
    raf.write(1);
   // raf.write(1);
    int d = raf.read();
    System.out.println(d);
    raf.close();
    RandomAccessFile rafr = new RandomAccessFile("test.txt","r");
    rafr.readLine();
    System.out.println(rafr);
    rafr.close();
		
	FileOutputStream fos = new FileOutputStream("fos.txt");
	String str ="���ڶ���·������������";
	byte[] data = str.getBytes("UTF-8");
	fos.write(data);
	str = "����Զ����ɽ�ϣ�����ʮ��";
	data = str.getBytes("UTF-8");
	fos.write(data);	
	System.out.println("������");
	fos.close();
	
	
	fos = new FileOutputStream("fos.txt");
	String str1 = "��ã�������";
	data = str1.getBytes("UTF-8");
	fos.write(data);
	System.out.println("������");
	fos.close();
	
	
	fos = new FileOutputStream("fos.txt",true);
	String str2 = "���ڶ���·������������";
	byte[] data2 = str2.getBytes("UTF-8");
	fos.write(data2);
	fos.close();
	
	FileInputStream fis = new FileInputStream("fos.txt");
	byte[] data3 = new byte[100];
	int len = fis.read(data3);
	String str3 = new String(data3,0,len,"UTF-8");
	System.out.println(str3);
		*/
	
		
	FileInputStream fis = new FileInputStream("fis.txt");
	BufferedInputStream  bis = BufferedInputStream(fis);
	FileOutputStream fos = new FileOutputStream("fos.txt");
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	int d =-1;
	long stratTime = System.currentTimeMillis();
	while((d=bis.read())!=-1){
		bos.write(d);
	}System.out.println("�������");
	long endTime= System.currentTimeMillis();
	long time =endTime-stratTime;
	System.out.println(time);
	bis.close();
	bos.close();
		
		
		
		
		
		
		
		
		
		
	}

	private static BufferedInputStream BufferedInputStream(FileInputStream fis) {
		// TODO Auto-generated method stub
		return null;
	}

}
