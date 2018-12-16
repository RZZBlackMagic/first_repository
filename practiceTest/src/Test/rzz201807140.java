package Test;

import java.util.Scanner;

public class rzz201807140 {
	
	public static void main(String[] args) throws InterruptedException {
        Account8 a7 = new Account8("任章哲",10000,"123456");
//		Account7 a8 = new Account7("张昊",8000,"234567");
        rzz201807140 r1 = new rzz201807140();
    	rzz201807140 r2 = new rzz201807140();
    	Thread t1 = new Thread(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+"正在运行");
		    	r1.drawMoney(a7);
		    	System.out.println(Thread.currentThread()+"取钱成功");
				super.run();
			}
    	};
    	Thread t2 = new Thread(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+"正在运行");
		    	r2.drawMoney(a7);
		    	System.out.println(Thread.currentThread()+"取钱成功");
				super.run();
			}
    	};
    	t1.start();
    	t1.join();
    	t2.start();
	}
	private void drawMoney(Account8 a7){
		System.out.println("请输入密码：");
		Scanner scan = new Scanner(System.in);
		String inputPassword=scan.nextLine();
		if(inputPassword.equals(a7.getPassword())){
			int inputBalance = scan.nextInt();
			if(inputBalance>a7.getBalance()){
				System.out.println("自己有多钱心里没一点B数吗？");
			}else{
				System.out.println("取钱成功，吐出钞票："+inputBalance+"剩余钞票："+(a7.getBalance()-inputBalance));
				a7.setBalance(a7.getBalance()-inputBalance);
			}
		}else{
			System.out.println("密码错误，请重新输入！");
		}
	}
	public void setMoney(Account8 a7){
		System.out.println("请输入密码：");
		Scanner scan = new Scanner(System.in);
		String inputPassword = scan.nextLine();
		if(inputPassword.equals(a7.getPassword())){
			System.out.println("请输入存入金额：");
            int inputBalance = scan.nextInt();			
			a7.setBalance(a7.getBalance()+inputBalance);
		}else{
			System.out.println("密码错误，请重新数入");
		}
	}
}
/**
 * @author asus
 *用户
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
