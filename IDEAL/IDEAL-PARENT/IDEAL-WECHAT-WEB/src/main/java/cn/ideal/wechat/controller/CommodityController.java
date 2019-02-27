package cn.ideal.wechat.controller;

import cn.ideal.wechat.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/goods/count")
    @ResponseBody
    public Integer getGoodsCount(){
        return commodityService.getGoodsCount();
    }


}
