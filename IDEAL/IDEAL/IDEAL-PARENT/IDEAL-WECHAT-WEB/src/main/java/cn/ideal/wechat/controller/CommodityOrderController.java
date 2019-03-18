package cn.ideal.wechat.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XINER
 * @create 2019-03-04 23:44
 * @desc
 **/
@Controller
public class CommodityOrderController {

    @Autowired
    private CommodityOrderService commodityOrderService;

    @RequestMapping("/order/list")
    @ResponseBody
    public MessageResult getOrderList(Long uid){
        return commodityOrderService.getOrderList(uid);
    }
}
