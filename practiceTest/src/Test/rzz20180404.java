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
    	System.out.println("文件已存在");
    }else{
    	file.createNewFile();
    	System.out.println("创建完毕");
    }
    
    FileOutputStream fos= new FileOutputStream(file);
    OutputStreamWriter osw = new OutputStreamWriter(fos);
    osw.write("bcdef我在二环路的里面想着你");
    osw.write(1);
    osw.write("你在远方的山上春风十里");
    BufferedWriter bw = new BufferedWriter(osw);
    bw.newLine();
    bw.write("我在二环路的里面想着你");
    bw.write(1);
    bw.write("你在远方的山上春风十里");
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
