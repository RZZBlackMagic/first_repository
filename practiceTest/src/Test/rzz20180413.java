package Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class rzz20180413 {

	public static void main(String[] args) throws IOException  {
   /* FileInputStream fos = new FileInputStream("t.txt");
    InputStreamReader osr = new InputStreamReader(fos); 
    BufferedReader br = new BufferedReader(osr);
	String str =br.readLine();
	System.out.println(str);
	String[] arr = str.split(" ");
	int[] arrs = new int[arr.length];
    for(int i=0;i<arr.length;i++){
    	arrs[i]= Integer.valueOf(arr[i]);
    }
    for(int i :arrs){
    	System.out.println(i);
    }
    Arrays.sort(arrs);

    for(int i=0;i<arrs.length;i++){
    	System.out.println(arrs[i]);
    }
	Map<String,Integer> map = new HashMap<String,Integer>();
	map.put("ren", 123);
	map.put("zhang", 12);
	map.put("zhe", 1);
    System.out.println(map);
    Set<Entry<String,Integer>> set = map.entrySet();
    for(Entry<String,Integer> e :set){
    	System.out.println(e);
    }
    Set<String> keyset = map.keySet();
    System.out.println(keyset);*/
    
    
	RandomAccessFile raf = new RandomAccessFile("t.txt","rw");
	student[] stu = new student[3];
	String[] s = new String[stu.length];
	
		
		
		
	}

}
class student {
	private int score;
	private String name;
	public student(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return "("+name+","+score+")";
	}
}