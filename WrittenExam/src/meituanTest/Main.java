package meituanTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Long n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextLong();
		//System.out.println(n);
		List<Long> list = new ArrayList<Long>();
		//long a[] = new long[Integer.valueOf(String.valueOf(n))];
		for(long i=0;i<n;i++){
			//a[Integer.valueOf(String.valueOf(i))] = scan.nextLong();
			list.add(scan.nextLong());
			//System.out.println("...");
		}
		long i,j ,k,flag,lastflag;
		long max=0;
		flag= 0;
		k=0;
		j=1;
		i=0;
		lastflag =0;
		while(i<n-1){
			//if(a[Integer.valueOf(String.valueOf(i))]<a[Integer.valueOf(String.valueOf(i+1))]){
			if(list.get(Integer.valueOf(String.valueOf(i)))<list.get(Integer.valueOf(String.valueOf(i+1)))){
				j++;
				i++;
				k=i;
				//System.out.println("!");
				if(j>max){
					max = j-1;
					i=k;
	         }
			}else{
				if((i+2)<n&&list.get(Integer.valueOf(String.valueOf(i)))<list.get(Integer.valueOf(String.valueOf(i+2)))){
					k=i;
					flag = 1;
					j++;
					i=i+2;
					//System.out.println(".");

					while((i+1)<n&&(list.get(Integer.valueOf(String.valueOf(i)))<list.get(Integer.valueOf(String.valueOf(i+1))))){
						j++;
						//System.out.println("?");
					}
		            if(j>max){
						max = j;
						i=k+1;
		            }
					j = 1;
				}else{
					//System.out.println(":");

					 if(j>max){
							max = j;
							i=k;
			         }
					 flag =0 ;
					 j=1;
					 i++;
					 k=i;
				}
			}
			//i=k;
				
		}
		System.out.println(max);
		     
		
	}

	
}
