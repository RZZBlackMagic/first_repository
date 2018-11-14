package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 聊天室服务端
 */
public class Serive {
/*
 * java.net.ServerSocket
 * 运行在SernerSocket主要有两个作用
 * 1 申请服务端口   2 监听服务端口，一旦一个客户端通过该端口建立连接，则创建一个Socket用于与该客户端通讯
 */
	private ServerSocket server;
	public Serive() throws IOException{
		/*
		 * 初始化ServerSocket的同时需要指定服务端口，该端口号不能喝系统其它的应用程序已申请的端口号重复，否则会抛出异常。
		 */
		server = new ServerSocket(8088);
			
	}
	public void start() throws IOException{
		/*
		 * ServerSocket提供了一个方法：
		 * Socket accept()
		 * 该方法会监听ServerSocket申请的服务端口
		 * 这是一个阻塞方法，直到一个客户端通过
		 * 该端口会返回一个Socket实例，这个返回的Socket是用于与连接上的客户端进行通讯的
		 */
		try{
		System.out.println("等待客户端连接...");
		Socket socket = server.accept();
		System.out.println("一个客户端连接上了");
		/*
	        * InputStream getInputStream()
	        * Socket提供的该方法可以获取一个输入流，通过该流客户读取到远距离计算机发送过来的数据。
	        */
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String message = null;
			while(true){
		    	message= br.readLine();
			    System.out.println("客户说:"+message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(){
		try{
			Serive server = new Serive();
			server.start();
			
		}catch(Exception e ){
			e.printStackTrace();
			System.out.println(" ");
		}
	}
}
