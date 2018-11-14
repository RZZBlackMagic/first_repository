package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.OutputStream;


/*
 * 聊天室客户端
 */
public class Client1 {
    /*
     * java.net.Socket;
     * 封装了TCP通讯协议，使他与远程计算机进行网络通讯
     */
	private Socket socket;
	/*
	 * 构造方法，用来初始化客户端
	 */
	public Client1() throws UnknownHostException, IOException{
		System.out.println("正在与服务端建立连接。。。");
		socket = new Socket("localhost",8088);
		System.out.println("与服务端连接成功。。。");
	}
	/**
	 * 客户端的启动方法，从这里开始执行客户端逻辑
	 */
	public void start(){
		try{
			Scanner scanner  = new Scanner(System.in);
			OutputStream out =  socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			ServerHandler handler = new ServerHandler();
  			Thread t = new Thread(handler);
			System.out.println("开始聊天吧！");
			t.start();
			while(true){
				String line = scanner.nextLine();
				pw.println(line);
				pw.flush();
//				pw.close();
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
           try{
        	   Client1 client1 = new Client1();
        	   client1.start();
        	  
           }catch(Exception e){
        	   e.printStackTrace();
        	   System.out.println("客户端启动失败");
           }
	}
	/*
	 * 该线程用来循环接收服务器发送给客户端的信息
	 */
	private class ServerHandler implements Runnable{
		public void run(){
			try{
		       InputStream in =socket.getInputStream();
		       InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		       BufferedReader br = new BufferedReader(isr);
		       String message = null;
		       while((message=br.readLine())!=null){
		    	   System.out.println("服务端说："+message);
		       }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}


}
