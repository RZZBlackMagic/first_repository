package com.ideal.controller;

import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.pojo.Commodity;
import com.ideal.pojo.ZtreeNodesEntity;
import com.ideal.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("category/{id}")
    @ResponseBody
    public Commodity getCommodityById(@PathVariable long id){
        Commodity commodity = commodityService.getCommodityById(id);

        return commodity;
    }
    @RequestMapping("category/ztree")
    @ResponseBody
    public List getZtreeJsonNodes(){
        List<ZtreeNodesEntity> list = commodityService.getZtreeJsonNodesService();
        return list;
    }
    @RequestMapping("category/table")
    @ResponseBody
    public CommdoityTableJsonResult getTableList(String category_id, int limit, int page){
        CommdoityTableJsonResult commdoityTableJsonResult = commodityService.getProductList(category_id,limit,page);
        return commdoityTableJsonResult;
    }

}
