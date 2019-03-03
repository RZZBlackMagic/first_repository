package cn.ideal.manager.service;

import cn.ideal.common.results.MessageResult;

public interface OrderService {
    MessageResult getComFromCookieById(String idList,String numList);
}
