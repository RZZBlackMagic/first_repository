package cn.ideal.sso.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.utils.CookieUtils;
import cn.ideal.pojo.AccountProductor;
import cn.ideal.sso.service.ProductorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductorController {

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Autowired
    private ProductorService productorService;

    @RequestMapping("/sso/productor/check/{type}/{param}")
    @ResponseBody
    public MessageResult checkProductorData(@PathVariable String param, @PathVariable Integer type){
        MessageResult result = productorService.checkData(param, type);
        return result;
    }

    @RequestMapping(value = "/sso/productor/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountProductor productor){
        MessageResult result = productorService.register(productor);
        return result;
    }

    @RequestMapping(value = "/sso/productor/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        MessageResult result = productorService.login(username, password);
        CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
        return result;
    }

    @RequestMapping(value = "/sso/productor/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getProductorByToken(@PathVariable String token, String callback){
        MessageResult result = productorService.getProductorByToken(token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/productor/logout/{token}", method = RequestMethod.GET)
    @ResponseBody
    public MessageResult logout(@PathVariable String token){
        MessageResult result = productorService.logout(token);
        return result;
    }
}
