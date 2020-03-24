package HuaWeiTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
//本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
//A={1,2,3},B={1,2,4},R=1
public class Main {
 public static void main(String[] args) throws IOException {
   /*  Scanner sc = new Scanner(System.in);
     String input = sc.nextLine();
     String[] list = input.split("=");
     int A[]={0,0,0};
     int B[]={0,0,0};
     for(int i=0;i<3;i++){
    	 int a = Integer.valueOf(list[1].charAt(2*i+1));
    	 A[i] = a-48;
    	 //A[1] = list[1].charAt(3);
     }
     for(int i=0;i<3;i++){
    	 int b = Integer.valueOf(list[2].charAt(2*i+1));
    	 B[i] =b-48;
    	 //B[1] = list[2].charAt(3);    
    	 }
     int R = Integer.valueOf(list[3].toString());
     int minBj = B[0];
     ArrayList<String> result = new ArrayList<String>();
     for(int i=0;i<3;i++){
    	 String string = "";
    	 for(int j=0;j<3;j++){
    		 
    		 if(A[i]<=B[j]){
    			double r = B[j]-A[i];//Math.sqrt(B[j]*B[j] - A[i]*A[i]);
    			if(minBj<=B[j]){
    				//保存最小Bj
    				minBj=B[j];
    			}
    			if(r<=R){
    				//距离满足
    				string = forResult(A[i],B[j]);
    				result.add(string);
    			}
    		 }
    		 
    	 }
    	 if(string.equals("")){
				 string = forResult(A[i],minBj);
				 result.add(string);
		 }
     }
     String resultString = "";
     for(int i=0;i<=result.size();i++){
    	 resultString = resultString + result.get(i);
     }
     System.out.println(resultString);
*/
	/* Scanner scan = new Scanner(System.in);
	 int[] a = {0,1,2};
	 int a1[] = new int[3];
	 String a2[] = new String[9];
	 String a3[][] = new String[2][5];
	 for(int i=0;i<1;i++){
		 
	 }
	 String string = scan.nextLine();
	 System.out.println(string);
	 StringBuffer stringBuffer = new StringBuffer(string);
	 String s = stringBuffer.substring(1, 4);
	 System.out.println(s);
	 Main main = new Main();
	 List<Integer> list = new ArrayList<Integer>();
	 Random random= new Random();
	 for(int i=0;i<10;i++){
	    list.add(random.nextInt(100));
	 }
	 System.out.println(main.test(s));*/
	 /*Calendar calendar = Calendar.getInstance();
     calendar.setTime(new Date());
     int year = calendar.get(Calendar.YEAR);
     int month = calendar.get(Calendar.MONTH)+1;
     int day = calendar.get(Calendar.DAY_OF_MONTH);
     System.out.println(month);
	 Thread t1 = new Thread(){
		 public void run(){
			 for(int i=0;i<100;i++){
				 // System.out.println(1);
			 }
		 }
	 };
	 Thread t2 = new Thread(){
		 public void run(){
			 for(int i=0;i<100;i++){
				 //System.out.println(2);
			 }
		 }
	 };
	 t1.start();
	 t2.start();*/
	 /*Random rand = new Random();
	  for(int i=0; i<10; i++) {
	   System.out.println(rand.nextInt(100) + 1);
	  }
	  List<Integer> list = new ArrayList<Integer>();
	  List<Integer> list1 = new ArrayList<Integer>();
	  Collections.sort(list);
	  Collections.copy(list1, list);
	  Collections.swap(list1, 0, 4);
	  Integer[] a = (Integer[]) list.toArray();*/
	  /*String str = "asd!wZer?ZXC#";
	  String [] str1 = str.split("!?#");
	  for(int i=0;i<str1.length;i++){
		  System.out.println(str1[i]);
	  }*/
	 
	 /*int x,y;
	 Scanner scan = new Scanner(System.in);
	 String str = scan.next();
	 x = Integer.parseInt(str);
	 str = scan.next();
	 y = Integer.parseInt(str);
	 //List<String> list = new ArrayList<String>();
	 int[] a = new int[x];
	 int[] b = new int[y];
	 for(int i=0;i<x;i++){
		 a[i] = Integer.parseInt(scan.next());
	 }
	 for(int i=0;i<y;i++){
		 b[i] = Integer.parseInt(scan.next());
	 }*/
	 /*for(int i=0;i<a.length;i++){
		 System.out.println(a[i]);
	 }
	 System.out.println("<<<<<");
	 for(int i=0;i<b.length;i++){
		 System.out.println(b[i]);
	 }*/
	 //输入完成
	/* int i=0;
	 int j=0;
	 int n=0;
	 int length=0;
	 int [] c = new int [x+y];
	 while(true){
		 if(i>=x||j>=y){
			 break;
		 }
		 if(n==0){
			 if(a[i]>b[j]){
				 c[n]=b[j];
				 j++;
				 n++;
				 length++;
			 }else{
				 c[n]=a[i];
				 i++;
				 n++;
				 length++;
			 }
		 }else{
			 if(a[i]>b[j]){
				 if(b[j]==c[n-1]){
					 j++;
				 }else{
					 c[n]=b[j];
					 j++;
					 n++;
					 length++;
				 }
			 }else{
				 if(a[i]==c[n-1]){
					 i++;
				 }else{
					 c[n]=a[i];
					 i++;
					 n++;
					 length++;
				 }
			 }
		 }
	 }
	 if(i<x){
		 while(i<x){
			 if(a[i]==c[n-1]){
				 i++;
			 }else{
				 c[n] = a[i];
				 i++;
				 n++;
				 length++;
			 }
		 }
	 }
	 if(j<y){
		 while(j<y){
			 if(b[j]==c[n-1]){
				 j++;
			 }else{
				 c[n] =b[j];
				 n++;
				 j++;
				 length++;
			 }
		 }
	 }
	 for( i=0;i<length;i++){
		 System.out.println(c[i]);
	 }
*/
	 /*InputStreamReader is = new InputStreamReader(System.in);
     BufferedReader br = new BufferedReader(is);
     String input = br.readLine();
     System.out.println(input);
     String[] str = input.split(" ");
     for(int i=0;i<str.length;i++){
    	 System.out.println(str[i]);
     }*/
	 /*

*/
	 List<Integer> l = new ArrayList<Integer>();
	 l.add(1);
	 l.add(2);
	 l.add(3);
	 l.remove(1);
	 System.out.println(l.size());
	 System.out.print(l.toString());
 }
 public  String test(String a){
	 return a+"hahahahahha";
 }
 public static String forResult(int a , int b){
	 return "("+a+","+b+")";
 }
}