package cn.tedu.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NotebodyDao;
import cn.tedu.note.entity.Note;

@Service("notebodyService")
public class NotebodyServiceImpl implements NotebodyService{

	@Resource
	private NotebodyDao notebodyDao;
	public Note showText(String NoteId) {
		Note text = notebodyDao.findNotebodyByNoteId(NoteId);
		if(NoteId==null||NoteId.trim().isEmpty()){
			throw new NoteIdNoteFoundException("没有该笔记");
		}
		if(text.getCn_note_body()==null||text.getCn_note_body().trim().isEmpty()){
			text.setCn_note_body("该笔记本还没有内容");
			return text;
		}
		return text;
	}

	

}
