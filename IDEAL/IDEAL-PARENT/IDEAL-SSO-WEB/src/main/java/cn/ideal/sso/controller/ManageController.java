package cn.ideal.sso.controller;

import cn.ideal.common.pojo.AccountManager;
import cn.ideal.common.pojo.AccountMerchant;
import cn.ideal.common.pojo.AccountProductor;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.utils.CookieUtils;
import cn.ideal.sso.service.ManageService;
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
public class ManageController {

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Autowired
    private ManageService managerService;


    @RequestMapping(value = "/sso/product/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountProductor productor){
        return managerService.productRegister(productor);
    }

    @RequestMapping(value = "/sso/manager/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountManager manager){
        return managerService.managerRegister(manager);
    }

    @RequestMapping(value = "/sso/merchant/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountMerchant merchant){
        return managerService.merchantRegister(merchant);
    }

    @RequestMapping(value = "/sso/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult login(String username, String password, String type, HttpServletRequest request, HttpServletResponse response){
        MessageResult result = managerService.login(username, password, type);
        if(result.getStatus() == 200){
            CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
        }
        return result;
    }

    @RequestMapping(value = "/sso/manager/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getManagerByToken(@PathVariable String token, String callback){
        MessageResult result = managerService.getMessageByToken("MANAGER", token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/product/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getProductByToken(@PathVariable String token, String callback){
        MessageResult result = managerService.getMessageByToken("PRODUCT", token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/merchant/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMerchantByToken(@PathVariable String token, String callback){
        MessageResult result = managerService.getMessageByToken("MERCHANT", token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

//    @RequestMapping(value = "/sso/logout", method = RequestMethod.POST)
//    @ResponseBody
//    public MessageResult logout(String user_type, String token){
//        return managerService.logout(user_type, token);
//    }
}
