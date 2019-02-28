package cn.ideal.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XINER
 * @create 2018-11-27 18:59
 * @desc 页面管理Controller
 **/

@Controller
public class PageController {

    @RequestMapping("/")
    public String displayIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String displayPage(@PathVariable String page){
        return page;
    }
}
