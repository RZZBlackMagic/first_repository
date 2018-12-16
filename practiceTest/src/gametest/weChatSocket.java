package gametest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class weChatSocket {
	ServerSocket ss=null;
	public static void main(String[] args) throws IOException {
		weChatSocket wcs = new weChatSocket();
		wcs.start();
	}
	/**
	 * ��ʼ��һ��ServerSocketʵ��
	 * @throws IOException 
	 * */
    public weChatSocket() throws IOException{
       ss = new ServerSocket(2005);
      
    }
    /**
     * ִ�з�����߼�
     * @throws IOException 
     * */
    public void start() throws IOException{
    	while(true){
    		 System.out.println("�ȴ��ͻ������ӡ�����");
    	     Socket socket =ss.accept();
    	     System.out.println("һ���ͻ������ӣ�");
    	     socketRunnable run1 = new socketRunnable(socket);
    	     Thread t1 = new Thread(run1);
    	     t1.start();
    	     toClientRunnable run2 = new toClientRunnable(socket);
    	     Thread t2 = new Thread(run2);
    	     t2.start();
    	     
    	}
    	
    }
    /**
     * �������߳�
     * */
    private class socketRunnable implements Runnable{
    	Socket socket;
        public socketRunnable(Socket socket){
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
				e.printStackTrace();
			}
           
           	
           	
		}
    	
    }
    /**
     * �������߳�
     * */
    private class toClientRunnable implements Runnable{
    	Socket socket;
        public toClientRunnable(Socket socket){
        	this.socket=socket;
        }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			OutputStream os;
			try {
				Scanner scan = new Scanner(System.in);
				String message = scan.nextLine();
				os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
                pw.println(message);
                pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    }
}
