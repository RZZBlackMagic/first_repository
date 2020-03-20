package HuaWeiTest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
//本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
//A={1,2,3},B={1,2,4},R=1
public class Main {
 public static void main(String[] args) {
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
	 Calendar calendar = Calendar.getInstance();
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
	 t2.start();
 }
 public  String test(String a){
	 return a+"hahahahahha";
 }
 public static String forResult(int a , int b){
	 return "("+a+","+b+")";
 }
}