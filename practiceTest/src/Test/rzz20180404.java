package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class rzz20180404 {

	public static void main(String[] args) throws IOException {
    File file = new File("t.txt");
    if(file.exists()){
    	System.out.println("�ļ��Ѵ���");
    }else{
    	file.createNewFile();
    	System.out.println("�������");
    }
    
    FileOutputStream fos= new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(fos);
    osw.write("bcdef���ڶ���·������������");
    osw.write(1);
    osw.write("����Զ����ɽ�ϴ���ʮ��");
    BufferedWriter bw = new BufferedWriter(osw);
    bw.newLine();
    bw.write("���ڶ���·������������");
    bw.write(1);
    bw.write("����Զ����ɽ�ϴ���ʮ��");
    String str =bw.toString();
    char[] data = new char[100];
    for(int i=0;i<100;i++){
    	char c = (char)i;
    	data[i]=c;
    }
    bw.write(data);
    bw.close();
    
    FileInputStream fis = new FileInputStream(file);
    InputStreamReader isr  = new InputStreamReader(fis);
         
	}

}
