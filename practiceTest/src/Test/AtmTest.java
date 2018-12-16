package Test;

public class AtmTest {

	public static void main(String[] args) {
		 UnionAtm ia = new ICBCAtm();
         UnionPay ic = new ICBCImpl();
         ia.insertCard(ic);
         ia.payTelBill();
         ia.showBalance();
	}

}
class UnionAtm{
	private UnionPay card;
	public void insertCard(UnionPay card){
		this.card=card;
	}
	public void outCard(){
		this.card=null;
	}
	public void payTelBill(){//ATM���ϵ�֧���绰�Ѱ�ť����������ִ����֮�󣬾ͽ���֧��������ʵ����payOnline������
		if(this.card instanceof ICBC){
			ICBC icbccard = (ICBC)this.card;
	        icbccard.payOnline();
		}else{
			System.out.println("���ǹ��п�������֧��!");
		}
        
	}
	public double showBalance(){
		this.card.checkMoney();
		return 0.0;
	}
    public void drawBalance(){
    	
    }
    public void setBalance(){
    	
    }
    public void turnBalace(){
    	
    }
    public void payforwater(){
    	if(this.card instanceof CCB){
    		CCB ccbcard = (CCB)this.card;
    		ccbcard.payForWater();
    	}else{
    		System.out.println("֧��ʧ��");
    	}
    }
    public void payonline(){
    	if(this.card instanceof ICBC){
    		ICBC icbccard = (ICBC)this.card;
    		icbccard.payOnline();
    	}else{
    		
    	}
    }

}
class ABCAtm extends UnionAtm{
	public void abc(){
		System.out.println("abc");
	}
	public void alterABCPassword(){
		
	}
}
class ICBCAtm extends UnionAtm{
	public void icbc(){
		System.out.println("icbc");
	}
    public void alterICBCPassword(){
		
	}
}
class CCBAtm extends UnionAtm{
	public void ccb(){
		System.out.println("ccb");
	}
    public void alterCCBPassword(){
		
	}
}
interface UnionPay{
	public void setMonry(double number);//��Ǯ
	public void drawMoney(double number);//ȡǮ
	public void turnMoney(double number);//ת��
	public double checkMoney();//��ѯ
}
interface ICBC extends UnionPay{//���нӿ�
	public void payOnline();//����֧��
}
interface ABC extends UnionPay{
	public void payForPhone();//֧���绰��
}
interface CCB extends UnionPay{
	public void payForWater();
}
class ICBCImpl implements ICBC,UnionPay{

	@Override
	public void setMonry(double number) {
		
	}

	@Override
	public void drawMoney(double number) {
		
	}

	@Override
	public void turnMoney(double number) {
		
	}

	@Override
	public double checkMoney() {
		System.out.println("ICBCʣ����");	
		return 0;
	}

	@Override
	public void payOnline() {
		System.out.println("֧���绰�ѳɹ���");
	}
}
class ABCImpl implements ABC,UnionPay{

	@Override
	public void setMonry(double number) {
		
	}

	@Override
	public void drawMoney(double number) {
		
	}

	@Override
	public void turnMoney(double number) {
		
	}

	@Override
	public double checkMoney() {
		return 0;
	}

	@Override
	public void payForPhone() {
		
	}
	
}
class CCBImpl implements CCB,UnionPay{

	@Override
	public void setMonry(double number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawMoney(double number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnMoney(double number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double checkMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void payForWater() {
		// TODO Auto-generated method stub
		
	}
	
}
