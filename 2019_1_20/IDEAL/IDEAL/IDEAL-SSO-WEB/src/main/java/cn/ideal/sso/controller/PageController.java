package cn.ideal.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 展示页面
     * @param page 页面名称
     * @return 页面名称字段
     */
    @RequestMapping("/{page}")
    public String displayPage(@PathVariable String page){
        return page;
    }
}
