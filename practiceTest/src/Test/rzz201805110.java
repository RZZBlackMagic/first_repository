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
		System.out.println("���������Ĳ���ҵ��");
		String str = scan.nextLine();
		if(str.equals("��ѯ���")){
			System.out.println("���������룺");
		    h.queryMoney();
		}else if(str.equals("ȡǮ����")){
			System.out.println("���������룺");
			h.drawMoney();
		}else if(str.equals("��Ǯ����")){
			System.out.println("���������룺");
			h.setMoney();
		}else{
			System.out.println("�������������Ĳ���ҵ��");
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
				System.out.println("�Լ��ж�Ǯ����û��B����");
			}else{
				System.out.println("ȡǮ�ɹ����³���Ʊ��"+this.drawBalance+"ʣ���"+(acco.getBalance()-this.drawBalance));
				acco.setBalance(acco.getBalance()-this.drawBalance);
			}
		}else{
			System.out.println("�����������");
		}
	}
	public void setMoney(){
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
		    int money = scan.nextInt();
		   acco.setBalance(money+acco.getBalance());
		   System.out.println("��Ǯ�ɹ���ʣ����"+acco.getBalance());
		}
	}
	public void queryMoney(){
		int inputPassword=scan.nextInt();
		if(inputPassword==acco.getPassword()){
		System.out.println("��ѯ���ɹ�����ǰ��"+acco.getBalance());
		}
	}
}
  