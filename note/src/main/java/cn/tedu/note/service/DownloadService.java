package cn.tedu.note.service;

import cn.tedu.note.entity.Note;

public interface DownloadService {

	public Note download(String noteId,String path) throws Exception ;
}
