package cn.ideal.product.service;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;

public interface MerchantManagerService {

    TableJsonResult getMerchantApplyList(Integer limit, Integer page, Long product_id);

    MessageResult handleMerchantApply(Long product_id, String merchant_id, String option);

    TableJsonResult getMerchantManageList(Integer limit, Integer page, Long product_id);

}
