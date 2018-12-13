package tetris20180116;

public class T extends Tetromino{
	int row;int col;

	T(){
		this(5,5);
	}
	T(int row,int col){
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row+1,col);
		cells[2]=new Cell(row+2,col);
		cells[3]=new Cell(row+1,col+1);
	}
	
	
}
