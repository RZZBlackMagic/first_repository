package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.CommodityCatMapper;
import cn.ideal.common.mapper.CommoditySpuMapper;
import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.pojo.CommodityCatExample;
import cn.ideal.wechat.service.CommodityCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityCatServiceImpl implements CommodityCatService {

    @Autowired
    private CommodityCatMapper commodityCatMapper;
    @Autowired
    private CommoditySpuMapper commoditySpuMapper;

    @Override
    public Map<String, Object> catalogList() {
        HashMap<String, Object> map = new HashMap<>();

        CommodityCatExample example = new CommodityCatExample();
        example.setOrderByClause("`sort` DESC");
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo((long)1);
        ArrayList<CommodityCat> navList = (ArrayList<CommodityCat>) commodityCatMapper.selectByExample(example);
        map.put("navList", navList);
        map.put("currentCategory", catalogCurrent((long) 2));
        return map;
    }

    @Override
    public Map<String, Object> catalogCurrent(Long id){
        HashMap<String, Object> map = new HashMap<>();

        CommodityCat commodityCat = commodityCatMapper.selectByPrimaryKey(id);
        map.put("id", commodityCat.getId());
        map.put("front_name", commodityCat.getFrontName());
        map.put("name", commodityCat.getName());
        map.put("wap_banner_url", commodityCat.getImage());

        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(id);
        ArrayList<CommodityCat> subCategoryList = (ArrayList<CommodityCat>) commodityCatMapper.selectByExample(example);
        map.put("subCategoryList", subCategoryList);

        return map;
    }

    @Override
    public Map<String, Object> brotherCategory(Long id) {
        HashMap<String, Object> map = new HashMap<>();

        CommodityCat cat = commodityCatMapper.selectByPrimaryKey(id);

        CommodityCatExample example = new CommodityCatExample();
        CommodityCatExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(cat.getPid());
        List<CommodityCat> cats = commodityCatMapper.selectByExample(example);
        map.put("brotherCategory", cats);

        HashMap<String, Object> newMap = new HashMap<>();
        newMap.put("id", cat.getId());
        newMap.put("front_name", cat.getFrontName());
        newMap.put("name", cat.getName());
        map.put("currentCategory", newMap);

        return map;
    }

}

