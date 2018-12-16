package Test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class rzz20180421Server0 {
	private Socket socket;

	public static void main(String[] args) throws IOException {
		rzz20180421Server0 server = new rzz20180421Server0();
		server.start();
//		server.init();
	}
	public void start() throws IOException {
		ServerSocket ss = new ServerSocket(8088);
		System.out.println("等待客户端连接");
		Socket socket = ss.accept();
		System.out.println("一个客户端连接成功");
		System.out.println("开始聊天");
		server run1 = new server(socket);
		Thread t = new Thread(run1);
		t.start();
		/*myClient run2 = new myClient( socket);
		Thread t1 = new Thread(run2);
		t1.start();*/
	}
	public void init(){
		Frame f = new Frame("服务端聊天窗口");
		f.setBounds(30,30,250,300);
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
		f.setLayout(fl);
		TextField tf = new TextField(100);
		Button ok = new Button("发送");
		OkListener ol = new OkListener();
		ok.addActionListener(ol);
		f.add(tf);
		f.add(ok);
        f.pack();
        f.setVisible(true);
	}
    class OkListener implements ActionListener  {
 		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("用户点击了按钮");
			Scanner scan = new Scanner(System.in);
			String message = scan.nextLine();
			String str="任章哲说：";
// 			tf.setText(str+message);
		}
 	}
	private class server implements Runnable {
		private Socket socket;
		public server(Socket socket) {
			this.socket = socket;
		}
		public void run() {
			Frame f = new Frame("服务端聊天窗口");
			f.setBounds(30,30,250,300);
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
			f.setLayout(fl);
			TextArea tf = new TextArea();
			Button ok = new Button("发送");
			OkListener ol = new OkListener();
			ok.addActionListener(ol);
			f.add(tf);
			f.add(ok);
	        f.pack();
	        f.setVisible(true);
//			while (true) {
				try {
					InputStream  in = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);
                    BufferedReader br = new BufferedReader(isr);
                    String message = null;
                      while((message=br.readLine())!=null){
//                     	   System.out.println(message);
              			String str="客户端说：";

               			tf.setText(message);
                      }
				} catch (IOException e) {
					System.out.println("異常了");
				}
				
				
			}
             
//		}
	}
	/*private class myClient implements Runnable{
		private Socket socket;
		public myClient(Socket socket){
			this.socket=socket;
		}
		public void run(){
			Scanner scan = new Scanner(System.in);
			while(true){
				try{
					String message = null;
				    OutputStream out = socket.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(out);
					PrintWriter pw = new PrintWriter(osw);
					message = scan.nextLine();
					pw.println(message);
					pw.flush();
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
			
			     
		}
	}*/
	
}
