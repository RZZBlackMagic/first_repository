package net.fuzui.video;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class Mon_GridFS {

	public static void main(String[] args) throws Exception {
		//saveFile();
		readFile();
	}
    
	/**
     * 存储文件
	 * @throws IOException 
     */
	public static void saveFile() throws IOException{
		//连接服务器，创建实例
		System.out.println(1);

		Mongo mongo = new Mongo("116.62.222.40",27017);
		//连接数据库
		System.out.println(1);

		DB db = mongo.getDB("PUNCH");
		//文件是在DB基础上实现的，与表和文档没有关系
		GridFS gridFS = new GridFS(db);
		System.out.println(1);

		String fileName = "D:/test/1582788755063.mp4";
		File readFile = new File(fileName);
		GridFSInputFile mongofile = gridFS.createFile(readFile);
		//再添加对象
		mongofile.put("path", fileName);
		mongofile.put("", "");
		//保存
		mongofile.save();
		System.out.println(1);
	}
	
	/**
	 * 读取文件，写入磁盘
	 * @throws Exception 
	 */
	public static void readFile() throws Exception{
		//1.连接服务器，创建实例
		Mongo mongo = new Mongo("116.62.222.40",27017);
		//连接数据库
		DB db = mongo.getDB("PUNCH");
		//文件是在DB基础上实现的，与表和文档没有关系
		GridFS gridFS = new GridFS(db);
	    
		//2.查找条件
		DBObject query = new BasicDBObject(); 
		List<GridFSDBFile> listFile = gridFS.find(query);
		GridFSDBFile gridFSDBFile = listFile.get(1);
		
		//3.获取文件名
		//注意：不是fs中的表的列名，而是根据调试gridDBFile中的属性而来
		String fileName = (String)gridFSDBFile.get("filename");
		System.out.println("从MongoDB获得的文件名为:"+fileName);
		
		//4.创建空文件
		File writeFile = new File("d:/reback_test/"+fileName);
		if(!writeFile.exists()){
			writeFile.createNewFile();
		}
		System.out.println(1);
		//5.写入文件
		gridFSDBFile.writeTo(writeFile);
		System.out.println(1);

	}


}
