package cn.ideal.manager.controller;


import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.utils.FastDFSClient;
import cn.ideal.manager.service.ContentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentManagerController {

    @Autowired
    private ContentManagerService contentManagerService;

    @RequestMapping("/portal/table/content.do")
    @ResponseBody
    public TableJsonResult getContentListForTable(Long id, Integer page, Integer limit) {
        return contentManagerService.getContentListForTable(id, page, limit);
    }

    @RequestMapping("/portal/content/addContent.do")
    @ResponseBody
    public MessageResult addContent(CommodityContent commodityContent) throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("client.conf");
        System.out.println("***************************"+commodityContent.getPic()+"**********"+commodityContent.getPic2());
        commodityContent.setPic("http://39.105.163.90:8888/" + fastDFSClient.uploadFile(commodityContent.getPic()));
        commodityContent.setPic2("http://39.105.163.90:8888/" + fastDFSClient.uploadFile(commodityContent.getPic2()));

        return contentManagerService.insertContent(commodityContent);
    }

    @RequestMapping("/portal/content/deleteContent.do")
    @ResponseBody
    public MessageResult deleteContent(String id) {

        return contentManagerService.deleteContent(id);
    }

    @RequestMapping("/portal/content/editContent.do")
    @ResponseBody
    public MessageResult editContentController(CommodityContent commodityContent) {
        return contentManagerService.updateContent(commodityContent);
    }

}
