package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.CommodityCartMapper;
import cn.ideal.common.mapper.CommodityOrderItemMapper;
import cn.ideal.common.mapper.CommodityOrderMapper;
import cn.ideal.common.mapper.CommodityOrderShippingMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author XINER
 * @create 2019-03-04 22:01
 * @desc
 **/
@Service
public class CommodityOrderServiceImpl implements CommodityOrderService {

    @Autowired
    private CommodityOrderMapper commodityOrderMapper;
    @Autowired
    private CommodityOrderItemMapper commodityOrderItemMapper;
    @Autowired
    private CommodityCartMapper commodityCartMapper;

    @Override
    public MessageResult getOrderList(Long uid) {

        List<Map<String, Object>> resList = new LinkedList<>();

        CommodityOrderExample orderExample = new CommodityOrderExample();
        CommodityOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<CommodityOrder> orders = commodityOrderMapper.selectByExample(orderExample);
        for (CommodityOrder order : orders){
            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("id", order.getId());
            orderMap.put("order_sn", order.getId());
            orderMap.put("actual_price", order.getPayment());
            orderMap.put("payOption", order.getStatus()==1);

            if (order.getStatus() == 1)
                orderMap.put("order_status_text", "未付款");
            else if (order.getStatus() == 1)
                orderMap.put("order_status_text", "已付款");
            else if (order.getStatus() == 1)
                orderMap.put("order_status_text", "未发货");
            else if (order.getStatus() == 1)
                orderMap.put("order_status_text", "已发货");
            else if (order.getStatus() == 1)
                orderMap.put("order_status_text", "交易成功");
            else if (order.getStatus() == 1)
                orderMap.put("order_status_text", "交易关闭");
            else
                orderMap.put("order_status_text", "未知参数");

            List<Map<String, Object>> goodsList = new LinkedList<>();
            CommodityOrderItemExample orderItemExample = new CommodityOrderItemExample();
            CommodityOrderItemExample.Criteria orderItemCriteria = orderItemExample.createCriteria();
            orderItemCriteria.andOrderIdEqualTo(order.getId());
            List<CommodityOrderItem> orderItems = commodityOrderItemMapper.selectByExample(orderItemExample);
            for (CommodityOrderItem orderItem : orderItems){
                Map<String, Object> goodsMap = new HashMap<>();
                goodsMap.put("id", orderItem.getItemId());
                goodsMap.put("list_pic_url", orderItem.getPicPath());
                goodsMap.put("goods_name", orderItem.getTitle());
                goodsMap.put("number", orderItem.getNumber());
                goodsList.add(goodsMap);
            }
            orderMap.put("goodsList", goodsList);
            resList.add(orderMap);
        }
        return MessageResult.ok(resList);
    }


}
