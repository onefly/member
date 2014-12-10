package com.qianqian.user.service;

import java.util.Date;
import java.util.List;




import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.RechargeRecord;
/**
 * 充值记录的业务逻辑操作
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.RechargeRecordService.java
 * @ClassName	: RechargeRecordService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月15日 下午4:35:43
 */
public interface IRechargeRecordService {
	

	/**
	 * 根据用户id分页显示充值记录
	 *  @Method_Name    : getAll
	 *  @param uid
	 *  @param pageBounds 分装的分页条件
	 *  @return 
	 *  @return         : List<RechargeRecord>
	 *  @Creation Date  : 2014年4月15日 下午4:36:05
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<RechargeRecord> getAll(Long uid,PageBounds pageBounds);
	/**
	 * 增加充值记录
	 *  @Method_Name    : addRechargeRecord
	 *  @param rechargeRecord
	 *  @return 
	 *  @return         : int 返回影响的行数
	 *  @Creation Date  : 2014年4月16日 上午10:24:12
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	int addRechargeRecord(RechargeRecord rechargeRecord );
	/**
	 * 根据用户id和日期分页显示充值记录
	 *  @Method_Name    : getAll
	 *  @param uid
	 *  @param pageBounds
	 *  @param date
	 *  @return 
	 *  @return         : List<RechargeRecord>
	 *  @Creation Date  : 2014年5月9日 上午11:05:43
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<RechargeRecord> getAll(Long uid,PageBounds pageBounds,Date date);
}
