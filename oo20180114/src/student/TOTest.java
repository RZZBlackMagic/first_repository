package student;

public class TOTest {

	public static void main(String[] args) {
          T t=new T();
          for(int i=0;i<20;i++){
         	   for(int j=0;j<10;j++){
         		   if(j==t.row&&i==t.col){
         			   System.out.print(" *");
         		   }
         		   else{
         			   System.out.print(" _");

         		   }
         	   }
         	   System.out.println();
            }
          t.print();
          t.drop();
          t.print();
	}

}
