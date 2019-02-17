package cn.ideal.manager.service;

import cn.ideal.common.pojo.MessageResult;

public interface AccountManagerService {
    public MessageResult checkAccountService(Long jobnum, String password);
}
