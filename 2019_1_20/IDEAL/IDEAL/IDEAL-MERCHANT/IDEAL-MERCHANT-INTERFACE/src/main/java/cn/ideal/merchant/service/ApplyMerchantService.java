package cn.ideal.merchant.service;

import java.util.List;

public interface ApplyMerchantService {
    public List SearchCompanyForTable(String limit, String page, String search);
    public String ApplyCompany(Long merchantId,String merchantName,Long productorId,String productorName );
    public List initAppliedComTable(int limit,int page,Long merchantId);
    public List getCommdityForMer(String productorId);
}
