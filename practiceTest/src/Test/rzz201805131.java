package Test;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class rzz201805131 {
	public void init() {
		Frame f = new Frame("²âÊÔ");
		MenuBar mb = new MenuBar();

		Menu m1 = new Menu("ÐÂ½¨");
		Menu m2 = new Menu("±à¼­");
		TextArea ta = new TextArea(6, 30);
		Menu m11 = new Menu("Java");
		m1.add(m11);
		MenuItem copyItem = new MenuItem("¸´ÖÆ");
		MenuItem patseItem = new MenuItem("Õ³Ìù");
		m1.addSeparator();
		m1.add(copyItem);
		m1.add(patseItem);
		MenuItem command = new MenuItem("×¢ÊÍ");
		MenuItem exit = new MenuItem("ÍË³ö");
		m2.add(command);
		m2.add(exit);
		MenuItem maven = new MenuItem("maven");
		MenuItem javaEE = new MenuItem("javaEE");
		m11.add(maven);
		m11.add(javaEE);
		mb.add(m1);
		mb.add(m2);
		myListener ml = new myListener();
		exit.addActionListener(ml);
		f.setMenuBar(mb);
		f.add(ta);
		Listener l = new Listener();

		f.addWindowListener(l);
		f.pack();
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new rzz201805131().init();
	}

	private class myListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if (str.equals("ÍË³ö")) {
				System.exit(0);
			}
		}
	}

	private class Listener extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

}
