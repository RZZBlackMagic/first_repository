package cn.ideal.manager.service;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.results.MessageResult;

public interface CartService {
     MessageResult insertAddress(CommodityAddress commodityAddress);
     MessageResult getAddressList();

}
