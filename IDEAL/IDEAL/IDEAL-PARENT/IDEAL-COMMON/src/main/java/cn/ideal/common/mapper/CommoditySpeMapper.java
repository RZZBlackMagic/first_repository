package cn.ideal.common.mapper;

import cn.ideal.common.pojo.CommoditySpe;
import cn.ideal.common.pojo.CommoditySpeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommoditySpeMapper {
    long countByExample(CommoditySpeExample example);

    int deleteByExample(CommoditySpeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommoditySpe record);

    int insertSelective(CommoditySpe record);

    List<CommoditySpe> selectByExample(CommoditySpeExample example);

    CommoditySpe selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommoditySpe record, @Param("example") CommoditySpeExample example);

    int updateByExample(@Param("record") CommoditySpe record, @Param("example") CommoditySpeExample example);

    int updateByPrimaryKeySelective(CommoditySpe record);

    int updateByPrimaryKey(CommoditySpe record);
}