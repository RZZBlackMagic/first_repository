package cn.ideal.portal.service;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.results.MessageResult;

public interface OrderService {
    MessageResult getComFromCookieById(String idList, String numList);
    MessageResult insertIntoCommodityOrder(CommodityOrder commodityOrder);
    MessageResult updateCommodityOrder(String id, String shippingCode, String shippingName);
    MessageResult insertIntoCommodityOrderItem(CommodityOrderItem commodityOrderItem);
    MessageResult insertIntoCommodityOrderShipping(CommodityOrderShipping commodityOrderShipping);
    MessageResult getAddressList(Long userId);
    MessageResult insertIntoCommodityAddress(CommodityAddress commodityAddress);
    MessageResult getOrderInfo(String orderId);
}
