package cn.ideal.portal.controller;

import cn.ideal.portal.service.CommodityDetailService;
import cn.ideal.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author XINER
 * @create 2018-11-27 18:59
 * @desc 页面管理Controller
 **/

@Controller
public class PageController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private CommodityDetailService commodityDetailService;

    @RequestMapping("/")
    public String displayIndex(HttpServletRequest request){
        request.setAttribute("slide", indexService.getSlideContent());
        request.setAttribute("adv", indexService.getAdContent());
        request.setAttribute("hot", indexService.getContentList(Long.valueOf(43)));
        request.setAttribute("recommend", indexService.getContentList(Long.valueOf(45)));
        return "index";
    }

    @RequestMapping("/commodity_detail.html")
    public String displayCommodityDetail(HttpServletRequest request){
        request.setAttribute("commodity", commodityDetailService.getSpuMessage(Long.valueOf(request.getParameter("spuid"))));
        request.setAttribute("spes", commodityDetailService.getSpeSkuMessage(Long.valueOf(request.getParameter("spuid")), request.getParameter("spevs")));
        return "commodity_detail";
    }

    @RequestMapping("/cart.html")
    public String cart(){
        return "cart";
    }
    @RequestMapping("/order.html")
    public String order(){
        return "order";
    }
    @RequestMapping("/orderInfo.html")
    public String orderInfo(){
        return "orderInfo";
    }
}
