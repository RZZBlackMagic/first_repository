package cn.ideal.productor.controller;

import cn.ideal.common.pojo.CommoditySku;
import cn.ideal.common.results.CommodityJsonResult;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.SKUResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.productor.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/product/commodity/add", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult addCommodity(CommodityJsonResult commodity){
        return commodityService.addCommodity(commodity);
    }

    @RequestMapping("/product/commodity/table")
    @ResponseBody
    public TableJsonResult getCommodityList(Integer limit, Integer page, Long apid) {
        return commodityService.getCommodityList(limit, page, apid);
    }

    @RequestMapping("/product/sku/table")
    @ResponseBody
    public TableJsonResult getSkuList(Integer limit, Integer page, Long spu) {
        return commodityService.getSkuList(limit, page, spu);
    }

    @RequestMapping("/product/sku/add")
    @ResponseBody
    public MessageResult getSkuList(Long id, String data) {
        return commodityService.addSku(id, data);
    }

    @RequestMapping(value = "/product/sku/edit", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult editSkuForTable(SKUResult skuResult){
        return commodityService.editSkuForTable(skuResult);
    }

    @RequestMapping(value = "/product/sku/edit_desc", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult editSkuForDesc(Long id, String image, String desc){
        return commodityService.editSkuForDesc(id, image, desc);
    }
}
