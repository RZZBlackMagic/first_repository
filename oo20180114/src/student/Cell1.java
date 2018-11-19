package student;

public class Cell1 {
	int row;
	int col;
	Cell1(int row,int col){
		this.row=row;
		this.col=col;
	}
	Cell1(int n){
		row=n;
		col=n;
	}
	Cell1(){
		
	}
	public void moveLeft(){
		col++;
	}
   public void drop(){
	   row++;
   }
   public void moveLeft(int n){
	   col=col+n;
   }
   public void drop(int n){
	   row+=n;
   }
}
