package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculatorTest {

	public static void main(String[] args) {
		calculatorJFrame cj =new calculatorJFrame();
	}

}
class calculatorJFrame extends JFrame{
	
	String str ="";
	public calculatorJFrame(){
		JTextField jtf1 =new JTextField("text1");
		JTextField jtf2 =new JTextField("text2");
		JTextField jtf3 =new JTextField("text3");
		JTextField jtf4 =new JTextField("text4");
		JTextField jtf5 =new JTextField("结果");
		JButton jb1 = new JButton("1");
		
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");
		JButton jb4 = new JButton("4");
		JButton jb5 = new JButton("5");
		JButton jb6 = new JButton("6");
		JButton jb7 = new JButton("7");
		JButton jb8 = new JButton("8");
		JButton jb9 = new JButton("9");
		JButton jb10 = new JButton("+");
		JButton jb11 = new JButton("-");
		JButton jb12 = new JButton("*");
		JButton jb13 = new JButton("=");
		JButton jb14 = new JButton("/");
		JButton jb15 = new JButton("clear");

		this.setTitle("小小计算器");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(30, 30, 300, 300);
		this.setLayout(new GridLayout(4,5));
	    this.add(jtf1);
	    this.add(jtf2);
//	    this.add(jtf3);
//	    this.add(jtf4);
//	    this.add(jtf5);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jb6);
        this.add(jb7);
        this.add(jb8);
        this.add(jb9);
        this.add(jb10);
        this.add(jb11);
        this.add(jb12);
        this.add(jb13);
        this.add(jb14);
        this.add(jb15);
        jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"1";
			     jtf1.setText(str);
			}
			
		});
        jb2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"2";
			     jtf1.setText(str);
			}
			
		});
        jb3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"3";
			     jtf1.setText(str);
			}
			
		});
        jb4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"4";
			     jtf1.setText(str);
			}
			
		});
        jb5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"5";
			     jtf1.setText(str);
			}
			
		});
        jb6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"6";
			     jtf1.setText(str);
			}
			
		});
        jb7.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"7";
			     jtf1.setText(str);
			}
			
		});
        jb8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"8";
			     jtf1.setText(str);
			}
			
		});
        jb9.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"9";
			     jtf1.setText(str);
			}
			
		});
        jb10.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"+";
			     jtf1.setText(str);
			}
			
		});
        jb11.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"-";
			     jtf1.setText(str);
			}
			
		});
        jb12.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"*";
			     jtf1.setText(str);
			}
			
		});
        jb13.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String regax="[*+-/]?";
				 String[] s=str.split(regax);
				 String regax1="[0-9]";
				 String[] ss= str.split(regax1);
                 int[] arr = new int[(s.length+1)/2];
         		int j =0;
                for(int i=0;i<s.length;i++){
                	if(i%2==0){
                        int a= Integer.parseInt(s[i]);
                        arr[j] = a;
                        j++;
                	}else{
                	}
                }
                for(int i=0;i<arr.length;i++){
                }
				double result = arr[0];

                for(int i=0;i<s.length;i++){
                	if(i%2==0){
                		
                	}else{
                		if(ss[(i+1)/2].equals("+")){
                			 result=result+arr[(i+1)/2];
                		}else if(ss[(i+1)/2].equals("-")){
                			 result=result-arr[(i+1)/2];

                		}else if(ss[(i+1)/2].equals("*")){
                			 result=result*arr[(i+1)/2];

                		}else if(ss[(i+1)/2].equals("/"))
                			 result=result/arr[(i+1)/2];
                	}
                }
               
//               System.out.println(result);
               jtf2.setText(""+result);
			}
		});
        jb14.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str=str+"/";
			     jtf1.setText(str);
			}
		});
        jb15.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 str="";
			     jtf1.setText(str);
			}
			
		});
       
	}
}


















