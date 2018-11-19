package student;
import java.util.Scanner;
public class Cell1test {

	public static void main(String[] args) {
      Cell1 c1=new Cell1(4,4);
      System.out.println();
      Scanner scan=new Scanner(System.in);
      int n=scan.nextInt();
      //c1.drop();
      c1.moveLeft(n);
      for(int i=0;i<10;i++){
    	  for(int j=0;j<10;j++){
    		  if(i==c1.row&&j==c1.col){
    			  System.out.print("*");
    			  
    		  }
    		  else{
    			  System.out.print("-");
    		  }
    	  }
    	  System.out.println();
      }
      
	}

}
