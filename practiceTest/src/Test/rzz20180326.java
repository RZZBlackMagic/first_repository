package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class rzz20180326 {

	public static void main(String[] args) {
		String str= new String();
    Collection c = new ArrayList();
    c.add("ni");
    c.add("wo");
    c.add("xs");
    System.out.println(c);
    Iterator it = c.iterator();
    while(it.hasNext()){
    	str = (String)it.next();
    	System.out.print(str+" ");
    }
    System.out.println();
   Collection c1= new ArrayList();
   c1.addAll(c);
   System.out.println(c1);
   boolean isTrue =c1.isEmpty();
   System.out.println(isTrue);
   c1.clear();
   c1.add("ni");
   c1.add("wo");
   
   System.out.println(c1);
   boolean isFalse= c.containsAll(c1);
   System.out.println(isFalse);
   Object[] arr=c1.toArray();
   String s=arr.toString();
   System.out.println(s);
   //String[] arrs = (String[])c1.toArray();
  
   //System.out.println(arrs);
  
	}

}
/*class Object{
	public String toString(){
		return null;
	}
}
*/
