package Day01;

import java.util.Scanner;

public class StringTest {
	/*
	public static void main(String[] args){
		System.out.println("你要输入的是：");
       Scanner s=new Scanner(System.in);
       String nameStr=s.nextLine();
       Scanner s1=new Scanner(System.in);
       String Str=s1.nextLine();
       if(nameStr.equals("身份证号码")){
    	   
           String regax= "([0-9]{18})";
           if(Str.equals(regax)){
        	   System.out.println("true");
           }else{
        	   System.out.println("false");
           }
       }
       if(nameStr.equals("邮政编码吗")){
    	  
    	   String regax="[0-9]{6}";
    	
    	   if(Str.equals(regax)){
    		   System.out.println("true");
    	   }else{
    		   System.out.println("false");
    	   }
       }
       if(nameStr.equals("手机号码")){
    	   String regax="(^13[0-9]{9})|(15[89][0-9]{7}$)";
    	   if(Str.matches(regax)){
    		   System.out.println("true");
    	   }else{
    		   System.out.println("false");
    	   }
       }
       
	}
	public static void main(String[] args){
		System.out.println("pleasa input information:");
		Scanner s= new Scanner(System.in);
		String information= s.nextLine();
		String[] date = information.split("[0-9]+");
		String[] date1= information.split("\\D|\\W");
		for(int i=0;i<date.length;i++){
			System.out.println(date[i]);
		}
		for(int i=0;i<date1.length;i++){
			System.out.println(date1[i]);
		}
		*/
	
	public static void main(String[] args){
		System.out.println("please input string :");
		Scanner s= new Scanner(System.in);
		String str= s.nextLine();
		int n= str.indexOf(".");
		if(n!=-1&&(n!=(str.length()-1))){
			System.out.println("小数");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
