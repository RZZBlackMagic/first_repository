package Test;

import java.util.Scanner;

public class rzz20180323 {

	public static void main(String[] args) {
    System.out.println("please input String:");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    Tricks t = new Tricks();
    System.out.println(t.toLower(str));
    System.out.println(t.toUpper(str));
    System.out.println(t.turnAround(str));
    System.out.println(t.capitalize(str));
    System.out.println(t.deleteBlank(str));
   // String name = getName(str);
   // String password = getPassword(str);
    //System.out.println("name:"+name+"password:"+password);
	}
	/*public static String getName(String str){
		int position =str.indexOf(":");
		String str1 = str.substring(0, position);
		return str1;
	}
	public static String getPassword(String str){
		int position =str.indexOf(":");
		String str2= str.substring(position, str.length());
		return str2;
	}*/

}
class Tricks{
	public String turnAround(String str){
		String newStr = "";
		int len = str.length();
		System.out.println(len);
		for(int i=len;i>0;i--){
			newStr=newStr+str.charAt(i-1);
			//System.out.println(newStr);
		}
		
		return newStr;
	}
	public String toLower(String str){
		String str1=str.toLowerCase();
		return str1;
	}
	public String toUpper(String str){
		String str2=str.toUpperCase();
		return str2;
	}
	public String capitalize(String str){
		String str1 = str.substring(0, 1);
		str1=str1.toUpperCase();
		String str2 = str.substring(1);
		str2= str2.toLowerCase();
		String nowStr=str1+str2;
		return nowStr;
	}
	public String deleteBlank(String str){
		str= str.trim();
		StringBuilder builder = new StringBuilder(str);
		int len = builder.length();
		for(int i=0;i<len;i++){
			if(builder.charAt(i)==' '){
				builder.deleteCharAt(i);
			}
			len = builder.length();
		}
		str=builder.toString();
		return str;
	}
}
