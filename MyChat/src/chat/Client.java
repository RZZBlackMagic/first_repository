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
 * �����ҿͻ���
 * @author asus
 *
 */
public class Client {
/*
 * java.net.Socket
 * ��װTCPͨ��Э�飬ʹ������Զ�̼������������ͨ��
 */
	private Socket socket;
/*
 * ���췽��������ʯ���ͻ���
 */
   public Client() throws UnknownHostException, IOException{
	   /*
	    * ʵ����socket��Ҫ����������1�����ip  2 �����ζ˿�
	    * ͨ��IP�����ҵ������Ϸ�������ڵļ����
	    * ͨ���϶˿ڿ������ӵ��ü�����ϵķ����Ӧ�ó���
	    * 
	    * ����socket�Ĺ��̾��ǽ������ӵĹ��̣����������ӷ�����ʧ�ܣ�������׳��쳣��
	    */
	   System.out.println("���������˽������ӡ�����");
	   socket = new Socket("localhost",8088);
	   System.out.println("���������ӳɹ�");
	     
   }
/*
 * �ͻ��˵����������������￪ʼִ�пͻ����߼�
 */
   public void start(){
	  try{
		  Scanner scanner = new Scanner(System.in);
		  OutputStream out = socket.getOutputStream();
		  OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
		  PrintWriter pw =new PrintWriter(osw);
		  String line = null;
		  System.out.println("��ʼ�����");
		  while(true){
			  line=scanner.nextLine();
		     pw.println("��ð���������");
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
		   System.out.println("�ͻ�������ʧ��");
	   }
   }
}
