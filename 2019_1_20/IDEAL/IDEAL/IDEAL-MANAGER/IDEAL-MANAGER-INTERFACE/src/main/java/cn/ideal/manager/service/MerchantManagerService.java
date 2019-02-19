package cn.ideal.manager.service;

import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.pojo.RelaMerPro;

import java.util.List;

public interface MerchantManagerService {
   public TableJsonResult getUnRelaMerProListForTable(int limit,int page);
   public TableJsonResult getRelaMerProListForTable(int limit ,int page);
   public TableJsonResult getRelaProMerComListForTable(int limit ,int page);
   public TableJsonResult getUnRelaProMerComListForTable(int limit ,int page);

}
