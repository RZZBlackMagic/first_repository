package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
    private Socket socket;
    public Client2() throws UnknownHostException, IOException{
    	System.out.println("正在与服务器建立连接");
    	socket = new Socket("localhost",2005);
    	System.out.println("连接成功");

    }
    public void start() throws IOException{
   
  		       System.out.println("开始聊天");
        	   Scanner scan = new Scanner(System.in);
      	       String message = scan.nextLine();
				  OutputStream	out = socket.getOutputStream();
      	      OutputStreamWriter osw = new OutputStreamWriter(out);
      	      PrintWriter pw = new PrintWriter(osw);
      	      Thread t1 = new Thread(){
        		InputStream in;
        		public void run(){
    				try {
    					
    					 in = socket.getInputStream();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
             	     InputStreamReader isr = new InputStreamReader(in);
             	     BufferedReader br = new BufferedReader(isr);
             	     String message;

					try {
						 message = br.readLine();
						 System.out.println("please");
	             	     System.out.println("服务器说："+message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        	};
      	  //t.start();

        	  t1.start();
      	      while(true){
      	    	 
      		     pw.println(message);
          	     pw.flush();
      	      }
      	   
    }
	public static void main(String[] args) throws UnknownHostException, IOException {
		try{
	        Client2 client2 = new Client2();
            client2.start();
		}catch(Exception e){
			e.printStackTrace();
     	   System.out.println("客户端启动失败");
		}
        
	}

}
