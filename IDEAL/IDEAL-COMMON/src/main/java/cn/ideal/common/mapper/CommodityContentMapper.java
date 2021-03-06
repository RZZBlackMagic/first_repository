package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityContent;
import cn.ideal.common.pojo.CommodityContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityContentMapper {
    int countByExample(CommodityContentExample example);

    int deleteByExample(CommodityContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityContent record);

    int insertSelective(CommodityContent record);

    List<CommodityContent> selectByExample(CommodityContentExample example);

    CommodityContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByExample(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByPrimaryKeySelective(CommodityContent record);

    int updateByPrimaryKey(CommodityContent record);
}