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
		dataMap.put("province", "����");
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setDirectoryForTemplateLoading(new File("D:\\apps\\test"));
		// ����ĵ�·��������
		//File outFile = new File("D:\\apps\\test\\test-gen.doc");

		
		//���ɸ��ļ���
        UUID uuid = UUID.randomUUID();
        File outFile = new File("D:\\apps\\test"+uuid.toString()+".doc");
        StringBuffer buffer = new StringBuffer(); //��Ϊ�������HTML��ʽ ���� �������htmlͷ
        byte[] contentBytes = buffer.toString().getBytes();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(contentBytes);
		//����word�ĵ�
        POIFSFileSystem poifSystem = new POIFSFileSystem(); //��ʱ��֪��ʲô��˼
        DirectoryNode root = poifSystem.getRoot(); //ͬ��
        root.createDocument("WordDocument",byteStream); //���WordDocument �����Խ����޸� ��������
        FileOutputStream outStream = new FileOutputStream(outFile); 
        poifSystem.writeFilesystem(outStream); //���� �����word�ĵ���
        byteStream.close();
        outStream.close();
        //��utf-8�ı����ȡftl�ļ�
		/*Template t =  configuration.getTemplate("test.xml","GBK");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"),10240);
		t.process(dataMap, out);
		out.close();*/
	}
	

}
