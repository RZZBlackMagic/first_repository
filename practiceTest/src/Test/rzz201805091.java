package Test;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rzz201805091 {

	public static void main(String[] args) {
      Frame f = new Frame();
      Button ok =new Button("确定");
      TextField tf = new TextField(30);
//      ok.addActionListener(new OkListener());
      f.add(tf);
		f.add(ok);
		f.pack();
		f.setVisible(true);
	}
	private class OkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
          System.out.println("用户点击了确定按钮");			
		}
		
	}

}
