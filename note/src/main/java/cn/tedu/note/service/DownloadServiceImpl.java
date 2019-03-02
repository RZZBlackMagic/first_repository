package cn.tedu.note.service;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;

@Service
public class DownloadServiceImpl implements DownloadService{

	@Resource 
	private NoteDao noteDao;
	public Note download(String noteId,String path) throws Exception {
        Note note = noteDao.findNoteByNoteId(noteId);
        System.out.println(note);
        System.out.println("*******"+path);
		
        
      //���ɸ��ļ���
        File outFile = new File(path+"\\"+note.getCn_note_title()+".doc");
        //StringBuffer buffer = new StringBuffer(); //��Ϊ�������HTML��ʽ ���� �������htmlͷ
        //byte[] contentBytes = buffer.toString().getBytes();
        //ByteArrayInputStream byteStream = new ByteArrayInputStream(contentBytes);
		//����word�ĵ�
        //POIFSFileSystem poifSystem = new POIFSFileSystem(); //��ʱ��֪��ʲô��˼
        //DirectoryNode root = poifSystem.getRoot(); //ͬ��
        //root.createDocument("WordDocument",byteStream); //���WordDocument �����Խ����޸� ��������
        
        
        //FileOutputStream outStream = new FileOutputStream(outFile,true); 
        //String body = note.getCn_note_body();
        //byte[] data = body.getBytes();
        
        
       
        FileOutputStream out = new FileOutputStream(outFile);
        byte[] bytes = note.getCn_note_body().getBytes("utf-8");
        out.write(bytes);
        out.close();
        
        
        //poifSystem.writeFilesystem(outStream); //���� �����word�ĵ���
        //outStream.write(data, 0, body.length());
        //poifSystem.close();
        //byteStream.close();
        //outStream.close();
       
        
        return note;
	}
}
