package net.fuzui.handler;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;

@Controller
public class GridFsController {
	@Autowired
	MongoTemplate mongoTemplate;

	private static Mongo md = null;
	private static DB db = null;
	private static GridFS myFs = null;
	
	public void saveGridFs(String localpath){
		File file = new File(localpath);
		//FTPClient fc = new FTPClient();
		
	}
	
}
