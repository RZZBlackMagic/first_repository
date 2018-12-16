package Test;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class rzz20180719Client {
	Socket socket;
   
	public static void main(String[] args) throws UnknownHostException, IOException {
		rzz20180719Client rc = new rzz20180719Client();
		rc.start();
	}
	public rzz20180719Client() throws UnknownHostException, IOException{
		System.out.println("正在与服务端取得连接!");
		 socket = new Socket("localhost",2005);
		System.out.println("连接成功！");
	}
	public void start(){
		while(true){
			try {
				receiveServer rs = new receiveServer(socket);
				Thread t1 = new Thread(rs);
				t1.start();
				
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String message = null;
				Scanner scan = new Scanner(System.in);
				message=scan.nextLine();
				pw.println(message);
				pw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
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
			InputStream is;
			try {
				is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				while((message=br.readLine())!= null){
					System.out.println("服务端说："+message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
