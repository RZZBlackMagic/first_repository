package Test;

public class rzz201804212 {

	public static void main(String[] args) {
	  Account2 acco = new Account2("任章哲",1000);
      myAccount3 run3 = new myAccount3(acco);
      myAccount4 run4 = new myAccount4(acco);
      Thread t1 = new Thread(run3);
      Thread t2 = new Thread(run4);
      t1.start();
      t2.start();
      
	}

}
class Account2{
	private boolean flag = false;
	private String accountNo;
	private double balance;
	public Account2(String accountNo,double balance){
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public void setAccountNo(String accountNo){
		this.accountNo=accountNo;
	}
	public String getAccountNo(){
		return this.accountNo;
	}
	public double getBalance(){
		return this.balance;
	}
	
	
	public synchronized void drawMoney(double drawBalance) throws InterruptedException{
		if(!flag){
			wait();
		}else{
			if(drawBalance>this.getBalance()){
				System.out.println("余额不足");
			}	 		 

			  Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"取钱成功！吐出金额："+drawBalance);
			this.setBalance(this.balance-drawBalance);
			System.out.println("剩余金额："+this.getBalance());

			flag = false;
			notifyAll();
			System.out.println();
		}
	}
	
	
	public synchronized void setMoney(double setmoney) throws InterruptedException{
		if(flag){
		    wait();
		}else{
		  Thread.sleep(1000);
		  this.setBalance(setmoney+this.getBalance());
		  System.out.println(Thread.currentThread().getName()+"存入金额："+setmoney+"剩下余额"+this.getBalance()); 
		  flag = true;
		  notifyAll();
		}
	}
}
class myAccount3 implements Runnable{
	private Account2 acco;
	public myAccount3(Account2 acco){
		this.acco=acco;
	}
	public synchronized void run(){
		for(int i=0;i<5;i++){
        	 try {
        		 acco.drawMoney(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+"执行第"+i+"次");
			}
		}
	}
}
class myAccount4 implements Runnable{
	private Account2 acco;
	public myAccount4(Account2 acco){
		this.acco=acco;
	}
	public synchronized void run(){
		for(int i=0;i<5;i++){
			try {
				acco.setMoney(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+"执行第"+i+"次");
			}
		}
	}
}
