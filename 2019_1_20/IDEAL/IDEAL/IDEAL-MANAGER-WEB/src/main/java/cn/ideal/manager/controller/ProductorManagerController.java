package cn.ideal.manager.controller;

import cn.ideal.common.pojo.MessageResult;
import cn.ideal.common.pojo.TableJsonResult;
import cn.ideal.manager.service.ProductorManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductorManagerController {

    @Autowired
    private ProductorManagerService productorManagerService;
    @RequestMapping("/manager/getProductorListForTable/productorManager.do")
    @ResponseBody
    public TableJsonResult getProductorListForTable(int page, int limit){
        TableJsonResult tableJsonResult = productorManagerService.getProductorListForTable(page,limit);
        return tableJsonResult;
    }

    /**
     * 管理人员通过注册用户申请动作
     * @param id
     * @return
     */
    @RequestMapping("/manager/editProductorStatus/productorManager.do")
    @ResponseBody
    public MessageResult editProductorStatus(String id){

        return productorManagerService.editProductorStatus(id);
    }

    /**
     * 删除注册用户
     * @param id
     * @return
     */
    @RequestMapping("/manager/deleteProductor/productorManager.do")
    @ResponseBody
    public MessageResult deleteProductor(String id){
        return productorManagerService.deleteProductor(id);
    }

    /**
     * 将已经通过的用户选择出来加载table
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/manager/getAllowedProductorListForTable/productorManager.do")
    @ResponseBody
    public TableJsonResult getAllowedProductorListForTable(int page, int limit){
        return productorManagerService.getAllowedProductorListForTable(page, limit);
    }
    /**
     * 封号操作
     * @param id
     * @return
     */
    @RequestMapping("/manager/clockProductor/producotManager.do")
    @ResponseBody
    public MessageResult clockProductor(String id){
        return productorManagerService.clockProductor(id);
    }

    /**
     * 加载被封号的table
     * @return
     */
    @RequestMapping("/manager/getClockProductorListForTable/productorManager.do")
    @ResponseBody
    public TableJsonResult getClockProductorListForTable(int page, int limit){
        TableJsonResult tableJsonResult = productorManagerService.getClockProductorListForTable(page,limit);
        return tableJsonResult;
    }
    /**
     * 解封操作
     */
    @RequestMapping("/manager/unClockProductor/productorManager.do")
    @ResponseBody
    public MessageResult unClockProductor(String id){
        return productorManagerService.unClockProductor(id);
    }
}
