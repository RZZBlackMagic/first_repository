package cn.ideal.mapper;

import cn.ideal.pojo.CommodityCat;
import cn.ideal.pojo.CommodityCatExample;
import cn.ideal.pojo.CommodityCatKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityCatMapper {
    int countByExample(CommodityCatExample example);

    int deleteByExample(CommodityCatExample example);

    int deleteByPrimaryKey(CommodityCatKey key);

    int insert(CommodityCat record);

    int insertSelective(CommodityCat record);

    List<CommodityCat> selectByExample(CommodityCatExample example);

    CommodityCat selectByPrimaryKey(CommodityCatKey key);

    int updateByExampleSelective(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);

    int updateByExample(@Param("record") CommodityCat record, @Param("example") CommodityCatExample example);

    int updateByPrimaryKeySelective(CommodityCat record);

    int updateByPrimaryKey(CommodityCat record);
}