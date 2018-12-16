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
	public void payTelBill(){//ATM机上的支付电话费按钮（动作），执行了之后，就进行支付，具体实现在payOnline方法内
		if(this.card instanceof ICBC){
			ICBC icbccard = (ICBC)this.card;
	        icbccard.payOnline();
		}else{
			System.out.println("不是工行卡，不能支付!");
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
    		System.out.println("支付失败");
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
	public void setMonry(double number);//存钱
	public void drawMoney(double number);//取钱
	public void turnMoney(double number);//转账
	public double checkMoney();//查询
}
interface ICBC extends UnionPay{//工行接口
	public void payOnline();//在线支付
}
interface ABC extends UnionPay{
	public void payForPhone();//支付电话费
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
		System.out.println("ICBC剩余金额");	
		return 0;
	}

	@Override
	public void payOnline() {
		System.out.println("支付电话费成功！");
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
