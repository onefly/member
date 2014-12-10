package com.qianqian.user.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.Medal;
import com.qianqian.user.model.MedalExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MedalMapper {
    int countByExample(MedalExample example);

    int deleteByExample(MedalExample example);

    int deleteByPrimaryKey(Long userMedalId);

    int insert(Medal record);

    int insertSelective(Medal record);

    List<Medal> selectByExample(MedalExample example,PageBounds pageBounds);

    Medal selectByPrimaryKey(Long userMedalId);

    int updateByExampleSelective(@Param("record") Medal record, @Param("example") MedalExample example);

    int updateByExample(@Param("record") Medal record, @Param("example") MedalExample example);

    int updateByPrimaryKeySelective(Medal record);

    int updateByPrimaryKey(Medal record);
}