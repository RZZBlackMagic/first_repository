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
import java.util.ArrayList;
import java.util.List;

/*
 * 聊天室服务端
 * java.net.ServerSocket;
 * 运行在服务端的ServerSocket主要有两个作用：
 * 1 申请服务端口
 * 2 监听服务端口，一旦一个客户端通过该端口建立连接，则创建一个SOCket用于与该客户端通讯
 */
public class Server1 {

	 private ServerSocket server;
	 /*
	  * 该集合用来存放所有的输出流，用于将消息广播给所有客户端
	  */
	 private List<PrintWriter> allout;
	 
	 
	 
	 public Server1() throws IOException{
		 /**
		  * 初始化ServerSocket同时要指定端口号，不能和系统其它程序已经占用的端口号重复。否则会抛异常
		  */
		 server = new ServerSocket(8088);
		 allout = new ArrayList<PrintWriter>();
	 }
	 
	 
	 
	 
	 public void start(){
		 try{
			 /**
			  * ServerSocket提供方法：
			  * Socket accept()
			  * 该方法会监听ServerSocket申请的服务端口。这是一个阻塞方法，直到一个客户端通过，该端口连接才会返回一个Socket，这个返回的Socket适用于与连接的客户端进行通讯的
			  */
			 while(true){
				 System.out.println("等待客户端连接。。。");
				 Socket socket1 = server.accept();
				 System.out.println("一个客户端连接。。。");
				 ClientHandler handler = new ClientHandler(socket1);
		//		 handler.run();
				 Thread t1 = new Thread(handler);
				 t1.start();
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	 }
	 
	 
	 
	 
	 public void sendMessage(String message){
		 /*
		  * 将给定的消息广播给所有客户端
		  */
		 synchronized(allout){
			 for(PrintWriter o : allout){
				 o.println(message);
			 }
		 }
		
		 
	 }
	 
	 
	 
	 public static void main(String[] args) {

         try{
             Server1 server1 = new Server1();
        	 server1.start();
         }catch(Exception e){
      	   e.printStackTrace();
      	   System.out.println("客户端启动失败");
         }
         
	}
	 
	 
	 
	 private class ClientHandler implements Runnable{
		 /**
		  * 当前线程通过这个Socket与指定客户端进行交互
		  */
		 private Socket socket;
		 /**
		  * 客户端的地址
		  * @param socket
		  */
		 String host;
		 
		 
		 public ClientHandler(Socket socket){
			 this.socket=socket;
			 /**
			  * 通过Socket获取远程计算机地址信息
			  */
			 InetAddress address= socket.getInetAddress();
			 /**
			  * 获取远端计算机的IP地址
			  */
			 host = address.getHostAddress();
		 }
		 
		 
		 public void run(){
			 PrintWriter pw = null;
			 try{
				 InputStream in = socket.getInputStream();
				 InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				 BufferedReader br = new BufferedReader(isr);
				 /*
				  * 创建输出流，给客户端发送字符串
				  */
				 OutputStream out = socket.getOutputStream();
				 OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				 pw = new PrintWriter(osw);
				 /*
				  * 由于多个线程会同时调用该集合的add方法，向其中添加输出流，所以为了保证贤臣安全，给集合上锁。
				  */
				 synchronized(allout){
					 allout.add(pw);//将客户端的输出流放到集合中去
				 }
				 
				 sendMessage(host+"上线了");
				 String message=null;
				 while((message = br.readLine())!=null){

					 /*
					  * 将客户端说的话返回到客户端
					  */
					// pw.println(message);
					 sendMessage((host+"说"+message));

					 
				 }
				 
			 }catch(Exception e){
				 e.printStackTrace();
			 }finally{
				 //处理客户端下线的工作
				 synchronized(allout){
					//将断开的客户端的输出流从集合中删除
					 allout.remove(pw);
				 }
				 
				 sendMessage(host+"下线了！当前在线人数："+allout.size());
				 if(socket!=null){
					 try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				 }
			 }
			 
		 }
	 }
}
