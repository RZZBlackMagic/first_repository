package cn.ideal.manager.controller;

import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.results.TreeJsonResult;
import cn.ideal.manager.service.CommodityCatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author XINER
 * @create 2018-11-27 19:27
 * @desc 商品分类--Controller
 **/

@Controller
public class CommodityCatController {

    /**
     * 商品分类Mapper
     */
    @Autowired
    private CommodityCatService commodityCatService;

    /**
     * 向 Bootstrap Table 填充的分类表单
     * @param pid 按父类Pid检索
     * @return 父类的子分类
     */
    @RequestMapping("/manager/initTable/commodityCategory.do")
    @ResponseBody
    public TableJsonResult getCategoryByIdForTable(String pid, int page, int limit){
        return commodityCatService.getCategoryByPidForTable(Long.valueOf(pid), page, limit);
    }

    /**
     * 从 Bootstrap Table 接收的编辑修改请求
     *
     * @param commodityCat 修改的分类条目信息
     * @return MessageResult 反馈消息
     */
    @RequestMapping("/manager/bootstrap/editCommodityCategory.do")
    @ResponseBody
    public MessageResult editCategoryByPidAndFieldForTable(CommodityCat commodityCat){
        return commodityCatService.editCategoryByPidAndFieldForTable(commodityCat);
    }


    /**
     * 向 zTree 填充分类树
     *
     * @return 全部分类
     */
    @RequestMapping("/manager/ztree/commodityCate.do")
    @ResponseBody
    public List<TreeJsonResult> getCategoryListForTree(){
        return commodityCatService.getCategoryListForTree();
    }

    /**
     * 新增 CommodityCat 商品分类
     *
     * @param pid
     * @param name
     * @return MessageResult
     */
    @RequestMapping("/manager/bootstrap/commodityCat.do")
    @ResponseBody
    public MessageResult insertCategory(String name, Long pid){
        return commodityCatService.insertCategory(name,pid);
    }

    /**
     * 删除 CommodityCat List 商品分类列表
     * @param id
     * @param pid
     * @return MessageResult
     */
    @RequestMapping("/manager/bootstrap/removeCate.do")
    @ResponseBody
    public MessageResult deleteCategory(String id, Long pid){
        return commodityCatService.deleteCategory(id, pid);
    }
}
