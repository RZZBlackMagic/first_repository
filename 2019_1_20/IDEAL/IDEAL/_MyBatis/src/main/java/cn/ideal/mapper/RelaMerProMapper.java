package cn.ideal.mapper;

import cn.ideal.pojo.RelaMerPro;
import cn.ideal.pojo.RelaMerProExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelaMerProMapper {
    int countByExample(RelaMerProExample example);

    int deleteByExample(RelaMerProExample example);

    int insert(RelaMerPro record);

    int insertSelective(RelaMerPro record);

    List<RelaMerPro> selectByExample(RelaMerProExample example);

    int updateByExampleSelective(@Param("record") RelaMerPro record, @Param("example") RelaMerProExample example);

    int updateByExample(@Param("record") RelaMerPro record, @Param("example") RelaMerProExample example);
}