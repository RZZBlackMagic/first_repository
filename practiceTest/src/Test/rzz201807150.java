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
	//��ѡ��
	JCheckBox jcb = new JCheckBox("��ס����");
	//��ѡ��ť
	JRadioButton jrb1 = new JRadioButton("��ʿ");
	JRadioButton jrb2 = new JRadioButton("Ůʿ");
	ButtonGroup bg = new ButtonGroup();		
	
	Vector v = new Vector();
	JComboBox jcb1 =new JComboBox(v);
	
	JTabbedPane jtb = new JTabbedPane(JTabbedPane.BOTTOM);
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	
	//�б��Ӧ��
	JList jl = new JList(new String[]{"����","����","�ɶ�","tianjin","shanghai","dalian"});
	JScrollPane jsp = new JScrollPane(jl);
	
	//�˵�Ӧ��
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu("�ļ�");
	JMenu jm2 = new JMenu("�༭");
	JMenu jm3 = new JMenu("�½�");
	JMenuItem jmi1 = new JMenuItem("����");
	JMenuItem jmi2 = new JMenuItem("ճ��");
	JMenuItem jmi3 = new JMenuItem("Word");
	public JFrameTest(){
		this.setTitle("��һ�����Դ���");
		this.setVisible(true);
		this.setBounds(30, 30, 300, 300);
		this.setLayout(new GridLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.add(jcb);

		bg.add(jrb1);
		bg.add(jrb2);
//		this.add(jrb1);
//		this.add(jrb2);
		v.add("�Ϻ�");
		v.add("beijing");
		v.add("�ӱ�");
//		this.add(jcb1);
		jp1.setBackground(Color.BLACK);
		jp2.setBackground(Color.red);
		jp3.setBackground(Color.blue);
//		this.add(jtb);
		jtb.add("��ɫ����", jp1);
		jtb.add("��ɫ����", jp2);
		jtb.add("��ɫ����", jp3);
//		this.add(jsp);
		jmb.add(jm1);
		jmb.add(jm2);
		  jm2.add(jm3);
		     jm3.add(jmi2);
		  jm2.add(jmi1);
		this.setJMenuBar(jmb);
	}
}