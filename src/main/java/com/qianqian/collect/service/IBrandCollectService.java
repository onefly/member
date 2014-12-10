package com.qianqian.collect.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.collect.model.MemBrandCollect;

/**
 * 会员中心，我的品牌收藏 操作接口
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.service.IBrandCollectService.java
 * @ClassName : IBrandCollectService
 * @Author : caozhifei
 * @CreateDate : 2014年4月29日 上午10:12:43
 */
public interface IBrandCollectService {
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
	public List<MemBrandCollect> getPagiBrandCollectListByUserId(Long userId,
			PageBounds pageBounds);

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
	public List<MemBrandCollect> getPagiBrandCollectListByUserIdAndName(
			Long userId, String key, PageBounds pageBounds);

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
	public boolean deleteBrandCollectById(String ids, Long userId);
	/**
	 * 收藏品牌操作
	 *  @Method_Name    : addCommodityCollect
	 *  @param commodity
	 *  @return 
	 *  @return         : int 0收藏失败 1 收藏成功 2 已经收藏过
	 *  @Creation Date  : 2014年4月30日 上午10:35:13
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public int addBrandCollect(MemBrandCollect brand);
	
	
	/**
	 * 用户收藏品牌个数
	 * @param userId
	 * @return
	 * @author peichunting
	 */
	public int getBrandCollectCountByUser(long userId);
}
