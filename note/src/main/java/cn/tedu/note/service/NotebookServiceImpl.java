package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
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

}
