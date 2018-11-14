package chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 聊天室客户端
 * @author asus
 *
 */
public class Client {
/*
 * java.net.Socket
 * 封装TCP通信协议，使用它与远程计算机进行网络通信
 */
	private Socket socket;
/*
 * 构造方法用来吃石化客户端
 */
   public Client() throws UnknownHostException, IOException{
	   /*
	    * 实例化socket需要两个参数：1服务端ip  2 福区段端口
	    * 通过IP可以找到网络上服务端所在的计算机
	    * 通过断端口可以连接到该计算机上的服务端应用程序
	    * 
	    * 数理化socket的过程就是建立连接的过程，所以若连接服务器失败，这里会抛出异常。
	    */
	   System.out.println("正在与服务端建议连接。。。");
	   socket = new Socket("localhost",8088);
	   System.out.println("与服务端连接成功");
	     
   }
/*
 * 客户端的启动方法，从这里开始执行客户端逻辑
 */
   public void start(){
	  try{
		  Scanner scanner = new Scanner(System.in);
		  OutputStream out = socket.getOutputStream();
		  OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
		  PrintWriter pw =new PrintWriter(osw);
		  String line = null;
		  System.out.println("开始聊天吧");
		  while(true){
			  line=scanner.nextLine();
		     pw.println("你好啊，服务器");
		     pw.flush();
		  }
	  }catch(Exception e){
		  e.printStackTrace();
	  }
   }
   public static void main(){
	   System.out.println("1");
	   try{
		   Client client= new Client();
		   client.start();
	   }catch(Exception e){
		   e.printStackTrace();
		   System.out.println("客户端启动失败");
	   }
   }
}
