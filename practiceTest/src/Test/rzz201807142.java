package Test;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class rzz201807142 {

	public static void main(String[] args) {
		swingTest1 st = new swingTest1();
		
	}

}
class swingTest1 extends JFrame{
	JButton b1 = new JButton("按钮1");
	
	JPopupMenu j = new JPopupMenu();
	public swingTest1(){
		this.setLayout(new FlowLayout());
		this.setTitle("测试窗口1");
		this.setBounds(30, 30, 300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JLabel j1 = new JLabel("a");
		JLabel j2 = new JLabel("b");
		this.add(j1);
		this.add(j2);
		ImageIcon i1 = new ImageIcon("bullet.png");
		j1.setlcon(i1);
        this.add(b1);
        b1.addActionListener(new myAction());
        */
		JMenuItem jmi = new JMenuItem("A");
		jmi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
               System.out.println("弹出式菜单A");				
			}
		});
		this.addMouseListener(new MouseListener(){

			
			@Override
			public void mouseReleased(MouseEvent e) {
               if(e.isPopupTrigger()){
            	   j.show(e.getComponent(), e.getX(), e.getY());
            	   System.out.println(e.getX());
               }
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
class myAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("时间响应成功");
	}
	
}
