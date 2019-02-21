package cn.ideal.manager.service;

import cn.ideal.common.results.TableJsonResult;

public interface MerchantManagerService {
    TableJsonResult getUnRelaMerProListForTable(int limit, int page);

    TableJsonResult getRelaMerProListForTable(int limit, int page);

    TableJsonResult getRelaProMerComListForTable(int limit, int page);

    TableJsonResult getUnRelaProMerComListForTable(int limit, int page);

}
