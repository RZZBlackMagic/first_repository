package cn.ideal.merchant.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.common.pojo.TreeJsonResult;
import cn.ideal.merchant.service.ApplyMerchantService;
import cn.ideal.pojo.RelaMerPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.util.List;

@Controller
public class ApplyMerchantController {
    @Autowired
    private ApplyMerchantService applyMerchantService;
    @RequestMapping("/merchant/getCompanyListForTable/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult getCompanyListForTable(Integer limit, Integer page, String search){
        return applyMerchantService.getCompanyListForTable(limit,page,search);
    }
    @RequestMapping("/merchant/applyCompanyForMer/ApplyMerchant.do")
    @ResponseBody
    public MessageResult applyCompanyForMer(RelaMerPro relaMerPro){
        return applyMerchantService.ApplyCompany(relaMerPro);
    }
    @RequestMapping("/manager/getAppliedComListForTable/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult getAppliedComListForTable(int limit,int page,Long merchantId){
        System.out.println("***************************"+merchantId);
        return applyMerchantService.getAppliedComListForTable(limit,page,merchantId);
    }
    @RequestMapping("/manager/getCommdityListForMer/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult getCommdityListForMer(int limit,int page,String productorId){
        return applyMerchantService.getCommdityListForMer(limit,page,productorId);
    }
    @RequestMapping("/manager/ApplyCommodityForMer/ApplyMerchant.do")
    @ResponseBody
    public MessageResult ApplyCommodityForMer(String id,Long merchantId,Long productorId,String productorName,String merchantName){
        return applyMerchantService.ApplyCommodityForMer(id,merchantId,productorId,productorName,merchantName);
    }
}
