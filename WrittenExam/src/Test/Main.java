package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int [] l = new int[n];
		for(int i=0;i<l.length;i++){
			l[i]=1;
		}
		int count = 1;
		int p =0,i=0;
		
		while(p<n){
			if(i==n){
				i=i-n;
			}
			if(l[i]==0){
				i++;
			}
			if(count%m==0){
				l[i]=0;
				p++;
				i++;
				count++;
			}else{
				count++;
			}
		}
		System.out.println(i);
		
		
	}
    void d(){
    	
		
    	int n,x;
		List<Integer> ylist = new ArrayList<Integer>();
		List<Integer> dlist = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		n = scan.nextInt();
		for(int i =0;i<n;i++){
			ylist.add(scan.nextInt());
			dlist.add(scan.nextInt());
		}
		int i =0 ;
		Long count = Long.valueOf(0);
	    
	    while(i<dlist.size()){
	    	count = count+dlist.get(i)+ylist.get(i)-x;
	    	//dlist.remove(i);
	    	//list.remove(i);
	    	i++;
	    }
	    System.out.println(count);
    }
}
