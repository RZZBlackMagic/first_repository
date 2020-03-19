package ByteDanceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
       Test t = new Test();
       t.test2();
	}
  public void tese(){
	  Scanner scan = new Scanner(System.in);
      int N = scan.nextInt();
      int M = 1024-N;
      int flag = 0;
      List<Integer> set = new ArrayList<Integer>();
      set.add(64);
      set.add(16);
      set.add(4);
      set.add(1);
      for(int i=0;i<set.size();i++){
    	  if(M>=set.get(i)){
        	  flag = flag + (M/set.get(i));
        	  M = M-(M/set.get(i))*set.get(i);
          }
      }
      System.out.println(flag);
      
  }
  public void test(){
	  Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      List<String> list = new ArrayList<String>();
      List<String> inputString = new ArrayList();
      for(int i=0;i<n;i++){
   	   String string = scan.next();
   	   inputString.add(string);
      }
      for(int i=0;i<n;i++){
          StringBuffer stringBuffer = new StringBuffer(inputString.get(i));
          int j=0;

          if(stringBuffer.length()<3){
           	   list.add(stringBuffer.toString());
           	   break;
              }
       	   while(j<(stringBuffer.length()-3)){
       		   if(stringBuffer.charAt(j)!=stringBuffer.charAt(j+1)){
       			   j++;
       			   continue;
       		   }
       		   if(stringBuffer.charAt(j+1)==stringBuffer.charAt(j+2)){
       			   stringBuffer.deleteCharAt(j);
       			   continue;
       		   }
       		   if(stringBuffer.length()>=4){
       			   if((stringBuffer.charAt(j+2)==stringBuffer.charAt(j+3))){
           			   stringBuffer.deleteCharAt(j+2);
           			   continue;
           		   }
       		   }
       		   j++;
       	   }
       	   if(stringBuffer.charAt(stringBuffer.length()-1)==stringBuffer.charAt(stringBuffer.length()-2)&&(stringBuffer.charAt(stringBuffer.length()-2)==stringBuffer.charAt(stringBuffer.length()-3))){
       		   stringBuffer.deleteCharAt(stringBuffer.length()-1);
       	   }
       	   list.add(stringBuffer.toString());
       	   
   	   }
      for(int i=0;i<list.toArray().length;i++){
   	   System.out.println(list.toArray()[i]);
      }
  }
  public void test2(){
	  int i=0;
	  int j=0;
	  System.out.println(i++);
	  System.out.println(++j);
	  /*for(int i=0;i<5;++i){
		  System.out.println("¹þ¹þ");
		  System.out.println("Ö´ÐÐ´ÎÊý£º"+i);
	  }*/
  }


}
