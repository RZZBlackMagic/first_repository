package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class rzz20180330 {

	public static void main(String[] args) {
   /* point<String> str = new point<String>();
    str.point("hi", "hello");
    System.out.println(str.getX());
    System.out.println(str.getY());*/
	Collection c = new ArrayList();
	c.add("任先生");
	c.add("你好啊");
	c.add("还行吧");
	

	System.out.println(c);
	//c.remove("任先生");
	//System.out.println(c);
	Collection<String> c1 = new ArrayList<String>();
	c1.add("任先生");
	c1.add("你好啊");
	c1.add("还行吧");
	//c.removeAll(c1);
	System.out.println(c);
	String str =c.toString();
	System.out.println(str);
	
	Object[] arr = c.toArray(new String[c.size()]);
	Object[] sss=new String[c.size()];
     System.out.println(arr); 
    Object[] or = new String[100];
	or=c.toArray();
	System.out.println(Arrays.toString(or));

	
	Object a = new Object();
	a=1;
	str = a.toString();
	System.out.println(str);
	
	Object[] arrs = new Object[3];
	arrs[0]=1;
	arrs[1]="任章哲";
	arrs[2]='c';
	str=arrs.toString();
	System.out.println(str);
	String s = Arrays.toString(arrs);
    System.out.println(s);
    
    int[] aa= {0,9,8,7,6};
    str = aa.toString();
    System.out.println(str);
    s=Arrays.toString(aa);
    System.out.println(s);
	}

}
class point<T>{
	private T x;
	private T y;
	public void point(T x,T y){
		this.x=x;
		this.y=y;
	}
	public T getX(){
	    return this.x;
	}
	public T getY(){
		return this.y;
	}
	public void setX(T x){
		this.x=x;
	}
	public void setY(T y){
		this.y=y;
	}
}