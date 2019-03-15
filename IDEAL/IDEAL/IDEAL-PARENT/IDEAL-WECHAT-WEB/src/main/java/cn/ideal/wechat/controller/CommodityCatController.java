package cn.ideal.wechat.controller;

import cn.ideal.wechat.service.CommodityCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CommodityCatController {

    @Autowired
    private CommodityCatService commodityCatService;

    @RequestMapping("/catalog/index")
    @ResponseBody
    public Map<String, Object> CatalogList() throws Exception {
        return commodityCatService.catalogList();
    }

    @RequestMapping("/catalog/current")
    @ResponseBody
    public Map<String, Object> CatalogCurrent(Long id) throws Exception {
        return commodityCatService.catalogCurrent(id);
    }

    @RequestMapping("/goods/category")
    @ResponseBody
    public Map<String, Object> getGoodsBrotherCategory(Long id){
        return commodityCatService.brotherCategory(id);
    }
}
