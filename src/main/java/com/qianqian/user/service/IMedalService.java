package com.qianqian.user.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.user.model.Medal;
/**
 * 大牌勋章业务接口
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.IMedalService.java
 * @ClassName	: IMedalService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月28日 下午5:37:42
 */
public interface IMedalService {
	/**
	 * 根据用户id和分页条件查询大牌胸章
	 *  @Method_Name    : getAllMedal
	 *  @param userId    ：用户id
	 *  @param pageBounds ：封装的分页条件
	 *  @return 		返回Medal集合
	 *  @return         : List<Medal>
	 *  @Creation Date  : 2014年4月28日 下午5:38:15
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public List<Medal> getAllMedal(long userId,PageBounds pageBounds);
	/**
	 * 根据用户id和关键字和分页条件查询大牌胸章
	 *  @Method_Name    : getPagiMedalByKyeword
	 *  @param userId	用户userId
	 *  @param keyword	：关键字
	 *  @param pageBounds
	 *  @return 
	 *  @return         : List<Medal>
	 *  @Creation Date  : 2014年5月6日 上午11:16:12
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public List<Medal>getPagiMedalByKeyword(long userId,String keyword,PageBounds pageBounds);
}
