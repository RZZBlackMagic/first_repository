package cn.tedu.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.NotebookNotFoundException;
import cn.tedu.note.util.JsonResult;

@Controller
public class NoteController extends AbatractController{

	@Resource
	private NoteService noteService;
	@RequestMapping("/Notelist.do")
	@ResponseBody
	public JsonResult listNotes(String NotebookId) throws NotebookNotFoundException{
		List<Map<String,Object>> list = noteService.listNotes(NotebookId);
		return new JsonResult(list);
	}
	@RequestMapping("/addNote.do")
	@ResponseBody
	public JsonResult addNote(String UserID, String cn_notebook_id, String cn_note_title) throws Exception{
		Note note = noteService.createNewNote(UserID, cn_notebook_id, cn_note_title);
		return new JsonResult(note);
	}
	@RequestMapping("/saveBody.do")
	@ResponseBody
	public JsonResult saveBody(String NoteId,String NoteBody,String title){
		noteService.saveBody(NoteId, NoteBody, title);
		return new JsonResult("修改成功");
	}
	@RequestMapping("/updateNotebookId.do")
	@ResponseBody
	public JsonResult updateNotebookId(String NoteId,String NotebookId){
		noteService.updateNotebookId(NoteId, NotebookId);
		return new JsonResult("移动成功");
	}

}
