package Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * �����
 */
public class rzz201808140 {
    Socket socket;
	public static void main(String[] args) {
      rzz201808140 r = new rzz201808140();
      r.start();
	}
	public rzz201808140() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(8088);
			System.out.println("�ȴ��ͻ�������");
	    	 socket = ss.accept();
	    	System.out.println("���ӳɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
	}
    public void start(){
    	while(true){
    		try {
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				Scanner scan = new Scanner(System.in);
				String message = scan.nextLine();
				pw.println(message);
				pw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
