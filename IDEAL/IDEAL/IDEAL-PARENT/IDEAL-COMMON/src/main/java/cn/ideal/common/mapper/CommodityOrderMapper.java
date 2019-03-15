package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityOrderMapper {
    long countByExample(CommodityOrderExample example);

    int deleteByExample(CommodityOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommodityOrder record);

    int insertSelective(CommodityOrder record);

    List<CommodityOrder> selectByExample(CommodityOrderExample example);

    CommodityOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByExample(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByPrimaryKeySelective(CommodityOrder record);

    int updateByPrimaryKey(CommodityOrder record);
}