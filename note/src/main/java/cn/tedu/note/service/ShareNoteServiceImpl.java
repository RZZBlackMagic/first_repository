package cn.tedu.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.ShareNoteDao;
import cn.tedu.note.entity.CollectNote;
import cn.tedu.note.entity.cn_share_note;
@Service
public class ShareNoteServiceImpl implements ShareNoteService{

	@Resource
	private ShareNoteDao shareNoteDao;
	public List<cn_share_note> loadShareNotesService() {
		List<cn_share_note> list = shareNoteDao.findAllFromShareNote();
		if(list==null){
			throw new RuntimeException("û���ҵ���Ӧ���");
		}
		return list;
	}
	/**
	 * ���ڷ�������潫�ñʼ��ҳ����ڽ���浽�ղر�����
	 */
	public String collectNoteService(String shareId,String userId) {
		cn_share_note note = shareNoteDao.findNoteByShareId(shareId);
		System.out.println(note);
		if(note==null){
			throw new RuntimeException("�ñʼǲ�����");
		}
		CollectNote collectNote = new CollectNote();
		collectNote.setCn_note_id(note.getCn_note_id());
		collectNote.setCn_share_body(note.getCn_share_body());
		collectNote.setCn_share_id(note.getCn_share_id());
		collectNote.setCn_share_title(note.getCn_share_title());
		collectNote.setCn_user_id(userId);
		System.out.println(collectNote);
		int row = shareNoteDao.addNoteToCollectNote(collectNote);
		if(row==0){
			throw new RuntimeException("�ղ�ʧ��!");
		}
		return "�ղسɹ�";
	}
	public List<CollectNote> showCollectNote(String userId) {
		List<CollectNote> list = shareNoteDao.showCollectNotes(userId);
		if(list==null){
			throw new RuntimeException("�����ղرʼ�");
		}
		
		return list;
	}
	public cn_share_note showShareNote(String shareId) {
		cn_share_note shareNote = shareNoteDao.findNoteByShareId(shareId);
		if(shareNote==null){
			throw new RuntimeException("û���ҵ��ñʼ�");
		}
		return shareNote;
	}

}
