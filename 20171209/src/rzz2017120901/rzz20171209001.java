package rzz2017120901;
import java.util.Scanner;
public class rzz20171209001 {
    
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		/*
        int num=(int)(Math.random()*1000+1);
        System.out.println("������nin������");
        int guess=scan.nextInt();
        while(2>1){
    	    if(guess>num){
             	System.out.println("sorry,������̫����");
    	         System.out.println("please �������룺");
    	         guess=scan.nextInt(); 	
            }
    	    else if(guess<num){
    		     System.out.println("sorry,������̫С��");
    		     System.out.println("please repeat input :");
    		     guess=scan.nextInt();
    		
    	    }
    	    else{
    		     System.out.println("��ϲ��������");
    		    break;
          	}
    		
    	}

		int count=0;
        while(count<5)
{
            System.out.print(count+" ");
            count++;
        }
        
		 for(int i=0,j=0,k=0;i<10&&j<4&&k<10;j+=2){
	            System.out.print(i++);
	            System.out.println(++k+i);
	        }
	        */
	 long sum=0,num=1;
     int n,i;
     for(n=1;n<11;n++){
    	 for(i=1;i<=n;i++){
    		 num=num*10;
    	 }
    	 num=num-1;
    	 sum=sum+num;
    	 num=1;
     }
     System.out.println(sum);
		
	}

}
