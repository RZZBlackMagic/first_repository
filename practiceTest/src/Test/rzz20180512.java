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
			ta.append("单击" + cmd + "\n");
			if (cmd.equals("退出")) {
				System.exit(0);
			}
		}

	}

	myListener ml = new myListener();

	Frame f = new Frame("测试");
	MenuBar mb = new MenuBar();

	Menu file = new Menu("文件");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");

	Menu edit = new Menu("编辑");
	MenuItem exitItem = new MenuItem("退出", new MenuShortcut(KeyEvent.VK_X));
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");

	Menu format = new Menu("格式");
	MenuItem commentItem = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_SLASH, true));
	MenuItem cancelItem = new MenuItem("取消注释");
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
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
