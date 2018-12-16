package Test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class rzz20180411 {

	public static void main(String[] args) {
      ArrayList<String> c = new ArrayList<String>();
      c.add("A");
      c.add("a");
      c.add("B");
      c.add("b");
      System.out.println(c.toArray(new String[c.size()]));
      String[] str =  {"1","222","2376","4444444","55"};
      ArrayList c1 =  new ArrayList();
      c1.add("11111");
      c1.add("222");
      c1.add("333333");
      //c1=Arrays.asList(str);
      System.out.println(c1);
      Collections.sort(c);
      System.out.println(c);
      Collections.reverse(c);
      System.out.println(c1);
      String str1= "任章哲你好啊";
      String str2="任章s哲还行啊";
      compare com = new compare();
      com.Sort(str1, str2);
      
      points p= new points(1,2);
      points o = new points(2,3);
      ArrayList<points> c2 = new ArrayList<points>();
      c2.add(new points(1,2));
      c2.add(new points(2,3));
      c2.add(new points(4,5));
      c2.add(new points(3,4));
      System.out.println(p.compareTo(o));
      System.out.println(c2);
      //myComparator mc= new myComparator();
      //Collections.sort(c1, mc);
      //System.out.println(c1);
      
      System.out.println(c2);
      
      myComparator Mc= new myComparator();
      Collections.sort(c2,Mc);
      System.out.println(c2);
	}

}
	

class compare {
	public void Sort(String str1,String str2){
		if(str1.length()>str2.length()){
			System.out.println("str1>str2");
		}else if(str1.length()<str2.length()){
			System.out.println("str1<str2");
		}else{
			System.out.println("str1=str2");
		}
	}
}
class points implements Comparable<points>{
	private int x;
	private int y;
	public points(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
	public int compareTo(points o) {
        int orinum= this.x*this.x+this.y*this.y;
        int nownum =o.x*o.x+o.y*o.y;
        int num=nownum-orinum;
            return num;
        }
}
class myComparator implements Comparator<points>{//建议使用

	public int compare(points o1, points o2) {
		return o1.compareTo(o2);
	}

	

	

	
	
	
}


	
