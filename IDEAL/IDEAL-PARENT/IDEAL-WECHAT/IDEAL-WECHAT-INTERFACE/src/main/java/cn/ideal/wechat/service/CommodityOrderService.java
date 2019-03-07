package cn.ideal.wechat.service;

import cn.ideal.common.results.MessageResult;

public interface CommodityOrderService {

    MessageResult getOrderList(Long uid);
}
