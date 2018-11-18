package cn.tedu.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.service.NotebookService;
import cn.tedu.note.util.JsonResult;

@Controller
public class NotebookController extends AbatractController {

	@Resource
	private NotebookService notebookService;
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult list(String UserId){
		List<Map<String,Object>> list = notebookService.listNotebooks(UserId);
		return new JsonResult(list);
	}

}
