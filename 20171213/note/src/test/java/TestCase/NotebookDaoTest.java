package TestCase;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.entity.Notebook;

public class NotebookDaoTest extends BaseTest{

	NotebookDao dao;
	@Before
	public void initDao(){
		dao = ctx.getBean("notebookDao",NotebookDao.class);
	}
	@Test
	public void testNotebookDao(){
		String UserId = "52f9b276-38ee-447f-a3aa-0d54e7a736e4";
		List<Map<String,Object>> list = dao.findNotebooksByUser(UserId); 
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void notebookById(){
		String NotebookId="";
		Notebook notebook = dao.findNotesByNotebookId(NotebookId);
		System.out.println(notebook);
	}
   
}
