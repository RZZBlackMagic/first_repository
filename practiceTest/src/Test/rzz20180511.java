package Test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class rzz20180511 {
    Frame f = new Frame();
	TextArea t= new TextArea();
	TextField[] tf = new TextField[3];
	
    public void init(){
    	f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
    	for(int i=0;i<3;i++){
    		tf[i]=new TextField(10);
        	f.add(tf[i]);
            f.add(new Button("按钮"+i));
    	}
    	myListener ml = new myListener();
    	f.addWindowListener(ml);
    	f.add(t);
        f.pack();
        f.setVisible(true);
    }
	public static void main(String[] args) {
		rzz20180511 r = new rzz20180511();
		r.init();
		
	}
	private class myListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("用户关闭了窗口\n");
			System.exit(0);
		}
	}
}
