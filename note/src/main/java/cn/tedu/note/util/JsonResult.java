package cn.tedu.note.util;

import java.io.Serializable;

import cn.tedu.note.service.UserNotFoundException;

public class JsonResult implements Serializable {

	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	private int state;//登录状态
	private String message;//错误信息
	private Object data;//正确信息
	public JsonResult() {
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
	}
	public JsonResult(Throwable e ){
		state=ERROR;
		message = e.getMessage();
	}
	public JsonResult(int state,Throwable e){
		this.state=state;
		this.message = e.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	

}
