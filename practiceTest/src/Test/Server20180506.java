package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server20180506 {

   private ServerSocket server;

   public Server20180506() throws IOException {
	   super();
	   server=new ServerSocket(8088);
   }
   public void start() throws IOException{
	   while(true){
		   System.out.println("等待客户端连接");
		   Socket socket = server.accept();
		   System.out.println("一个服务端建立连接");
		   myServer run = new myServer(socket);
		   Thread t = new Thread(run);
		   t.start();
	   }
	  
   }
   public static void main(String[] args) throws IOException {                                         
	   Server20180506 s = new Server20180506();
	   s.start();
   }
   private class myServer implements Runnable{
	   private Socket socket;
	   public  myServer(Socket socket){
		   this.socket=socket;
	   }
	   public void run(){
		   while(true){
			   try{
				   InputStream is = socket.getInputStream();
                   InputStreamReader isr = new InputStreamReader(is);
                   BufferedReader br = new BufferedReader(isr);
                   String message= null;
                   while((message=br.readLine())!=null){
                	   System.out.println(message);
                   }
			   }catch(Exception e){
					e.printStackTrace();
			   }
		   }
	   }
   }
  
        
}