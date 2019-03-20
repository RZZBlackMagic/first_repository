package cn.ideal.portal.service.impl;

import cn.ideal.common.mapper.CommodityAddressMapper;
import cn.ideal.common.mapper.CommodityOrderItemMapper;
import cn.ideal.common.mapper.CommodityOrderMapper;
import cn.ideal.common.mapper.CommodityOrderShippingMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.OrderResult;
import cn.ideal.portal.service.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CommodityOrderMapper commodityOrderMapper;
    @Autowired
    private CommodityOrderItemMapper commodityOrderItemMapper;
    @Autowired
    private CommodityOrderShippingMapper commodityOrderShippingMapper;
    @Autowired
    private CommodityAddressMapper commodityAddressMapper;

    @Override
    public MessageResult insertIntoCommodityOrder(CommodityOrder order) {
        CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(order.getId());
        if (commodityOrder != null) {
            return MessageResult.ok();
        }
        //设置订单创建时间
        order.setCreated(new Date(System.currentTimeMillis()));
        //设置订单状态：未付款
        order.setStatus((byte) 1);
        //设置订单更新时间
        order.setUpdated(new Date(System.currentTimeMillis()));
        commodityOrderMapper.insert(order);
        return MessageResult.ok();
    }

    @Override
    public MessageResult updateCommodityOrder(String id, String shippingCode, String shippingName) {
        CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(id);
        commodityOrder.setShippingCode(shippingCode);
        commodityOrder.setShippingName(shippingName);
        commodityOrder.setUpdated(new Date(System.currentTimeMillis()));
        commodityOrder.setPaymentTime(new Date(System.currentTimeMillis()));
        commodityOrderMapper.updateByPrimaryKey(commodityOrder);
        return MessageResult.ok();
    }

    @Override
    public MessageResult insertIntoCommodityOrderItem(CommodityOrderItem commodityOrderItem) {
        System.out.println("*****************"+commodityOrderItem);
        String[] itemIdArray = commodityOrderItem.getItemId().split("#");
        String[] number = commodityOrderItem.getNumber().split("#");
        String[] title = commodityOrderItem.getTitle().split("#");
        String[] price = commodityOrderItem.getPrice().split("#");
        String[] picPath = commodityOrderItem.getPicPath().split("#");
        for (int i = 0; i < itemIdArray.length; i++) {

            CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(commodityOrderItem.getOrderId());
            commodityOrderItem.getOrderId();
            String id = (String.valueOf(System.currentTimeMillis() + new Random().nextInt(10)));
            System.out.println("****************"+commodityOrder);
            String totalFee = String.valueOf((Long.valueOf(price[i]) * Long.valueOf(number[i]) + Long.valueOf(commodityOrder.getPostFee())));//加上邮费
            CommodityOrderItem commodityOrderItem1 = new CommodityOrderItem(id, (itemIdArray[i]), commodityOrderItem.getOrderId(), (number[i]), title[i], (price[i]), (totalFee), picPath[i]);
            commodityOrderItemMapper.insert(commodityOrderItem1);
        }

        return MessageResult.ok();
    }

    @Override
    public MessageResult insertIntoCommodityOrderShipping(CommodityOrderShipping commodityOrderShipping) {
        commodityOrderShipping.setCreated(new Date(System.currentTimeMillis()));
        commodityOrderShipping.setUpdated(new Date(System.currentTimeMillis()));
        commodityOrderShippingMapper.insert(commodityOrderShipping);
        return MessageResult.ok();
    }

    @Override
    public MessageResult getAddressList(Long userId) {
        CommodityAddressExample example = new CommodityAddressExample();
        CommodityAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<CommodityAddress> list = commodityAddressMapper.selectByExample(example);
        return MessageResult.ok(list);
    }

    @Override
    public MessageResult insertIntoCommodityAddress(CommodityAddress commodityAddress) {
        if (commodityAddress.getId() != null) {
            commodityAddressMapper.deleteByPrimaryKey(commodityAddress.getId());
        }
        commodityAddress.setId(null);
        commodityAddressMapper.insert(commodityAddress);
        MessageResult messageResult = getAddressList(commodityAddress.getUserId());
        return messageResult;
    }

    @Override
    public MessageResult getOrderInfo(String orderId) {
        CommodityOrderShipping commodityOrderShipping = commodityOrderShippingMapper.selectByPrimaryKey(orderId);
        if(commodityOrderShipping==null){
            return MessageResult.build(203,"异步异常");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("name", commodityOrderShipping.getReceiverName());
        map.put("phone", commodityOrderShipping.getReceiverMobile());
        map.put("address", commodityOrderShipping.getReceiverAddress() + " " + commodityOrderShipping.getReceiverDetailAddress());
        CommodityOrderItemExample example = new CommodityOrderItemExample();
        CommodityOrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<CommodityOrderItem> list = commodityOrderItemMapper.selectByExample(example);
        Long totalFee = Long.valueOf(0);
        String CommodityTitle = "";
        for (CommodityOrderItem commodityOrderItem : list) {
            CommodityTitle = CommodityTitle + commodityOrderItem.getTitle() + "  ";
            totalFee = totalFee + Long.valueOf(commodityOrderItem.getTotalFee());
        }
        map.put("ComTitle", CommodityTitle);
        map.put("totalFee", totalFee);
        return MessageResult.ok(map);
    }

    @Override
    public MessageResult updateOrderStatus(String orderId) {

        CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(orderId);
        commodityOrder.setStatus((byte) 2);//状态2：已付款
        commodityOrderMapper.updateByPrimaryKey(commodityOrder);
        return MessageResult.ok();
    }

    @Override
    public List getOrderInfoForCenter(String userId, byte status) {
        List<OrderResult> resultList = new ArrayList<>();
        //全部订单
        CommodityOrderExample example = new CommodityOrderExample();
        CommodityOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(Long.valueOf(userId));
        criteria.andStatusEqualTo(status);
        List<CommodityOrder> commodityOrderList = commodityOrderMapper.selectByExample(example);

        List<CommodityOrderItem> commodityOrderItemList = new ArrayList<>();
        List<CommodityOrderShipping> commodityOrderShippingList = new ArrayList<>();
        for(int i=0;i<commodityOrderList.size();i++){
            List<CommodityOrderItem> list = new ArrayList<>();
            CommodityOrderItemExample example1 = new CommodityOrderItemExample();
            CommodityOrderItemExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andOrderIdEqualTo(commodityOrderList.get(i).getId());
            list = commodityOrderItemMapper.selectByExample(example1);
            commodityOrderItemList.addAll(list);

            CommodityOrderShipping commodityOrderShipping = commodityOrderShippingMapper.selectByPrimaryKey(commodityOrderList.get(i).getId());
            commodityOrderShippingList.add(commodityOrderShipping);
        }

        for(int i=0;i<commodityOrderItemList.size();i++){
            OrderResult o = new OrderResult();
            for(int j=0;j<commodityOrderList.size();j++){
                if(commodityOrderItemList.get(i).getOrderId()==commodityOrderList.get(j).getId()){
                    o.setCreated(commodityOrderList.get(i).getCreated());
                    o.setUserId(String.valueOf(commodityOrderList.get(i).getUserId()));
                }
            }
            for(int k=0;k<commodityOrderShippingList.size();k++){
                if(commodityOrderShippingList.get(k).getOrderId()==commodityOrderItemList.get(i).getOrderId()){
                    o.setReceiverName(commodityOrderShippingList.get(i).getReceiverName());
                }
            }
            o.setNumber(commodityOrderItemList.get(i).getNumber());
            o.setPrice(commodityOrderItemList.get(i).getPrice());
            o.setTitle(commodityOrderItemList.get(i).getTitle());
            o.setPicPath(commodityOrderItemList.get(i).getPicPath());
            o.setOrderId(commodityOrderItemList.get(i).getOrderId());
            resultList.add(o);
        }

        return resultList;
    }

    @Override
    public List getAllOrderForCenter(String userId) {
        List<OrderResult> list = new ArrayList<>();
        list.addAll(getUnReceiveOrderList(userId));
        list.addAll(getOrderInfoForCenter(userId,(byte)1));
        list.addAll(getOrderInfoForCenter(userId,(byte)5));
        return list;
    }

    @Override
    public List getUnReceiveOrderList(String userId) {
        //未收货就是状态为2,3,4
        List list = getOrderInfoForCenter(userId,(byte)2);
        list.addAll(getOrderInfoForCenter(userId,(byte)3));
        list.addAll(getOrderInfoForCenter(userId,(byte)4));
        return list;
    }

    @Override
    public Integer getTotalForPay(String oid) {
        CommodityOrderItemExample example = new CommodityOrderItemExample();
        CommodityOrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(oid);
        List<CommodityOrderItem> list = commodityOrderItemMapper.selectByExample(example);
        CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(oid);
        int price = 0;
        price = price + Integer.valueOf(commodityOrder.getPostFee());
        for(int i=0;i<list.size();i++){
            price = price + Integer.valueOf(list.get(i).getPrice());
        }
        return (price);
    }
}
