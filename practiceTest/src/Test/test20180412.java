package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test20180412 {

	public static void main(String[] args) {
    /*List<emps> c = new ArrayList<emps>();
    c.add(new emps(12,"ren",'M',1500));
    c.add(new emps(18,"zhang",'M',2500));
    c.add(new emps(16,"ze",'W',2000));
    c.add(new emps(20,"zhe",'M',3500));
    c.add(new emps(11,"rose",'M',3000));
    //System.out.println(c);
    myComparator2 mc2 = new myComparator2();
    Collections.sort(c,mc2);
   // System.out.println(c);
    for(emps e :c){
    	//System.out.println(e);
    }
    
    emps[] str1 = new emps[c.size()];
    c.toArray(str1);
    for(emps s:str1){
    	System.out.println(s);
    }
   // System.out.println(str1);
    
    
    Integer[] arr ={1,2,3,4,5};
    List<Integer> c1 = Arrays.asList(arr);
    System.out.println(c1);
    for(Integer i:c1){
    	System.out.println(i);
    }
    
    String[] arrs ={"1","2","3","4","5"};
    List<String> c2 = Arrays.asList(arrs);
    System.out.println(c2);
    for(String str : c2){
    	System.out.println(str);
    }
	
    
    
    List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		 
		String[] targetArr=new String[list.size()];
		list.toArray(targetArr);
		System.out.println(targetArr);
		for(String s:targetArr){
		    System.out.println(s);
		}*/
		
		Map<String,Integer> map = new HashMap<String,Integer>(14000000);
		for(int i=0;i<14000000;i++){
            map.put("i"+i, i);
		}
		System.out.println(map);
	}

}
class emps{
	private int age;
	private String name;
	private char gender;
	private int sal;
	public emps(int age, String name, char gender, int sal) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String toString(){
		return "("+name+","+age+","+gender+","+sal+")";
	}
}
class myComparator2 implements Comparator<emps>{
	public int compare(emps o1,emps o2) {
        int sals =o1.getSal()-o2.getSal();
		return sals;
	}
}

