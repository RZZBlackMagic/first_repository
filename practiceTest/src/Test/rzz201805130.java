package Test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rzz201805130 {

	public static void main(String[] args) {

		new rzz201805130().inti();

	}

	public void inti() {
		Frame f = new Frame("≤‚ ‘");
		Button b1 = new Button("∞¥≈•");
		TextArea ta = new TextArea(6, 40);
		myListener ml = new myListener();
		b1.addActionListener(ml);
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		f.add(b1);
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}

	private class myListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}
}
