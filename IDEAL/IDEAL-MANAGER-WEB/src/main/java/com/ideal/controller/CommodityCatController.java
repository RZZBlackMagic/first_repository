package com.ideal.controller;

import com.ideal.common.pojo.MessageResult;
import com.ideal.common.pojo.TableJsonResult;
import com.ideal.common.pojo.TreeJsonResult;
import com.ideal.pojo.CommodityCat;
import com.ideal.service.CommodityCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @RequestMapping("category/table/select")
    @ResponseBody
    public TableJsonResult getCategoryByIdForTable(long pid, int page, int limit){
        return commodityCatService.getCategoryByPidForTable(pid, page, limit);
    }

    /**
     * 从 Bootstrap Table 接收的编辑修改请求
     *
     * @param commodityCat 修改的分类条目信息
     * @return MessageResult 反馈消息
     */
    @RequestMapping(value = "category/table/edit", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult editCategoryByPidAndFieldForTable(CommodityCat commodityCat){
        return commodityCatService.editCategoryByPidAndFieldForTable(commodityCat);
    }

    /**
     * 向 zTree 填充分类树
     *
     * @return 全部分类
     */
    @RequestMapping("category/tree/select")
    @ResponseBody
    public List<TreeJsonResult> getCategoryListForTree(){
        return commodityCatService.getCategoryListForTree();
    }

    /**
     * 新增 CommodityCat 商品分类
     *
     * @param commodityCat 商品分类表单
     * @return MessageResult
     */
    @RequestMapping(value = "category/insert", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult insertCategory(CommodityCat commodityCat){
        return commodityCatService.insertCategory(commodityCat);
    }

    /**
     * 删除 CommodityCat List 商品分类列表
     * @param cidList 商品分类id的列表
     * @return MessageResult
     */
    @RequestMapping("category/delete/{cidList}")
    @ResponseBody
    public MessageResult deleteCategory(@PathVariable String cidList){
        //将传过来的字符串切割
        String[] split = cidList.split(",");
        //转成ArrayList<Long>
        ArrayList<Long> result = new ArrayList<>();
        for (String str : split){
            result.add(Long.parseLong(str));
        }
        return commodityCatService.deleteCategory(result);
    }
}
