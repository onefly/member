package com.qianqian.user.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.model.AccountRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AccountRecordMapper {
    int countByExample(AccountRecordExample example);

    int deleteByExample(AccountRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountRecord record);

    int insertSelective(AccountRecord record);

    List<AccountRecord> selectByExample(AccountRecordExample example,PageBounds pageBounds);

    AccountRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountRecord record, @Param("example") AccountRecordExample example);

    int updateByExample(@Param("record") AccountRecord record, @Param("example") AccountRecordExample example);

    int updateByPrimaryKeySelective(AccountRecord record);

    int updateByPrimaryKey(AccountRecord record);
}