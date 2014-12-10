package com.qianqian.user.service;


import java.util.List;

import com.qianqian.user.model.RecieveAddress;

/**
 * Title:IShippingAddressService
 * Description:收货地址接口
 * @Create_by:yinsy
 * @Create_date:2014-4-29
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:member.maxtp 1.0
 */
public interface IRecieveAddressService {
	/**
	 * 查询收货地址列表
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	List<RecieveAddress> searchRecAddr() throws Exception;
	
	/**
	 * 获取收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-30
	 * @param id 主键
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	RecieveAddress getRecAddr(String id) throws Exception;
	
	/**
	 * 新增收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param recAddr 收货地址对象
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	int addRecAddr(RecieveAddress recAddr) throws Exception;
	
	/**
	 * 修改收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param recAddr 收货地址对象
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	int modifyRecAddr(RecieveAddress recAddr) throws Exception;
	
	/**
	 * 删除收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param id
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	int deleteRecAddr(String id) throws Exception;
}
