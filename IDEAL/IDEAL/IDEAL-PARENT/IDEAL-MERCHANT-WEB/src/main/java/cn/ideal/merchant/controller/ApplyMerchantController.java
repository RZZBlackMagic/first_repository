package cn.ideal.merchant.controller;

import cn.ideal.common.pojo.RelaMerPro;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.merchant.service.ApplyMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplyMerchantController {
    @Autowired
    private ApplyMerchantService applyMerchantService;

    @RequestMapping("/merchant/getCompanyListForTable/ApplyMerchant")
    @ResponseBody
    public TableJsonResult getCompanyListForTable(Integer limit, Integer page, String search) {
        return applyMerchantService.getCompanyListForTable(limit, page, search);
    }

    @RequestMapping("/merchant/applyCompanyForMer/ApplyMerchant")
    @ResponseBody
    public MessageResult applyCompanyForMer(RelaMerPro relaMerPro) {
        return applyMerchantService.ApplyCompany(relaMerPro);
    }

    @RequestMapping("/manager/getAppliedComListForTable/ApplyMerchant")
    @ResponseBody
    public TableJsonResult getAppliedComListForTable(int limit, int page, Long merchantId) {
        return applyMerchantService.getAppliedComListForTable(limit, page, merchantId);
    }

    @RequestMapping("/manager/getCommdityListForMer/ApplyMerchant")
    @ResponseBody
    public TableJsonResult getCommdityListForMer(int limit, int page, String productorId) {
        return applyMerchantService.getCommdityListForMer(limit, page, productorId);
    }

    @RequestMapping("/manager/ApplyCommodityForMer/ApplyMerchant")
    @ResponseBody
    public MessageResult ApplyCommodityForMer(String id, Long merchantId, Long productorId) {
        return applyMerchantService.ApplyCommodityForMer(id, merchantId, productorId);
    }
}
