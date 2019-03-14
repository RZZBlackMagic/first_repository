package cn.ideal.manager.controller;

import cn.ideal.common.results.MessageResult;
import cn.ideal.manager.service.CommodityDetailService;
import cn.ideal.manager.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private CommodityDetailService commodityDetailService;
    @Autowired
    private IndexService indexService;
    @RequestMapping("/product/index/getSlidePicture")
    @ResponseBody
    public MessageResult getSlidePicture(Long category_id){
        MessageResult messageResult = indexService.getSlidePicture(category_id);
        return messageResult;
    }
    @RequestMapping("/product/index/getMainCategory")
    @ResponseBody
    public MessageResult getMainCategory(Long pid){
        MessageResult messageResult = indexService.getMainCategory(pid);
        return messageResult;
    }
    @RequestMapping("/commodity_detail.html")
    public String displayCommodityDetail(HttpServletRequest request){
        request.setAttribute("commodity", commodityDetailService.getSpuMessage(Long.valueOf(request.getParameter("spuid"))));
        request.setAttribute("spes", commodityDetailService.getSpeSkuMessage(Long.valueOf(request.getParameter("spuid")), request.getParameter("spevs")));
        return "commodity_detail";
    }
}
