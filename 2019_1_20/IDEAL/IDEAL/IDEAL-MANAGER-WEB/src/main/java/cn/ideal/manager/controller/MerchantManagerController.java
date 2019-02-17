package cn.ideal.manager.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.manager.service.MerchantManagerService;
import cn.ideal.pojo.RelaMerchantProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MerchantManagerController {
    @Autowired
    private MerchantManagerService merchantManagerService;
    @RequestMapping("/manager/initTable/selectApplyMerchant.do")
    public MessageResult initMerchantApply(){
        System.out.println("人之前按这个号");
        List<RelaMerchantProductor> list = merchantManagerService.initMerchantApplyTable();
        System.out.println("1****************"+list);
        return MessageResult.ok(list);
    }
}
