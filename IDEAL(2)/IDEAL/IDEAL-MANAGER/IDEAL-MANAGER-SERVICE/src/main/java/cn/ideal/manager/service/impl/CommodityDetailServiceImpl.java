package cn.ideal.manager.service.impl;

import cn.ideal.common.mapper.*;
import cn.ideal.common.pojo.*;
import cn.ideal.manager.service.CommodityDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author XINER
 * @create 2019-03-10 14:39
 * @desc
 **/
public class CommodityDetailServiceImpl implements CommodityDetailService {

    @Autowired
    private CommoditySpuMapper spuMapper;
    @Autowired
    private CommoditySkuMapper skuMapper;
    @Autowired
    private CommoditySpuSpeMapper spuSpeMapper;
    @Autowired
    private CommoditySpeMapper speMapper;
    @Autowired
    private CommoditySpevMapper spevMapper;
    @Autowired
    private CommoditySkuSpevMapper skuSpevMapper;

    @Override
    public Map<String, Object> getSpuMessage(Long spuid) {
        Map<String, Object> res = new HashMap<>();
        CommoditySpu spu = spuMapper.selectByPrimaryKey(spuid);
        res.put("spu", spu);
        return res;
    }

    @Override
    public Map<String, Object> getSpeSkuMessage(Long spuid, String spevs) {

        Map<String, Object> res = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<Long> default_data = new LinkedList<>();

        CommoditySpuSpeExample spuSpeExample = new CommoditySpuSpeExample();
        CommoditySpuSpeExample.Criteria spuSpeCriteria = spuSpeExample.createCriteria();
        spuSpeCriteria.andSpuidEqualTo(spuid);
        List<CommoditySpuSpeKey> spuSpeKeys = spuSpeMapper.selectByExample(spuSpeExample);
        for (CommoditySpuSpeKey spuSpeKey : spuSpeKeys) {
            CommoditySpe spe = speMapper.selectByPrimaryKey(spuSpeKey.getSpeid());

            CommoditySpevExample spevExample = new CommoditySpevExample();
            CommoditySpevExample.Criteria spevCriteria = spevExample.createCriteria();
            spevCriteria.andSpeidEqualTo(spe.getId());
            List<CommoditySpev> spevList = spevMapper.selectByExample(spevExample);
            default_data.add(spevList.get(0).getId());
            data.put(spe.getName(), spevList);
        }
        res.put("data", data);

        if (spevs == null) {
            res.put("sku", getSkuBySpevid(default_data));
            Collections.sort(default_data);
            res.put("default_data", default_data);
        } else {
            String[] spevIds = spevs.split(",");
            List<Long> spevsList = new LinkedList<>();
            for (String cell : spevIds){
                spevsList.add(Long.valueOf(cell));
            }
            Collections.sort(default_data);
            res.put("default_data", spevsList);
            res.put("sku", getSkuBySpevid(spevsList));
        }
        return res;
    }

    @Override
    public CommoditySku getSkuBySpevid(List<Long> spev) {

        List<Long> sku_list = new LinkedList<>();

        CommoditySkuSpevExample example = new CommoditySkuSpevExample();
        CommoditySkuSpevExample.Criteria criteria = example.createCriteria();
        criteria.andSpevidIn(spev);
        List<CommoditySkuSpevKey> keys = skuSpevMapper.selectByExample(example);
        for (CommoditySkuSpevKey cell : keys) {
            if (!sku_list.contains(cell.getSkuid()))
                sku_list.add(cell.getSkuid());
        }
        for (Long sku_cell : sku_list) {
            ArrayList<Long> check = new ArrayList<>();
            CommoditySkuSpevExample exampleOther = new CommoditySkuSpevExample();
            CommoditySkuSpevExample.Criteria criteriaOther = exampleOther.createCriteria();
            criteriaOther.andSkuidEqualTo(sku_cell);
            List<CommoditySkuSpevKey> spevKeys = skuSpevMapper.selectByExample(exampleOther);
            for (CommoditySkuSpevKey key : spevKeys) {
                if (!check.contains(key.getSpevid()))
                    check.add(key.getSpevid());
            }
            if (check.containsAll(spev)) {
                return skuMapper.selectByPrimaryKey(sku_cell);
            }
        }
        return null;
    }
}
