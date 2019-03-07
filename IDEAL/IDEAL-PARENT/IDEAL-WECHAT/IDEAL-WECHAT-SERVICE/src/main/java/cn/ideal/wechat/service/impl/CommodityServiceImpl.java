package cn.ideal.wechat.service.impl;

import cn.ideal.common.mapper.*;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;
import cn.ideal.wechat.service.CommodityService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommoditySpuMapper commoditySpuMapper;
    @Autowired
    private CommoditySkuMapper commoditySkuMapper;
    @Autowired
    private CommoditySpeMapper commoditySpeMapper;
    @Autowired
    private CommoditySpevMapper commoditySpevMapper;
    @Autowired
    private CommoditySpuSpeMapper commoditySpuSpeMapper;
    @Autowired
    private RelaMerProComMapper relaMerProComMapper;
    @Autowired
    private CommoditySkuSpevMapper commoditySkuSpevMapper;
    @Autowired
    private AccountProductorMapper accountProductorMapper;

    @Override
    public int getGoodsCount() {
        CommoditySpuExample example = new CommoditySpuExample();
        CommoditySpuExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        return commoditySpuMapper.countByExample(example);
    }

    @Override
    public TableJsonResult getGoodsList(Long cid, String location, Integer page, Integer size) {
        HashMap<String, Object> map = new HashMap<>();

        //设置分页信息
        PageHelper.startPage(page, size);

        RelaMerProComExample example = new RelaMerProComExample();
        RelaMerProComExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andLocationEqualTo(location);
        criteria.andStatusEqualTo((byte) 1);
        List<RelaMerProCom> list = relaMerProComMapper.selectByExample(example);
        List<Map<String, Object>> sList = new LinkedList<>();
        for (RelaMerProCom cell : list){
            CommoditySpu spu = commoditySpuMapper.selectByPrimaryKey(cell.getCommodityId());
            HashMap<String, Object> spuMap = new HashMap<>();
            spuMap.put("id", spu.getId());
            spuMap.put("list_pic_url", spu.getImage());
            spuMap.put("name", spu.getTitle());

            CommoditySkuExample sku_example = new CommoditySkuExample();
            CommoditySkuExample.Criteria sku_criteria = sku_example.createCriteria();
            sku_criteria.andSpuidEqualTo(spu.getId());
            List<CommoditySku> commoditySkus = commoditySkuMapper.selectByExample(sku_example);

            double min_price = commoditySkus.get(0).getPrice();
            for (CommoditySku sku : commoditySkus){
                if (sku.getPrice() < min_price)
                    min_price = sku.getPrice();
                if (sku.getDiscount() < min_price && sku.getDiscount() != 0)
                    min_price = sku.getDiscount();
            }
            spuMap.put("retail_price", min_price);
            sList.add(spuMap);
        }
        //取查询结果
        TableJsonResult result = new TableJsonResult(sList.size(), sList);

        return result;
    }

    @Override
    public Map<String, Object> getGoodDetail(Long id) {
        HashMap<String, Object> map = new HashMap<>();
        CommoditySpu spu = commoditySpuMapper.selectByPrimaryKey(id);
        CommoditySkuExample skuExample = new CommoditySkuExample();
        CommoditySkuExample.Criteria skuCriteria = skuExample.createCriteria();
        skuCriteria.andSpuidEqualTo(id);
        List<CommoditySku> skus = commoditySkuMapper.selectByExample(skuExample);


        Integer retail_price = skus.get(0).getPrice();
        LinkedList<HashMap<String, Object>> gallery = new LinkedList<>();
        for (CommoditySku sku : skus){
            //填装价格
            if (sku.getDiscount() != 0 && sku.getDiscount() < retail_price)
                retail_price = sku.getDiscount();
            if (sku.getPrice() < retail_price)
                retail_price = sku.getPrice();
            //填装轮播图
            HashMap<String, Object> galleryCell = new HashMap<>();
            galleryCell.put("id", sku.getId());
            galleryCell.put("img_url", sku.getImage());
            gallery.add(galleryCell);
        }
        //装填规格
        LinkedList<HashMap<String, Object>> specificationList = new LinkedList<>();
        CommoditySpuSpeExample spuSpeExample = new CommoditySpuSpeExample();
        CommoditySpuSpeExample.Criteria spuSpeCriteria = spuSpeExample.createCriteria();
        spuSpeCriteria.andSpuidEqualTo(id);
        List<CommoditySpuSpeKey> spuSpeKeys = commoditySpuSpeMapper.selectByExample(spuSpeExample);
        for (CommoditySpuSpeKey key : spuSpeKeys ){
            HashMap speMap = new HashMap();
            CommoditySpe spe = commoditySpeMapper.selectByPrimaryKey(key.getSpeid());
            speMap.put("specification_id", spe.getId());
            speMap.put("name", spe.getName());
            
            CommoditySpevExample spevExample = new CommoditySpevExample();
            CommoditySpevExample.Criteria spevCriteria = spevExample.createCriteria();
            spevCriteria.andSpeidEqualTo(spe.getId());
            List<CommoditySpev> commoditySpevs = commoditySpevMapper.selectByExample(spevExample);
            LinkedList<HashMap<String, Object>> spevList = new LinkedList<>();
            for (CommoditySpev spev : commoditySpevs){
                HashMap<String, Object> spevMap = new HashMap<>();
                spevMap.put("id", spev.getId());
                spevMap.put("specification_id", spev.getSpeid());
                spevMap.put("value", spev.getValue());
                spevList.add(spevMap);
            }
            speMap.put("valueList", spevList);
            specificationList.add(speMap);
        }

        map.put("id", id);

        HashMap<String, Object> goodsMap = new HashMap<>();
        goodsMap.put("name", spu.getTitle());
        goodsMap.put("goods_brief", spu.getSellpoint());
        goodsMap.put("retail_price", retail_price);
        goodsMap.put("descp", skus.get(0).getDescp());
        map.put("goods", goodsMap);

        map.put("gallery", gallery);

        HashMap<String, Object> brandMap = new HashMap<>();
        brandMap.put("brandId", spu.getApid());
        brandMap.put("name", accountProductorMapper.selectByPrimaryKey(spu.getApid()).getCompanyZh());
        map.put("brand", brandMap);

        map.put("specificationList", specificationList);

        map.put("attribute", null);

        map.put("issueList", null);

        map.put("comment", null);

        map.put("productList", null);

        map.put("userHasCollect", 0);

        return map;
    }

    @Override
    public MessageResult checkSku(String id) {
        String[] ids = id.split(",");
        ArrayList<Long> id_list = new ArrayList<>();
        ArrayList<Long> sku_list = new ArrayList<>();
        for (String id_cell : ids){
            id_list.add(Long.valueOf(id_cell));
        }
        CommoditySkuSpevExample example = new CommoditySkuSpevExample();
        CommoditySkuSpevExample.Criteria criteria = example.createCriteria();
        criteria.andSpevidIn(id_list);
        List<CommoditySkuSpevKey> keys = commoditySkuSpevMapper.selectByExample(example);
        for (CommoditySkuSpevKey cell : keys){
            if (!sku_list.contains(cell.getSkuid()))
                sku_list.add(cell.getSkuid());
        }
        for (Long sku_cell : sku_list){
            ArrayList<Long> check = new ArrayList<>();
            criteria.andSkuidEqualTo(sku_cell);
            List<CommoditySkuSpevKey> spevKeys = commoditySkuSpevMapper.selectByExample(example);
            for (CommoditySkuSpevKey key : spevKeys){
                if (!check.contains(key.getSpevid()))
                    check.add(key.getSpevid());
            }
            if (check.equals(id_list)){
                HashMap<String, Object> res = new HashMap<>();
                CommoditySku sku = commoditySkuMapper.selectByPrimaryKey(sku_cell);
                res.put("sku", sku.getId());
                res.put("price", sku.getPrice());
                res.put("discount", sku.getDiscount());
                res.put("descp", sku.getDescp());
                res.put("quantity", sku.getQuantity());
                return MessageResult.ok(res);
            }
        }
        return MessageResult.build(400, "商品不存在!");
    }
}
