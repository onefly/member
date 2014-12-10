package com.qianqian.user.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.RechargeRecord;
import com.qianqian.user.model.RechargeRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RechargeRecordMapper {
    int countByExample(RechargeRecordExample example);

    int deleteByExample(RechargeRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(RechargeRecord record);

    int insertSelective(RechargeRecord record);

    List<RechargeRecord> selectByExample(RechargeRecordExample example,PageBounds pageBounds);

    RechargeRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);

    int updateByExample(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);

    int updateByPrimaryKeySelective(RechargeRecord record);

    int updateByPrimaryKey(RechargeRecord record);
}