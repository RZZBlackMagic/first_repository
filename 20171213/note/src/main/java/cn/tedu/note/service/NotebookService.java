package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Notebook;

public interface NotebookService {

	List<Map<String,Object>> listNotebooks(String UserId) throws UserNotFoundException;
	Notebook addNotebook(String title,String UserId);
}
