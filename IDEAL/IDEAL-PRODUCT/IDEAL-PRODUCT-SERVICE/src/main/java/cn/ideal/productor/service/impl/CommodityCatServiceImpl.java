package cn.ideal.productor.service.impl;

import cn.ideal.common.mapper.CommodityCatMapper;
import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.pojo.CommodityCatExample;
import cn.ideal.common.results.TreeJsonResult;
import cn.ideal.productor.service.CommodityCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XINER
 * @create 2019-01-31 19:49
 * @desc 商品分类Service
 **/
@Service
public class CommodityCatServiceImpl implements CommodityCatService {

    @Autowired
    private CommodityCatMapper commodityCatMapper;

    @Override
    public List<TreeJsonResult> getCommodityCatList(long parentID) {

        CommodityCatExample example = new CommodityCatExample();
        List<CommodityCat> list = commodityCatMapper.selectByExample(example);
        List<TreeJsonResult> resultList = new ArrayList<>();
        for (CommodityCat commodityCat: list){
            TreeJsonResult treeNode = new TreeJsonResult(commodityCat.getId(), commodityCat.getName(), commodityCat.getPid(), commodityCat.getIsparent().toString());
            resultList.add(treeNode);
        }
        return resultList;
    }
}
