package Test;

import java.util.Scanner;

public class rzz20180504 {

	public static void main(String[] args) {
	  Account5 acco = new Account5(10000,"������",123456);
      drawMoney1 run = new drawMoney1(acco,5000);
      Thread t1 = new Thread(run);
      drawMoney1 run2 = new drawMoney1(acco,6000);
      Thread t2 = new Thread(run2);
      t1.start();
      t2.start();
	}

}
class Account5{
	private double balance;
	private String name;
	private int password;
	public Account5(double balance,String name,int password){
		this.balance=balance;
		this.name=name;
		this.password=password;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return this.balance;
	}
	public String getName(){
		return this.name;
	}
	public int getPassword(){
		return this.password;
	}
}
class drawMoney1 implements Runnable{
	private Account5 acco;
	private double drawBalance;
	public drawMoney1(Account5 acco,double drawBalance){
		this.acco=acco;
		this.drawBalance=drawBalance;
	}
	public void run(){
		System.out.println("please input password:");
		Scanner scan = new Scanner(System.in);
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
			if(acco.getBalance()>=this.drawBalance){
				System.out.println(Thread.currentThread()+"ȡǮ�ɹ����³���Ʊ��"+this.drawBalance);
				acco.setBalance(acco.getBalance()-this.drawBalance);
				System.out.println("ʣ���"+acco.getBalance());
			}else{
				System.out.println("�Լ��ж�Ǯ����û��B����");
			}
		}else{
			System.out.println("����������������롣");
		}
		
	}
}
