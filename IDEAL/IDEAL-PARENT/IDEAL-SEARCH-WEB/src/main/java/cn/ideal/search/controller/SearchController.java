package cn.ideal.search.controller;

import cn.ideal.common.results.TableJsonResult;
import cn.ideal.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XINER
 * @create 2019-02-24 14:51
 * @desc
 **/
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/search")
    public String search(@RequestParam String query, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "60") Integer limit, Model model) throws Exception {
        TableJsonResult search = searchService.search(query, page, limit);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("total", search.getTotal());
        model.addAttribute("itemList", search.getRows());
        return "search";
    }
}
