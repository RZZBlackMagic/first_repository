package cn.ideal.manager.service;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;

public interface ProductorManagerService {
    public TableJsonResult getProductorListForTable(int page, int limit);
    public MessageResult editProductorStatus(String id);
    public MessageResult deleteProductor(String id);
    public TableJsonResult getAllowedProductorListForTable(int page, int limit);
    public MessageResult clockProductor(String id);
    public TableJsonResult getClockProductorListForTable(int page, int limit);
    public MessageResult unClockProductor(String id);
}
