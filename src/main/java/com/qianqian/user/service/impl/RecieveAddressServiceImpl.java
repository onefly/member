package com.qianqian.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framelib.common.SessionData;
import com.framelib.utils.DateUtil;
import com.framelib.utils.SessionUtil;
import com.framelib.utils.StringUtil;
import com.qianqian.user.common.UserConstants;
import com.qianqian.user.mapper.RecieveAddressMapper;
import com.qianqian.user.model.RecieveAddress;
import com.qianqian.user.model.RecieveAddressExample;
import com.qianqian.user.service.IRecieveAddressService;

/**
 * Title:ShippingAddressServiceImpl
 * Description:收货地址实现
 * @Create_by:yinsy
 * @Create_date:2014-4-29
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:member.maxtp 1.0
 */
@Service("recieveAddressService")
public class RecieveAddressServiceImpl implements IRecieveAddressService {
	
	private final static Logger log = LoggerFactory.getLogger(RecieveAddressServiceImpl.class);
	
	@Autowired
	RecieveAddressMapper recieveAddressMapper;
	
	/**
	 * 2014-4-29, 下午01:41:00
	 * 方法描述：查询收货地址
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RecieveAddress> searchRecAddr() throws Exception {
		RecieveAddressExample example = new RecieveAddressExample();
		example.createCriteria().andUserIdEqualTo(getUserId()).andDeleteFlagEqualTo(UserConstants.DELETE_FLAG_DEF);
		example.setOrderByClause("modify_time desc");
		try {
			List<RecieveAddress> recAddrList = recieveAddressMapper.selectByExample(example);
			return recAddrList;
		} catch (Exception e) {
			log.error("查询收货地址失败"+e);
			throw new Exception();
		}
	}
	
	/**
	 * 2014-4-30, 上午09:13:10
	 * 方法描述：获取收货地址
	 * @param id 主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public RecieveAddress getRecAddr(String id) throws Exception {
		try {
			RecieveAddress recAddr = recieveAddressMapper.selectByPrimaryKey(Long.parseLong(id));
			return recAddr;
		} catch (Exception e) {
			log.error("获取收货地址失败"+e);
			throw new Exception();
		}
	}

	/**
	 * 2014-4-29, 下午01:41:17
	 * 方法描述：新增收货地址
	 * @param recAddr 收货地址model
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addRecAddr(RecieveAddress recAddr) throws Exception {
		recAddr.setUserId(getUserId());
		recAddr.setCreateTime(DateUtil.getCurrentDate());
		recAddr.setModifyTime(DateUtil.getCurrentDate());
		recAddr.setDeleteFlag(UserConstants.DELETE_FLAG_DEF);
		try {
			if (!modifyRecAddrDef(recAddr)) {
				recAddr.setIsDefaultAddress(UserConstants.DEF_ADDR_BYTE);
			}
			recieveAddressMapper.insert(recAddr);
			return 1;
		} catch (Exception e) {
			log.error("新增收货地址失败"+e);
			throw new Exception();
		}
	}

	/**
	 * 2014-4-29, 下午01:41:24
	 * 方法描述：删除收货地址
	 * @param id 主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteRecAddr(String id) throws Exception {
		RecieveAddress addr = new RecieveAddress();
		try {
			addr.setRecieveAddressId(Long.parseLong(id));
			addr.setDeleteFlag(UserConstants.DELETE_FLAG_DEF_DEL);
			return recieveAddressMapper.updateByPrimaryKeySelective(addr);
		} catch (Exception e) {
			log.error("删除收货地址失败"+e);
			throw new Exception();
		}
	}

	/**
	 * 2014-4-29, 下午01:41:34
	 * 方法描述：修改收货地址
	 * @param addr 收货地址model
	 * @return
	 * @throws Exception
	 */
	@Override
	public int modifyRecAddr(RecieveAddress recAddr) throws Exception {
		try {
			modifyRecAddrDef(recAddr);
			return recieveAddressMapper.updateByPrimaryKeySelective(recAddr);
		} catch (Exception e) {
			log.error("删除收货地址失败"+e);
			throw new Exception();
		}
	}
	
	/**
	 * 方法描述：修改默认收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-30
	 * @param recAddr 地址对象
	 * @return boolean true默认地址不为空，修改默认地址，false否
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	private boolean modifyRecAddrDef(RecieveAddress recAddr) throws Exception {
		if (StringUtil.notEmpty(recAddr.getIsDefaultAddress())) {
			Map<String, Object> paramMap = new HashMap<String, Object>();	//参数Map
			paramMap.put("defAddr", UserConstants.DEF_ADDR_BYTE);
			paramMap.put("userId", getUserId());
			recieveAddressMapper.updateDefAddr(paramMap);
			return true;
		}
		return false;
	}
	
	/**
	 * 获取用户ID
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	private long getUserId() {
		try {
			SessionData sessionData = SessionUtil.getSessionData();
			return sessionData.getId();
		} catch (Exception e) {
			return 0;
		}
	}


}
