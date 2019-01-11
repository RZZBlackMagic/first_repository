package com.ideal.controller;

import com.ideal.common.CommdoityTableJsonResult;
import com.ideal.common.CommodityZtreeJsonResult;
import com.ideal.common.MessageResult;
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
    /**
     * 加载Ztree列表
     * @return
     */
    @RequestMapping("category/ztree.do")
    @ResponseBody
    public List<ZtreeNodesEntity> getZtreeJsonNodes(){
    	List<ZtreeNodesEntity> list = commodityService.getZtreeJsonNodesService();
        return list;
    }
    /**
     * 加载商品信息在bootstrap-table区域
     * @param category_id
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("category/table.do")
    @ResponseBody
    public CommdoityTableJsonResult getTableList(String category_id, int limit, int page){
        CommdoityTableJsonResult commdoityTableJsonResult = commodityService.getProductList(category_id,limit,page);
        return commdoityTableJsonResult;
    }
    /**
     * 编辑商品信息
     * @param id
     * @param title
     * @param hotpoint
     * @param price
     * @param quantity
     * @param bid
     * @param image
     * @param position
     * @param category
     * @param status
     * @param created
     * @param updated
     * @return
     */
    @RequestMapping("commodity/editCommodity.do")
    @ResponseBody
    public MessageResult editTableList(Long id,String title,String hotpoint,Long price,Integer quantity,Long bid,String image,String position,String category,Byte status,String created,String updated){
    	System.out.println(title);
    	//System.out.println(com);
    	String message = commodityService.EditCommodity( id, title, hotpoint, price, quantity, bid, image, position, category, status, created, updated);
    	//System.out.println(message);
    	return MessageResult.build(200, message);
    }
    /**
     * 添加商品
     * @param name
     * @param title
     * @param price
     * @param quantity
     * @param hotpoint
     * @param status
     * @return
     */
    @RequestMapping("commodity/addGood.do")
    @ResponseBody
    public MessageResult addGood(String name,String title ,String price,String quantity,String hotpoint, String status){
    	System.out.println("cid="+name+"title="+title);
    	String message = commodityService.addGood(name, title, price, quantity, hotpoint, status);
    	//System.out.println("controller="+message);
    	return MessageResult.build(200, message);
    }
    /**
     * 删除商品
     * @param title
     * @return
     */
    @RequestMapping("commodity/removeGood.do")
    @ResponseBody
    public MessageResult removeGood(String title){
    	//System.out.print("title="+title);
    	String message = commodityService.removeGood(title);
    	//System.out.println(message);
    	return MessageResult.build(200, message);
    }

}
