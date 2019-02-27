package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.CommoditySpuMapper;
import cn.ideal.common.pojo.CommoditySpuExample;
import cn.ideal.wechat.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommoditySpuMapper commoditySpuMapper;

    @Override
    public int getGoodsCount() {
        CommoditySpuExample example = new CommoditySpuExample();
        CommoditySpuExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        return commoditySpuMapper.countByExample(example);
    }
}
