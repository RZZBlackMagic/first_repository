package cn.ideal.productor.controller;

import cn.ideal.common.results.TreeJsonResult;
import cn.ideal.productor.service.CommodityCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author XINER
 * @create 2019-01-31 21:36
 * @desc 商品分类Controller
 **/
@Controller
public class CommodityCatController {

    @Autowired
    private CommodityCatService commodityCatService;

    @RequestMapping("/product/tree/category")
    @ResponseBody
    List<TreeJsonResult> getCommodityCatList(long parentID){
        List<TreeJsonResult> list = commodityCatService.getCommodityCatList(parentID);
        return list;
    }
}
