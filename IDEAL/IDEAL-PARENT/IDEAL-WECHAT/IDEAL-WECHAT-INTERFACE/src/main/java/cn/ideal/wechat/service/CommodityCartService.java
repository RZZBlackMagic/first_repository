package cn.ideal.wechat.service;

import cn.ideal.common.results.MessageResult;

import java.util.Map;

public interface CommodityCartService {

    Map<String, Object> getCartList(Long uid);

    MessageResult checkCartList(String cartIds, Byte isChecked);

    MessageResult updateCart(Long id, Integer number);

    MessageResult deleteCart(String cartIds);

    MessageResult checkOutCart(Long uid);
}
