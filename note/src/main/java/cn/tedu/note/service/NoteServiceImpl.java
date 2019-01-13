package cn.tedu.note.service;

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
@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NotebookDao notebookDao;
	@Resource
	private NoteDao noteDao;
	public List<Map<String, Object>> listNotes(String NotebookId) throws NotebookNotFoundException   {
		List<Map<String,Object>> notes = noteDao.findNoteByNotebookId(NotebookId);
		if(NotebookId==null||NotebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("NotebookId����Ϊ��");
		}
		Notebook notebook = notebookDao.findNotesByNotebookId(NotebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("û�иñʼǱ�");
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
		//��ǰ��������ϵ�addStar�У�����Ϊһ��
		addStars(UserID,5);
		return backNote;
	}
	public void saveBody(String NoteId, String NoteBody,String title) {
		Note note = noteDao.findNoteByNoteId(NoteId);
        if(NoteBody==null||NoteBody.trim().isEmpty()){
        	NoteBody="�ñʼǱ�����Ϊ��";
        }
        if(title==null||title.trim().isEmpty()){
    		note.setCn_note_title(title);
        }
		note.setCn_note_body(NoteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.updateNote(note);
	}
	public void updateNotebookId(String NoteId, String NotebookId) {
        Note note = noteDao.findNoteByNoteId(NoteId);
        note.setCn_notebook_id(NotebookId);
        noteDao.updateNote(note);
	}
	public String deleteNoteById(String NoteId) {
		int row = noteDao.deleteNoteById(NoteId);
		if(row==1){
			return "ɾ���ɹ�";
		}
		return "ɾ��ʧ��";
	}
	@Resource
	private StarDao starsDao;
	@Resource(name="dao")
	private UserDao userDao;
	@Transactional
	public boolean addStars(String userId, int stars) throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("userId����Ϊ��");
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("û�ж�Ӧ ���û�");
		}
		System.out.println(user);
		Stars star = starsDao.findStarsByUseId(userId);
		if(star==null){
			//ִ��insert��䣬
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
			//�����ǣ��������������У�ִ��update��
			int n = star.getCn_stars()+stars;
			star.setCn_stars(n);
			if(n<0){
				throw new RuntimeException("�۷�̫��");
			}
			System.out.println("update"+star);
			int nn = starsDao.updateStars(star);
			System.out.println("update:"+stars);
			System.out.println(nn);
			/*if(nn!=1){
				System.out.println("��Ŷ��");
				throw new  RuntimeException();
			}*/
			return true;
		}
	}


}
