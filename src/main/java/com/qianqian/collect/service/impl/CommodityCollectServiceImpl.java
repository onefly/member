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
import com.qianqian.collect.mapper.MemCommodityCollectMapper;
import com.qianqian.collect.model.MemCommodityCollect;
import com.qianqian.collect.model.MemCommodityCollectExample;
import com.qianqian.collect.service.ICommodityCollectService;

/**
 * 会员中心我的商品收藏操作接口实现类
 * 
 * @Project : member.maxtp
 * @Program Name:
 *          com.qianqian.user.service.impl.CommodityCollectServiceImpl.java
 * @ClassName : CommodityCollectServiceImpl
 * @Author : caozhifei
 * @CreateDate : 2014年4月29日 上午10:31:05
 */
@Service("commodityCollectService")
public class CommodityCollectServiceImpl implements ICommodityCollectService {
	private static Logger log = LoggerFactory
			.getLogger(CommodityCollectServiceImpl.class);
	/**
	 * 注入mapper
	 */
	@Resource(name = "memCommodityCollectMapper")
	private MemCommodityCollectMapper memCommodityCollectMapper;

	/**
	 * 根据当前登录用户的主键ID 分页查询收藏的品牌
	 * 
	 * @Method_Name : getPagiCommodityCollectListNByUserId
	 * @param userId
	 *            用户主键ID
	 * @param pageBounds
	 *            分页对象
	 * @return
	 * @return : List<MemCommodityCollect>
	 * @Creation Date : 2014年4月29日 上午10:17:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public List<MemCommodityCollect> getPagiCommodityCollectListByUserId(
			Long userId, PageBounds pageBounds) {
		MemCommodityCollectExample example = new MemCommodityCollectExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<MemCommodityCollect> list = memCommodityCollectMapper
				.selectByExample(example, pageBounds);
		log.debug("getPagiCommodityCollectListNByUserIdAndName success ,and list count is "
				+ list.size());
		return list;

	}

	/**
	 * 根据当前登录用户的主键ID和查询关键字 分页查询收藏的品牌
	 * 
	 * @Method_Name : getPagiCommodityCollectListNByUserId
	 * @param userId
	 *            用户主键ID
	 * @param key
	 *            查询关键字
	 * @param pageBounds
	 *            分页对象
	 * @return
	 * @return : List<MemCommodityCollect>
	 * @Creation Date : 2014年4月29日 上午10:17:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public List<MemCommodityCollect> getPagiCommodityCollectListByUserIdAndName(
			Long userId, String key, PageBounds pageBounds) {
		MemCommodityCollectExample example = new MemCommodityCollectExample();
		example.createCriteria().andUserIdEqualTo(userId)
				.andCommodityNameLike("%" + key + "%");
		List<MemCommodityCollect> list = memCommodityCollectMapper
				.selectByExample(example, pageBounds);
		log.debug("getPagiCommodityCollectListNByUserIdAndName success ,and list count is "
				+ list.size());
		return list;
	}

	/**
	 * 根据主键ID和用户主键ID删除用户收藏的品牌
	 * 
	 * @Method_Name : deleteCommodityCollectById
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
	public boolean deleteCommodityCollectById(String ids, Long userId) {
		MemCommodityCollectExample example = new MemCommodityCollectExample();
		List<Long> idList = StringUtil.String2LongList(ids);
		example.createCriteria().andUserIdEqualTo(userId)
				.andCollectIdIn(idList);
		int result = memCommodityCollectMapper.deleteByExample(example);
		if (result > 0) {
			log.debug("deleteBrandCollectById success and result is " + result);
			return true;
		} else {
			log.debug("deleteBrandCollectById failure and result is " + result);
			return false;
		}
	}

	/**
	 * 收藏商品操作
	 * 
	 * @Method_Name : addCommodityCollect
	 * @param commodity
	 * @return
	 * @return : int 0收藏失败 1 收藏成功 2 已经收藏过
	 * @Creation Date : 2014年4月30日 上午10:35:13
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public int addCommodityCollect(MemCommodityCollect commodity) {
		commodity.setCollectTime(new Date());
		commodity.setUserId(SessionUtil.getSessionData().getId());// 设置当前登录用户id
		MemCommodityCollectExample example = new MemCommodityCollectExample();
		example.createCriteria()
				.andCommodityIdEqualTo(commodity.getCommodityId())
				.andUserIdEqualTo(commodity.getUserId());
		List<MemCommodityCollect> list = memCommodityCollectMapper
				.selectByExample(example);
		log.debug(" check result list is "+list+" list size is "+list.size());
		if (list.size() > 0) {
			log.debug("user is already collect this commodity and commodityId is "+commodity.getCommodityId());
			return 2;
		}		
		log.debug("MemCommodityCollect is "+commodity);
		int result = memCommodityCollectMapper.insert(commodity);
		return result;
	}

	/**
	 * 用户收藏商品数量
	 * 
	 * @Method_Name : getCommodityCollectCountByUser
	 * @param userId
	 * @return
	 * @version : v1.00
	 * @Author : peichunting
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public int getCommodityCollectCountByUser(Long userId) {
		// TODO Auto-generated method stub
		MemCommodityCollectExample example = new MemCommodityCollectExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return memCommodityCollectMapper.countByExample(example);

	}

}
