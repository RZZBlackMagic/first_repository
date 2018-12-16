package Test;

public class rzz20180516 {
    static String str = "renzhangzhe";
	public static void main(String[] args) {
	   rzz20180516 r = new rzz20180516();
       r.run();
       System.out.println(str);
	}
	static void run(){
//		 client c = new client(" ");
         System.out.println(str);
	}
	public void run1(){
		run();
	}
	private  class client {
		String name;
		public client(String name){
			this.name=name;
		}
		public String getName(){
			return this.name;
		}
		
	}
    private class shop{
    	private client c;
    	public void select(client c){
    		System.out.println(c.name+"正在挑选衣服");
    	}
    	public void trying(client c){
    		System.out.println(c.name+"正在试衣服");
    	}
    	public void buy(client c){
    		System.out.println(c.name+"正在买衣服");
    	}
    }
}
