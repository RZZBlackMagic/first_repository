package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
	private ServerSocket server2;
	private String host;
	private InetAddress in;
	public Server2() throws IOException{
		//初始化端口号.
		server2 = new ServerSocket(2005);
	}
	public void start()throws IOException{

		try{
			while(true){

			    System.out.println("等待客户端连接。。。");
			    Socket socket = server2.accept();
			    System.out.println("一个客户端连接");
			    InetAddress address = socket.getInetAddress();
			    host =address.getHostAddress();

			Thread t2 = new Thread(){
				public void run(){
			    String message=null;

					InputStream in;
					try {
						in = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(in);
					      BufferedReader br= new BufferedReader(isr);
							message = br.readLine();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
			      
			        System.out.println(host+"说:"+message);
						/*OutputStream out;
							out = socket.getOutputStream();
						
					
				    OutputStreamWriter osw = new OutputStreamWriter(out);
				    PrintWriter pw = new PrintWriter(osw);
				    while(true){
				      pw.write(message);
				      pw.flush();
				    }*/
		    	}
		    };
		    t2.start();
		    //t3.start();

			   
			    }
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws IOException {
		try{
			 Server2 server2 = new Server2();
		      server2.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("服务端启动失败");
		}
          
      }

}
