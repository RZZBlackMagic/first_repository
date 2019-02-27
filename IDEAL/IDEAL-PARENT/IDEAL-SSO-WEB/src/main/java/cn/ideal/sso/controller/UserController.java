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


    @RequestMapping(value = "/sso/user/register", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult register(AccountUser user){
        return userService.userRegister(user);
    }


    @RequestMapping(value = "/sso/wechat/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageResult login(String username, String password, String type){
        MessageResult result = userService.loginForWeChat(username, password);
        return result;
    }

    @RequestMapping(value = "/sso/user/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public Object getManagerByToken(@PathVariable String token, String callback){
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
