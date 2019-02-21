package cn.ideal.merchant.service;

import cn.ideal.common.pojo.RelaMerPro;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;

public interface ApplyMerchantService {
    TableJsonResult getCompanyListForTable(Integer limit, Integer page, String search);

    MessageResult ApplyCompany(RelaMerPro relaMerPro);

    TableJsonResult getAppliedComListForTable(int limit, int page, Long merchantId);

    TableJsonResult getCommdityListForMer(int limit, int page, String productorId);

    MessageResult ApplyCommodityForMer(String id, Long merchantId, Long productorId, String productorName, String merchantName);
}
