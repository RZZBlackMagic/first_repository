package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class rzz201808141 {
    Socket socket;
	public static void main(String[] args) {
        rzz201808141 r = new rzz201808141();
        r.start();
	}
	public rzz201808141(){
		try {
			System.out.println("正在建立连接");
			 socket = new Socket("localhost",8088);
			System.out.println("连接成功");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start(){
		while(true){
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
