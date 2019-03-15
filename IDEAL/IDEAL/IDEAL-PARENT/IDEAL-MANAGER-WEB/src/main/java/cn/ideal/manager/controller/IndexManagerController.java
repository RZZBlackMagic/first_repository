package cn.ideal.manager.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.search.service.SearchCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XINER
 * @create 2019-02-24 12:00
 * @desc
 **/
@Controller
public class IndexManagerController {

    @Autowired
    private SearchCommodityService searchCommodityService;

    @RequestMapping("/index/import")
    @ResponseBody
    public MessageResult importCommoditiesToIndex(){
        return searchCommodityService.importCommoditiesToIndex();
    }
}
