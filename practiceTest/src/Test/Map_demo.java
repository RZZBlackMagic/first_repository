package Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_demo {

	public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<String,Integer>();
    map.put("阿里", 10000);
    map.put("华为", null);
    map.put("小米", 30000);
    map.put("腾讯", 40000);
    System.out.println(map);
    Integer i1=map.get("阿里");
    System.out.println(i1);
    Integer i2 = map.put("华为",12000);
    System.out.println(i2);
    Collection<Integer> c = map.values();//遍历Values
    System.out.println(c);
    for(Integer in:c){
    	System.out.println(in);
    }
    
    Set<String> keyset = map.keySet();//遍历key值
    System.out.println(keyset);
    for(String s:keyset){
    	System.out.println(s);
    }
    
    
    //遍历键值对
    Set<Entry<String,Integer>> entry = map.entrySet();
    System.out.println(entry);
    for(Entry<String,Integer> e :entry){
    	System.out.println(e);
    }
	}

}
