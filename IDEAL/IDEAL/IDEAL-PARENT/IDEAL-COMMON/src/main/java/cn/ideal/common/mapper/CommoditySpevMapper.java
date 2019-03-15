package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommoditySpev;
import cn.ideal.common.pojo.CommoditySpevExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommoditySpevMapper {
    long countByExample(CommoditySpevExample example);

    int deleteByExample(CommoditySpevExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommoditySpev record);

    int insertSelective(CommoditySpev record);

    List<CommoditySpev> selectByExample(CommoditySpevExample example);

    CommoditySpev selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommoditySpev record, @Param("example") CommoditySpevExample example);

    int updateByExample(@Param("record") CommoditySpev record, @Param("example") CommoditySpevExample example);

    int updateByPrimaryKeySelective(CommoditySpev record);

    int updateByPrimaryKey(CommoditySpev record);
}