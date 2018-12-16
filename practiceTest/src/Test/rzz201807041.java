package Test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;


public class rzz201807041 {

	public static void main(String[] args) {
		FrameEx f1 = new FrameEx();
//		FrameEx1 f2 = new FrameEx1();

	}
}
class FrameEx extends Frame{
	Button bok = new Button("按钮1");
	Button bok2 = new Button("按钮2");
	TextField tf = new TextField(30);
	TextArea ta = new TextArea("abcdefghijklmn");
	FrameEx(){
		bok.addActionListener(new bokListener());
		this.setTitle("测试窗口1");
		this.setBounds(100,100, 250, 250);
		this.setVisible(true);
		//设置从左到右的布局
		this.setLayout(null);
		this.add(bok);
		this.add(bok2);
		this.add(tf);
		this.add(ta);
		Font f = new Font("宋体",Font.ITALIC+Font.BOLD,50);
		ta.setFont(f);
		bok.setBounds(10, 10, 20, 20);
	}
	class bokListener implements ActionListener,WindowListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	      		System.out.println("用户点击了按钮");
	      		tf.setText("hello world");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("打开");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("jieshu");
			System.exit(0);

		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("释放");

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("最小化");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("最大化");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("激活");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("失去焦点");
		}

		
		
	}
}
