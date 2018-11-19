package student;

public class T {
	cell[] cells;
	int row;
	int col;
	T(){
	     this(5,5);
	}
    T(int row ,int col){
    	cells[0]=new cell(row,col);
    	cells[1]=new cell(row,col+1);
    	cells[2]=new cell(row,col+2);
    	cells[3]=new cell(row+1,col+1);

    }
    public void drop(){
    	cells[0].col++;
    	cells[1].col++;
    	cells[2].col++;
    	cells[3].col++;

    }
    public void moveleft(){
    	cells[0].row--;
    	cells[1].row--;
    	cells[2].row--;
    	cells[3].row--;

    }
    public void moverigth(){
    	cells[0].row++;
    	cells[1].row++;
    	cells[2].row++;
    	cells[3].row++;

    }
    public  void print(){
    	for(int i=0;i<cells.length;i++){
    		String str=cells[i].getInFor();
    		System.out.println(str);
    	}
    }
}
