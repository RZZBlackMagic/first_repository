package TestCase;

import java.sql.Date;

import org.junit.Test;

import cn.tedu.note.dao.NotebodyDao;
import cn.tedu.note.entity.Note;

public class NotebodyTest extends BaseTest{

	@Test
	public void findNotebodyByNoteId(){
		String NoteId = "c9250b3e-ed22-432c-960a-175dbc2134d1";
		NotebodyDao nbd = ctx.getBean("notebodyDao",NotebodyDao.class);
		Note text = nbd.findNotebodyByNoteId(NoteId);
		System.out.println(text);
	}
	

}
