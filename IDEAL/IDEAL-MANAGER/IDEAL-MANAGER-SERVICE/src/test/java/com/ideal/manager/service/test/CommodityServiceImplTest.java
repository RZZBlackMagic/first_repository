package com.ideal.manager.service.test;

import com.ideal.common.pojo.CommdoityTableJsonResult;
import com.ideal.common.pojo.CommodityZtreeJsonResult;
import com.ideal.service.CommodityService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CommodityServiceImplTest {


    @Test
    public void CommodityTableJsonResultTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml","spring/applicationContext-service.xml","spring/applicationContext-trans.xml");
        CommodityService commodityService = ac.getBean("goodService",CommodityService.class);
        CommdoityTableJsonResult commdoityTableJsonResult = commodityService.getProductList("1,39,38,",10,1);
        System.out.println(commdoityTableJsonResult);
        System.out.println("认真学喊着");
        System.out.println("任章哲");
    }

}
