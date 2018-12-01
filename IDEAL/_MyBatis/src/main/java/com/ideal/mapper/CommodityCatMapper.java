package com.ideal.mapper;

import com.ideal.pojo.CommodityCat;
import com.ideal.pojo.CommodityCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityCatMapper {
    int countByExample(CommodityCatExample example);

    int deleteByExample(CommodityCatExample example);

    int insert(CommodityCat record);

    int insertSelective(CommodityCat record);

    List<CommodityCat> selectByExample(CommodityCatExample example);

    int updateByExampleSelective(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);

    int updateByExample(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);
}