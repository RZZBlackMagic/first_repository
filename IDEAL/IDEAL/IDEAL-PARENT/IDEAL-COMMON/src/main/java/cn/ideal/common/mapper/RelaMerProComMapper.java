package cn.ideal.common.mapper;

import cn.ideal.common.pojo.RelaMerProCom;
import cn.ideal.common.pojo.RelaMerProComExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelaMerProComMapper {
    long countByExample(RelaMerProComExample example);

    int deleteByExample(RelaMerProComExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RelaMerProCom record);

    int insertSelective(RelaMerProCom record);

    List<RelaMerProCom> selectByExample(RelaMerProComExample example);

    RelaMerProCom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RelaMerProCom record, @Param("example") RelaMerProComExample example);

    int updateByExample(@Param("record") RelaMerProCom record, @Param("example") RelaMerProComExample example);

    int updateByPrimaryKeySelective(RelaMerProCom record);

    int updateByPrimaryKey(RelaMerProCom record);
}