package tetris20180116;

public class Tetromino {
	Cell[] cells=new Cell[4];
	   Tetromino(){
		cells=new Cell[4];
		
	}
	   public void moveRight(){
			for(int i=0;i<cells.length;i++){
				cells[i].col++;
			}
		}
	    public void moveLeft(){
		for(int i=0;i<cells.length;i++){
				cells[i].col--;
			}
		}
		public void drop(){
			for(int i=0;i<cells.length;i++){
				cells[i].row++;
			}
		}
		
		public void print(){
			for(int i=0;i<cells.length;i++){
				    String str =cells[i].getCellInfor();
				  System.out.println(str);
				
			}
			
		}
}
