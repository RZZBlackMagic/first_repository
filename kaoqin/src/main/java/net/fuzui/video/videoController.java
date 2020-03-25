package net.fuzui.video;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import net.fuzui.pojo.FileEntity;
import net.fuzui.pojo.JsonResult;

@Controller
public class videoController {

	@RequestMapping(value = "/upload", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public JsonResult  upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
            HttpServletRequest request, ModelMap map) {
        String message = "";
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if (entity != null) {
//                service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
            } else {
                message = "上传失败";
                map.put("result", message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(200, map.toString());
    }
}
