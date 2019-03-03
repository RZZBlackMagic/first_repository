package cn.ideal.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 展示 SSO 首页
     * @return index
     */
    @RequestMapping("/{page}")
    public String displayPage(@PathVariable String page){
        return page;
    }
}
