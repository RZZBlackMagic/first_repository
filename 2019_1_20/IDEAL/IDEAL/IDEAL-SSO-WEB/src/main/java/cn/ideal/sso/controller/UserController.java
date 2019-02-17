package cn.ideal.sso.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.utils.CookieUtils;
import cn.ideal.pojo.AccountUser;
import cn.ideal.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @Autowired
    private UserService userService;

    @RequestMapping("/sso/user/check/{type}/{param}")
    @ResponseBody
    public MessageResult checkUserData(@PathVariable String param, @PathVariable Integer type){
        MessageResult result = userService.checkData(param, type);
        return result;
    }

    @RequestMapping(value = "/sso/user/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountUser user){
        MessageResult result = userService.register(user);
        return result;
    }

    @RequestMapping(value = "/sso/user/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        MessageResult result = userService.login(username, password);
        CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
        return result;
    }

    @RequestMapping(value = "/sso/user/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByToken(@PathVariable String token, String callback){
        MessageResult result = userService.getUserByToken(token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/user/logout/{token}", method = RequestMethod.GET)
    @ResponseBody
    public MessageResult logout(@PathVariable String token){
        MessageResult result = userService.logout(token);
        return result;
    }
}
