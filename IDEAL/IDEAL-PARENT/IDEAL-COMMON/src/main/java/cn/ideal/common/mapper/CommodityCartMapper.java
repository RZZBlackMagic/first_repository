package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityCart;
import cn.ideal.common.pojo.CommodityCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityCartMapper {
    long countByExample(CommodityCartExample example);

    int deleteByExample(CommodityCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityCart record);

    int insertSelective(CommodityCart record);

    List<CommodityCart> selectByExample(CommodityCartExample example);

    CommodityCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityCart record, @Param("example") CommodityCartExample example);

    int updateByExample(@Param("record") CommodityCart record, @Param("example") CommodityCartExample example);

    int updateByPrimaryKeySelective(CommodityCart record);

    int updateByPrimaryKey(CommodityCart record);
}