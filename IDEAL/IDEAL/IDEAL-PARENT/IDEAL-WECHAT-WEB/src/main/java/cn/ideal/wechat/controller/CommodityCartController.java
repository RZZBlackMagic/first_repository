package cn.ideal.wechat.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * @author XINER
 * @create 2019-03-03 14:05
 * @desc
 **/
@Controller
public class CommodityCartController {

    @Autowired
    private CommodityCartService commodityCartService;

    @RequestMapping("/cart/index")
    @ResponseBody
    public Map<String, Object> getCartList(Long uid) {
        return commodityCartService.getCartList(uid);
    }

    @RequestMapping("/cart/checked")
    @ResponseBody
    public MessageResult checkCartList(String cartIds, Byte isChecked) {
        return commodityCartService.checkCartList(cartIds, isChecked);
    }

    @RequestMapping("/cart/update")
    @ResponseBody
    public MessageResult updateCart(Long id, Integer number){
        return commodityCartService.updateCart(id, number);
    }

    @RequestMapping("/cart/delete")
    @ResponseBody
    public MessageResult deleteCart(String cartIds){
        return commodityCartService.deleteCart(cartIds);
    }

    @RequestMapping("/cart/checkout")
    @ResponseBody
    public MessageResult checkoutCart(Long uid){
        return commodityCartService.checkOutCart(uid);
    }

}
