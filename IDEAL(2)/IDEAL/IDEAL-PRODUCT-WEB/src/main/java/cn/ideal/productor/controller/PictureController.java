package cn.ideal.productor.controller;

import java.util.HashMap;
import java.util.Map;

import cn.ideal.common.utils.FastDFSClient;
import cn.ideal.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PictureController {


    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    @SuppressWarnings("all")
    public String uploadFile(MultipartFile uploadFile) {

        try {
            // 1、取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            // 2、创建一个FastDFS的客户端
            FastDFSClient client = new FastDFSClient("classpath:client.conf");

            // 3、执行上传处理
            String path = client.uploadFile(uploadFile.getBytes(), extName);

            // 4、拼接返回的url和ip地址，拼装成完整的url
            String url = IMAGE_SERVER_URL + path;

            // 5、返回map
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);

            //把java对象转换成json字符串
            String json = JsonUtils.objectToJson(result);
            return json;

        } catch (Exception e) {
            e.printStackTrace();
            // 5、返回map
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");

            //把java对象转换成json字符串
            String json = JsonUtils.objectToJson(result);
            return json;
        }
    }
}