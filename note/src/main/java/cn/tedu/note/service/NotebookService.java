package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

public interface NotebookService {

	List<Map<String,Object>> listNotebooks(String UserId) throws UserNotFoundException;
}
