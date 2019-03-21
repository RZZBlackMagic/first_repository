package cn.tedu.serviceImpl;

import org.springframework.stereotype.Service;

import cn.tedu.service.HelloWordService;

@Service("helloService")
public class HelloWordServiceImpl implements HelloWordService{

	public String hello() {
		System.out.println("·þÎñ²ã");
		return "success";
	}

}
