package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.CommodityCartMapper;
import cn.ideal.common.pojo.CommodityCart;
import cn.ideal.common.pojo.CommodityCartExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.wechat.service.CommodityCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author XINER
 * @create 2019-03-03 13:36
 * @desc
 **/
@Service
public class CommodityCartServiceImpl implements CommodityCartService {

    @Autowired
    private CommodityCartMapper commodityCartMapper;

    @Override
    public Map<String, Object> getCartList(Long uid) {
        Map<String, Object> res= new HashMap<>();
        CommodityCartExample example = new CommodityCartExample();
        CommodityCartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List<CommodityCart> carts = commodityCartMapper.selectByExample(example);

        LinkedList<Map<String, Object>> list = new LinkedList<>();
        Integer goodsAmount = 0;
        Integer checkedGoodsAmount = 0;
        Integer checkedGoodsCount = 0;
        for (CommodityCart cart : carts){
            HashMap<String, Object> cart_map = new HashMap<>();
            cart_map.put("id", cart.getId());
            cart_map.put("product_id", cart.getSkuId());
            cart_map.put("goods_name", cart.getTitle());
            cart_map.put("number", cart.getAmount());
            cart_map.put("goods_specifition_name_value", cart.getSpe());
            cart_map.put("list_pic_url", cart.getImage());
            cart_map.put("retail_price", cart.getPrice());
            cart_map.put("checked", cart.getChecked());
            list.add(cart_map);

            goodsAmount += cart.getPrice() * cart.getAmount();
            if (cart.getChecked() == (byte)1) {
                checkedGoodsAmount += cart.getPrice() * cart.getAmount();
                checkedGoodsCount += cart.getAmount();
            }
        }
        res.put("cartGoods", list);

        HashMap<String, Object> total_map = new HashMap<>();
        total_map.put("goodsCount", carts.size());
        total_map.put("checkedGoodsCount", checkedGoodsCount);
        total_map.put("goodsAmount", goodsAmount);
        total_map.put("checkedGoodsAmount", checkedGoodsAmount);
        res.put("cartTotal", total_map);
        return res;
    }

    @Override
    public MessageResult checkCartList(String cartIds, Byte isChecked) {

        String[] cartIdList = cartIds.split(",");
        for (String cartId : cartIdList){
            commodityCartMapper.updateByPrimaryKeySelective(new CommodityCart(Long.valueOf(cartId) , null, null, null, null, null, null, null, null, isChecked));
        }
        return MessageResult.ok();
    }

    @Override
    public MessageResult updateCart(Long id, Integer number) {
        commodityCartMapper.updateByPrimaryKeySelective(new CommodityCart(id, null, null, null, null, null, number, null, null, null));
        return MessageResult.ok();
    }

    @Override
    public MessageResult deleteCart(String cartIds) {
        String[] cartIdList = cartIds.split(",");
        for (String cartId : cartIdList){
            commodityCartMapper.deleteByPrimaryKey(Long.valueOf(cartId));
        }
        return MessageResult.ok();
    }
}
