package com.ideal.controller;

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

    /**
     * 首页
     * @return 首页字段
     */
    @RequestMapping("/")
    public String displayIndex(){
        return "manager-category";
    }

    /**
     * 其他页面
     * @param page 页面名称
     * @return 页面名称字段
     */
    @RequestMapping("/{page}")
    public String displayManagerPage(@PathVariable String page){
        return page;
    }
}
