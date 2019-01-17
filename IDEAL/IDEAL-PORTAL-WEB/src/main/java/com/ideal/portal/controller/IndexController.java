package com.ideal.portal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页展示Controller
 */
@Controller
public class IndexController{
    @RequestMapping("/")
    @ResponseBody
    public String displayIndex(){
         return "index";
    }
}