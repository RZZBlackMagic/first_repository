package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityOrderItemMapper {
    int countByExample(CommodityOrderItemExample example);

    int deleteByExample(CommodityOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommodityOrderItem record);

    int insertSelective(CommodityOrderItem record);

    List<CommodityOrderItem> selectByExample(CommodityOrderItemExample example);

    CommodityOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommodityOrderItem record, @Param("example") CommodityOrderItemExample example);

    int updateByExample(@Param("record") CommodityOrderItem record, @Param("example") CommodityOrderItemExample example);

    int updateByPrimaryKeySelective(CommodityOrderItem record);

    int updateByPrimaryKey(CommodityOrderItem record);
}