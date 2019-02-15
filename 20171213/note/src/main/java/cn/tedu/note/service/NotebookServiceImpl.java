package cn.tedu.note.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.User;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService{

	@Resource
	private NotebookDao notebookDao;
	@Resource
	private UserDao userDao;
	public List<Map<String, Object>> listNotebooks(String UserId) throws UserNotFoundException {
		if(UserId==null||UserId.trim().isEmpty()){
			throw new UserNotFoundException();
		}
        List<Map<String,Object>> list = notebookDao.findNotebooksByUser(UserId);
        User user = userDao.findUserById(UserId);
        if(user==null){
        	throw new UserNotFoundException("用户不存在");
        }
		return list;
	}
	public Notebook addNotebook(String title,String UserId) {
        Notebook notebook = new Notebook();
        notebook.setCn_user_id(UserId);
        notebook.setCn_notebook_name(title);
        String NotebookId = UUID.randomUUID().toString();
        notebook.setCn_notebook_id(NotebookId);
        notebook.setCn_notebook_type_id("5");
        Timestamp cn_notebook_createtime = new Timestamp(System.currentTimeMillis());
        notebook.setCn_notebook_createtime(cn_notebook_createtime);
        //服务层调用持久层
        notebookDao.addNotebook(notebook);
        return notebook;
	}

}
