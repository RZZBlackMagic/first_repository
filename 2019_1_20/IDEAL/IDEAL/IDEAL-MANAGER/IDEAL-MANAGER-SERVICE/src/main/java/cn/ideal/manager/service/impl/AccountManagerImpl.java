package cn.ideal.manager.service.impl;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.manager.service.AccountManagerService;
import cn.ideal.mapper.AccountManagerMapper;
import cn.ideal.pojo.AccountManager;
import cn.ideal.pojo.AccountManagerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountManagerImpl implements AccountManagerService {
    @Autowired
    private AccountManagerMapper accountManagerMapper;
    @Override
    public MessageResult checkAccountService(Long jobnum, String password) {
        AccountManagerExample accountManagerExample = new AccountManagerExample();
        AccountManagerExample.Criteria criteria = accountManagerExample.createCriteria();
        criteria.andJobnumEqualTo(jobnum);
        List<AccountManager> list = accountManagerMapper.selectByExample(accountManagerExample);
        if(list.get(0).getPassword().equals(password)){
            //登录成功
            return MessageResult.ok(list.get(0));
        }else{
            //登录失败
            return MessageResult.ok("登录失败");
        }
    }
}
