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
 * �����ҿͻ���
 */
public class Client1 {
    /*
     * java.net.Socket;
     * ��װ��TCPͨѶЭ�飬ʹ����Զ�̼������������ͨѶ
     */
	private Socket socket;
	/*
	 * ���췽����������ʼ���ͻ���
	 */
	public Client1() throws UnknownHostException, IOException{
		System.out.println("���������˽������ӡ�����");
		socket = new Socket("localhost",8088);
		System.out.println("���������ӳɹ�������");
	}
	/**
	 * �ͻ��˵����������������￪ʼִ�пͻ����߼�
	 */
	public void start(){
		try{
			Scanner scanner  = new Scanner(System.in);
			OutputStream out =  socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			ServerHandler handler = new ServerHandler();
  			Thread t = new Thread(handler);
			System.out.println("��ʼ����ɣ�");
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
        	   System.out.println("�ͻ�������ʧ��");
           }
	}
	/*
	 * ���߳�����ѭ�����շ��������͸��ͻ��˵���Ϣ
	 */
	private class ServerHandler implements Runnable{
		public void run(){
			try{
		       InputStream in =socket.getInputStream();
		       InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		       BufferedReader br = new BufferedReader(isr);
		       String message = null;
		       while((message=br.readLine())!=null){
		    	   System.out.println("�����˵��"+message);
		       }
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}


}
