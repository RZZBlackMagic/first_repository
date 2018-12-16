package Test;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

public class rzz201807150 {

	public static void main(String[] args) {
         JFrameTest jf1 = new JFrameTest();
	}

}
class JFrameTest extends JFrame{
	//复选框
	JCheckBox jcb = new JCheckBox("记住密码");
	//单选按钮
	JRadioButton jrb1 = new JRadioButton("男士");
	JRadioButton jrb2 = new JRadioButton("女士");
	ButtonGroup bg = new ButtonGroup();		
	
	Vector v = new Vector();
	JComboBox jcb1 =new JComboBox(v);
	
	JTabbedPane jtb = new JTabbedPane(JTabbedPane.BOTTOM);
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	
	//列表框应用
	JList jl = new JList(new String[]{"北京","陕西","成都","tianjin","shanghai","dalian"});
	JScrollPane jsp = new JScrollPane(jl);
	
	//菜单应用
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu("文件");
	JMenu jm2 = new JMenu("编辑");
	JMenu jm3 = new JMenu("新建");
	JMenuItem jmi1 = new JMenuItem("复制");
	JMenuItem jmi2 = new JMenuItem("粘贴");
	JMenuItem jmi3 = new JMenuItem("Word");
	public JFrameTest(){
		this.setTitle("第一个测试窗口");
		this.setVisible(true);
		this.setBounds(30, 30, 300, 300);
		this.setLayout(new GridLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.add(jcb);

		bg.add(jrb1);
		bg.add(jrb2);
//		this.add(jrb1);
//		this.add(jrb2);
		v.add("上海");
		v.add("beijing");
		v.add("河北");
//		this.add(jcb1);
		jp1.setBackground(Color.BLACK);
		jp2.setBackground(Color.red);
		jp3.setBackground(Color.blue);
//		this.add(jtb);
		jtb.add("黑色背景", jp1);
		jtb.add("红色背景", jp2);
		jtb.add("蓝色背景", jp3);
//		this.add(jsp);
		jmb.add(jm1);
		jmb.add(jm2);
		  jm2.add(jm3);
		     jm3.add(jmi2);
		  jm2.add(jmi1);
		this.setJMenuBar(jmb);
	}
}