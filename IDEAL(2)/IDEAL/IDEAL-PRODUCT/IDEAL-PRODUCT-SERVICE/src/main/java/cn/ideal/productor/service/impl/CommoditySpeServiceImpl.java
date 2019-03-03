package cn.ideal.productor.service.impl;

import cn.ideal.common.mapper.CommoditySkuMapper;
import cn.ideal.common.mapper.CommoditySpeMapper;
import cn.ideal.common.mapper.CommoditySpevMapper;
import cn.ideal.common.mapper.CommoditySpuSpeMapper;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.productor.service.CommoditySpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XINER
 * @create 2019-02-08 13:35
 * @desc
 **/
@Service
public class CommoditySpeServiceImpl implements CommoditySpeService {

    @Autowired
    private CommoditySpuSpeMapper commoditySpuSpeMapper;
    @Autowired
    private CommoditySpeMapper commoditySpeMapper;
    @Autowired
    private CommoditySpevMapper commoditySpevMapper;

    @Override
    public MessageResult getSpeSpevBySpuId(Long id) {

        ArrayList<Long> speids = new ArrayList<>();
        ArrayList<String> spenames = new ArrayList<>();
        String res = "";
        CommoditySpuSpeExample example = new CommoditySpuSpeExample();
        CommoditySpuSpeExample.Criteria criteria = example.createCriteria();
        criteria.andSpuidEqualTo(id);
        List<CommoditySpuSpeKey> spuSpeKeys = commoditySpuSpeMapper.selectByExample(example);
        for (CommoditySpuSpeKey cell : spuSpeKeys){
            CommoditySpe commoditySpe = commoditySpeMapper.selectByPrimaryKey(cell.getSpeid());
            speids.add(commoditySpe.getId());
            spenames.add(commoditySpe.getName());
        }
        for (int i = 0; i < speids.size(); i++){
            CommoditySpevExample example1 = new CommoditySpevExample();
            CommoditySpevExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSpeidEqualTo(speids.get(i));
            List<CommoditySpev> spevs = commoditySpevMapper.selectByExample(example1);
            res += speids.get(i).toString() + ":";
            res += spenames.get(i) + ":";
            for (CommoditySpev cell : spevs){
                res += cell.getId().toString() + "." + cell.getValue() + ",";
            }
            res = res.substring(0, res.length()-1);
            res += ";";
        }
        return MessageResult.ok(res);
    }

}
