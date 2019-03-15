package cn.ideal.portal.service.impl;

import cn.ideal.common.mapper.CommodityCatMapper;
import cn.ideal.common.mapper.CommodityContentCategoryMapper;
import cn.ideal.common.mapper.CommodityContentMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.portal.service.IndexService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private CommodityContentMapper commodityContentMapper;
    @Autowired
    private CommodityContentCategoryMapper commodityContentCategoryMapper;
    @Autowired
    private CommodityCatMapper commodityCatMapper;

    @Override
    public MessageResult getSlidePicture(Long cid) {
        CommodityContentExample example = new CommodityContentExample();
        CommodityContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        List<CommodityContent> list = commodityContentMapper.selectByExample(example);
        return MessageResult.ok(list);
    }

    @Override
    public Map<String, Object> getSlideContent() {
        Map<String, Object> map = new HashMap<>();

        CommodityCatExample catExample = new CommodityCatExample();
        catExample.setOrderByClause("`sort` DESC");
        CommodityCatExample.Criteria catCriteria = catExample.createCriteria();
        catCriteria.andPidEqualTo(Long.valueOf(1));
        List<CommodityCat> categoryList = commodityCatMapper.selectByExample(catExample);
        for (CommodityCat cat : categoryList){
            CommodityCatExample cellExample = new CommodityCatExample();
            CommodityCatExample.Criteria cellCriteria = cellExample.createCriteria();
            cellCriteria.andPidEqualTo(cat.getId());
            List<CommodityCat> cellList = commodityCatMapper.selectByExample(cellExample);
            map.put(cat.getName(), cellList);
        }
        return map;
    }

    @Override
    public Map<String, Object> getAdContent() {
        Map<String, Object> map = new HashMap<>();

        CommodityContentExample contentExample = new CommodityContentExample();
        CommodityContentExample.Criteria contentCriteria = contentExample.createCriteria();
        contentCriteria.andCategoryIdEqualTo(Long.valueOf(32));
        List<CommodityContent> leftContents = commodityContentMapper.selectByExample(contentExample);
        map.put("left_adv", leftContents);

        CommodityContentExample contentOtherExample = new CommodityContentExample();
        CommodityContentExample.Criteria contentOtherCriteria = contentOtherExample.createCriteria();
        contentOtherCriteria.andCategoryIdEqualTo(Long.valueOf(8));
        List<CommodityContent> rightContent = commodityContentMapper.selectByExample(contentOtherExample);
        map.put("right_adv", rightContent);

        return map;
    }

    @Override
    public Map<String, Object> getContentList(Long pid) {
        Map<String, Object> map = new HashMap<>();

        CommodityContentCategoryExample contentCategoryExample = new CommodityContentCategoryExample();
        CommodityContentCategoryExample.Criteria contentCategoryCriteria = contentCategoryExample.createCriteria();
        contentCategoryCriteria.andParentIdEqualTo(pid);
        List<CommodityContentCategory> contentCategories = commodityContentCategoryMapper.selectByExample(contentCategoryExample);
        for (CommodityContentCategory category  : contentCategories){
            CommodityContentExample contentExample = new CommodityContentExample();
            CommodityContentExample.Criteria contentCriteria = contentExample.createCriteria();
            contentCriteria.andCategoryIdEqualTo(category.getId());
            List<CommodityContent> contents = commodityContentMapper.selectByExample(contentExample);
            map.put(category.getName(), contents);
        }

        return map;
    }


}
