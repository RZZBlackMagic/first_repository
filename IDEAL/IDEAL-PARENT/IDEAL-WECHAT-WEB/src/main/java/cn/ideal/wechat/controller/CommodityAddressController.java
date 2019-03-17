package cn.ideal.wechat.controller;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;


@Controller
public class CommodityAddressController {

    @Autowired
    private CommodityAddressService commodityAddressService;

    @RequestMapping("/address/list")
    @ResponseBody
    public MessageResult getAddressList(Long uid){
        return commodityAddressService.getAddressList(uid);
    }

    @RequestMapping(value = "/address/save")
    @ResponseBody
    public MessageResult addAddressItem(CommodityAddress address) throws UnsupportedEncodingException {
        return commodityAddressService.addAddressItem(address);
    }

    @RequestMapping(value = "/address/delete")
    @ResponseBody
    public MessageResult deleteAddressItem(Long id) throws UnsupportedEncodingException {
        return commodityAddressService.deleteAddressItem(id);
    }

    @RequestMapping("/address/change")
    @ResponseBody
    public MessageResult changeAddressDefault(Long addressId){
        return commodityAddressService.changeAddressDefault(addressId);
    }

}
