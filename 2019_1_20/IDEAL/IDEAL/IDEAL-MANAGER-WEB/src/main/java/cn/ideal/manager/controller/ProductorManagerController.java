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
    @RequestMapping("/manager/initTable/productorManager.do")
    @ResponseBody
    public TableJsonResult initProductorTable(int page, int limit){
        System.out.println(111111);
        TableJsonResult tableJsonResult = productorManagerService.initProductorTableService(page,limit);
        System.out.println("***********"+tableJsonResult);
        return tableJsonResult;
    }

    /**
     * 管理人员通过注册用户申请动作
     * @param id
     * @return
     */
    @RequestMapping("/manager/bootstrap/editProductorStatus.do")
    @ResponseBody
    public MessageResult editProductorStatus(String id){
         System.out.println("********"+id);
         String message = productorManagerService.editProductorStatus(id);
        return MessageResult.ok(message);
    }

    /**
     * 删除注册用户
     * @param id
     * @return
     */
    @RequestMapping("/manager/bootstrap/deleteProductor.do")
    @ResponseBody
    public MessageResult deleteProductor(String id){
        String message = productorManagerService.deleteProductor(id);
        return MessageResult.ok(message);
    }

    /**
     * 将已经通过的用户选择出来加载table
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/manager/initAllowedTable/productorManager.do")
    @ResponseBody
    public TableJsonResult initAllowedProductor(int page, int limit){
         TableJsonResult tableJsonResult = productorManagerService.initAllowedProductorService(page, limit);
        System.out.println("*****************"+tableJsonResult);
        return tableJsonResult;
    }

    /**
     * 封号操作
     * @param id
     * @return
     */
    @RequestMapping("/manager/bootstrap/clockProductor.do")
    @ResponseBody
    public MessageResult clockProductor(String id){
        String message = productorManagerService.clockProductor(id);
        return MessageResult.ok(message);
    }

    /**
     * 加载被封号的table
     * @return
     */
    @RequestMapping("/manager/initTable/clockProductorManager.do")
    @ResponseBody
    public TableJsonResult initClockProductor(int page, int limit){
        TableJsonResult tableJsonResult = productorManagerService.initClockProductorService(page,limit);
        System.out.println("*****************"+tableJsonResult);
        return tableJsonResult;
    }
    /**
     * 解封操作
     */
    @RequestMapping("/manager/bootstrap/unClockProductor.do")
    @ResponseBody
    public MessageResult unClockProductor(String id){
        String message = productorManagerService.unClockProductorService(id);
        return MessageResult.ok(message);
    }
}
