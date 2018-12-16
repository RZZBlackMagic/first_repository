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
import java.util.Scanner;

public class readLine {

	public static void main(String[] args) throws IOException {
     File file = new File("t.txt");
     FileInputStream fis = new FileInputStream(file);
     InputStreamReader isr = new InputStreamReader(fis);
     BufferedReader br = new BufferedReader(isr);
     String str = null;
     while((str=br.readLine())!=null){
    	 System.out.println(str);
     }
     Scanner scan = new Scanner(System.in);
     String message = scan.nextLine();
     
     FileOutputStream fos = new FileOutputStream("t.txt");
     OutputStreamWriter osw = new OutputStreamWriter(fos);
     PrintWriter  pw = new PrintWriter(osw);
     pw.write(message);
	 pw.flush();
	 pw.close();
	 fis = new FileInputStream(file);
     isr = new InputStreamReader(fis);
     br = new BufferedReader(isr);
     str = null;
     while((str=br.readLine())!=null){
    	 System.out.println(str);
     }
	}
}
