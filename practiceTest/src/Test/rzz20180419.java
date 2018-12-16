package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class rzz20180419 {

	public static void main(String[] args) {
		Thread thread1 = new Thread(){
			public void run(){
				for(int i=0;i<26;i++){
					try {
						LetterExchange();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				
			}
		};
		Thread thread2 = new Thread(){
			public void run(){
				try {
					FileHandle();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
		

	}
	public static void FileHandle() throws FileNotFoundException{
		File file = new File("t.txt");
		if(file.exists()){
			System.out.println("文件已存在");
		}else{
			System.out.println("已创建新文件");
		}
		FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw);
        for(int i=0;i<26;i++){
        	pw.write(97+i);
        }
        pw.close();
	}
	public static void LetterExchange() throws IOException{
		File file = new File("t.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		
		char[] data = new char[100];
		BufferedReader br = new BufferedReader(isr);
		br.read(data);
		
       for(int i=1;i<26;i++){
    	   
           char c;
           c=data[i];
           data[i]=data[i-1];
           data[i-1]=c;

       }
       System.out.println(data);
	}
}
