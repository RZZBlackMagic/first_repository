package cn.ideal.product.service.impl;

import cn.ideal.common.mapper.CommodityCatMapper;
import cn.ideal.common.mapper.CommodityContentMapper;
import cn.ideal.common.pojo.CommodityCatExample;
import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.pojo.CommodityContentExample;
import cn.ideal.common.results.MessageResult;
import cn.ideal.product.service.IndexService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private CommodityContentMapper commodityContentMapper;
    @Autowired
    private CommodityCatMapper commodityCatMapper;
    @Override
    public MessageResult getSlidePicture(Long category_id) {
        CommodityContentExample example = new CommodityContentExample();
        CommodityContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(category_id);
        System.out.println("*****************************"+category_id);
        List<CommodityContent> list = commodityContentMapper.selectByExample(example);
        return MessageResult.ok(list);
    }

    @Override
    public MessageResult getMainCategory(Long pid) {
        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List list = commodityCatMapper.selectByExample(example);
        return MessageResult.ok(list);
    }


}
