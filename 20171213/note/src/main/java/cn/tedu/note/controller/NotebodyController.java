package cn.tedu.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.NotebodyService;
import cn.tedu.note.service.NotebookService;
import cn.tedu.note.util.JsonResult;

@Controller
public class NotebodyController extends AbatractController{

	@Resource
	private NotebodyService notebodyService;
	@RequestMapping("/showText.do")
	@ResponseBody
	public JsonResult showTextController(String NoteId){
		Note text = notebodyService.showText(NoteId);
		return new JsonResult(text);
	}

}
