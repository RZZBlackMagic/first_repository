package rzz201712130;
import java.util.Arrays;
import java.util.Scanner;
public class rzz2017121301 {

	public static void main(String[] args) {
		int [][]arr=new int[5][5];
		/*int n;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				 arr[i][j]=(int)(Math.random()*100);
			}
		}
		System.out.println("原始数组为：");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("转制后数组为：");
		//int [][]Arr=new int[10][10];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				n=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=n;
				
			}
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		int s=0;
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*10);
		}
		System.out.println("原始数组为：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arr.length;i++){
			if((i+1)%2==0){
				s=s+arr[i];
			}
		}
		System.out.println(s);
		
		int s=0,num=0;
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]<10&&arr[i]>=0){
				s=s+arr[i];
				num++;
			}
		}
		System.out.println();
		System.out.println("共有"+num+"个数");
		System.out.println("其和为："+s);
	
	    for(int i=0;i<arr.length;i++){
	    	arr[i]=(int)(Math.random()*100);
	    }
	    for(int i=0;i<arr.length;i++){
	    	System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	    int n=arr.length;
	    System.out.println(n);
	    for(int i=n-1;i>=0;i--){
	    	System.out.print(arr[i]+" ");
	    }
		int []Arr=new int[100];
		 for(int i=0;i<arr.length;i++){
		    	arr[i]=(int)(Math.random()*100);
		    }
		    for(int i=0;i<arr.length;i++){
		    	System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		    int i,j;
		    for( i=0,j=0;i<arr.length;i++){
		    	if(arr[i]%3==0&&arr[i]!=0){
		    		
		    			Arr[j]=arr[i];
		    		    j++;
		    	}
		    }
		    System.out.println(j);
		    int []ARR=new int[j];
		    for(int n=0;n<ARR.length;n++){
		    	ARR[n]=Arr[n];
		    	
		    }
		    for(int n=0;n<ARR.length;n++){
		    	System.out.print(ARR[n]+" ");
		    	
		    }
		    
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
		}
		System.out.println("please input a number:");
		int num=scan.nextInt();
		
		for(int i=0;i<arr.length;i++){
		      System.out.print(arr[i]+" ");
		}
		System.out.println();
		int []Arr=new int[num];
		for(int i=0;i<num;i++){
			Arr[i]=arr[i];
		}
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		for(int i=0;i<arr.length-1;i++){
			arr[i]=(int)(Math.random()*100);
		}
		System.out.println("原始数组为：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();z
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("please input a number :");
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		arr[0]=x;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
		int s=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				arr[i][j]=(int)(Math.random()*10);
				
			}
		}
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
			   System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(i==j||i+j+1==arr.length){
					s=s+arr[i][j];
				}
			}
		}
		System.out.println(s);
		*/
	}

}
