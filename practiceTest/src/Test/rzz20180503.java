package Test;

public class rzz20180503 {

	public static void main(String[] args) {
 	   for(int i=0;i<5;i++){     
 		   try{
 			   System.out.println(i);
 		   }catch(Exception e){
 			   e.printStackTrace();
 		   }
 		   finally{
 			   System.out.println("Ö´ÐÐµÚ"+i+"´Î");
 		   }
 	   }
	}

}
