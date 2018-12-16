package Test;

import java.util.Scanner;

public class rzz201804210 {

	public static void main(String[] args) {
		System.out.println("please input number :");
		Scanner scan = new Scanner(System.in);
		double drawBalance= scan.nextDouble();
      Account account = new Account("任章哲",800.0);
      Thread12 run1 = new Thread12(account,drawBalance);
      Thread12 run2 = new Thread12(account,600);
      Thread t = new Thread(run1);
      Thread t1 = new Thread(run2);
      t.start();
      t1.start();
	}

}
class Account{
	private String accountNo;
	private double balance;
	public Account(String accountNo,double balance){
		super();
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return this.balance;
	}
	public String getAccountNo(){
		return this.accountNo;
	}
}
class Thread12 implements Runnable{
	private Account acco ;
	private double drawBalance;
	public Thread12(Account account,double drawBlance){
		super();
		this.acco=account;
		this.drawBalance=drawBlance;
	}
	public  void run(){
		
		synchronized(acco){
		if(this.drawBalance>acco.getBalance()){	
			System.out.println("余额不足");
		}else{
			System.out.println(acco.getAccountNo()+"取钱成功！突出钞票："+this.drawBalance);
			 acco.setBalance((acco.getBalance()-this.drawBalance));
		        System.out.println("账户余额："+acco.getBalance());
		}
		}
		
	}
}