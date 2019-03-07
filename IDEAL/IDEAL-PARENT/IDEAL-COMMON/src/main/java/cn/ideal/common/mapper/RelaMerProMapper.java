package cn.ideal.common.mapper;

import cn.ideal.common.pojo.RelaMerPro;
import cn.ideal.common.pojo.RelaMerProExample;
import cn.ideal.common.pojo.RelaMerProKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelaMerProMapper {
    long countByExample(RelaMerProExample example);

    int deleteByExample(RelaMerProExample example);

    int deleteByPrimaryKey(RelaMerProKey key);

    int insert(RelaMerPro record);

    int insertSelective(RelaMerPro record);

    List<RelaMerPro> selectByExample(RelaMerProExample example);

    RelaMerPro selectByPrimaryKey(RelaMerProKey key);

    int updateByExampleSelective(@Param("record") RelaMerPro record, @Param("example") RelaMerProExample example);

    int updateByExample(@Param("record") RelaMerPro record, @Param("example") RelaMerProExample example);

    int updateByPrimaryKeySelective(RelaMerPro record);

    int updateByPrimaryKey(RelaMerPro record);
}