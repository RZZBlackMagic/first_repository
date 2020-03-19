import java.util.Scanner;

public class Main {

	private static String string;
	public static void main(String[] args) {
		System.out.println(string);
		Main t = new Main();
		t.test1();
       

	}
	public void test1(){
		System.out.println("请输入主播个数：");
	       Scanner scan = new Scanner(System.in);
	       int personNum = scan.nextInt();
	       System.out.println("请输入时间段个数：");
	       int timeNum = scan.nextInt();
	       int[] sacnTimeArray = new int[personNum*2];
	       for(int i=0;i<(personNum*2);i++){
	    	   sacnTimeArray[i] = scan.nextInt();
	    	   if(sacnTimeArray[i]>timeNum){
	    		   return;
	    	   }
	       }
	       int[][] timeArray = new int[personNum][2];
	       for(int i =0;i<sacnTimeArray.length;i++){
	    	   if((i)%2==0){
	    		   timeArray[(i)/2][0]=sacnTimeArray[i];
	    	   }
	    	   if((i)%2==1){
	    		   timeArray[(i-1)/2][1]=sacnTimeArray[i];
	    	   }
	       }
	       //开始比较时间
	       int flag = 1;
	       int right=timeArray[0][0];
	       for(int i=0;i<timeArray.length-1;i++){
	    	   if(right<=timeArray[i+1][0]){
	    		   flag++;
	        	   right = timeArray[i+1][1];
	    	   }else{
	        	   right = timeArray[i][1];
	    	   }
	       }
	       if((sacnTimeArray[sacnTimeArray.length-2]>sacnTimeArray[sacnTimeArray.length-1])&&(sacnTimeArray[0]!=sacnTimeArray[sacnTimeArray.length-1])){
	    	   flag--;
	       }
	       System.out.println(flag);
	}
    public void test2(){
    	
    }
}
