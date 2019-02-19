package cn.tedu.note.service;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.StarDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.Stars;
import cn.tedu.note.entity.User;
import cn.tedu.note.entity.cn_share_note;
import cn.tedu.note.entity.deleteNotes;
import cn.tedu.note.util.JsonResult;
@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NotebookDao notebookDao;
	@Resource
	private NoteDao noteDao;
	
	public List<Map<String, Object>> listNotes(String NotebookId) throws NotebookNotFoundException   {
		List<Map<String,Object>> notes = noteDao.findNoteByNotebookId(NotebookId);
		if(NotebookId==null||NotebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("NotebookId不能为空");
		}
		Notebook notebook = notebookDao.findNotesByNotebookId(NotebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有该笔记本");
		}
		return notes;
	}
	@Transactional
	public Note createNewNote(String UserID, String cn_notebook_id, String cn_note_title) throws Exception {
		Note note = new Note();
		note.setCn_note_body(null);
		note.setCn_note_create_time(System.currentTimeMillis());
		String cn_note_id = UUID.randomUUID().toString();
		note.setCn_note_id(cn_note_id);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_status_id("1");
		note.setCn_note_title(cn_note_title);
		note.setCn_note_type_id("5");
		note.setCn_notebook_id(cn_notebook_id);
		note.setCn_user_id(UserID);
		noteDao.createNewNote(note);
		Note  backNote = noteDao.findNoteByNoteId(cn_note_id);
		//当前事务会整合到addStar中，整合为一件
		addStars(UserID,5);
		return backNote;
	}
	public void saveBody(String NoteId, String NoteBody,String title) {
		Note note = noteDao.findNoteByNoteId(NoteId);
        if(NoteBody==null||NoteBody.trim().isEmpty()){
        	NoteBody="该笔记本内容为空";
        }
        if(title.trim()!=null){
    		note.setCn_note_title(title.trim());
        }
		note.setCn_note_body(NoteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.updateNote(note);
	}
	public void updateNotebookId(String NoteId, String NotebookId) {
        Note note = noteDao.findNoteByNoteId(NoteId);
        
        noteDao.updateNote(note);
	}
	public String deleteNoteById(String NoteId) {
		Note note = noteDao.findNoteByNoteId(NoteId);
		System.out.println(note);
		deleteNotes deletenote = new deleteNotes();
        deletenote.setCn_note_body(note.getCn_note_body());
        deletenote.setCn_note_create_time(note.getCn_note_create_time());
        deletenote.setCn_note_id(note.getCn_note_id());
        deletenote.setCn_note_last_modify_time(note.getCn_note_last_modify_time());
        deletenote.setCn_note_status_id(note.getCn_note_status_id());
        deletenote.setCn_note_title(note.getCn_note_title());
        deletenote.setCn_notebook_id(note.getCn_notebook_id());
        deletenote.setCn_type_id(note.getCn_note_type_id());
        deletenote.setCn_user_id(note.getCn_user_id());
		noteDao.addNoteToDeleteNote(deletenote);
		int row = noteDao.deleteNoteById(NoteId);
		if(row==1){
			return "删除成功";
		}
		return "删除失败";
	}
	@Resource
	private StarDao starsDao;
	@Resource(name="dao")
	private UserDao userDao;
	@Transactional
	public boolean addStars(String userId, int stars) throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("userId不能为空");
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("没有对应 的用户");
		}
		System.out.println(user);
		Stars star = starsDao.findStarsByUseId(userId);
		if(star==null){
			//执行insert语句，
			System.out.println("insert"+star);
			String id = UUID.randomUUID().toString();
			Stars st = new Stars(id,userId,stars);
			System.out.println(st);
			int n = starsDao.insertStars(st);
			System.out.println(n);
			System.out.println("insert:"+stars);
			if(n!=1){
				throw new  RuntimeException();
			}
			return true;
		}else{
			//有星星，就在现有星星中，执行update，
			int n = star.getCn_stars()+stars;
			star.setCn_stars(n);
			if(n<0){
				throw new RuntimeException("扣分太多");
			}
			System.out.println("update"+star);
			int nn = starsDao.updateStars(star);
			System.out.println("update:"+stars);
			System.out.println(nn);
			/*if(nn!=1){
				System.out.println("错哦了");
				throw new  RuntimeException();
			}*/
			return true;
		}
	}
	public JsonResult showDeleteNote() {
        //
		List<Note> deleteNoteList = noteDao.selectAllDeleteNote();
		if(deleteNoteList==null){
			return new JsonResult("回收站无笔记0");
		}else{
			return new JsonResult(deleteNoteList);
		}
	}
	public String shareNoteService(String selectedNoteId) {
		Note note = noteDao.findNoteByNoteId(selectedNoteId);
		if(note==null){
			throw new RuntimeException("请选择正确的笔记！");
		}
		cn_share_note shareNote1 = noteDao.findShareNote(selectedNoteId);
		if(shareNote1!=null){
			throw new RuntimeException("该笔记已添加至共享笔记");
		}
		cn_share_note  shareNote = new cn_share_note();
		shareNote.setCn_note_id(selectedNoteId);
		shareNote.setCn_share_body(note.getCn_note_body());
		String cn_share_id =UUID.randomUUID().toString();
		
		shareNote.setCn_share_id(cn_share_id);
		shareNote.setCn_share_title(note.getCn_note_title());
		//向share表里面添加
		noteDao.addNoteToShareNote(shareNote);
		return "添加成功";
	}
	/**
	 * 先在回收站将该笔记本查出来，在将其在回收站删除，最后将其添加至note表里面
	 */
	public String replayDelNoteService(String noteId, String notebookId) {
        deleteNotes delNote = noteDao.findDelNoteByNoteId(noteId);
        int row = noteDao.deleteNotesFromDel(noteId);
        if(row==0){
        	throw new RuntimeException("移动失败");
        }
        Note note = new Note();
        note.setCn_notebook_id(notebookId);
        note.setCn_note_body(delNote.getCn_note_body());
        note.setCn_note_create_time(delNote.getCn_note_create_time());
        note.setCn_note_id(noteId);
        note.setCn_note_last_modify_time((System.currentTimeMillis()));
        note.setCn_note_status_id(delNote.getCn_note_status_id());
        note.setCn_note_title(delNote.getCn_note_title());
        note.setCn_user_id(delNote.getCn_user_id());
        note.setCn_note_type_id(delNote.getCn_type_id());
        noteDao.createNewNote(note);
		return "移动成功！";
	}


}
