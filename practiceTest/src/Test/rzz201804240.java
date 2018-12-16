package Test;

import java.util.Scanner;

public class rzz201804240 {

	public static void main(String[] args) throws InterruptedException {
     Account3 acco = new Account3(199706,"任章哲",10000);     
     Scanner scan = new Scanner(System.in);
     drawMoney run1 = new drawMoney(acco,5000,199706);
     Thread t1 = new Thread(run1);
     t1.start();
     //drawMoney run2 = new drawMoney(acco,6000,199706);
    // Thread t2 = new Thread(run2);
    //t2.start();
	}

}
class Account3{
	private String name;
	private double balance;
	private int password;
	public Account3(int password,String name,double balance){
		this.balance=balance;
		this.name=name;
		this.password=password;
	}
	public void setName(String name){
		this.name=name;
    }
	public void setBalance(double balance){
		this.balance=balance;
	}
	public String getName(){
		return this.name;
	}
	public double getBalance(){
		return this.balance;
	}
	public int getPassword(){
		return this.password;
	}
	
}
class drawMoney implements Runnable{
	private Account3 acco;
	private double drawbalance;
	private int password;
	public drawMoney(Account3 acco,double drawbalance,int password){
		this.acco=acco;
		this.drawbalance=drawbalance;
		this.password=password;
	}
	public  void run(){
		synchronized(acco){
			if(this.password==acco.getPassword()){
			       if(drawbalance>acco.getBalance()){
				       System.out.println("自己有多钱心里没点B数吗？");
			       }else{
			    	   System.out.println(acco.getBalance());
				       System.out.println("取钱成功！剩下余额："+(acco.getBalance()-drawbalance));
				       acco.setBalance(acco.getBalance()-drawbalance);
				       System.out.println(acco.getBalance());
			       }
			 }
		}
	}
}
class setMoney implements Runnable{
	private Account3 acco;
	private double setBalance;
	private int password;
	public setMoney(Account3 acco,double setBalance,int password){
		this.acco=acco;
		this.setBalance=setBalance;
		this.password=password;
	}
	public synchronized void run(){
		if(this.password==acco.getPassword()){
			acco.setBalance(setBalance+acco.getBalance());
			System.out.println("存取成功！剩下余额:"+acco.getBalance());
		}
		
	}
}