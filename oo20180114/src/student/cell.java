package student;

public class cell {
	int row;//����
	int col;//����
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
