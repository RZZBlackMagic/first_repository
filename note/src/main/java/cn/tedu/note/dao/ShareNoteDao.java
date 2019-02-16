package cn.tedu.note.dao;

import java.util.List;

import cn.tedu.note.entity.CollectNote;
import cn.tedu.note.entity.cn_share_note;

public interface ShareNoteDao {

	public List<cn_share_note> findAllFromShareNote();
	public cn_share_note findNoteByShareId(String shareId);
	public int addNoteToCollectNote(CollectNote collectNote);
	public List<CollectNote> showCollectNotes(String useId);
}
