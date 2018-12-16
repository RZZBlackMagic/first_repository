package Test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Collection_sort {

	public static void main(String[] args) {
		 ArrayList list = new ArrayList();
	     list.add(new pointss(1,2));
	     list.add(new pointss(2,3));
	     list.add(new pointss(3,4));
	     list.add(new pointss(4,5));
	     System.out.println(list);
	     Collections.sort(list);
	     System.out.println(list);
	     
	     
	     
	     String str1 = "ÈÎÕÂÕÜ";
	     String str2 ="ÄãºÃ°¡°¡";
	     myCompareator c = new myCompareator(); 
	     System.out.println(c.compare(str1, str2));
	     
	     
	     
	     pointss o = new pointss(1,2);
	     pointss p = new pointss(3,4);
	     System.out.println(o.toString());
	     int d =p.compareTo(o);
	     System.out.println(d);
	     
	     
		 person p1= new person(12,"ÈÎÕÂÕÜ");
		 person p2 = new person(13,"¹ş¹ş¹ş");
		 person p3= new person(19,"heheh");
		 System.out.println(p2.compareTo(p3));
		 
		 
		 
		 ArrayList c1 = new ArrayList();
		 c1.add("ÈÎÕÂÕÜ");
		 c1.add("Äêºó");
		 c1.add("¹ş¹ş¹ş¹ş");
		 myCompareator mc = new myCompareator();
		 Collections.sort(c1,mc);
		 System.out.println(c1);
		 //System.out.println(mc.compare(p1, p2));
	    }

}
class myCompareator implements Comparator<String>{
	public int compare(String o1,String o2){
		int d = o1.length()-o2.length();
		return d;
	}


}
class pointss implements Comparable<pointss>{
	private int x;
	private int y;
	public pointss(int x,int y){
		super();
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public int compareTo(pointss o) {
        int len = (x*x+y*y)-(o.x*o.x+o.y*o.y);
		return len;
	}
	
}
class person implements Comparable<person>{
    private int age;
    private String name;
    public person(int age,String name){
    	super();
    	this.age=age;
    }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int compareTo(person o) {
       int d=this.age-o.age;
       return d;
	}
	
}



