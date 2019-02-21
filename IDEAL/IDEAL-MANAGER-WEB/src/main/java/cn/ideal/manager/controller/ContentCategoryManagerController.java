package cn.ideal.manager.controller;


import cn.ideal.common.pojo.CommodityContentCategory;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.manager.service.ContentCategoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class ContentCategoryManagerController {

    @Autowired
    private ContentCategoryManagerService contentCategoryManagerService;

    /**
     * 加载商品内容分类Ztree
     *
     * @return
     */
    @RequestMapping("/portal/ztree/contentCategory.do")
    @ResponseBody
    public MessageResult getCommodityCatListForZtree() {
        return contentCategoryManagerService.getCommodityCatListForZtree();
    }

    /**
     * 初始化商品内容分类的bootstrap
     *
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/portal/table/contentCategory.do")
    @ResponseBody
    public TableJsonResult getCommodityCatListForTable(String id, int page, int limit) {
        return contentCategoryManagerService.getCommodityCatListForTable(id, page, limit);
    }

    @RequestMapping("/portal/table/updateContentCategory.do")
    @ResponseBody
    public MessageResult updateContentCategory(CommodityContentCategory commodityContentCategory) {
        return contentCategoryManagerService.updateContentCategory(commodityContentCategory);
    }

    @RequestMapping("/portal/table/deleteContentCategory.do")
    @ResponseBody
    public MessageResult deleteContentCategory(String id, String name) {
        return contentCategoryManagerService.deleteContentCategory(id);
    }

    @RequestMapping("/portal/table/addContentCategory.do")
    @ResponseBody
    public MessageResult addContentCategory(String id, String name) {
        return contentCategoryManagerService.addContentCategory(id, name);
    }


}
