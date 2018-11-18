package cn.tedu.note.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.util.JsonResult;

public  class AbatractController {

	

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult Handle(Exception e) {
		e.printStackTrace();
		return new JsonResult(e);
	}

}