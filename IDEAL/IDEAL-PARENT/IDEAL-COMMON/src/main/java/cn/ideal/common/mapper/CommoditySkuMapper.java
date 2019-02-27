package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommoditySku;
import cn.ideal.common.pojo.CommoditySkuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommoditySkuMapper {
    int countByExample(CommoditySkuExample example);

    int deleteByExample(CommoditySkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommoditySku record);

    int insertSelective(CommoditySku record);

    List<CommoditySku> selectByExample(CommoditySkuExample example);

    CommoditySku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommoditySku record, @Param("example") CommoditySkuExample example);

    int updateByExample(@Param("record") CommoditySku record, @Param("example") CommoditySkuExample example);

    int updateByPrimaryKeySelective(CommoditySku record);

    int updateByPrimaryKey(CommoditySku record);
}