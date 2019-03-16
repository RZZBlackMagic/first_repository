package ByteDanceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
       Scanner scan = new Scanner(System.in);
       List<Float> outList = new ArrayList();
       int NN = scan.nextInt();
       for(int j=0;j<NN;j++){
    	   int N = scan.nextInt();
           int M = scan.nextInt();
           List<Integer> list = new ArrayList();
           for(int i=0;i<N;i++){
        	   list.add(scan.nextInt());
           }
    	   Collections.sort(list);
    	   if(N>=M){
    		   float result = list.get(M-1);
    		   System.out.println(result);
    		   outList.add(result);
    	   }
    	   if(N<M){
    		   int maxNum = M/N+1;
    		   int n = M%N;//n个长度是maxNum
    		   int nn = N-n;//nn个长度是maxNum-1
    		   float nX = list.get(list.size()-n)/maxNum;
    		   float nnX = list.get(0)/(maxNum-1);
    		   if(nX<nnX){
    			   outList.add(nX);
    		   }else{
    			   outList.add(nnX);
    		   }
    		  
    	   }
       }
       for(int i=0;i<outList.size();i++){
          System.out.println(outList.toArray()[i]);
       }
	   
	   
      
	}

}
