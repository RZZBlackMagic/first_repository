package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteDao {

	public List<Map<String,Object>> findNoteByNotebookId(String NotebookId);
	public void createNewNote(Note note);
	public Note findNoteByNoteId(String NoteId);
	public void updateNote(Note note);
	public int deleteNoteById(String NoteId);
	public void findAllNote();
	public List<Note> selectAllDeleteNote();
	public void addNoteToDeleteNote(Note note);
}
