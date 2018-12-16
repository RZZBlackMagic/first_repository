package Test;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class rzz20180509 {
	    Frame f = new Frame("测试事件");
		Button ok =new Button("确定");
		TextField tf = new TextField(" haiahi",30);
	      FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
		public void init(){
			ok.addActionListener(new OkListener());   
		    f.setLayout(fl);

			f.add(tf);
			f.add(ok);
			f.pack();
			f.setVisible(true);
		}
 	public static void main(String[] args){
      /*Frame f = new Frame("测试窗口！");
      ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
      FlowLayout fl = new FlowLayout(FlowLayout.LEFT,20,5);
      f.setLayout(fl);
      Panel p = new Panel();
      f.add(new TextField(20));
      for(int i=0;i<10;i++){
        f.add(new Button("button"));
      }
//      f.add(p);
//      f.add(sp);
      f.setBounds(30, 30, 700, 600);
      f.setVisible(true);*/
 		new rzz20180509().init();
	}
 	 class OkListener implements ActionListener{
 		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("用户点击了按钮");
//			Scanner scan = new Scanner(System.in);
//			String message = scan.nextLine();
			String str="任章哲说：";
// 			tf.setText(str+message);
 			String a = tf.getText();
 		
 			System.out.println(a);
		}
 	}

}
     