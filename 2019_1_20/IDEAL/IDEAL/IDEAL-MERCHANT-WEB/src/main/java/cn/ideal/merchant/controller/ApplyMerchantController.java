package cn.ideal.merchant.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.common.pojo.TreeJsonResult;
import cn.ideal.merchant.service.ApplyMerchantService;
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
    @RequestMapping("/merchant/initProductorTable/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult SearchCompanyForTable(String limit, String page, String search){
        System.out.println("Controller*******"+search);
        List list = applyMerchantService.SearchCompanyForTable(limit,page,search);
        System.out.println("********"+list);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setRows(list);
        tableJsonResult.setTotal(list.size());
        return tableJsonResult;
    }
    @RequestMapping("/merchant/ApplyCompany/ApplyMerchant.do")
    @ResponseBody
    public MessageResult applyCompanyController(Long merchantId,String merchantName,Long productorId,String productorName ){
        System.out.println("******************"+merchantId+merchantName);
        String message = applyMerchantService.ApplyCompany(merchantId,merchantName,productorId,productorName);
        System.out.println(message);
        return new MessageResult(message);
    }
    @RequestMapping("/manager/initAlliedTable/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult initAppliedComTable(int limit,int page,Long merchantId){
        List list = applyMerchantService.initAppliedComTable(limit,page,merchantId);
        System.out.println("***************"+list);
        System.out.println(merchantId);
        TableJsonResult tableJsonResult = new TableJsonResult();
        tableJsonResult.setTotal(list.size());
        tableJsonResult.setRows(list);
        return tableJsonResult;
    }
    @RequestMapping("/manager/findAllCommodity/ApplyMerchant.do")
    @ResponseBody
    public TableJsonResult getCommdityForMer(String productorId){
        return null;
    }
}
