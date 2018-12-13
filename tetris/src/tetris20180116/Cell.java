package tetris20180116;

public class Cell {
	int row;
	int col;
	Cell(int col,int row){
	    this.col=col;
	    this.row=row;
	}
	public String getCellInfor(){
		return row+","+col;
	}
    /*public void drop(){
    	col++;
    	
    }
    public void moveleft(){
    	row--;
    }
    public void moverigth(){
    	row++;
    }
    public void up(){
    	col--;
    }
    public String getInFor(){
    	return row+","+col;
    }
    */

}
