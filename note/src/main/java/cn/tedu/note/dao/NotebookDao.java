package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Notebook;

public interface NotebookDao {

	List<Map<String,Object>> findNotebooksByUser(String UserId);
	public Notebook findNotesByNotebookId(String NotebookId);
    public void addNotebook(Notebook notebook);	
}
