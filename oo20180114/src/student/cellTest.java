package student;
//import java.util.Scanner;
public class cellTest {

	public static void main(String[] args) {
       cell c=new cell(2,5);
       /*System.out.println();
       System.out.println("1表示下落，2表示左移，3表示右移");
       Scanner scan=new Scanner(System.in);
       c.row=1;
       c.col=1;
       int n=scan.nextInt();
      
 	
       if(n==1){
           c.drop();
           past(c);

       }
       if(n==2){
           c.moveleft();
           past(c);
       }
       if(n==3){
           c.moverigth();
           past(c);

       }
       if(n==0){
           past(c);
           System.out.println("game ovre");
       }
       //c.up();
     
       
      //c.drop();
      
	}*/
	 //public static void  past (cell c){
         System.out.println("cell的位置为"+c.row+","+c.col);
   	  for(int i=0;i<20;i++){
      	   for(int j=0;j<10;j++){
      		   if(j==c.row&&i==c.col){
      			   System.out.print(" *");
      		   }
      		   else{
      			   System.out.print(" _");

      		   }
      	   }
      	   System.out.println();
         }
   	  
     }

}
