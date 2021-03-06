package cn.ideal.common.mapper;

import cn.ideal.common.pojo.RelaMerProCom;
import cn.ideal.common.pojo.RelaMerProComExample;
import cn.ideal.common.pojo.RelaMerProComKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelaMerProComMapper {
    int countByExample(RelaMerProComExample example);

    int deleteByExample(RelaMerProComExample example);

    int deleteByPrimaryKey(RelaMerProComKey key);

    int insert(RelaMerProCom record);

    int insertSelective(RelaMerProCom record);

    List<RelaMerProCom> selectByExample(RelaMerProComExample example);

    RelaMerProCom selectByPrimaryKey(RelaMerProComKey key);

    int updateByExampleSelective(@Param("record") RelaMerProCom record, @Param("example") RelaMerProComExample example);

    int updateByExample(@Param("record") RelaMerProCom record, @Param("example") RelaMerProComExample example);

    int updateByPrimaryKeySelective(RelaMerProCom record);

    int updateByPrimaryKey(RelaMerProCom record);
}