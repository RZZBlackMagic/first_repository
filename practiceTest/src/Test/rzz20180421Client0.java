package Test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class rzz20180421Client0 {
	private Socket socket;

	public rzz20180421Client0() throws UnknownHostException, IOException {
		System.out.println("请求服务器连接。。。");
		socket = new Socket("127.0.0.1", 8088);
		System.out.println("连接成功");
	}

	public void start() throws IOException {
		myclient run = new myclient(socket);
		Thread t1 = new Thread(run);
		t1.start();
		/*myServer run1 = new myServer(socket);
		Thread t2 = new Thread(run1);
		t2.start();*/
	}
	public void init(){
		Frame f = new Frame("客户端聊天窗口");
		f.setBounds(30,30,250,300);

		FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
		f.setLayout(fl);
		TextField tf = new TextField(100);
		Button ok = new Button("发送");
		f.add(tf);
		f.add(ok);
        f.pack();
        f.setVisible(true);
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		rzz20180421Client0 client = new rzz20180421Client0();
		client.start();
//		client.init();
	}

	private class myclient implements Runnable {
		private Socket socket;

		public myclient(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			OutputStream out;
//			Scanner scan = new Scanner(System.in);
			Frame f = new Frame("客户端聊天窗口");
			f.setBounds(30,30,250,300);
//            String message = scan.nextLine();
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
			f.setLayout(fl);
			TextArea tf = new TextArea(" ");
			Button ok = new Button("发送");
			f.add(tf);
			f.add(ok);
	        f.pack();
	        f.setVisible(true);
			while (true) {
				try {
					String message=null;

					  out = socket.getOutputStream();
	  					OutputStreamWriter osw = new OutputStreamWriter(out);
	  					PrintWriter pw = new PrintWriter(osw);
//	  					message = scan.nextLine();
	  					message = tf.getText();
	  					pw.println(message);
	  					pw.flush();
					/*InputStream  in = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);
                    BufferedReader br = new BufferedReader(isr);
                    //System.out.println(message);
                      while((message=br.readLine())!=null){
                     	   System.out.println(message);
                      }
//					pw.close();
                      */
                    
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	/*private class myServer implements Runnable{
		private Socket socket;
		public myServer(Socket socket){
			this.socket=socket;
		}
		public void run(){
			String message =null;
			while(true){
				try{
					InputStream  in = socket.getInputStream();
		            InputStreamReader isr = new InputStreamReader(in);
		            BufferedReader br = new BufferedReader(isr);
		              while((message=br.readLine())!=null){
		             	   System.out.println(message);
		              }
//					pw.close();
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
			
			
              
		}
	}
	*/
}
