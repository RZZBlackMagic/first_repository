package Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client20180506 {

	private Socket socket;

	public Client20180506() throws UnknownHostException, IOException {
		super();
		System.out.println("正在与服务端建立连接");
		socket = new Socket("losthost",8088);
		System.out.println("连接成功！开始聊天");
	}
	public void start(){
		myClient run = new myClient(socket);
		Thread t1 = new Thread(run);
		t1.start();
	}
	private class myClient implements Runnable{
		private Socket socket;
		public myClient(Socket socket){
			this.socket=socket;
		}
		public void run(){
			try{
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw);
				System.out.println("please input :");
                while(true){
                	Scanner scan = new Scanner(System.in);
                	String message=scan.nextLine();
                	pw.write(message);
                	pw.flush();
                }
			}catch(Exception e){
				e.printStackTrace();

			}
			
		}
	}
}







