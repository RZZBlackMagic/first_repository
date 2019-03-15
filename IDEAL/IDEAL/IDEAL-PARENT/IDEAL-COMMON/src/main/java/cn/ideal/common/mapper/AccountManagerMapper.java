package cn.ideal.common.mapper;

import cn.ideal.common.pojo.AccountManager;
import cn.ideal.common.pojo.AccountManagerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountManagerMapper {
    long countByExample(AccountManagerExample example);

    int deleteByExample(AccountManagerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountManager record);

    int insertSelective(AccountManager record);

    List<AccountManager> selectByExample(AccountManagerExample example);

    AccountManager selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountManager record, @Param("example") AccountManagerExample example);

    int updateByExample(@Param("record") AccountManager record, @Param("example") AccountManagerExample example);

    int updateByPrimaryKeySelective(AccountManager record);

    int updateByPrimaryKey(AccountManager record);
}