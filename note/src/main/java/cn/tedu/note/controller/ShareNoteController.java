package cn.tedu.note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.CollectNote;
import cn.tedu.note.entity.cn_share_note;
import cn.tedu.note.service.ShareNoteService;
import cn.tedu.note.util.JsonResult;

@Controller
public class ShareNoteController {

	@Resource
	private ShareNoteService shareNoteService;
	@RequestMapping("/listShareNote.do")
	@ResponseBody
	public JsonResult loadShareController(){
		List<cn_share_note> list = shareNoteService.loadShareNotesService();
		return new JsonResult(list);
	}
	@RequestMapping("/collectNote.do")
	@ResponseBody
	public JsonResult collectNoteController(String shareId,String userId){
		String message = shareNoteService.collectNoteService(shareId,userId);
		return new JsonResult(message);
	}
	@RequestMapping("/showCollectNotes.do")
	@ResponseBody
	public JsonResult showCollectController(String userId){
		List<CollectNote> list = shareNoteService.getCollectNote(userId);
		return new JsonResult(list);
	}
	@RequestMapping("/showShareNoteBody.do")
	@ResponseBody
	public JsonResult showShareNoteController(String shareId){
		cn_share_note shareNote = shareNoteService.showShareNote(shareId);
		return new JsonResult(shareNote);
	}
	@RequestMapping("/showShareNote.do")
	@ResponseBody
	public JsonResult showCollectNote(String NoteId){
		CollectNote collectNote = shareNoteService.showCollectNote(NoteId);
		return new JsonResult(collectNote);
	}
}
