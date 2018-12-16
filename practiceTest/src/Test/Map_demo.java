package Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_demo {

	public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<String,Integer>();
    map.put("����", 10000);
    map.put("��Ϊ", null);
    map.put("С��", 30000);
    map.put("��Ѷ", 40000);
    System.out.println(map);
    Integer i1=map.get("����");
    System.out.println(i1);
    Integer i2 = map.put("��Ϊ",12000);
    System.out.println(i2);
    Collection<Integer> c = map.values();//����Values
    System.out.println(c);
    for(Integer in:c){
    	System.out.println(in);
    }
    
    Set<String> keyset = map.keySet();//����keyֵ
    System.out.println(keyset);
    for(String s:keyset){
    	System.out.println(s);
    }
    
    
    //������ֵ��
    Set<Entry<String,Integer>> entry = map.entrySet();
    System.out.println(entry);
    for(Entry<String,Integer> e :entry){
    	System.out.println(e);
    }
	}

}
