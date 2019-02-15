package cn.tedu.note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.util.JsonResult;

@Controller
public class SessionController {

	@RequestMapping("session.do")
    @ResponseBody
    public JsonResult KeepSessionLiving(){
		return new JsonResult("session»î×ÅÄØ£¡");
	}
    
}
