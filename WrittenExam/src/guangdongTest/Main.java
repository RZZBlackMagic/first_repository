package guangdongTest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static long result =0;
	private static Map<String,Long> unitMap =new HashMap<String,Long>();
	private static Map<String,Long> numMap =new HashMap<String,Long>();

	private static String stryi = new String();
	private static String stryiwan = new String();
	private static String stryione = new String();
	private static String strwan = new String();
	private static String strone = new String();

	public static void main(String[] args) {
		
		
		
	}

	public static void ChangeChnString(String chnStr){
		unitMap.put("十", 10L);
		unitMap.put("百", 100L);
		unitMap.put("千", 1000L);
		unitMap.put("万", 10000L);
		unitMap.put("亿", 100000000L);
		numMap.put("零",0L);
		numMap.put("一",1L);
		numMap.put("二",2L);
		numMap.put("三",3L);
		numMap.put("四",4L);
		numMap.put("五",5L);
		numMap.put("六",6L);
		numMap.put("七",7L);
		numMap.put("八",8L);
		numMap.put("九",9L);
		for(int i=0;i<chnStr.length();i++){
			if('零'==(chnStr.charAt(i))){
				chnStr = chnStr.substring(0,i) + chnStr.substring(i+1);
			}
		}
		int index = 0;
		boolean yiflag = true;
		boolean yiwanflag = true;
		boolean wanflag = true;
		

	}
	
}
