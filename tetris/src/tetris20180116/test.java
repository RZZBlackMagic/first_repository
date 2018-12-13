package tetris20180116;

public class test {

	public static void main(String[] args) {
		T t=new T(2,6);
		printWall(t);
              
	}
	public static void printWall(T t){  
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				boolean flag=true;
				for(int k=0;k<t.cells.length;k++ ){
					if(i==t.cells[k].row&&j==t.cells[k].col){
						flag=false;
						break;
					}
				}
				if(flag){
					System.out.print("- ");
				}
				else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

}
