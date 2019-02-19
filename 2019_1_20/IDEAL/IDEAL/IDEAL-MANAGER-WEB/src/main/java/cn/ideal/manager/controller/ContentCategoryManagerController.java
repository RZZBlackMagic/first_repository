package cn.ideal.manager.controller;


import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.manager.service.ContentCategoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List list = contentCategoryManagerService.showZtreeListService( );
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
    public TableJsonResult initBootstrapTable(String id, int page, int limit){
        List list = contentCategoryManagerService.initBootstrapTableService(id,page,limit);
        if(list==null){
            //该节点没有子节点，点击该节点就是显示的内容信息
            return new TableJsonResult();
        }else{
            TableJsonResult tableJsonResult = new TableJsonResult();
            tableJsonResult.setRows(list);
            tableJsonResult.setTotal(list.size());
            return tableJsonResult;
        }

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
        String message = contentCategoryManagerService.addContentCategoryService(id,name);
        return MessageResult.ok(message);
    }


}
