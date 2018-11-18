package cn.tedu.note.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Notebook;
@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NotebookDao notebookDao;
	@Resource
	private NoteDao noteDao;
	public List<Map<String, Object>> listNotes(String NotebookId) throws NotebookNotFoundException   {
		List<Map<String,Object>> notes = noteDao.findNoteByNotebookId(NotebookId);
		if(NotebookId==null||NotebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("NotebookId不能为空");
		}
		Notebook notebook = notebookDao.findNotesByNotebookId(NotebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有该笔记本");
		}
		return notes;
	}
	public Note createNewNote(String UserID, String cn_notebook_id, String cn_note_title) throws Exception {
		Note note = new Note();
		note.setCn_note_body(null);
		note.setCn_note_create_time(System.currentTimeMillis());
		String cn_note_id = UUID.randomUUID().toString();
		note.setCn_note_id(cn_note_id);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_status_id("1");
		note.setCn_note_title(cn_note_title);
		note.setCn_note_type_id("5");
		note.setCn_notebook_id(cn_notebook_id);
		note.setCn_user_id(UserID);
		noteDao.createNewNote(note);
		Note  backNote = noteDao.findNoteByNoteId(cn_note_id);
		return backNote;
	}
	public void saveBody(String NoteId, String NoteBody,String title) {
		Note note = noteDao.findNoteByNoteId(NoteId);
        if(NoteBody==null||NoteBody.trim().isEmpty()){
        	NoteBody="该笔记本内容为空";
        }
        if(title==null||title.trim().isEmpty()){
    		note.setCn_note_title(title);
        }
		note.setCn_note_body(NoteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.updateNote(note);
	}
	public void updateNotebookId(String NoteId, String NotebookId) {
        Note note = noteDao.findNoteByNoteId(NoteId);
        note.setCn_notebook_id(NotebookId);
        noteDao.updateNote(note);
	}


}
