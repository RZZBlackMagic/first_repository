package cn.ideal.manager.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("order1/getComFromCookieById/orderManager.do")
    @ResponseBody
    public MessageResult getComFromCookieById(String idList,String numList){
        MessageResult messageResult = orderService.getComFromCookieById(idList,numList);
        return messageResult;
    }

}
