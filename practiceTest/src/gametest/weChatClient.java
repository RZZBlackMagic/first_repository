package gametest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class weChatClient {
	Socket socket;
	public static void main(String[] args) throws UnknownHostException, IOException {
		weChatClient wcc = new weChatClient();
		wcc.start();
	}
	/**
	 * ��ʼ��һ��Socketʵ��
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * */
    public weChatClient() throws UnknownHostException, IOException{
    	System.out.println("����������ȡ����ϵ������");
    	 socket = new Socket("localhost",2005);
    	System.out.println("���ӳɹ�");
    }
    /**
     * ִ�пͻ����߼�
     * @throws IOException 
     * */
    public void start() {
    	OutputStream os;
		PrintWriter pw;
    	while(true){
    		
			try {
				/**
				 * �������߳�
				 * */
				ClientRunnable cr = new ClientRunnable(socket);
				Thread t1 = new Thread(cr);
				t1.start();
				/**
				 * ������
				 * */
				os = socket.getOutputStream();
				pw = new PrintWriter(os);
	        	Scanner scan = new Scanner(System.in);
	        	String message = scan.nextLine();
	    		pw.println(message);
	    		pw.flush();
	    		
	    		
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
//				pw.close();
			}
        	
    	}
    }
    private class ClientRunnable implements Runnable{
    	Socket socket;
    	public ClientRunnable(Socket socket){
    		this.socket=socket;
    	}
		@Override
		public void run() {
            try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				while((message=br.readLine())!=null){
					System.out.println("�����˵��"+message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
    }
}

