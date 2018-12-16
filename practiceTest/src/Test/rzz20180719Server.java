package Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class rzz20180719Server {
	ServerSocket ss ;
	public static void main(String[] args) throws IOException {
		rzz20180719Server rs = new rzz20180719Server();
		rs.start();
	}
	public rzz20180719Server() throws IOException{
		ss= new ServerSocket(2005);
	}
	public void start() throws IOException{
		while(true){
			System.out.println("���ڵȴ��ͻ������ӣ�");
			Socket socket = ss.accept();
			System.out.println("���ӳɹ���");
			sendClient sc = new sendClient(socket);
			Thread t2 = new Thread(sc);
			t2.start();
			receiceClient rc = new receiceClient(socket);
			Thread t1 = new Thread(rc);
			t1.start();
			
		}
	}
	/**
	 * ��ȡ����ϵ �Ŀͻ���ͨ���̸߳���������accept�����ճ����������������ͻ��˵����硣
	 * ������ʵ����һ������˿������Ӷ���ͻ��ˡ�
	 * */
	private class receiceClient implements Runnable{
		Socket socket;
		public receiceClient(Socket socket){
			this.socket=socket;
		}

		@Override
		public void run() {
			InputStream is;
			try {
				is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				
				while((message=br.readLine())!=null){
					System.out.println("�ͻ���˵��"+message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	private class sendClient implements Runnable{
        Socket socket;
        public sendClient(Socket socket){
        	this.socket=socket;
        }
		@Override
		public void run() {
          try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			String message = null;
			Scanner scan = new Scanner(System.in);
			message = scan.nextLine();
			while(true){
				pw.println(message);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
		}
          
		}
		
	}

}
