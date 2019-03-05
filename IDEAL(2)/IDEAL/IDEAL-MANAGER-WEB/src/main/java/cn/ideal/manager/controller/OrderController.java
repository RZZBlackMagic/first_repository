package cn.ideal.manager.controller;

import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.results.MessageResult;
import cn.ideal.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("order1/getComFromCookieById/orderManager.do")
    @ResponseBody
    public MessageResult getComFromCookieById(String idList,String numList){
        MessageResult messageResult = orderService.getComFromCookieById(idList,numList);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrder/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrder(CommodityOrder commodityOrder){
        MessageResult messageResult = orderService.insertIntoCommodityOrder(commodityOrder);
        return messageResult;
    }
    @RequestMapping("order/updateCommodityOrder/orderManager.do")
    @ResponseBody
    public MessageResult updateCommodityOrder(String id,String shippingCode,String shippingName){
        MessageResult messageResult = orderService.updateCommodityOrder(id,shippingCode,shippingName);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrderItem/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrderItem(CommodityOrderItem commodityOrderItem){
        MessageResult messageResult = orderService.insertIntoCommodityOrderItem(commodityOrderItem);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrderShipping/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrderShipping(CommodityOrderShipping commodityOrderShipping){
        MessageResult messageResult = orderService.insertIntoCommodityOrderShipping(commodityOrderShipping);
        return messageResult;
    }

}
