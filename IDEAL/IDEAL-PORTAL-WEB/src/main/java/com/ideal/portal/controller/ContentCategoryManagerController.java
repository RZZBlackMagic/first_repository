package com.ideal.portal.controller;

import com.ideal.common.pojo.MessageResult;
import com.ideal.common.pojo.TableJsonResult;
import com.ideal.pojo.CommodityContentCategory;
import com.ideal.portal.service.ContentCategoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.resources.Messages_es;

import java.util.List;


@Controller
public class ContentCategoryManagerController {

    @Autowired
    private ContentCategoryManagerService contentCategoryManagerService;

    /**
     * 加载商品内容分类Ztree
     * @return
     */
    @RequestMapping("/portal/ztree/content_category.do")
    @ResponseBody
    public MessageResult showZtreeList(){
        Long parent_id = null;
        List list = contentCategoryManagerService.showZtreeListService( );
        System.out.println(111);
        System.out.println(list);
        return MessageResult.ok(list);
    }

    /**
     * 初始化商品内容分类的bootstrap
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/portal/initTable/contentCategory.do")
    @ResponseBody
    public TableJsonResult initBootstrapTable(String id,int page,int limit){
        System.out.println("Controller_ID："+id);
        List list = contentCategoryManagerService.initBootstrapTableService(id,page,limit);
        System.out.println(list);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setRows(list);
        tableJsonResult.setTotal(list.size());
        return tableJsonResult;
    }

    /**
     * 参数是更新后的商品内容分类信息，将其保存到数据库
     * @param id
     * @param parentId
     * @param name
     * @param status
     * @param sortOrder
     * @param isParent
     * @param created
     * @param updated
     * @return
     */
    @RequestMapping("/portal/bootstrap/editContentCategory.do")
    @ResponseBody
    public MessageResult updateContentCategory(String id,String parentId,String name,String status,String sortOrder,String isParent,String created,String updated ){
        System.out.println("编辑bootstrap");
        System.out.println(id+  parentId+ name+ status+ sortOrder+isParent+ created+ updated);
        String message = contentCategoryManagerService.updateContentCategoryService(id, parentId, name, status, sortOrder, isParent, created, updated);
        return MessageResult.ok(message);
    }

    /**
     * 删除table中选中内容（可能有多个)
     * @param id
     * @return
     */
    @RequestMapping("/portal/bootstrap/removeContentCategory.do")
    @ResponseBody
    public MessageResult removeContentcategory(String id,String name){
        String message = contentCategoryManagerService.removeContentcategoryService(id,name);
        return MessageResult.ok(message);
    }
    @RequestMapping("/portal/bootstrap/addContentCategory.do")
    @ResponseBody
    public MessageResult addContentCategory(String id,String name){
        System.out.println(id+name);
        String message = contentCategoryManagerService.addContentCategoryService(id,name);
        return MessageResult.ok(message);
    }
}
