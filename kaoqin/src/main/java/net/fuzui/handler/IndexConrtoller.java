package net.fuzui.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexConrtoller {
	
	@RequestMapping(value= {"","/","/index"})
	public String index(Model model) {
		return "/index";
	}
	
}
