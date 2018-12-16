package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * 服务端
 */
public class rzz201808041 {
	Socket socket;
	public static void main(String[] args) throws IOException {
		rzz201808041 r =new rzz201808041();
		r.start();
	}
    public void start() throws IOException{
    	ServerSocket ss=null;
    	while(true){
    		ss=new ServerSocket(2008);
    		System.out.println("等待客户端连接。。。");
    		 socket = ss.accept();
    		System.out.println("连接成功");
    		sendClient run1= new sendClient(socket);
    		Thread t1 =new  Thread(run1);
    		t1.start();
    		receiveClient run2 = new receiveClient(socket);
    		Thread t2 = new Thread(run2);
    		t2.start();
    	}
    }
    private class sendClient implements Runnable{
    	Socket socket;
       public sendClient(Socket socket){
    	   socket = this.socket;
       } 

	@Override
	  public void run() {
		while(true){
			try {
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String str = null;
				Scanner scan = new Scanner(System.in);
				str = scan.nextLine();
				pw.println(str);
				pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		 
	  }
    }
    private class receiveClient implements Runnable{
      Socket socket;
      public receiveClient(Socket socket){
    	  socket = this.socket;
      }
		@Override
		public void run() {
        	   try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String str = null;
				while((str=br.readLine())!=null){
					System.out.println(str);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
        	   
           
		}
    	
    }
}
