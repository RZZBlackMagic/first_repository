package gametest;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class fileViewer {
	init f = new init();
	static String fileName =null;
	public static void main(String[] args) throws IOException {
		init f = new init();
		
		String str = System.getProperty("user.dir");
		System.out.println(str);
		System.out.println("������Ҫ�򿪵��ļ�����");
		Scanner scan = new Scanner(System.in);
		fileName = scan.nextLine();
		f.openFile(fileName);
		f.decide(fileName);
		
	}
}
class init{
	static int flag = 0;
	/**���ļ�Ŀ¼*/
	public void openFile(String fileName){
		File file = new File(fileName);

		File[] sub = file.listFiles();
		System.out.println("���ļ���Ŀ¼��");
		if(sub.length==0){
			System.out.println("��Ŀ¼Ϊ��");
			return;
		}else{
			for(File name :sub){
        			System.out.println(name);
    		}
		}
	}
	/**
	 * �ж��������Ŀ¼�����ļ�����������ļ��ʹ����������
	 * �����Ŀ¼�ʹ�Ŀ¼��ʾ��һ��Ŀ¼*/
	public void decide(String fileName1) throws IOException{
		File file = new File(fileName1);
		System.out.println("��������FIle����");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		if(file.isFile()){
			flag = 0;//�ļ�
			System.out.println("��file���ļ�");
			readerFile(fileName);
		}else if(file.isDirectory()){
			System.out.println("��file��Ŀ¼");
			flag=1;//Ŀ¼
			openFile(fileName);
			System.out.println("����Ҫ�򿪵��ļ���");
			fileName = scan.nextLine();
			decide1(fileName);
		}else{
			System.out.println("�򿪷�ʽ������");
		}
	}
	public void decide1(String fileName) throws IOException{
		File file = new File(fileName);
		if(file.isFile()){
			System.out.println("��file���ļ�");
			readerFile(fileName);
		}else if(file.isDirectory()){
			System.out.println("��file��Ŀ¼");
			openFile(fileName);
		}else{
			System.out.println("�ļ��򿪸�ʽ����");
		}
	}
    /**��������ַ���Ϊ�������򿪸��ļ�
     * @throws IOException */
	public void readerFile(String fileName) throws IOException{
		FileInputStream fos = new FileInputStream(fileName);
		InputStreamReader osw = new InputStreamReader(fos);
		BufferedReader br = new BufferedReader(osw);
		String str = null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
	}
}
/*class FViewer extends JFrame{
        Panel p = new Panel();
		public  FViewer(){
			int fileCount=0;
			File file = new File(".");
			File[] sub = file.listFiles(new FileFilter(){

				@Override
				public boolean accept(File file) {
					return file.isFile();
				}
				
			});
			for(File name :sub){
				System.out.println(name);
				fileCount++;
			}
			this.setTitle("ʱ����");
			this.setVisible(true);
			this.setBounds(30, 30, 500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new FlowLayout());
			this.setBackground(Color.black);
			this.add(p);
			p.setBounds(0,0 , 20, 20);
			p.setBackground(Color.blue);
			p.setLayout(null);
			for(int i=0;i<fileCount;i++){
				JButton but = new JButton("��ť"+i);
				but.setBounds(20,20,300,20);
				this.add(but);
			}
		}
	
}*/