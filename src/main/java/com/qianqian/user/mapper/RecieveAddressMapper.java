package com.qianqian.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qianqian.user.model.RecieveAddress;
import com.qianqian.user.model.RecieveAddressExample;

public interface RecieveAddressMapper {
    int countByExample(RecieveAddressExample example);

    int deleteByExample(RecieveAddressExample example);

    int deleteByPrimaryKey(Long recieveAddressId);

    int insert(RecieveAddress record);

    int insertSelective(RecieveAddress record);

    List<RecieveAddress> selectByExample(RecieveAddressExample example);

    RecieveAddress selectByPrimaryKey(Long recieveAddressId);

    int updateByExampleSelective(@Param("record") RecieveAddress record, @Param("example") RecieveAddressExample example);

    int updateByExample(@Param("record") RecieveAddress record, @Param("example") RecieveAddressExample example);

    int updateByPrimaryKeySelective(RecieveAddress record);

    int updateByPrimaryKey(RecieveAddress record);
    
    /**
     * 更新默认收货地址
     * @Create_by:yinsy
     * @Create_date:2014-4-29
     * @param paramMap 参数
     * @return
     * @Last_Edit_By:
     * @Edit_Description:
     * @Create_Version:member.maxtp 1.0
     */
    int updateDefAddr(Map<String, Object> paramMap);
}