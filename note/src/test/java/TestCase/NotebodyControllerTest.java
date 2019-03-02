package TestCase;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

import cn.tedu.note.controller.NotebodyController;
import cn.tedu.note.util.JsonResult;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class NotebodyControllerTest extends BaseTest{

	@Test
	public void NoteBodytest(){
		String NoteId = "c9250b3e-ed22-432c-960a-175dbc2134d1";
		NotebodyController nc = ctx.getBean("notebodyController", NotebodyController.class);
		JsonResult text = nc.showTextController(NoteId);
		System.out.println(text);
	}
	@Test
	public void test() throws Exception{
		Map<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("name", "Tom");
		dataMap.put("age", "20");
		dataMap.put("province", "江苏");
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setDirectoryForTemplateLoading(new File("D:\\apps\\test"));
		// 输出文档路径及名称
		//File outFile = new File("D:\\apps\\test\\test-gen.doc");

		
		//生成个文件名
        UUID uuid = UUID.randomUUID();
        File outFile = new File("D:\\apps\\test"+uuid.toString()+".doc");
        StringBuffer buffer = new StringBuffer(); //因为必须符合HTML格式 所以 必须添加html头
        byte[] contentBytes = buffer.toString().getBytes();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(contentBytes);
		//创建word文档
        POIFSFileSystem poifSystem = new POIFSFileSystem(); //暂时不知道什么意思
        DirectoryNode root = poifSystem.getRoot(); //同上
        root.createDocument("WordDocument",byteStream); //这个WordDocument 不可以进行修改 否则乱码
        FileOutputStream outStream = new FileOutputStream(outFile); 
        poifSystem.writeFilesystem(outStream); //将流 输出到word文档上
        byteStream.close();
        outStream.close();
        //以utf-8的编码读取ftl文件
		/*Template t =  configuration.getTemplate("test.xml","GBK");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
		t.process(dataMap, out);
		out.close();*/
	}
	

}
