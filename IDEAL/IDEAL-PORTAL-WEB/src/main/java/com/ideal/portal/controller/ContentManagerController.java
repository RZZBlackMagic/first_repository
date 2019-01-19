package com.ideal.portal.controller;

import com.ideal.common.pojo.MessageResult;
import com.ideal.common.pojo.TableJsonResult;
import com.ideal.portal.service.ContentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentManagerController {

    @Autowired
    private ContentManagerService contentManagerService;

    /**
     * 初始化内容table
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/portal/initTable/content.do")
    @ResponseBody
    public TableJsonResult initTable(String id,Integer page,Integer limit){
        TableJsonResult tableJsonResult = contentManagerService.initContentTableService(id,page,limit);
        return tableJsonResult;
    }
    @RequestMapping("/protal/content/addContent.do")
    @ResponseBody
    public MessageResult addContent(String categoryId,String title,String subTitle,String titleDesc,String url ,String pic,String pic2 ,String content ){
        String message = contentManagerService.addContent(categoryId,title,subTitle,titleDesc,url,pic,pic2,content);
        return MessageResult.ok(message);
    }
    @RequestMapping("/protal/bootstrap/deleteContent.do")
    @ResponseBody
    public MessageResult deleteContent(String id){
        System.out.println("*********"+id);
        String message = contentManagerService.deleteContentService(id);

        return  MessageResult.ok(message);
    }
    @RequestMapping("/portal/content/editContent.do")
    @ResponseBody
    public MessageResult editContentController(String id,String categoryId,String title,String subTitle,String titleDesc,String url,String pic,String pic2,String content){
        System.out.println("*************************"+title+subTitle+titleDesc);
        String message = contentManagerService.editContentService(id,categoryId,title,subTitle,titleDesc,url,pic,pic2,content);
        return MessageResult.ok(message);
    }

}
