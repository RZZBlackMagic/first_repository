package cn.ideal.manager.controller;


import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.common.utils.FastDFSClient;
import cn.ideal.manager.service.ContentManagerService;
import jdk.internal.jline.internal.TestAccessible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentManagerController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;


    @Autowired
    private ContentManagerService contentManagerService;

    @RequestMapping("/portal/table/content")
    @ResponseBody
    public TableJsonResult getContentListForTable(Long id, Integer page, Integer limit) {
        return contentManagerService.getContentListForTable(id, page, limit);
    }

    @RequestMapping("/portal/content/addContent")
    @ResponseBody
    public MessageResult addContent(CommodityContent commodityContent) throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("src/main/resources/client.conf");
        if (commodityContent.getPic() != null || commodityContent.getPic().length() != 0){
            commodityContent.setPic(IMAGE_SERVER_URL + fastDFSClient.uploadFile(commodityContent.getPic()));
        }
        if (commodityContent.getPic2() != null || commodityContent.getPic2().length() != 0){
            commodityContent.setPic2(IMAGE_SERVER_URL + fastDFSClient.uploadFile(commodityContent.getPic2()));
        }
        return contentManagerService.insertContent(commodityContent);
    }

    @RequestMapping("/portal/content/deleteContent")
    @ResponseBody
    public MessageResult deleteContent(String id) {

        return contentManagerService.deleteContent(id);
    }

    @RequestMapping("/portal/content/editContent")
    @ResponseBody
    public MessageResult editContentController(CommodityContent commodityContent) {
        return contentManagerService.updateContent(commodityContent);
    }

}
