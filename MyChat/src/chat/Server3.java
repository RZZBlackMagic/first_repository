package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    private ServerSocket server;
    
    public Server3() throws IOException{
    	server=new ServerSocket(9998);
    	
    }
    public void start() throws IOException{
    	try{
    	System.out.println("等待客户端连接。。。");
    	Socket socket = server.accept();
    	System.out.println("一个客户端已经连接上了");
    	
    	InputStream in = socket.getInputStream();
    	InputStreamReader isr = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        int d =br.read();
       // System.out.println(d);
        String message = null;
        while((message= br.readLine())!=null){
            System.out.println(message);

        }
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	
    }
	public static void main(String[] args) throws IOException {
       Server3 server3 = new Server3();
       server3.start();
	}

}
