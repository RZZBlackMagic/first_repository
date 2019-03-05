package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.pojo.CommodityOrderShippingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityOrderShippingMapper {
    int countByExample(CommodityOrderShippingExample example);

    int deleteByExample(CommodityOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(CommodityOrderShipping record);

    int insertSelective(CommodityOrderShipping record);

    List<CommodityOrderShipping> selectByExample(CommodityOrderShippingExample example);

    CommodityOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") CommodityOrderShipping record, @Param("example") CommodityOrderShippingExample example);

    int updateByExample(@Param("record") CommodityOrderShipping record, @Param("example") CommodityOrderShippingExample example);

    int updateByPrimaryKeySelective(CommodityOrderShipping record);

    int updateByPrimaryKey(CommodityOrderShipping record);
}