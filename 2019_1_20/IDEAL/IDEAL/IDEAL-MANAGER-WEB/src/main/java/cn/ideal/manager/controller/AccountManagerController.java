package cn.ideal.manager.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.utils.CookieUtils;
import cn.ideal.manager.service.AccountManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.alibaba.dubbo.common.Constants.TOKEN_KEY;

@Controller
public class AccountManagerController {
    @Autowired
    private AccountManagerService accountManagerService;

    /**
     * manger登录验证
     * @param jobnum
     * @param password
     * @return
     */
    @RequestMapping("/manager/accountManager/login.do")
    @ResponseBody
    public MessageResult checkAccountManager(Long jobnum , String password, HttpServletRequest request, HttpServletResponse response){
        MessageResult messageResult = accountManagerService.checkAccountService(jobnum,password);
        CookieUtils.setCookie(request, response, TOKEN_KEY, messageResult.getData().toString());
        return messageResult;
    }
}
