package Test;

public class rzz20180426 {

	public static void main(String[] args) throws InterruptedException {
		Account4 acco = new Account4("任章哲",10000,123456);
        myAccount6 run = new myAccount6(acco,3000,123456);
        Thread t = new Thread(run);
        t.start();
        t.join();
        myAccount6 run2 = new myAccount6(acco,8000,123456);
        Thread t2 = new Thread(run2);
        t2.start();
	}

}
class Account4 {
	private String name;
	private double balance;
	private int password;
	public Account4(String name,double balance,int password){
		super();
		this.name=name;
		this.balance=balance;
		this.password=password;
	}
	public void setBanlance(double balance){
		this.balance=balance;
	}
	public void setName(String name){
		this.name=name;
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
class myAccount6 implements Runnable{
	private Account4 acco;
	private double drawBalance;
	private int Inpassword;
	public myAccount6(Account4 acco,double drawBalance,int Inpassword){
	     this.acco=acco;
	     this.drawBalance=drawBalance;
	     this.Inpassword=Inpassword;
	}
	public void run(){
		if(this.Inpassword==acco.getPassword()){
			if(this.drawBalance>acco.getBalance()){
				System.out.println("自己有多钱心里没点B数吗？");
			}else{
				System.out.println(acco.getName()+"取钱成功!吐出钞票："+this.drawBalance);
				acco.setBanlance(acco.getBalance()-this.drawBalance);
				System.out.println("剩下金额："+acco.getBalance());
			}
		}
		
	}
}
