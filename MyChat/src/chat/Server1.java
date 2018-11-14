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
 * �����ҷ����
 * java.net.ServerSocket;
 * �����ڷ���˵�ServerSocket��Ҫ���������ã�
 * 1 �������˿�
 * 2 ��������˿ڣ�һ��һ���ͻ���ͨ���ö˿ڽ������ӣ��򴴽�һ��SOCket������ÿͻ���ͨѶ
 */
public class Server1 {

	 private ServerSocket server;
	 /*
	  * �ü�������������е�����������ڽ���Ϣ�㲥�����пͻ���
	  */
	 private List<PrintWriter> allout;
	 
	 
	 
	 public Server1() throws IOException{
		 /**
		  * ��ʼ��ServerSocketͬʱҪָ���˿ںţ����ܺ�ϵͳ���������Ѿ�ռ�õĶ˿ں��ظ�����������쳣
		  */
		 server = new ServerSocket(8088);
		 allout = new ArrayList<PrintWriter>();
	 }
	 
	 
	 
	 
	 public void start(){
		 try{
			 /**
			  * ServerSocket�ṩ������
			  * Socket accept()
			  * �÷��������ServerSocket����ķ���˿ڡ�����һ������������ֱ��һ���ͻ���ͨ�����ö˿����ӲŻ᷵��һ��Socket��������ص�Socket�����������ӵĿͻ��˽���ͨѶ��
			  */
			 while(true){
				 System.out.println("�ȴ��ͻ������ӡ�����");
				 Socket socket1 = server.accept();
				 System.out.println("һ���ͻ������ӡ�����");
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
		  * ����������Ϣ�㲥�����пͻ���
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
      	   System.out.println("�ͻ�������ʧ��");
         }
         
	}
	 
	 
	 
	 private class ClientHandler implements Runnable{
		 /**
		  * ��ǰ�߳�ͨ�����Socket��ָ���ͻ��˽��н���
		  */
		 private Socket socket;
		 /**
		  * �ͻ��˵ĵ�ַ
		  * @param socket
		  */
		 String host;
		 
		 
		 public ClientHandler(Socket socket){
			 this.socket=socket;
			 /**
			  * ͨ��Socket��ȡԶ�̼������ַ��Ϣ
			  */
			 InetAddress address= socket.getInetAddress();
			 /**
			  * ��ȡԶ�˼������IP��ַ
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
				  * ��������������ͻ��˷����ַ���
				  */
				 OutputStream out = socket.getOutputStream();
				 OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				 pw = new PrintWriter(osw);
				 /*
				  * ���ڶ���̻߳�ͬʱ���øü��ϵ�add��������������������������Ϊ�˱�֤�ͳ���ȫ��������������
				  */
				 synchronized(allout){
					 allout.add(pw);//���ͻ��˵�������ŵ�������ȥ
				 }
				 
				 sendMessage(host+"������");
				 String message=null;
				 while((message = br.readLine())!=null){

					 /*
					  * ���ͻ���˵�Ļ����ص��ͻ���
					  */
					// pw.println(message);
					 sendMessage((host+"˵"+message));

					 
				 }
				 
			 }catch(Exception e){
				 e.printStackTrace();
			 }finally{
				 //����ͻ������ߵĹ���
				 synchronized(allout){
					//���Ͽ��Ŀͻ��˵�������Ӽ�����ɾ��
					 allout.remove(pw);
				 }
				 
				 sendMessage(host+"�����ˣ���ǰ����������"+allout.size());
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
