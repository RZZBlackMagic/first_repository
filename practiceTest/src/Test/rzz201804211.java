package Test;

public class rzz201804211 {

	public static void main(String[] args) throws InterruptedException {
       Account1 acco = new Account1("任章哲",1000);
       myAccount run1= new myAccount(acco);
       myAccount run2 = new myAccount(acco);
       Thread t1 = new Thread(run1);
       Thread t2 = new Thread(run2);
       t1.start();
       t2.start();
       
	}

}
class Account1 {
	private String accountNo;
	private double balance;
	public Account1(String accountNo,double balance){
		super();
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public void setAccountNo(String accountNo){
		this.accountNo=accountNo;
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
	public  void drawBalance(String accountNo,double drawBalance){
		if(drawBalance>this.balance){
			System.out.println("余额不足");
		}else{
			System.out.println(accountNo+"取钱成功！吐出金额："+drawBalance);
			this.setBalance(this.balance-drawBalance);
			System.out.println("剩余金额："+this.balance);
		}
	}
}
class myAccount implements Runnable{
	
	private Account1 acco;
	public myAccount(Account1 acco){
		this.acco=acco;
	}
	public void run(){
		acco.drawBalance("任章哲",800);
	}
}