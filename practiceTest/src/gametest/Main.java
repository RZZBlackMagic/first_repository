package gametest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		int[] arr = {5,6,8,4,3};
		int n =arr.length;
		int k = 3;
     arr=monkey_sort(arr,n,k);
     for(int i=0;i<arr.length;i++){
    	 System.out.println(arr[i]);
     }
    
     
	}
	public static int[] monkey_sort(int a[], int n, int k){
	    int i;
	    while(k<a.length){
	        for( i=0 ; i<i+k; i++){
	            if(a[i] > a[i+1]){
	            	int flag;
	                flag=a[i];
	                a[i]=a[i+1];
	                a[i+1]=flag;	    	        
	            }
	        }
	        i++;
	        k++;
	    }
	    //System.out.println(i+1);
	    return a;
	}
	private static void swap(int i, int j) {
         int flag;
         flag=i;
         i=j;
         j=flag;
	}
}
