package ByteDanceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	/*
	 * 3
CZ7132,A1,ZHANGSAN
CZ7132,A2,ZHAOSI
CZ7156,A2,WANGWU
2
CZ7132,A1,CZ7156,A2
CZ7156,A2,CZ7156,A3*/
       Scanner scan = new Scanner(System.in);
       int N = scan.nextInt();
       ArrayList<String> orgList = new ArrayList<String>();
       String string;
       for(int i=0;i<N+1;i++){
    	   string = scan.nextLine();
    	   orgList.add(string);
       }
       int M = scan.nextInt();
       ArrayList<String> newList = new ArrayList<String>();
       for(int i=0;i<M+1;i++){
    	   string = scan.nextLine();
    	   newList.add(string);
       }
       
	   /*System.out.println(orgList.get(0));
	   System.out.println(orgList.get(1));
	   System.out.println(orgList.get(2));
	   System.out.println(newList.get(0));
	   System.out.println(newList.get(1));
	   
	   *
	   *3
CZ7132,A1,ZHANGSAN
CZ7132,A2,ZHAOSI
CZ7156,A2,WANGWU
2
CZ7132,A1,CZ7156,A2
CZ7156,A2,CZ7156,A3/

       
	   /*System.out.println(N);
	   for(int i=0;i<orgList.size();i++){
		   System.out.println(orgList.get(i).toString());
	   }
	   System.out.println(M);
	   for(int i=0;i<orgList.size()+1;i++){
		   System.out.println(newList.get(i).toString());
	   }*/
	   ArrayList<String[]> orgFinalList = new ArrayList<String[]>();

       String[] orgString = new String[orgList.size()];
       for(int i=1;i<orgList.size();i++){
    	   //System.out.println(orgList.get(i));
    	   orgString = orgList.get(i).split(",");
    	   orgFinalList.add(orgString);
       }
       //System.out.println(orgList.size());
       //System.out.println(newList.size());

	  /* System.out.println(orgString[0]);
	   System.out.println(orgString[1]);
	   System.out.println(orgString[2]);*/

	   ArrayList<String[]> newFinalList = new ArrayList<String[]>();

	   String[] newString = new String[newList.size()];
       for(int i=1;i<newList.size();i++){
    	   //System.out.println(newList.get(i));
    	   newString = newList.get(i).split(",");
    	   newFinalList.add(newString);
       }
	   /*System.out.println(newString[0]);
	   System.out.println(newString[1]);
	   System.out.println(newString[2]);*/
       /*System.out.println(orgFinalList.get(0)[0].toString());
       System.out.println(orgFinalList.get(1)[1].toString());
       System.out.println(orgFinalList.get(2)[0].toString());
       System.out.println(orgFinalList.get(0)[1].toString());*/
	   for(int i=0;i<orgFinalList.size();i++){
		   for(int j=0;j<newFinalList.size();j++){
			   if(orgFinalList.get(i)[0].equals(newFinalList.get(j)[0])&&orgFinalList.get(i)[1].equals(newFinalList.get(j)[1])){
				   orgFinalList.get(i)[0]=newFinalList.get(j)[2];
				   orgFinalList.get(i)[1]=newFinalList.get(j)[3];
			   }
		   }
	   }
	   for(int i=0;i<orgFinalList.size();i++){
		   String string1 = "";
		   for(int j=0;j<orgFinalList.get(i).length;j++){
			   string1 = ","+string1+orgFinalList.get(i)[j];
		   }
		   System.out.println(string1.substring(1, string1.length()));
	   }
	}

}
