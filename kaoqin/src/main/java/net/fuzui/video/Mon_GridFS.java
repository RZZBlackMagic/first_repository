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

	public static void main(String[] args) throws Exception  {
		//saveFile();
		//readFile();
	}
    
	/**
     * 存储文件
	 * @throws IOException 
     */
	public static void saveFile(String user_id,String user_name,String path) throws IOException{
		//连接服务器，创建实例
		//System.out.println(1);

		Mongo mongo = new Mongo("116.62.222.40",27017);
		//连接数据库
		//System.out.println(1);

		DB db = mongo.getDB("PUNCH");
		//文件是在DB基础上实现的，与表和文档没有关系
		GridFS gridFS = new GridFS(db);
		//System.out.println(1);

		String fileName = "D:/test/IMG_20190915_202257.jpg";
		File readFile = new File(path);
		GridFSInputFile mongofile = gridFS.createFile(readFile);
		//再添加对象
		mongofile.put("path", path);
		mongofile.put("user_id", user_id);
		mongofile.put("user_name", user_name);
		//保存
		mongofile.save();
		//System.out.println(1);
	}
	
	/**
	 * 读取文件，写入磁盘
	 * @throws Exception 
	 */
	public static String readFile(String filename,String user_id) throws Exception{
		//1.连接服务器，创建实例
		Mongo mongo = new Mongo("116.62.222.40",27017);
		//连接数据库
		DB db = mongo.getDB("PUNCH");
		//文件是在DB基础上实现的，与表和文档没有关系
		GridFS gridFS = new GridFS(db);
	    
		//2.查找条件
		DBObject query = new BasicDBObject(); 
		query.put("user_id", user_id);
		List<GridFSDBFile> listFile = gridFS.find(query);
		if(listFile.size()==0){
			return "该用户还没有上传视频";
		}
		GridFSDBFile gridFSDBFile=null;
		for(int i=0;i<listFile.size();i++){
			if(listFile.get(i).getFilename().equals(filename)){
				 gridFSDBFile = listFile.get(i);
			}
		}
		if(gridFSDBFile==null){
			return "没有找到该视频，请重新尝试";
		}
		System.out.println("获得的文件个数是："+listFile.size());
		System.out.println(listFile.toString());
		//3.获取文件名
		//注意：不是fs中的表的列名，而是根据调试gridDBFile中的属性而来
		String fileName1 = (String)gridFSDBFile.get("filename");
		System.out.println("从MongoDB获得的文件名为:"+fileName1);
		
		//4.创建空文件
		File writeFile = new File("d:/re_test/"+fileName1);
		if(!writeFile.exists()){
			writeFile.createNewFile();
		}
		System.out.println(1);
		//5.写入文件
		gridFSDBFile.writeTo(writeFile);
		System.out.println(1);
        return "文件已写入相应目录";
	}

	/**
	 * 读取文件，写入磁盘
	 * @throws Exception 
	 */
	public static String readALLFile(String user_id) throws Exception{
		//1.连接服务器，创建实例
		Mongo mongo = new Mongo("116.62.222.40",27017);
		//连接数据库
		DB db = mongo.getDB("PUNCH");
		//文件是在DB基础上实现的，与表和文档没有关系
		GridFS gridFS = new GridFS(db);
	    
		//2.查找条件
		DBObject query = new BasicDBObject(); 
		query.put("user_id", user_id);
		List<GridFSDBFile> listFile = gridFS.find(query);
		if(listFile.size()==0){
			return "该用户还没有上传视频";
		}
		GridFSDBFile gridFSDBFile=null;
		for(int i=0;i<listFile.size();i++){
				    gridFSDBFile = listFile.get(i);
				//3.获取文件名
					//注意：不是fs中的表的列名，而是根据调试gridDBFile中的属性而来
					String fileName1 = (String)gridFSDBFile.get("filename");
					System.out.println("从MongoDB获得的文件名为:"+fileName1);
					
					//4.创建空文件
					File writeFile = new File("d:/re_test/"+fileName1);
					if(!writeFile.exists()){
						writeFile.createNewFile();
					}
					System.out.println(1);
					//5.写入文件
					gridFSDBFile.writeTo(writeFile);
			
		}
		
		
        return "文件已写入相应目录";
	}

}
