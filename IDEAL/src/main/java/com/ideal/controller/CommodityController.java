package com.ideal.controller;

import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.common.CommodityZtreeJsonResult;
import com.ideal.pojo.Commodity;
import com.ideal.pojo.ZtreeNodesEntity;
import com.ideal.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
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
    @RequestMapping("category/ztree.do")
    @ResponseBody
    public List<ZtreeNodesEntity> getZtreeJsonNodes(){
    	List<ZtreeNodesEntity> list = commodityService.getZtreeJsonNodesService();
        return list;
    }
    @RequestMapping("category/table.do")
    @ResponseBody
    public CommdoityTableJsonResult getTableList(String category_id, int limit, int page){
        CommdoityTableJsonResult commdoityTableJsonResult = commodityService.getProductList(category_id,limit,page);
        return commdoityTableJsonResult;
    }
    @RequestMapping("commodity/editCommodity.do")
    @ResponseBody
    public String editTableList(Long id,String title,String hotpoint,Long price,Integer quantity,Long bid,String image,String position,String category,Byte status,String created,String updated){
    	System.out.println(title);
    	Commodity com = new Commodity();
    	com.setBid(bid);
    	com.setCategory(category);
    	com.setHotpoint(hotpoint);
    	com.setId(id);
    	com.setImage(image);
    	com.setPosition(position);
    	com.setPrice(price);
    	com.setQuantity(quantity);
    	com.setStatus(status);
    	com.setTitle(title);
    	com.setCreated(new Date(Long.valueOf(created)));
    	com.setUpdated(new Date(Long.valueOf(updated)));
    	//System.out.println(com);
    	String message = commodityService.EditCommodity(com);
    	System.out.println(message);
    	return message;
    }
    @RequestMapping("commodity/addGood.do")
    @ResponseBody
    public void addGood(String name,String title ,String price,String quantity,String hitpoint, String status){
    	System.out.println("cid="+name+"title="+title);
    }
    @RequestMapping("commodity/removeGood.do")
    @ResponseBody
    public void removeGood(String title){
    	//System.out.print("title="+title);
    	String message = commodityService.removeGood(title);
    }

}
