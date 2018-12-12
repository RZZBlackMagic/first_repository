package Day03;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		/*
		 *日期转换代码
		 */
		/*
    Date date = new Date();
    System.out.println(date);
    int year = Calendar.YEAR;
    int month = Calendar.MONTH;
    int day = Calendar.DAY_OF_MONTH;
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");
    String str = sdf.format(date);
    System.out.println(str);
    
    String[] mon= {
    		"january","February","March","April","May","June","July","Augest","September","October","Novenber","December"
    };
    int index=Calendar.MONTH;
    String monthDay= mon[index];
    
    SimpleDateFormat sdf1=new SimpleDateFormat("dd.yyyy");
    String str1= sdf1.format(date);
    String s=monthDay+" "+str1;
    System.out.println(s);
    */
		/*
		 * 小孩游戏代码
		 */
         /*String str = "asdadfvsdfv";
         int flag = game(10,str.length());
         System.out.println(flag);
         
	}
	public static int game(int m,int length){//第m个孩子离开，一共有length个孩字
	    String str = new String();
	    length=str.length();
	    while(length>1){
	    	*/
	    
	    /*
	     * 随机输出一个数，第num个孩子离开
	     */
	    /*Scanner Scan = new Scanner (System.in);
	    int num = (int)(Math.random()*m)+1;*/
	    /*
	     *删除第num个孩子 
	     */
	    /*StringBuffer builder= new StringBuffer(str);
	    builder.delete(num, num+1);
	    str = builder.toString();
	    length=str.length();
	    }
		return 0;
		Collection c= new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
        Boolean isContains= c.contains("on");
        System.out.println(isContains);
        
        int size= c.size();
        System.out.println(size);
        
        Boolean isEmpty= c.isEmpty();
        System.out.println(isEmpty);
        
       // c.clear();
        System.out.println(c);
        
        c.remove("one");
        System.out.println(c);
        
        Collection c1 = new ArrayList();
        c1.add("five");
        c1.add("six");
        c1.add("seven");
        c1.add("two");
        c.addAll(c1);
        System.out.println(c);
        
        boolean isContain=c.containsAll(c1);
        System.out.println(isContain);
        
        //c.removeAll(c1);
        System.out.println(c);
        
        Iterator it = c.iterator();
        Boolean isHas=it.hasNext();
        System.out.println(isHas);
        
        String str = (String)it.next();
        System.out.println(str);
        
        it.remove();
        System.out.println(c);
		
		String str="123";
		int a=123;
		String str1=String.valueOf(a);
		System.out.println(str1);*/
                 
		String[] array = {"one","two","three","four","five"};
		Collection <String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
	}

}
