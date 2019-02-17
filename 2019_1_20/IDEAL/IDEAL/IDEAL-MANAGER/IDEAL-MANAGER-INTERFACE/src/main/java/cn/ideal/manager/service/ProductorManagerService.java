package cn.ideal.manager.service;

import cn.ideal.common.pojo.TableJsonResult;

public interface ProductorManagerService {
    public TableJsonResult initProductorTableService(int page, int limit);
    public String editProductorStatus(String id);
    public String deleteProductor(String id);
    public TableJsonResult initAllowedProductorService(int page, int limit);
    public String clockProductor(String id);
    public TableJsonResult initClockProductorService(int page, int limit);
    public String unClockProductorService(String id);
}
