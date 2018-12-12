package Day02;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class dateTest {


	public static void main(String[] args) {
    /* Calendar calender =  Calendar.getInstance();
     System.out.println(calender);
     Date date=calender.getTime();
     System.out.println(date);
     
     calender.setTime(date);
     System.out.println(date);
     System.out.println(calender);
     
     int year=calender.get(Calendar.YEAR ); 
     System.out.println(year);
     
     int month=calender.get(Calendar.MONTH);
     System.out.println(month+1);
     
     int day=calender.get(Calendar.DAY_OF_WEEK);
     int day1=calender.get(Calendar.DAY_OF_MONTH);
     System.out.println(day);
     System.out.println(day1);

     calender.set(Calendar.YEAR, 2008);
     System.out.println(calender);
     date=calender.getTime();
     System.out.println(date);
     HashSet c = new HashSet();
     Integer i=new Integer(12);
     
     c.add("one");
     
     
     c.add(i);
     c.add("three");
     c.add("four");
     c.add("five");
     System.out.println(c);
    System.out.println();
    StringBuffer builder= new StringBuffer("bcgfahdhd");
    String str = "a";
    builder.append(str);
    System.out.println(builder);
    
    //builder.replace(1,8,"bca");
    System.out.println(builder);
    
    int t =builder.indexOf(str);
    System.out.println(builder);
    System.out.println(t);
    
    builder.delete(1, 4);
    System.out.println(builder);
   
    builder.insert(1, str);
    System.out.println(builder);
	/**
	 * 矩阵求和算法
	 */
		/*
		int flag=1;
	int[][] str1=new int[3][3];
	for(int i=0;i<str1.length;i++){
		for(int j=0;j<str1[2].length;j++){
			str1[i][j]=flag;
			flag++;
			
            	System.out.print(str1[i][j]+" ");
            
		}
		System.out.println();
	}
	System.out.println("加上");
	int flag2=1;
   int[][] str2=new int[3][3];
   for(int i=0;i<str2.length;i++){
	   for(int j=0;j<str2[2].length;j++){
		 str2[i][j]=flag2;
		 flag2++;
		 System.out.print(str2[i][j]+" ");
	   }
		
		System.out.println();
		
   }
   int[][] sum = new int[3][3];
   for(int i=0;i<sum.length;i++){
	   for(int j=0;j<sum[2].length;j++){
		   sum[i][j]=str1[i][j]+str2[i][j];
		   System.out.print(sum[i][j]+" ");
	   }
	   System.out.println();
   }
  */
		String  str = "bcadefgba";
		int a=sun(str);
		System.out.println(a);
		
   
	}
	public static int sun(String str){
		int flag=0;
		StringBuffer  builder= new StringBuffer(str);
		int length=str.length();
		int num= builder.indexOf("a");	
		while(num!=-1){
			num=builder.indexOf("a");
            flag++;
    		builder.delete(num, num+1);
    		

		}
        
		return flag;
	}

}
