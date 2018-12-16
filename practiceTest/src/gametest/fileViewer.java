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
		System.out.println("请输入要打开的文件名：");
		Scanner scan = new Scanner(System.in);
		fileName = scan.nextLine();
		f.openFile(fileName);
		f.decide(fileName);
		
	}
}
class init{
	static int flag = 0;
	/**打开文件目录*/
	public void openFile(String fileName){
		File file = new File(fileName);

		File[] sub = file.listFiles();
		System.out.println("该文件字目录：");
		if(sub.length==0){
			System.out.println("该目录为空");
			return;
		}else{
			for(File name :sub){
        			System.out.println(name);
    		}
		}
	}
	/**
	 * 判断输入的是目录还是文件名，如果是文件就打开输出其内容
	 * 如果是目录就打开目录显示下一级目录*/
	public void decide(String fileName1) throws IOException{
		File file = new File(fileName1);
		System.out.println("请输入文FIle名：");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		if(file.isFile()){
			flag = 0;//文件
			System.out.println("该file是文件");
			readerFile(fileName);
		}else if(file.isDirectory()){
			System.out.println("该file是目录");
			flag=1;//目录
			openFile(fileName);
			System.out.println("输入要打开的文件：");
			fileName = scan.nextLine();
			decide1(fileName);
		}else{
			System.out.println("打开方式有问题");
		}
	}
	public void decide1(String fileName) throws IOException{
		File file = new File(fileName);
		if(file.isFile()){
			System.out.println("该file是文件");
			readerFile(fileName);
		}else if(file.isDirectory()){
			System.out.println("该file是目录");
			openFile(fileName);
		}else{
			System.out.println("文件打开格式不对");
		}
	}
    /**以输入的字符串为参数，打开该文件
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
			this.setTitle("时代的");
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
				JButton but = new JButton("按钮"+i);
				but.setBounds(20,20,300,20);
				this.add(but);
			}
		}
	
}*/