package cn.ideal.productor.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.productor.service.CommoditySpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author XINER
 * @create 2019-02-08 12:26
 * @desc
 **/
@Controller
public class CommoditySpeController {

    @Autowired
    private CommoditySpeService commoditySpeService;

    @RequestMapping("/product/spe/selects")
    @ResponseBody
    public MessageResult getSpeBySkuId(Long id){
        return commoditySpeService.getSpeSpevBySpuId(id);
    }
}
