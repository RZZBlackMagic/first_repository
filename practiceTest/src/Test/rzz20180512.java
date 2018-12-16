package Test;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class rzz20180512 {
	private class myListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			ta.append("����" + cmd + "\n");
			if (cmd.equals("�˳�")) {
				System.exit(0);
			}
		}

	}

	myListener ml = new myListener();

	Frame f = new Frame("����");
	MenuBar mb = new MenuBar();

	Menu file = new Menu("�ļ�");
	MenuItem newItem = new MenuItem("�½�");
	MenuItem saveItem = new MenuItem("����");

	Menu edit = new Menu("�༭");
	MenuItem exitItem = new MenuItem("�˳�", new MenuShortcut(KeyEvent.VK_X));
	MenuItem copyItem = new MenuItem("����");
	MenuItem pasteItem = new MenuItem("ճ��");

	Menu format = new Menu("��ʽ");
	MenuItem commentItem = new MenuItem("ע��", new MenuShortcut(KeyEvent.VK_SLASH, true));
	MenuItem cancelItem = new MenuItem("ȡ��ע��");
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("�Զ�����");
	TextArea ta = new TextArea(6, 40);

	public void init() {

		commentItem.addActionListener(ml);
		exitItem.addActionListener(ml);
		mb.add(file);
		mb.add(edit);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.add(format);
		format.add(commentItem);
		format.add(cancelItem);
		f.setMenuBar(mb);
		f.add(ta);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new rzz20180512().init();
	}

}
