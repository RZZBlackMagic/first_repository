package com.ideal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示Controller
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String displayIndex(){
        return "category";
    }

    @RequestMapping("/{page}")
    public String displayManagerPage(@PathVariable String page){
        return page;
    }
}
