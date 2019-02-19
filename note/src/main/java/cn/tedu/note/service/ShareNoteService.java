package cn.tedu.note.service;

import java.util.List;

import cn.tedu.note.entity.CollectNote;
import cn.tedu.note.entity.cn_share_note;

public interface ShareNoteService {

	public List<cn_share_note> loadShareNotesService();
	public String collectNoteService(String shareId,String userId);
	public List<CollectNote> getCollectNote(String userId);
	public cn_share_note showShareNote(String shareId);
	public CollectNote showCollectNote(String NoteId);
}
