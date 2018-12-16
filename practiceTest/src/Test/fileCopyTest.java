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
    	   System.out.println("file1已存在");
       }
       if(!file2.exists()){
    	   file2.createNewFile();
       }else{
    	   System.out.println("file1已存在");
       }
       FileOutputStream fos1 = new FileOutputStream(file1);
       OutputStreamWriter osw = new OutputStreamWriter(fos1,"GBK");
       BufferedWriter bw = new BufferedWriter(osw);
       String str1 = "FileOutputStream fos = new FileOutputStreamosw写出的字符串都使用该字符集转换 osw还支持第二个参数，是一个字符串，用来指定字符集，当指定后，那么所有使用为文字。OutputStreamWriter osw = new OutputStreamWriter(fos,”GBK”);将上面字节流转为字符流。";
       bw.write(str1);
       bw.close();
       FileOutputStream fos2 = new FileOutputStream(file2);
       OutputStreamWriter osw2 = new OutputStreamWriter(fos2,"GBK");
       BufferedWriter bw2 = new BufferedWriter(osw2);
       String str2 = "九 捕获异常Java异常结构中定义有Throwable类，Exception和Error是其派生的两个子类，其中Exception表示由于网络故障，文件损坏，设备错误，用户输入非法等情况导致的异常。而 Error表示Java运行时环境出现的错误，例如：JVM内存资源耗尽等。"; 
       bw2.write(str2);
       bw2.close();
       System.out.println("请输入源文件名:");
       Scanner scan = new Scanner(System.in);
       String ofn = scan.nextLine();
       System.out.println("请输入目标文件名:");
       String rfn = scan.nextLine();
       String regax = "+";
       String[] sofn = ofn.split("\\+");
       //开始读文件
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
    	   //得到两个文件的内容值和
    	   str11=str11+str22;
       }
       System.out.println(str11);
       File file3 = new File("finally.txt");
       if(!file3.exists()){
    	   file3.createNewFile();
       }else{
    	   System.out.println("file3文件已存在");
       }
       PrintWriter pw = new PrintWriter(file3);
       pw.println(str11);
       pw.close();
	}

}
