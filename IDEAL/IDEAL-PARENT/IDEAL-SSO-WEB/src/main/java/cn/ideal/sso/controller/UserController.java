package cn.ideal.sso.controller;

import cn.ideal.common.pojo.AccountUser;
import cn.ideal.common.results.MessageResult;
import cn.ideal.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/sso/wechat/register")
    @ResponseBody
    public MessageResult registerForWechat(AccountUser user){
        return userService.userRegister(user);
    }

    @RequestMapping(value = "/sso/web/register")
    @ResponseBody
    public MessageResult registerForWeb(AccountUser user){
        return userService.userRegister(user);
    }

    @RequestMapping(value = "/sso/wechat/login")
    @ResponseBody
    public MessageResult loginForWechat(String username, String password){
        MessageResult result = userService.loginForWeChat(username, password);
        return result;
    }

    @RequestMapping(value = "/sso/web/login")
    @ResponseBody
    public MessageResult loginForWeb(String username, String password){
        MessageResult result = userService.loginForWeChat(username, password);
        return result;
    }

    @RequestMapping(value = "/sso/wechat/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByTokenForWechat(@PathVariable String token, String callback){
        MessageResult result = userService.getMessageByToken(token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/web/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserByTokenForWeb(@PathVariable String token, String callback){
        MessageResult result = userService.getMessageByToken(token);
        if (StringUtils.isNotBlank(callback)) {
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
            //设置回调方法
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }
        return result;
    }

    @RequestMapping(value = "/sso/logout", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult logout(String token){
        return userService.logout(token);
    }
}
