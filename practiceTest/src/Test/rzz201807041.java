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
	Button bok = new Button("��ť1");
	Button bok2 = new Button("��ť2");
	TextField tf = new TextField(30);
	TextArea ta = new TextArea("abcdefghijklmn");
	FrameEx(){
		bok.addActionListener(new bokListener());
		this.setTitle("���Դ���1");
		this.setBounds(100,100, 250, 250);
		this.setVisible(true);
		//���ô����ҵĲ���
		this.setLayout(null);
		this.add(bok);
		this.add(bok2);
		this.add(tf);
		this.add(ta);
		Font f = new Font("����",Font.ITALIC+Font.BOLD,50);
		ta.setFont(f);
		bok.setBounds(10, 10, 20, 20);
	}
	class bokListener implements ActionListener,WindowListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	      		System.out.println("�û�����˰�ť");
	      		tf.setText("hello world");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("��");
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
			System.out.println("�ͷ�");

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("��С��");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("���");
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("����");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ʧȥ����");
		}

		
		
	}
}
