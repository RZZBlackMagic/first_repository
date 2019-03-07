package cn.ideal.product.service.impl;

import cn.ideal.common.mapper.*;
import cn.ideal.common.pojo.*;
import cn.ideal.common.results.*;
import cn.ideal.product.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private CommodityCatMapper commodityCatMapper;
    @Autowired
    private CommoditySkuSpevMapper commoditySkuSpevMapper;

    @Override
    public MessageResult addCommodity(CommodityJsonResult commodity) {
        //id字段
        Long spu_id = null;
        ArrayList<Long> spe_ids = new ArrayList<>();
        //提取规格KV字段
        String[] arr = commodity.getSpe().split("/");
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> vals = new ArrayList<>();
        for(String cell : arr){
            String[] kv = cell.split(":");
            if (kv.length == 2) {
                keys.add(kv[0]);
                vals.add(kv[1]);
            }
        }
        //装载SPU
        CommoditySpu spu = new CommoditySpu(null, commodity.getTitle(), commodity.getCategory(), commodity.getApid(), commodity.getSellpoint(), commodity.getImage(), (byte)1);
        commoditySpuMapper.insert(spu);
        spu_id = spu.getId();
        //装载SPE
        for (String key : keys){
            CommoditySpe spe = new CommoditySpe(null, key);
            commoditySpeMapper.insert(spe);
            spe_ids.add(spe.getId());

        }
        //装载SPU_SPE
        for (Long spe_id : spe_ids){
            commoditySpuSpeMapper.insert(new CommoditySpuSpeKey(spu_id, spe_id));
        }
        //装载SPEV
        for (int i = 0; i < spe_ids.size(); i++){
            String[] vals_cell = vals.get(i).split(",");
            for (String val : vals_cell){
                commoditySpevMapper.insert(new CommoditySpev(null, spe_ids.get(i), val));
            }
        }
        return MessageResult.ok();
    }

    @Override
    public TableJsonResult getCommodityList(Integer limit, Integer page, Long apid) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        CommoditySpuExample example = new CommoditySpuExample();
        CommoditySpuExample.Criteria criteria = example.createCriteria();
        criteria.andApidEqualTo(apid);
        List<CommoditySpu> list = commoditySpuMapper.selectByExample(example);
        List<SpuResult> sList = new LinkedList<>();
        for (CommoditySpu cell : list){
            CommodityCat cat = commodityCatMapper.selectByPrimaryKey(cell.getCid());
            SpuResult spu = new SpuResult(cell.getId(), cell.getCid(), cell.getApid(), cell.getTitle(), cat.getName(), null, cell.getSellpoint(), cell.getImage(), cell.getStatus());
            sList.add(spu);
        }
        //取查询结果
        PageInfo<SpuResult> pageInfo = new PageInfo<>(sList);
        TableJsonResult result = new TableJsonResult(pageInfo.getTotal(), sList);
        return result;
    }

    @Override
    public TableJsonResult getSkuList(Integer limit, Integer page, Long spu) {
        //设置分页信息
        PageHelper.startPage(page, limit);
        //查询
        CommoditySkuExample example = new CommoditySkuExample();
        CommoditySkuExample.Criteria criteria = example.createCriteria();
        criteria.andSpuidEqualTo(spu);
        List<CommoditySku> list = commoditySkuMapper.selectByExample(example);
        List<SkuResult> sList = new LinkedList<>();
        for (CommoditySku cell : list){
            CommoditySkuSpevExample example1 = new CommoditySkuSpevExample();
            CommoditySkuSpevExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSkuidEqualTo(cell.getId());
            List<CommoditySkuSpevKey> ssList = commoditySkuSpevMapper.selectByExample(example1);
            String spe = "";
            for(CommoditySkuSpevKey cell1 : ssList){
                CommoditySpev spev = commoditySpevMapper.selectByPrimaryKey(cell1.getSpevid());
                spe += spev.getValue() + ",";
            }
            sList.add(new SkuResult(cell.getId(), cell.getSpuid(), cell.getCsid(), null, null, null, spe.substring(0, spe.length()-1), cell.getPrice(), cell.getDiscount(), cell.getQuantity(), null, cell.getImage(), cell.getPosition(), null, cell.getDescp(), null, cell.getStatus()));
        }
        //取查询结果
        PageInfo<SkuResult> pageInfo = new PageInfo<>(sList);
        TableJsonResult result = new TableJsonResult(pageInfo.getTotal(), sList);
        return result;
    }

    @Override
    public MessageResult addSku(Long id, String data) {
        CommoditySku sku = new CommoditySku();
        sku.setSpuid(id);
        sku.setStatus((byte)0);
        commoditySkuMapper.insertSelective(sku);

        Long skuId = sku.getId();

        String[] array = data.split(";");
        for (String cell : array){
            String[] cell_c = cell.split(":");
            commoditySkuSpevMapper.insert(new CommoditySkuSpevKey(skuId, Long.parseLong(cell_c[1])));
        }
        return MessageResult.ok();
    }

    @Override
    public MessageResult editSkuForTable(SkuResult sku) {
        CommoditySkuExample example = new CommoditySkuExample();
        example.createCriteria().andIdEqualTo(sku.getId());
        commoditySkuMapper.updateByExample(new CommoditySku(sku.getId(), sku.getSpuid(), sku.getCsid(), sku.getPrice(), sku.getDiscount(), sku.getQuantity(), sku.getSku_image(), sku.getPosition(), sku.getSku_status(), sku.getDescp()), example);
        return MessageResult.ok();
    }

    @Override
    public MessageResult editSkuForDesc(Long id, String image, String desc){
        CommoditySkuExample example = new CommoditySkuExample();
        example.createCriteria().andIdEqualTo(id);
        CommoditySku sku = new CommoditySku(id, null, null, null, null, null, image, null, null, desc);
        commoditySkuMapper.updateByExampleSelective(sku, example);
        return MessageResult.ok();
    }
}
