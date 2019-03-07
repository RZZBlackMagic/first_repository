package cn.ideal.wechat.service;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;

import java.util.Map;


public interface CommodityService {

    int getGoodsCount();

    TableJsonResult getGoodsList(Long cid, String location, Integer page, Integer size);

    Map<String, Object> getGoodDetail(Long id);

    MessageResult checkSku(String id);
}
