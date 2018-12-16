package Test;

import java.util.Scanner;

public class rzz201808042 {

	public static void main(String[] args) {
        runnable run = new runnable();
        Thread t1 = new Thread(run);
        t1.start();
        System.out.println(2);
	}
   
}
 class runnable implements Runnable{
    
	@Override
	public void run() {
		while(true){
			System.out.println("«Î ‰»Î–≈œ¢°£°£°£");
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			
	       	System.out.println(str);
		}
	}
	
}