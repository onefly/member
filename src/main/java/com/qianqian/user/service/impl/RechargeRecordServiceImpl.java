package com.qianqian.user.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.framelib.utils.DateUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.mapper.RechargeRecordMapper;
import com.qianqian.user.model.RechargeRecord;
import com.qianqian.user.model.RechargeRecordExample;
import com.qianqian.user.service.IRechargeRecordService;

/**
 * 充值记录的业务逻辑操作
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.impl.RechargeRecordServiceImpl.java
 * @ClassName	: RechargeRecordServiceImpl 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月16日 下午1:27:45
 */
@Service("rechargeRecordService")
public class RechargeRecordServiceImpl implements IRechargeRecordService {
	
	private static Logger log = LoggerFactory.getLogger(AccountRecordServiceImple.class);
	@Resource
	private RechargeRecordMapper rechargeRecordMapper;

	@Override
	public List<RechargeRecord> getAll(Long uid, PageBounds pageBounds) {

		RechargeRecordExample example = new RechargeRecordExample();

		RechargeRecordExample.Criteria criteria = example.createCriteria();

		criteria.andUserIdEqualTo(uid);

		List<RechargeRecord> list=rechargeRecordMapper.selectByExample(example, pageBounds);
		log.debug("充值记录的条数："+list.size());
		return list;

	}

	@Override
	public int addRechargeRecord(RechargeRecord rechargeRecord) {
		log.debug("增加充值记录："+rechargeRecord);
		rechargeRecord.setRechargeTime(new Date());
		return rechargeRecordMapper.insertSelective(rechargeRecord);
	}

	@Override
	public List<RechargeRecord> getAll(Long uid, PageBounds pageBounds,
			Date date) {
		log.debug("日期："+date);
		RechargeRecordExample example = new RechargeRecordExample();

		RechargeRecordExample.Criteria criteria = example.createCriteria();

		criteria.andUserIdEqualTo(uid);
		criteria.andRechargeTimeLessThan(DateUtil.addDay(date, 1));
		criteria.andRechargeTimeGreaterThan(date);
		
		List<RechargeRecord> list=rechargeRecordMapper.selectByExample(example, pageBounds);
		log.debug("充值记录的条数："+list.size());
		return list;
	
	}

}
