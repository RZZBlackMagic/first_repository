package cn.ideal.manager.controller;

import cn.ideal.common.results.TableJsonResult;
import cn.ideal.manager.service.MerchantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MerchantManagerController {
    @Autowired
    private MerchantManagerService merchantManagerService;

    @RequestMapping("/manager/getUnRelaMerProListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getUnRelaMerProListForTable(int limit, int page) {
        return merchantManagerService.getUnRelaMerProListForTable(limit, page);
    }

    @RequestMapping("/manager/getRelaMerProListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getRelaMerProListForTable(int limit, int page) {
        return merchantManagerService.getRelaMerProListForTable(limit, page);
    }

    @RequestMapping("/manager/getRelaProMerComListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getRelaProMerComListForTable(int limit, int page) {
        return merchantManagerService.getRelaProMerComListForTable(limit, page);
    }

    @RequestMapping("/manager/getUnRelaProMerComListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getUnRelaProMerComListForTable(int limit, int page) {
        return merchantManagerService.getUnRelaProMerComListForTable(limit, page);
    }
}
