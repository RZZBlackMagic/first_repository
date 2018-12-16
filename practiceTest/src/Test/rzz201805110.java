package Test;

import java.util.Scanner;

public class rzz201805110 {

	public static void main(String[] args) {
		Account05110 acco = new Account05110("ren",10000,123456);
		rzz201805110 r = new rzz201805110();
		drawMoney0511 run = new drawMoney0511(acco,1000);
		Thread t = new Thread(run);
		t.start();
	}
	
      
}
 class Account05110{
	private String name;
	private double balance;
	private int password;
	public Account05110(String name,double balance,int password){
		this.name=name;
		this.balance=balance;
		this.password=password;
	}
	public String getName(){
       return this.name;
	}
	public int getPassword(){
		return this.password;
	}
	public double getBalance(){
		return this.balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
}
class drawMoney0511 implements Runnable{
	private Account05110 acco;
	private double drawBalance;
	public drawMoney0511(Account05110 acco,double drawBalance){
		this.drawBalance=drawBalance;
		this.acco=acco;
	}
	public void run(){
		handle h = new handle(acco,drawBalance);
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入您的操作业务：");
		String str = scan.nextLine();
		if(str.equals("查询余额")){
			System.out.println("请输入密码：");
		    h.queryMoney();
		}else if(str.equals("取钱操作")){
			System.out.println("请输入密码：");
			h.drawMoney();
		}else if(str.equals("存钱操作")){
			System.out.println("请输入密码：");
			h.setMoney();
		}else{
			System.out.println("请重新输入您的操作业务");
		}
	}
}
class handle{
	private Account05110 acco;
	private double drawBalance;
	Scanner scan = new Scanner(System.in);
	public handle(Account05110 acco,double drawBalance){
		this.acco=acco;
		this.drawBalance=drawBalance;
	}
	public void drawMoney(){
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
			if(drawBalance>acco.getBalance()){
				System.out.println("自己有多钱心里没点B数吗？");
			}else{
				System.out.println("取钱成功，吐出钞票："+this.drawBalance+"剩余金额："+(acco.getBalance()-this.drawBalance));
				acco.setBalance(acco.getBalance()-this.drawBalance);
			}
		}else{
			System.out.println("输入密码错误");
		}
	}
	public void setMoney(){
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
		    int money = scan.nextInt();
		   acco.setBalance(money+acco.getBalance());
		   System.out.println("存钱成功，剩余金额"+acco.getBalance());
		}
	}
	public void queryMoney(){
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
		System.out.println("查询余额成功，当前余额："+acco.getBalance());
		}
	}
}
  