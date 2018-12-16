package Test;



public  class rzz20180308Test {

	public  static void main(String[] args) {
	 Dimension d = new Dimension();
	 d.printHeight();d.printWidth();
	 d.setHeight(9);
	 d.setWidth(6);
	 d.printHeight();
	 d.printWidth();
	}
}
 
class Dimension{
	private int width=1;
	private int height=2;
	public void setWidth(int w){
		this.width=w;
	}
	public void setHeight(int h){
		this.height=h;
	}
	public void printWidth(){
    System.out.println(this.width);
	}
	public void printHeight(){
     System.out.println(this.height);
	}
}