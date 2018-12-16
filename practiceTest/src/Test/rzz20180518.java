package Test;

public class rzz20180518 {

	public static void main(String[] args) throws InterruptedException {
		rzz20180518 r = new rzz20180518();
		r.run();
	}
	public  void run() throws InterruptedException{
        Account7 acco = new Account7("������",123456,10000);
        drawMoney run1 = new drawMoney(acco,5000,123456);
        setMoney run2 = new setMoney(acco,6000,123456);
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t1.join();
        t2.start();
 
	}
	private class drawMoney implements Runnable{
		private Account7 acco;
		private double drawBalance;
		private int password;
		public drawMoney(Account7 acco,double drawBalance,int password){
			this.acco=acco;
			this.drawBalance= drawBalance;
			this.password=password;
		}
		public void run() {
             if(this.password==acco.getPassword()){
            	 if(this.drawBalance>acco.getBalance()){
            		 System.out.println("�Լ��ж�Ǯ����û��b���룿");
            	 }else{
            		 System.out.println("ȡǮ�ɹ���ͻ����Ʊ��"+this.drawBalance+"ʣ���"+(acco.getBalance()-this.drawBalance));
            		 acco.setBalance(acco.getBalance()-this.drawBalance);
            	 }
             }else{
            	 System.out.println("�������������룡");
             }
		}
	}
	private class setMoney implements Runnable{
		private Account7 acco;
		private double drawBalance;
		private int password;
		public setMoney(Account7 acco,double drawBalance,int password){
			this.acco=acco;
			this.drawBalance= drawBalance;
			this.password=password;
		}
		public void run() {
             if(this.password==acco.getPassword()){
            	 acco.setBalance(this.drawBalance+acco.getBalance());
            	 System.out.println("��Ǯ�ɹ���ʣ���"+acco.getBalance());
             }else{
            	 System.out.println("�������������룡");
             }
		}
	}
}
class Account7{
	private String name;
	private int password;
	private double balance;
	public Account7(String name,int password,double balance){
		this.balance=balance;
		this.name= name;
		this.password = password;
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
		this.balance= balance;
	}
}
