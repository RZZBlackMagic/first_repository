package cn.ideal.mapper;

import cn.ideal.pojo.AccountProductor;
import cn.ideal.pojo.AccountProductorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountProductorMapper {
    int countByExample(AccountProductorExample example);

    int deleteByExample(AccountProductorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountProductor record);

    int insertSelective(AccountProductor record);

    List<AccountProductor> selectByExample(AccountProductorExample example);

    AccountProductor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountProductor record, @Param("example") AccountProductorExample example);

    int updateByExample(@Param("record") AccountProductor record, @Param("example") AccountProductorExample example);

    int updateByPrimaryKeySelective(AccountProductor record);

    int updateByPrimaryKey(AccountProductor record);
}