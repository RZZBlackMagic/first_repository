package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class rzz20180506 {

	public static void main(String[] args) throws InterruptedException {
    Account6 acco1 = new Account6("������",10000,123456);
    Account6 acco2 = new Account6("������",12000,199706);
    myAccount2 run1 = new myAccount2(acco1,8000);
    myAccount2 run2 = new myAccount2(acco1,4000);
    Thread t1 = new Thread(run1);
    Thread t2 = new Thread(run2);
    t1.start();
    t1.join();
    t2.start();
	}

}
class Account6{
	private String name;
	private double balance;
	private int password;
	public Account6(String name,double balance,int password){
		this.balance=balance;
		this.name=name;
		this.password=password;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public String getName(){
		return this.name;
	}
	public int  getPassword(){
		return this.password;
	}
	public double getBalance(){
		return this.balance;
	}
}
class myAccount2 implements Runnable{
	private Account6 acco;
	private double drawBalance;
	public myAccount2(Account6 acco,double drawBalance){
		this.acco=acco;
		this.drawBalance=drawBalance;
	}
	public void run(){
	   String[] c = new String[3];
	   c[0]="��Ǯ����";
	   c[1]="ȡǮ����";
	   c[2]="��ѯ���";
	   System.out.println("��������Ҫִ�е�ҵ��");
	   Scanner scan = new Scanner(System.in);
       String str = scan.nextLine();
	   if(str.equals(c[0])){
		   this.setMoney();
	   }else if(str.equals(c[1])){
		   this.drawMoney();
	   }else if(str.equals(c[2])){
		   this.getMoney();
	   }else{
		   System.out.println("��������������ҵ��");
	   }
	}
	private synchronized void drawMoney(){
		if(acco.getBalance()>=this.drawBalance){
			System.out.println("ȡǮ�ɹ����³���Ʊ��"+this.drawBalance+" ʣ���"+(acco.getBalance()-this.drawBalance));
			acco.setBalance(acco.getBalance()-this.drawBalance);
		}else{
			System.out.println("�Լ��ж�Ǯ����û��B����");
		}
	}
	private synchronized void setMoney(){
		acco.setBalance(this.drawBalance+acco.getBalance());
		System.out.println("ʣ���"+acco.getBalance());
	}
	private synchronized void getMoney(){
        System.out.println("ʣ���"+acco.getBalance());
	}
}