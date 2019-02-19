package cn.ideal.manager.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.manager.service.MerchantManagerService;
import cn.ideal.pojo.RelaMerPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MerchantManagerController {
    @Autowired
    private MerchantManagerService merchantManagerService;
    @RequestMapping("/manager/getUnRelaMerProListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getUnRelaMerProListForTable(int limit,int page){
        TableJsonResult tableJsonResult = merchantManagerService.getUnRelaMerProListForTable(limit,page);
        return tableJsonResult;
    }
    @RequestMapping("/manager/getRelaMerProListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getRelaMerProListForTable(int limit ,int page){
        TableJsonResult tableJsonResult = merchantManagerService.getRelaMerProListForTable(limit,page);
        return tableJsonResult;
    }
    @RequestMapping("/manager/getRelaProMerComListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getRelaProMerComListForTable(int limit,int page){
        TableJsonResult tableJsonResult = merchantManagerService.getRelaProMerComListForTable(limit,page);
        return tableJsonResult;
    }
    @RequestMapping("/manager/getUnRelaProMerComListForTable/relaManager.do")
    @ResponseBody
    public TableJsonResult getUnRelaProMerComListForTable(int limit,int page){
        TableJsonResult tableJsonResult = merchantManagerService.getUnRelaProMerComListForTable(limit,page);
        return tableJsonResult;
    }
}
