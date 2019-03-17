package cn.ideal.portal.service;

import cn.ideal.common.pojo.CommoditySku;

import java.util.List;
import java.util.Map;

public interface CommodityDetailService {

    Map<String, Object> getSpuMessage(Long spuid);

    Map<String, Object> getSpeSkuMessage(Long spuid, String spevs);

    CommoditySku getSkuBySpevid(List<Long> spev);
}
