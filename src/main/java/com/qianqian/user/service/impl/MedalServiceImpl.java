package com.qianqian.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.mapper.MedalMapper;
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.model.AccountRecordExample;
import com.qianqian.user.model.Medal;
import com.qianqian.user.model.MedalExample;
import com.qianqian.user.service.IMedalService;
/**
 * 大牌勋章业务接口的实现类
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.impl.MedalServiceImpl.java
 * @ClassName	: MedalServiceImpl 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月28日 下午5:40:45
 */
@Service("medalService")
public class MedalServiceImpl implements IMedalService {
	@Resource
	private MedalMapper medalMapper;
	
	
	private static Logger logger = LoggerFactory.getLogger(MedalServiceImpl.class);
	/**
	 * 根据用户id和分页条件查询大牌勋章
	 */
	@Override
	public List<Medal> getAllMedal(long userId, PageBounds pageBounds) {
		
		MedalExample example =new MedalExample();
		//先按照显示顺序降序，再按照勋章数量降序排列
		example.setOrderByClause("show_level desc,medal_count desc");
		
		MedalExample.Criteria criteria = example.createCriteria();
		
		criteria.andUserIdEqualTo(userId);
		
		List<Medal> list= medalMapper.selectByExample(example,pageBounds);
		
		logger.debug("账户记录："+list);
		
 		return list;
		
	}
	/**
	 * 根据用户id,关键字和分页条件查询大牌勋章
	 */
	@Override
	public List<Medal> getPagiMedalByKeyword(long userId, String keyword,
			PageBounds pageBounds) {
		MedalExample example =new MedalExample();
		
		//先按照显示顺序降序，再按照勋章数量降序排列
		example.setOrderByClause("show_level desc,medal_count desc");
		
		MedalExample.Criteria criteria = example.createCriteria();
		
		criteria.andUserIdEqualTo(userId).andBrandNameLike("%"+keyword+"%");
		
		List<Medal> list= medalMapper.selectByExample(example,pageBounds);
		
		logger.debug("账户记录："+list);
		
 		return list;
	}

}
