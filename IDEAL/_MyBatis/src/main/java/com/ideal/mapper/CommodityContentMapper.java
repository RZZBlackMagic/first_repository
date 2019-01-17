package com.ideal.mapper;

import com.ideal.pojo.CommodityContent;
import com.ideal.pojo.CommodityContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityContentMapper {
    int countByExample(CommodityContentExample example);

    int deleteByExample(CommodityContentExample example);

    int insert(CommodityContent record);

    int insertSelective(CommodityContent record);

    List<CommodityContent> selectByExampleWithBLOBs(CommodityContentExample example);

    List<CommodityContent> selectByExample(CommodityContentExample example);

    int updateByExampleSelective(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);

    int updateByExample(@Param("record") CommodityContent record, @Param("example") CommodityContentExample example);
}