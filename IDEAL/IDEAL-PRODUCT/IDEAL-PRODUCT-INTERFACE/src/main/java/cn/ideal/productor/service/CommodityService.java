package cn.ideal.productor.service;

import cn.ideal.common.results.CommodityJsonResult;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.SKUResult;
import cn.ideal.common.results.TableJsonResult;

public interface CommodityService {

    MessageResult addCommodity(CommodityJsonResult commodity);

    TableJsonResult getCommodityList(Integer limit, Integer page, Long apid);

    TableJsonResult getSkuList(Integer limit, Integer page, Long spu);

    MessageResult addSku(Long id, String data);

    MessageResult editSkuForTable(SKUResult skuResult);

    MessageResult editSkuForDesc(Long id, String image, String desc);
}
