package Day01;

import java.util.Date;

public class StringDemo {

	public static void main(String[] args) {
        //java推荐使用字面量形式创建字符串对象
		String s1="123abc";
		//字面量对象一旦发现曾经创建过就重用
		String s2="123abc";
		//s2重用s1创建的字符串对象
		System.out.println(s1==s2);//true
		System.out.println(s1.equals(s2));//true
		//new操作一定创建对象
		String s3=new String("123abc");
		System.out.println("s3"+s3);
		 
		 System.out.println(s1==s3);//false
		 System.out.println(s1.equals(s2));//true
		 String s4="123"+"abc";
		 System.out.println(s1==s4);//true
		  
		 String s5="123";
		 String s6=s5+"abc";
		 System.out.println(s1==s6);//false
		  
		 
		 //           0123456789012345
		 String str= "thinking in java";
		 //找第一次出现in的位置
		 int index = str.indexOf("in");
		 System.out.println(index);
		 //从下标3处开始查找第一次出现in的位置
		 index = str.indexOf("in",3);
		 System.out.println(index);
		 //查找最后一次出现的in的位置
		 index = str.lastIndexOf("in");
		 System.out.println(index);
		 
		 
       //             01234567890123		 
		 String str1="www.oracle.com";
		 //通常用两个数字表示范围时，都是含头不含尾的
		 String sub = str.substring(4,10);
		 System.out.println(sub);
		 
		 sub=str.substring(4);
		 System.out.println(sub);
		 
		 
		 
		  String str2= " he llo  ";
	      String s = str2.trim();
	      System.out.println(str2);//  hello
	      System.out.println(s);//hello
	      
			 String str3= "thinking in java";
			 char a=str3.charAt(3);
			 System.out.println(a);
 
			 
			 String str4 = "好好学习Java";
			 StringBuilder builder = new StringBuilder(str4);
			builder.append(",为了找个好工作");
			  String St = builder.toString();
			System.out.println(St);
			
			
			Date now = new Date();
			System.out.println(now);
			
	       
	}

}
