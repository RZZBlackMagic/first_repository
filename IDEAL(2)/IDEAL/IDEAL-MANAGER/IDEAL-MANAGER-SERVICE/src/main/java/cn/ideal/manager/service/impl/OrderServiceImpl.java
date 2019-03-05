package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.CommodityOrderItemMapper;
import cn.ideal.common.mapper.CommodityOrderMapper;
import cn.ideal.common.mapper.CommodityOrderShippingMapper;
import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.results.MessageResult;
import cn.ideal.manager.service.OrderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CommodityOrderMapper commodityOrderMapper;
    @Autowired
    private CommodityOrderItemMapper commodityOrderItemMapper;
    @Autowired
    private CommodityOrderShippingMapper commodityOrderShippingMapper;
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
    public MessageResult updateCommodityOrder(String id,String shippingCode,String shippingName) {
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
        System.out.println("*****************!!!!!!!!!!!!!"+commodityOrderItem);
        String[] itemIdArray = commodityOrderItem.getItemId().split("#");
        String[] number = commodityOrderItem.getNumber().split("#");
        String[] title = commodityOrderItem.getTitle().split("#");
        String[] price = commodityOrderItem.getPrice().split("#");
        String[] picPath = commodityOrderItem.getPicPath().split("#");
        for(int i=0;i<itemIdArray.length;i++){
            String id = (String.valueOf(System.currentTimeMillis()+new Random().nextInt(10)));
            String totalFee = String.valueOf(Long.valueOf(price[i])*Long.valueOf(number[i]));
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
}
