package cn.ideal.productor.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.productor.service.MerchantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MerchantManagerController {

    @Autowired
    private MerchantManagerService merchantManagerService;

    @RequestMapping(value = "/product/table/merchant_apply", method = RequestMethod.POST)
    @ResponseBody
    public TableJsonResult getMerchantApplyList(Integer limit, Integer page, Long product_id){
        return merchantManagerService.getMerchantApplyList(limit, page, product_id);
    }

    @RequestMapping(value = "/product/table/merchant_manage", method = RequestMethod.POST)
    @ResponseBody
    public TableJsonResult getMerchantManageList(Integer limit, Integer page, Long product_id){
        return merchantManagerService.getMerchantManageList(limit, page, product_id);
    }

    @RequestMapping(value = "/product/handle/merchant_apply", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult handleMerchantApply(Long product_id, String merchant_id, String option){
        return merchantManagerService.handleMerchantApply(product_id, merchant_id, option);
    }
}
