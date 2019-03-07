package cn.ideal.portal.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/product/index/getSlidePicture")
    @ResponseBody
    public MessageResult getSlidePicture(Long category_id){
        MessageResult messageResult = indexService.getSlidePicture(category_id);
        return messageResult;
    }
    @RequestMapping("/product/index/getMainCategory")
    @ResponseBody
    public MessageResult getMainCategory(Long pid){
        MessageResult messageResult = indexService.getMainCategory(pid);
        return messageResult;
    }

}
