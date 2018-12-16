package Test;

public class thread_Synchronized_Test {

	public static void main(String[] args) {
		System.out.println("主线程开始执行");
    personInfo p1 = new personInfo();
    personInfo p2 = new personInfo();
    Thread t1 = new Thread(){
    	public void run(){
    		while(true){
    			p1.setNameAndId("Just Lin", "J L");
    		}
    	}
    };
    Thread t2 = new Thread(){
    	public void run(){
    		while(true){
    			p2.setNameAndId("Shang Hai", "S H");
    		}
    	}
    };
    System.out.println("开始测试");
    t1.start();
    t2.start();
	}

}
class personInfo{
	private String name;
	private String id;
	private int count;
	public personInfo() {
		super();
		this.name = "Nobody";
		this.id = "N,A";
		this.count = 0;
	}
	public void setNameAndId(String name,String id){
		this.name = name;
		this.id= id;
		if(!checkNameAndIdEqual()){
	        //Thread t = Thread.currentThread();

			System.out.println(count+")illage name or id");
			System.out.println(name.charAt(0));
        	System.out.println(id.charAt(0));
			count++;
		}
		
	}
	private boolean checkNameAndIdEqual(){
        if(name.charAt(0)==id.charAt(0)){
        	
        	return true;
        }else{
        	
        	return false;
        }
	}
}