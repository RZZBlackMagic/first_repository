package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class rzz20180412 {

	public static void main(String[] args) {
   /* Queue<String> queue = new LinkedList<String>();
    queue.offer("one");
    queue.offer("two");
    queue.offer("three");
    queue.offer("four");
    System.out.println(queue);
    String str =queue.poll();
    System.out.println(str);
    System.out.println(queue);
    str=queue.peek();
    System.out.println(str);
    System.out.println(queue);
    for(String s:queue){
    	System.out.println(s);
    }
    System.out.println(queue);
    
    
    //����
    Deque<String> deque = new LinkedList<String>();
    deque.offer("one");
    deque.offer("two");
    deque.offer("three");
    deque.offerFirst("four");
    System.out.println(deque);
    str = deque.poll();
    System.out.println(str);
    str=deque.pollLast();
    System.out.println(str);
    System.out.println(deque);
    
    
    
    //zhan
    Deque<String> stack = new LinkedList<String>();
    stack.push("one");
    stack.push("two");
    stack.push("three");
    stack.push("four");
    System.out.println(stack);
    str= stack.pop();
    System.out.println(str);
    System.out.println(stack);
	Map<String,Integer> map = new HashMap<String,Integer>();
	map.put("����", null);
	map.put("��ѧ", 98);
	map.put("Ӣ��", 97);
	map.put("����", 96);
	map.put("��ѧ", 94);
    System.out.println(map);
    Integer num = map.put("����", 88);
    System.out.println(num);
    System.out.println(map);
    Integer values1 = map.get("��ѧ");
    System.out.println(values1);
    Integer values2 = map.remove("��ѧ");
    System.out.println(values2);
    System.out.println(map);
    
    
    
    Set<String> keyset = map.keySet();
    System.out.println(keyset);
    for(String str:keyset){
    	System.out.println(str);
    }
    
    
    Set<Entry<String,Integer>> entry = map.entrySet();
    System.out.println(entry);
    for(Entry e:entry){
    	System.out.println(e);
    	
    	
    Collection<Integer> c = map.values();
    System.out.println(c);
    for(Integer i:c){
    	System.out.println(i);
    }
	List<point1> c1 = new ArrayList<point1>();
	c1.add(new point1(1,2));
	c1.add(new point1(9,8));
	c1.add(new point1(3,4));
    System.out.println(c1);
	//Collections.sort(c1);
	System.out.println(c1);
		
	
	myComparator1 mc1 = new myComparator1();
	Collections.sort(c1,mc1);
	System.out.println(c1);*/
		
	Map<String,Integer> map = new HashMap<String,Integer>();
	map.put("������", 18);
	map.put("����", 11);
	map.put("������", 19);
	map.put("��", 29);
    System.out.println(map);
    Integer in =map.get("��");
	System.out.println(in);
	
	Set<String> set = map.keySet();
	System.out.println(set);
	for(String s :set){
		System.out.println(s);
	}
	
	Collection<Integer> c = map.values();
	System.out.println(c);
	for(Integer i:c){
		System.out.println(i);
	}
	
	
	Set<Entry<String,Integer>> set1 = map.entrySet();
	System.out.println(set1);
	for(Entry<String ,Integer> e:set1){
		System.out.println(e);
	}
	map.remove("������");
	System.out.println(map);
    }
}
class point1 implements Comparable<point1> {
	private int x;
	private int y;
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
	public point1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public int compareTo(point1 o) {
       int len = (this.x*this.x)-(o.x*o.x+o.y*o.y);
		return len;
	}
	
	
}
class myComparator1 implements Comparator<point1>{

	public int compare(point1 o1, point1 o2) {
        int len = o1.getX()*o1.getY()-o2.getX()*o2.getY();
		return len;
	}

	
	
}
