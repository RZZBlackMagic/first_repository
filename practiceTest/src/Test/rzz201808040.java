package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端
 */
public class rzz201808040 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		rzz201808040 r = new rzz201808040();
		r.start();
	}
	public void start() throws UnknownHostException, IOException{
		System.out.println("正在与服务端取得连接。。。");
		Socket socket = new Socket("localhost",2008);
		System.out.println("连接成功！");
		
		sendServer ss = new sendServer(socket);
		Thread t1 = new Thread(ss);
		t1.start();
		
		receiveServer rs = new receiveServer(socket);
		Thread t2 = new Thread(rs);
		t2.start();
	}
	private class sendServer implements Runnable{
        Socket socket;
		public sendServer(Socket socket){
			this.socket = socket;
		}
		@Override
		public void run() {
			while(true){
				try {
					OutputStream os = socket.getOutputStream();
					PrintWriter pw = new PrintWriter(os);
					Scanner scan = new Scanner(System.in);
					String message = scan.nextLine();
					pw.println(message);
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	private class receiveServer implements Runnable{
		Socket socket;
        public receiveServer(Socket socket){
        	this.socket=socket;
        }
		@Override
		public void run() {
            try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
            
		}
		
		
	}

}
















