package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class codeWord {

	public static void main(String[] args) throws Exception {
	System.out.println("please input:");
	Scanner scan = new Scanner(System.in);
	String str = scan.nextLine();
    File file = new File("t.txt");
    FileOutputStream  fos = new FileOutputStream(file);
    PrintWriter pw = new PrintWriter(fos);
    pw.write(str);
    System.out.println(" È–¥ÕÍ±œ");
    
    StringBuilder builder = new StringBuilder(str);
    int d = builder.capacity();
    System.out.println(d);
	}
}
