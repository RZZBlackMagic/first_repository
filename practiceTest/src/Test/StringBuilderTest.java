package Test;

import java.util.Scanner;

public class StringBuilderTest {

	public static void main(String[] args) {
		System.out.println("plesae input string:");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    StringBuilder builder = new StringBuilder(str);
    builder.append("ÄãºÃ°¡");
    str = builder.toString();
    System.out.println(str);
    
   /* System.out.println(builder.length());
    
    builder.append(false);
    System.out.println(builder.toString());
    
    char[] data = new char[10];
    String Str = "¹ş¹ş¹ş¹ş";
    data=str.toCharArray();
    builder.append(data);
    str=builder.toString();
    System.out.println(str);
    
    builder.append(1.9);
    str=builder.toString();
    System.out.println(str);
    
    Man0322 man = new Man0322(18,"ÈÎÕÂÕÜ",1.8);
    builder.append(man.returninfor());
    str=builder.toString();
    System.out.println(str);*/
    
   int d = builder.codePointAt(0);
   System.out.println(d);
   
   builder.delete(2, 3);
   str = builder.toString();
   System.out.println(str);
   
   builder.deleteCharAt(4);
   str=builder.toString();
   System.out.println(str);
	}

}
class Man0322{
	int age;
	String name;
	double height;
	Man0322(int age,String name,double height){
		this.age=age;
		this.name=name;
		this.height=height;
	}
	public String returninfor(){
		return this.age+";"+this.name+";"+this.height;
	}
}
