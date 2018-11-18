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
			throw new NoteIdNoteFoundException("û�иñʼ�");
		}
		if(text.getCn_note_body()==null||text.getCn_note_body().trim().isEmpty()){
			text.setCn_note_body("�ñʼǱ���û������");
			return text;
		}
		return text;
	}

	

}
