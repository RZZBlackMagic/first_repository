package cn.ideal.mapper;

import cn.ideal.pojo.RelaMerProCom;
import cn.ideal.pojo.RelaMerProComExample;
import cn.ideal.pojo.RelaMerProComKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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