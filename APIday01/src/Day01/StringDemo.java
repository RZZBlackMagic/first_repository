package Day01;

import java.util.Date;

public class StringDemo {

	public static void main(String[] args) {
        //java�Ƽ�ʹ����������ʽ�����ַ�������
		String s1="123abc";
		//����������һ����������������������
		String s2="123abc";
		//s2����s1�������ַ�������
		System.out.println(s1==s2);//true
		System.out.println(s1.equals(s2));//true
		//new����һ����������
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
		 //�ҵ�һ�γ���in��λ��
		 int index = str.indexOf("in");
		 System.out.println(index);
		 //���±�3����ʼ���ҵ�һ�γ���in��λ��
		 index = str.indexOf("in",3);
		 System.out.println(index);
		 //�������һ�γ��ֵ�in��λ��
		 index = str.lastIndexOf("in");
		 System.out.println(index);
		 
		 
       //             01234567890123		 
		 String str1="www.oracle.com";
		 //ͨ�����������ֱ�ʾ��Χʱ�����Ǻ�ͷ����β��
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
 
			 
			 String str4 = "�ú�ѧϰJava";
			 StringBuilder builder = new StringBuilder(str4);
			builder.append(",Ϊ���Ҹ��ù���");
			  String St = builder.toString();
			System.out.println(St);
			
			
			Date now = new Date();
			System.out.println(now);
			
	       
	}

}
