package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/ary.do")
	@ResponseBody
	//会自动的将返回结果的JavaBean转换为json字符串发送到浏览器客户端，底层用力Jackson API
	public Object test(){
		String[] ary = {"lhh","xe","xd"};
		return ary;
	}
	
	@RequestMapping("/bean.do")
	@ResponseBody
	//将JavaBean作为返回值，ResponseBody注解将bean转换为json字符串发送到浏览器客户顿
	public Object bean(){
		return new admin("rzz",8,99.9);
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	//返回同一类型的多个对象时，就把他做成集合来返回
	public List<admin> list(){
		List<admin> l = new ArrayList<admin>();
		l.add(new admin("ee",8,88.8));
		l.add(new admin("ee",8,88.8));
		return l;
	}
	
	@RequestMapping("/map.do")
	@ResponseBody
	//返回多个不同类型的对象时，就放进map返回
	public Map map(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("对象一", new admin("ee",8,88.8) );
		map.put("对象二", "hah");
		return map;
	}
	
	//也可以在list里面套上map
	
	
	
}
