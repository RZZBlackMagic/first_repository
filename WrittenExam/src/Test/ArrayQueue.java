package Test;

public class ArrayQueue {
	private int[] array = null;
	
	private static int pre_count = 0;
	private static int hou_count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

	 
	    
	    //Your code
	    
	    public ArrayQueue(int capacity){
	        //Your code
	    	this.array = new int[capacity];
	    }
	    public void enqueue(int v) throws Exception{
	        //Your Code
	    	
	    	if(hou_count>array.length){
	    		hou_count = hou_count%array.length;
	    	}
	    	if(hou_count+1==pre_count){
	    		throw new Exception();
	    	}
	    	array[hou_count] = v;
	    	hou_count++;
	    }
	    
	    public int dequeue() throws Exception{
	    	if(pre_count>array.length){
	    		pre_count= pre_count%array.length;
	    	}
	    	if(pre_count==hou_count){
	    		throw new Exception();
	    	}
	        int ret=0;
	        
	        ret = array[pre_count];
	        pre_count++;
	        return ret;
	    }

}


