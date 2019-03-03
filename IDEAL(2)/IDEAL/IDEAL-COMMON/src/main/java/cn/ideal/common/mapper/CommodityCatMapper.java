package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommodityCat;
import cn.ideal.common.pojo.CommodityCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityCatMapper {
    int countByExample(CommodityCatExample example);

    int deleteByExample(CommodityCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityCat record);

    int insertSelective(CommodityCat record);

    List<CommodityCat> selectByExample(CommodityCatExample example);

    CommodityCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);

    int updateByExample(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);

    int updateByPrimaryKeySelective(CommodityCat record);

    int updateByPrimaryKey(CommodityCat record);
}