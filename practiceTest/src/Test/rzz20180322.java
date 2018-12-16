package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class rzz20180322 {

	public static void main(String[] args) throws IOException {
	System.out.println("please input String:");
    Scanner scan = new Scanner(System.in);
    String oriStr= scan.nextLine();
    Caesar cs = new Caesar();
    String nowStr= cs.moved(oriStr);
    System.out.println(nowStr);
   /* int letter=0;
    int chars=0;
    int sixword=0;
	File file = new File("t.txt");
	FileOutputStream fos = new FileOutputStream(file);
	PrintWriter pw = new PrintWriter(fos);
	pw.write(oriStr);
	System.out.println(" ‰»ÎÕÍ≥…");
	pw.close();
	FileInputStream fis = new FileInputStream(file);
	InputStreamReader isr = new InputStreamReader(fis);
	BufferedReader br = new BufferedReader(isr);
	String str =br.readLine();
	int len = str.length();
	for(int i=0;i<len;i++){
		if(str.charAt(i)>=65&&str.charAt(i)<=122){
			letter++;
		}
		if(str.charAt(i)>=6&&str.charAt(i)<=16){
			chars++;
		}
	}
   System.out.println(letter);
   System.out.println(chars);*/
   
	
	}

}
class Caesar{
	String str1;
	public String moved(String str){
		str=str.trim();
		StringBuilder builder= new StringBuilder(str); 
		int len = builder.length();
		for(int i=0;i<len;i++){
			if(builder.charAt(i)==' '){
				builder.deleteCharAt(i);
				i--;
			}
			len = builder.length();
		}
		String s = builder.toString();
		System.out.println(s);
		len =builder.length();
		
		int flag=0;
		for(int i=0;i<len;i++){
			if((i+1)%(5+flag)==flag){
				  builder.insert(5,' ');
				  len=builder.length();
				  flag++;
			}
		}
		str = builder.toString();
	    return str;
		
	}
}

/*len = builder.length();
for(int i=1;i<len+1;i++){
if(len%5==0){
	builder.insert(i, i+1);
}
}
str1= builder.toString();*/
/*str=str.trim();
StringBuilder builder= new StringBuilder(str); 
int len = builder.length();
for(int i=0;i<len;i++){
	if(str.charAt(i)==' '){
		builder.deleteCharAt(i);
	}
	len = builder.length();
}
String s = builder.toString();
//System.out.println(s);

return s*/