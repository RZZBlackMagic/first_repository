package cn.ideal.portal.controller;

import cn.ideal.portal.service.IndexService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XINER
 * @create 2019-03-17 15:43
 * @desc 静态化页面
 **/

@Controller
public class FreeMarkerController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/generator-index")
    @ResponseBody
    public String generatorIndex(HttpServletRequest request) throws Exception {
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = configuration.getTemplate("index.ftl");
        Map<String, Object> data = new HashMap<>();
        data.put("slide", indexService.getSlideContent());
        data.put("adv", indexService.getAdContent());
        data.put("adv", indexService.getContentList(Long.valueOf(43)));
        data.put("recommend", indexService.getContentList(Long.valueOf(45)));
        Writer out = new FileWriter(new File("C:\\Users\\AEROSOL.XINER\\OneDrive\\Workspace\\IDEAL\\IDEAL-PARENT\\IDEAL-PORTAL-WEB\\src\\main\\webapp\\PORTAL-WEB-SOURCE\\html\\index.html"));
        template.process(data, out);
        out.close();
        return "index";
    }




}
