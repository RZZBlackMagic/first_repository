package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommoditySkuSpevExample;
import cn.ideal.common.pojo.CommoditySkuSpevKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommoditySkuSpevMapper {
    long countByExample(CommoditySkuSpevExample example);

    int deleteByExample(CommoditySkuSpevExample example);

    int deleteByPrimaryKey(CommoditySkuSpevKey key);

    int insert(CommoditySkuSpevKey record);

    int insertSelective(CommoditySkuSpevKey record);

    List<CommoditySkuSpevKey> selectByExample(CommoditySkuSpevExample example);

    int updateByExampleSelective(@Param("record") CommoditySkuSpevKey record, @Param("example") CommoditySkuSpevExample example);

    int updateByExample(@Param("record") CommoditySkuSpevKey record, @Param("example") CommoditySkuSpevExample example);
}