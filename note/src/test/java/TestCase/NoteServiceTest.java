package TestCase;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.NotebookNotFoundException;

public class NoteServiceTest extends BaseTest{

	@Test
	public void noteServiceTest() throws NotebookNotFoundException{
		String NotebookId="1";
		NoteService  ns = ctx.getBean("noteService",NoteService.class);
		List<Map<String,Object>> list = ns.listNotes(NotebookId);
		System.out.println(list);
	}
	@Test
	public void createNewNoteTest() throws Exception{
		NoteService ns = ctx.getBean("noteService", NoteService.class);
		Note note = ns.createNewNote(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
		System.out.println(note);
	}
	@Test
	public void saveBody(){
		String NoteId="f6b3e78c-88d4-418a-bc95-f829e38dd533";
        String NoteBody = "ÄãºÃ°¡";
		NoteService ns = ctx.getBean("noteService", NoteService.class);
	    String title = "";
		ns.saveBody(NoteId, NoteBody,title);
		System.out.println(1);
	}
	@Test
	public void updateNotebookId(){
		String NoteId = "1ec185d6-554a-481b-b322-b562485bb8e8";
		String NotebookId="e46239d6-4f54-426c-a448-f7a0d45f9425";
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		ns.updateNotebookId(NoteId, NotebookId);
		System.out.println(1);
	}
	@Test
	public void addStars(){
		String userId = "39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		boolean b = ns.addStars(userId, 5);
		System.out.println(b);
		b=ns.addStars(userId, 6);
		System.out.println(b);
	}

}
