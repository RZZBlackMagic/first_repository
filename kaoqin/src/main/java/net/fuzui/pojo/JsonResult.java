package net.fuzui.pojo;

import java.io.Serializable;

public class JsonResult implements Serializable{

	public static final int SUCCESS = 200;
	public static final int ERROR = 302;
	private int state;//200:成功 300：失败״̬
	private String message;//������Ϣ
	private Object data;//
	public JsonResult() {
	}
	public JsonResult(Object data){
		state=SUCCESS;
		this.data=data;
	}
	public JsonResult(String error){
		state=ERROR;
		this.message=error;
	}
	public JsonResult(Throwable e ){
		state=ERROR;
		message = e.getMessage();
	}
	public JsonResult(int state,Throwable e){
		this.state=state;
		this.message = e.getMessage();
	}
	public JsonResult(int state,String message){
		this.state=state;
		this.message = message;
	}
	public JsonResult(int state,Object data){
		this.state=state;
		this.data = data;
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
