package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �����ҷ����
 */
public class Serive {
/*
 * java.net.ServerSocket
 * ������SernerSocket��Ҫ����������
 * 1 �������˿�   2 ��������˿ڣ�һ��һ���ͻ���ͨ���ö˿ڽ������ӣ��򴴽�һ��Socket������ÿͻ���ͨѶ
 */
	private ServerSocket server;
	public Serive() throws IOException{
		/*
		 * ��ʼ��ServerSocket��ͬʱ��Ҫָ������˿ڣ��ö˿ںŲ��ܺ�ϵͳ������Ӧ�ó���������Ķ˿ں��ظ���������׳��쳣��
		 */
		server = new ServerSocket(8088);
			
	}
	public void start() throws IOException{
		/*
		 * ServerSocket�ṩ��һ��������
		 * Socket accept()
		 * �÷��������ServerSocket����ķ���˿�
		 * ����һ������������ֱ��һ���ͻ���ͨ��
		 * �ö˿ڻ᷵��һ��Socketʵ����������ص�Socket�������������ϵĿͻ��˽���ͨѶ��
		 */
		try{
		System.out.println("�ȴ��ͻ�������...");
		Socket socket = server.accept();
		System.out.println("һ���ͻ�����������");
		/*
	        * InputStream getInputStream()
	        * Socket�ṩ�ĸ÷������Ի�ȡһ����������ͨ�������ͻ���ȡ��Զ�����������͹��������ݡ�
	        */
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String message = null;
			while(true){
		    	message= br.readLine();
			    System.out.println("�ͻ�˵:"+message);
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
