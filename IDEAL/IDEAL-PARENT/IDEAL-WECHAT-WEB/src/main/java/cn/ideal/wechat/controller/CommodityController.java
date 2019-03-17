package cn.ideal.wechat.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
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

    @RequestMapping("/index/index")
    @ResponseBody
    public MessageResult getIndex(){
        return commodityService.getIndex();
    }

    @RequestMapping("/goods/count")
    @ResponseBody
    public Integer getGoodsCount(){
        return commodityService.getGoodsCount();
    }

    @RequestMapping("/goods/list")
    @ResponseBody
    public TableJsonResult getGoodsList(Long cid, String location, Integer page, Integer size){
        return commodityService.getGoodsList(cid, location, page, size);
    }

    @RequestMapping("/goods/detail")
    @ResponseBody
    public Map<String, Object> getGoodDetail(Long id){
        return commodityService.getGoodDetail(id);
    }

    @RequestMapping("/goods/check")
    @ResponseBody
    public MessageResult checkGood(String id){
        return commodityService.checkSku(id);
    }
}
