package test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestClass {

	@RequestMapping("input.do")
	public String assess(){
		return "TestToLogin";
	}
	@RequestMapping("view.do")
	public String view(test t,HttpServletRequest req){
		Double height = t.getHeight();
		Double weight = t.getWeight();
		Double result = weight/(height*height);
		req.setAttribute("result", result);
		return "view";
	}
	
}
