package chat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client3 {
    private Socket socket;
    public Client3() throws UnknownHostException, IOException{
    	System.out.println("正在与服务器进行连接");
    	this.socket = new Socket("localhost",9998);
    	System.out.println("与服务器连接成功");
    }
    public void start() throws IOException{
    	try{
    	System.out.println("开始聊天");
    	Scanner scan = new Scanner(System.in);
    	String message = scan.nextLine();
    	OutputStream out = socket.getOutputStream();
    	OutputStreamWriter osw = new   OutputStreamWriter(out,"UTF-8");
    	PrintWriter pw = new PrintWriter(osw);
    		pw.println(message);
    		pw.flush();
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
	public static void main(String[] args) throws UnknownHostException, IOException {
     Client3  client = new Client3();
     client.start();
	}

}
