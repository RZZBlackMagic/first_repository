package Test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.*;

public class test0 {
	/*static {
		System.out.println(1);
	}
   */
	public static void main(String[] args) {
		
	System.out.println(2);
   
}

}







class JFrame0716 extends JFrame{
	JButton b1 = new JButton("°´Å¥1");
	JButton b2 = new JButton("°´Å¥2");
	JPanel jp = new JPanel();
	public JFrame0716(){
		this.setTitle("¹þ°¡");
		this.setBounds(30, 30, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
//		this.add(b1);
//		this.add(b2);
		this.add(jp);
		this.setBackground(Color.black);
		jp.setBounds(30,30,200, 200);
		jp.setBackground(Color.BLACK);
//		jp.setLayout(new FlowLayout());
		b1.setBounds(30, 30, 150, 150);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                if(e.getSource()==b1){
    				System.out.println(1);
                    System.out.println(e.getActionCommand());
                }
			}
		});
		for( int i=0;i<10;i++){
			JButton but = new JButton("°´Å¥"+i);
			but.setBounds(35, 35, 100, 10);
			jp.add(but);
			
		}
		
	}
}