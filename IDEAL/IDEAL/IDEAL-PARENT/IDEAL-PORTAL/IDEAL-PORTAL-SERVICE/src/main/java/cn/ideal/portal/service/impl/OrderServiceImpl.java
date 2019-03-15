package cn.ideal.portal.service.impl;

import cn.ideal.common.mapper.CommodityAddressMapper;
import cn.ideal.common.mapper.CommodityOrderItemMapper;
import cn.ideal.common.mapper.CommodityOrderMapper;
import cn.ideal.common.mapper.CommodityOrderShippingMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
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
    public MessageResult getComFromCookieById(String idList, String numList) {

        return null;
    }

    @Override
    public MessageResult insertIntoCommodityOrder(CommodityOrder commodityOrder) {
        CommodityOrder commodityOrder1 = commodityOrderMapper.selectByPrimaryKey(commodityOrder.getId());
        if(commodityOrder1!=null){
            return MessageResult.ok();
        }
        //设置订单创建时间
        commodityOrder.setCreated(new Date(System.currentTimeMillis()));
        //设置订单状态：未付款
        commodityOrder.setStatus((byte) 1);
        //设置订单更新时间
        commodityOrder.setUpdated(new Date(System.currentTimeMillis()));
        commodityOrderMapper.insert(commodityOrder);
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
        String[] itemIdArray = commodityOrderItem.getItemId().split("#");
        String[] number = commodityOrderItem.getNumber().split("#");
        String[] title = commodityOrderItem.getTitle().split("#");
        String[] price = commodityOrderItem.getPrice().split("#");
        String[] picPath = commodityOrderItem.getPicPath().split("#");
        for(int i=0;i<itemIdArray.length;i++){

            CommodityOrder commodityOrder = commodityOrderMapper.selectByPrimaryKey(commodityOrderItem.getOrderId());
            commodityOrderItem.getOrderId();
            String id = (String.valueOf(System.currentTimeMillis()+new Random().nextInt(10)));
            String totalFee = String.valueOf((Long.valueOf(price[i])*Long.valueOf(number[i])+Long.valueOf(commodityOrder.getPostFee())));//加上邮费
            CommodityOrderItem commodityOrderItem1 = new CommodityOrderItem(id,itemIdArray[i],commodityOrderItem.getOrderId(),number[i],title[i],price[i],totalFee,picPath[i]);
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
    public MessageResult getAddressList(Long userId ) {
        CommodityAddressExample example = new CommodityAddressExample();
        CommodityAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<CommodityAddress> list = commodityAddressMapper.selectByExample(example);
        return MessageResult.ok(list);
    }

    @Override
    public MessageResult insertIntoCommodityAddress(CommodityAddress commodityAddress) {
        if(commodityAddress.getId()!=null){
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
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("name",commodityOrderShipping.getReceiverName());
        map.put("phone", commodityOrderShipping.getReceiverMobile());
        map.put("address",commodityOrderShipping.getReceiverAddress()+" "+commodityOrderShipping.getReceiverDetailAddress());
        CommodityOrderItemExample example = new CommodityOrderItemExample();
        CommodityOrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<CommodityOrderItem> list = commodityOrderItemMapper.selectByExample(example);
        Long totalFee = Long.valueOf(0);
        String CommodityTitle = "";
        for(CommodityOrderItem commodityOrderItem:list){
            CommodityTitle = CommodityTitle + commodityOrderItem.getTitle() + "  ";
            totalFee = totalFee +Long.valueOf(commodityOrderItem.getTotalFee());
        }
        map.put("ComTitle",CommodityTitle);
        map.put("totalFee",totalFee);
        return MessageResult.ok(map);
    }
}
