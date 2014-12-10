package com.qianqian.user.service;

import java.util.Date;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.AccountRecord;
/**
 * 账户记录的业务逻辑
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.AccountRecordService.java
 * @ClassName	: AccountRecordService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月15日 下午4:28:18
 */
public interface IAccountRecordService {
	/**
	 * 查找账户记录
	 *  @Method_Name    : getAll
	 *  @param uid		   ：用户id
	 *  @param pageBounds :封装的分页条件
	 *  @return 
	 *  @return         : List<AccountRecord>
	 *  @Creation Date  : 2014年4月16日 上午9:45:37
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<AccountRecord> getAll(Long uid,PageBounds pageBounds);
	/**
	 * 增加账户记录		
	 *  @Method_Name    : addAccountRecord
	 *  @param accountRecord
	 *  @return 
	 *  @return         : int 返回影响的行数
	 *  @Creation Date  : 2014年4月16日 上午10:22:20
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	int addAccountRecord (AccountRecord accountRecord);
	List<AccountRecord> getAllByDate(Long uid, PageBounds pageBounds,
			Date date);
	
}
