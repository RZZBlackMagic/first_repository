package cn.ideal.common.mapper;

import cn.ideal.common.pojo.AccountProductor;
import cn.ideal.common.pojo.AccountProductorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountProductorMapper {
    long countByExample(AccountProductorExample example);

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