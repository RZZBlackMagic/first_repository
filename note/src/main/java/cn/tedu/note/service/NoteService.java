package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteService {

	public List<Map<String,Object>> listNotes(String NotebookId) throws NotebookNotFoundException;
    public Note createNewNote(String UserID,String cn_note_id,String cn_note_title) throws Exception;
    public void saveBody(String NoteId,String NoteBody,String title);
    public void updateNotebookId(String NoteId,String NotebookId);
}