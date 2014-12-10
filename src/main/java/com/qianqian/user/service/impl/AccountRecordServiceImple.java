package com.qianqian.user.service.impl;


import java.util.Date;
import java.util.List;










import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framelib.utils.DateUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.mapper.AccountRecordMapper;
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.model.AccountRecordExample;
import com.qianqian.user.service.IAccountRecordService;
/**
 * 账户记录的业务操作
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.impl.AccountRecordServiceImple.java
 * @ClassName	: AccountRecordServiceImple 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月15日 下午4:29:26
 */
@Service("accountRecordService")
public class AccountRecordServiceImple implements IAccountRecordService {
	
	private static Logger log = LoggerFactory.getLogger(AccountRecordServiceImple.class);
	
	@Resource
	private AccountRecordMapper accountRecordMapper;
	
	/**  
	 * 通过用户id查找该用户的账户记录
	 */
	
	public List<AccountRecord> getAll(Long uid,PageBounds pageBounds) {
		
		AccountRecordExample example =new AccountRecordExample();
		
		AccountRecordExample.Criteria criteria = example.createCriteria();
		
		criteria.andUserIdEqualTo(uid);
		List<AccountRecord> list= accountRecordMapper.selectByExample(example,pageBounds);
		log.debug("账户记录的条数："+list.size());
 		return list;
		
	}
	/**
	 * 通过日期是id查找记录
	 */
	public List<AccountRecord> getAllByDate(Long uid, PageBounds pageBounds,
			Date date) {
		
		
		AccountRecordExample example =new AccountRecordExample();
		
		AccountRecordExample.Criteria criteria = example.createCriteria();
		
		criteria.andUserIdEqualTo(uid);
		
		
		criteria.andRecordTimeGreaterThan(date);
		criteria.andRecordTimeLessThan(DateUtil.addDay(date, 1));
		
		List<AccountRecord> list= accountRecordMapper.selectByExample(example,pageBounds);
		log.debug("账户记录的条数："+list.size());
 		return list;
	}
	/**
	 * 增加账户记录
	 */
	@Override
	public int addAccountRecord(AccountRecord accountRecord) {
		return	accountRecordMapper.insert(accountRecord);
	
	}

}
