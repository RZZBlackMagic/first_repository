package cn.ideal.manager.service;

import cn.ideal.common.results.MessageResult;
import cn.ideal.common.results.TableJsonResult;


/**
 * @author XINER
 * @create 2019-02-18 10:34
 * @desc
 **/
public interface ProductManagerService {

    TableJsonResult getProductListForTable(int page, int limit);

    MessageResult editProductStatus(String id);

    MessageResult deleteProduct(String id);

    TableJsonResult allowProduct(int page, int limit);

    MessageResult lockProduct(String id);

    MessageResult unlockProduct(String id);

    TableJsonResult getLockProductForTable(int page, int limit);
}
