package student;

public class cell {
	int row;//行数
	int col;//列数
	cell(int col,int row){
	    this.col=col;
	    this.row=row;
	}
    public void drop(){
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
    
}
