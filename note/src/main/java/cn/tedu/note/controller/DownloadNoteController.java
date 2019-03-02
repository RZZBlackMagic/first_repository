package cn.tedu.note.controller;

import java.io.File;

import javax.annotation.Resource;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.service.DownloadService;
import cn.tedu.note.util.JsonResult;

@Controller
public class DownloadNoteController {

	@Resource
	private DownloadService downloadService;
	@Resource 
	private NoteDao noteDao;
	@RequestMapping("/download.do")
	@ResponseBody
	public JsonResult downloadNote(String noteId ,String path) throws Exception{
		Note note = downloadService.download(noteId, path);
		return new JsonResult(note);
	}

}
