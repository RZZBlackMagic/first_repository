package Test;

import java.util.Scanner;

public class rzz201807140 {
	
	public static void main(String[] args) throws InterruptedException {
        Account8 a7 = new Account8("������",10000,"123456");
//		Account7 a8 = new Account7("���",8000,"234567");
        rzz201807140 r1 = new rzz201807140();
    	rzz201807140 r2 = new rzz201807140();
    	Thread t1 = new Thread(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+"��������");
		    	r1.drawMoney(a7);
		    	System.out.println(Thread.currentThread()+"ȡǮ�ɹ�");
				super.run();
			}
    	};
    	Thread t2 = new Thread(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+"��������");
		    	r2.drawMoney(a7);
		    	System.out.println(Thread.currentThread()+"ȡǮ�ɹ�");
				super.run();
			}
    	};
    	t1.start();
    	t1.join();
    	t2.start();
	}
	private void drawMoney(Account8 a7){
		System.out.println("���������룺");
		Scanner scan = new Scanner(System.in);
		String inputPassword=scan.nextLine();
		if(inputPassword.equals(a7.getPassword())){
			int inputBalance = scan.nextInt();
			if(inputBalance>a7.getBalance()){
				System.out.println("�Լ��ж�Ǯ����ûһ��B����");
			}else{
				System.out.println("ȡǮ�ɹ����³���Ʊ��"+inputBalance+"ʣ�೮Ʊ��"+(a7.getBalance()-inputBalance));
				a7.setBalance(a7.getBalance()-inputBalance);
			}
		}else{
			System.out.println("����������������룡");
		}
	}
	public void setMoney(Account8 a7){
		System.out.println("���������룺");
		Scanner scan = new Scanner(System.in);
		String inputPassword = scan.nextLine();
		if(inputPassword.equals(a7.getPassword())){
			System.out.println("����������");
            int inputBalance = scan.nextInt();			
			a7.setBalance(a7.getBalance()+inputBalance);
		}else{
			System.out.println("�����������������");
		}
	}
}
/**
 * @author asus
 *�û�
 */
class Account8{
	String name;
	double balance;
	String password;
	public Account8(String name,double balance,String password){
		this.name=name;
		this.balance=balance;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
