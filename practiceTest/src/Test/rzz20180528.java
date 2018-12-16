package Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rzz20180528 {

	public static void main(String[] args) {
        Map<String,Integer> m= new HashMap<String,Integer>();
        m.put("语文", 99);
        m.put("生物", 92);
        m.put("化学", 96);
        m.put("物理", 97);
        m.put("数学", 98);
       System.out.println(m);
       Integer i = m.get("语文");
       System.out.println(i);
       Set<String> s = m.keySet();
       System.out.println(s);
       Set<Entry<String,Integer>> e = m.entrySet();
       for(Entry<String,Integer> entry:e){
    	   System.out.println(entry);
       }
       Frame f = new Frame();
       f.setVisible(true);
       f.setBounds(100, 100, 250, 250);
	}

}
