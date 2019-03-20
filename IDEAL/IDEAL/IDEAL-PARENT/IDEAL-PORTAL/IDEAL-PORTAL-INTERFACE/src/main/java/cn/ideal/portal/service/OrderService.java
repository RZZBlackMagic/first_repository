package cn.ideal.portal.service;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.results.MessageResult;

import java.util.List;

public interface OrderService {

    MessageResult insertIntoCommodityOrder(CommodityOrder commodityOrder);

    MessageResult updateCommodityOrder(String id, String shippingCode, String shippingName);

    MessageResult insertIntoCommodityOrderItem(CommodityOrderItem commodityOrderItem);

    MessageResult insertIntoCommodityOrderShipping(CommodityOrderShipping commodityOrderShipping);

    MessageResult getAddressList(Long userId);

    MessageResult insertIntoCommodityAddress(CommodityAddress commodityAddress);

    MessageResult getOrderInfo(String orderId);

    MessageResult updateOrderStatus(String orderId);

    List getOrderInfoForCenter(String userId,byte status);

    List getAllOrderForCenter(String userId);

    List getUnReceiveOrderList(String userId);

    Integer getTotalForPay(String oid);
}
