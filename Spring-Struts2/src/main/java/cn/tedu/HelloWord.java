package cn.tedu;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.service.HelloWordService;

@Controller
@Scope("prototype")//让每一个请求都创建一个单独的Action，避免属性重复使用，数据不安全
public class HelloWord {
	@Resource(name="helloService")
	private HelloWordService helloWord;
	private String id;
	Integer i = new Integer(100);
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute(){
		
		
		   System.out.println("COntroller");
		   String message = helloWord.hello();
           return id;
	}
   
}
