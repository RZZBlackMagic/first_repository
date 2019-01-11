package com.ideal.mapper;

import com.ideal.pojo.RelaCommodityCat;
import com.ideal.pojo.RelaCommodityCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelaCommodityCatMapper {
    int countByExample(RelaCommodityCatExample example);

    int deleteByExample(RelaCommodityCatExample example);

    int insert(RelaCommodityCat record);

    int insertSelective(RelaCommodityCat record);

    List<RelaCommodityCat> selectByExample(RelaCommodityCatExample example);

    int updateByExampleSelective(@Param("record") RelaCommodityCat record, @Param("example") RelaCommodityCatExample example);

    int updateByExample(@Param("record") RelaCommodityCat record, @Param("example") RelaCommodityCatExample example);
}