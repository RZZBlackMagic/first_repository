package cn.ideal.merchant.service;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.pojo.RelaMerPro;
import cn.ideal.pojo.RelaMerProCom;

import java.util.List;

public interface ApplyMerchantService {
     TableJsonResult getCompanyListForTable(Integer limit, Integer page, String search);
     MessageResult ApplyCompany(RelaMerPro relaMerPro);
     TableJsonResult getAppliedComListForTable(int limit,int page,Long merchantId);
     TableJsonResult getCommdityListForMer(int limit,int page,String productorId);
     MessageResult ApplyCommodityForMer(String id,Long merchantId,Long productorId,String productorName,String merchantName);
}
