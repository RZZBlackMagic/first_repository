package cn.ideal.portal.service.impl;

import cn.ideal.common.mapper.CommoditySkuMapper;
import cn.ideal.common.mapper.CommoditySpuMapper;
import cn.ideal.common.pojo.CommoditySku;
import cn.ideal.common.pojo.CommoditySkuExample;
import cn.ideal.common.pojo.CommoditySpu;
import cn.ideal.common.pojo.PCCommodityCart;
import cn.ideal.common.results.MessageResult;
import cn.ideal.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    private CommoditySpuMapper commoditySpuMapper;
    @Autowired
    private CommoditySkuMapper commoditySkuMapper;
    @Override
    public MessageResult getCommodityForCart(Long id) {
        /*CommoditySkuExample  example = new CommoditySkuExample();
        CommoditySkuExample.Criteria criteria = example.createCriteria();
        criteria.andSpuidEqualTo(id);
        CommoditySpu commoditySpu = commoditySpuMapper.selectByPrimaryKey(id);
        List<CommoditySku> list = commoditySkuMapper.selectByExample(example);
        PCCommodityCart pcCommodityCart = new PCCommodityCart(id,commoditySpu.getTitle(),commoditySku.getQuantity(),commoditySku.getPrice(),commoditySku.getImage());
        */
        return null;
    }
}
