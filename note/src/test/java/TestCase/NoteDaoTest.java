package TestCase;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;

public class NoteDaoTest extends BaseTest{

	@Before
	public void init(){

	}
	@Test
	public void findByNotebookId(){
		String NotebookId = "1db556b9-d1dc-4ed9-8274-45cf0afbe859";
		NoteDao nd = ctx.getBean("noteDao",NoteDao.class);
		List<Map<String,Object>> list = nd.findNoteByNotebookId(NotebookId);
		System.out.println(list);
	}
	@Test
	public void createNoteTest(){
		Note note = new Note();
		Long l = System.currentTimeMillis();
		note.setCn_note_body(null);
		note.setCn_note_create_time(l);
		note.setCn_note_id("1");
		note.setCn_note_last_modify_time(l);
		note.setCn_note_status_id("1");
		note.setCn_note_title("a");
		note.setCn_note_type_id("5");
		note.setCn_notebook_id("2");
		String UserId = UUID.randomUUID().toString();
		note.setCn_user_id("3");
		NoteDao nd = ctx.getBean("noteDao", NoteDao.class);
		nd.createNewNote(note);
		System.out.println(1);
	}
	@Test
	public void findNoteByNoteId(){
		String NoteId = "1b7713a6-863d-4043-a6de-e2e3b989191c";
		NoteDao nd = ctx.getBean("noteDao", NoteDao.class);
		Note note = nd.findNoteByNoteId(NoteId);
		System.out.println(note);
	}
	@Test
	public void saveNote(){
		String NoteId="f6b3e78c-88d4-418a-bc95-f829e38dd533";
		Map<String,String> map =new LinkedHashMap();
		String body = "asd";
		map.put("cn_note_id", NoteId);
		map.put("cn_note_body",body );
		NoteDao nd = ctx.getBean("noteDao", NoteDao.class);
		Note note = nd.findNoteByNoteId(NoteId);
		note.setCn_note_body(body);
		Long l = System.currentTimeMillis();
		note.setCn_note_last_modify_time(l);
		System.out.println(note);
		System.out.println(1);
	}
	@Test
	public void update(){
		String NoteId = "1ec185d6-554a-481b-b322-b562485bb8e8";
		String NotebookId="fa8d3d9d-2de5-4cfe-845f-951041bcc461";
		Note note = new Note();
		note.setCn_note_id(NoteId);
		note.setCn_notebook_id(NotebookId);
		NoteDao nd = ctx.getBean("noteDao",NoteDao.class);
		nd.updateNote(note);
		System.out.println(1);
	}

}
