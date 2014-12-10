package com.qianqian.collect.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.framelib.utils.SessionUtil;
import com.framelib.utils.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.collect.mapper.MemBrandCollectMapper;
import com.qianqian.collect.model.MemBrandCollect;
import com.qianqian.collect.model.MemBrandCollectExample;
import com.qianqian.collect.service.IBrandCollectService;

/**
 * 会员中心，我的品牌收藏 操作接口实现类
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.service.impl.BrandCollectServiceImpl.java
 * @ClassName : BrandCollectServiceImpl
 * @Author : caozhifei
 * @CreateDate : 2014年4月29日 上午10:29:14
 */
@Service("brandCollectService")
public class BrandCollectServiceImpl implements IBrandCollectService {
	private static Logger log = LoggerFactory
			.getLogger(BrandCollectServiceImpl.class);
	/**
	 * 注入mapper
	 */
	@Resource(name = "memBrandCollectMapper")
	private MemBrandCollectMapper memBrandCollectMapper;

	/**
	 * 根据当前登录用户的主键ID 分页查询收藏的品牌
	 * 
	 * @Method_Name : getPagiBrandCollectListNByUserId
	 * @param userId
	 *            用户主键ID
	 * @param pageBounds
	 *            分页对象
	 * @return
	 * @return : List<MemBrandCollect>
	 * @Creation Date : 2014年4月29日 上午10:17:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public List<MemBrandCollect> getPagiBrandCollectListByUserId(Long userId,
			PageBounds pageBounds) {
		MemBrandCollectExample example = new MemBrandCollectExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<MemBrandCollect> list = memBrandCollectMapper.selectByExample(
				example, pageBounds);
		log.debug(" getPagiBrandCollectListNByUserId list success ,the list count is "
				+ list.size());
		return list;
	}

	/**
	 * 根据当前登录用户的主键ID和查询关键字 分页查询收藏的品牌
	 * 
	 * @Method_Name : getPagiBrandCollectListNByUserId
	 * @param userId
	 *            用户主键ID
	 * @param key
	 *            查询关键字
	 * @param pageBounds
	 *            分页对象
	 * @return
	 * @return : List<MemBrandCollect>
	 * @Creation Date : 2014年4月29日 上午10:17:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public List<MemBrandCollect> getPagiBrandCollectListByUserIdAndName(
			Long userId, String key, PageBounds pageBounds) {
		MemBrandCollectExample example = new MemBrandCollectExample();
		example.createCriteria().andUserIdEqualTo(userId).andBrandNameLike("%"+key+"%");
		List<MemBrandCollect> list = memBrandCollectMapper.selectByExample(
				example, pageBounds);
		log.debug(" getPagiBrandCollectListNByUserIdAndName list success ,the list count is "
				+ list.size());
		return list;
	}

	/**
	 * 根据主键ID和用户主键ID删除用户收藏的品牌
	 * 
	 * @Method_Name : deleteBrandCollectById
	 * @param id
	 *            收藏ID
	 * @param userId
	 *            当前登录用户主键ID
	 * @return
	 * @return : boolean true 删除成功，false 删除失败
	 * @Creation Date : 2014年4月29日 上午10:22:23
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean deleteBrandCollectById(String ids, Long userId) {
		MemBrandCollectExample example = new MemBrandCollectExample();
		List<Long> list = StringUtil.String2LongList(ids);
		example.createCriteria().andCollectIdIn(list)
				.andUserIdEqualTo(userId);
		int result = memBrandCollectMapper.deleteByExample(example);
		if (result > 0) {
			log.debug("deleteBrandCollectById success and result is" + result);
			return true;
		} else {
			log.debug("deleteBrandCollectById failure and result is" + result);
			return false;
		}
	}
	
	/**
	 * 收藏商品操作
	 * 
	 * @Method_Name : addBrandCollect
	 * @param brand
	 * @return
	 * @return : int 0收藏失败 1 收藏成功 2 已经收藏过
	 * @Creation Date : 2014年4月30日 上午10:35:13
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public int addBrandCollect(MemBrandCollect brand) {
		brand.setCollectTime(new Date());
		brand.setUserId(SessionUtil.getSessionData().getId());// 设置当前登录用户id
		MemBrandCollectExample example = new MemBrandCollectExample();
		example.createCriteria()
				.andBrandIdEqualTo(brand.getBrandId())
				.andUserIdEqualTo(brand.getUserId());
		List<MemBrandCollect> list = memBrandCollectMapper
				.selectByExample(example);
		log.debug(" check result list is "+list+" list size is "+list.size());
		if (list.size() > 0) {
			log.debug("user is already collect this brand and brandId is "+brand.getBrandId());
			return 2;
		}		
		log.debug("MemBrandCollect is "+brand);
		int result = memBrandCollectMapper.insert(brand);
		return result;
	}

	@Override
	public int getBrandCollectCountByUser(long userId) {
		// TODO Auto-generated method stub
		MemBrandCollectExample example = new MemBrandCollectExample();
		example.createCriteria().andUserIdEqualTo(userId);
		
		return memBrandCollectMapper.countByExample(example);
	}

}
