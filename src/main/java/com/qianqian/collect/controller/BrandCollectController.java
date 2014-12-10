package com.qianqian.collect.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framelib.utils.SessionUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.qianqian.collect.model.MemBrandCollect;
import com.qianqian.collect.service.IBrandCollectService;

/**
 * 我的品牌收藏控制器
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.controller.BrandCollectController.java
 * @ClassName : BrandCollectController
 * @Author : caozhifei
 * @CreateDate : 2014年4月29日 上午10:59:45
 */
@Controller
@RequestMapping("/collect")
public class BrandCollectController {
	private static Logger log = LoggerFactory
			.getLogger(BrandCollectController.class);
	/**
	 * 我的收藏品牌展示链接
	 */
	private static final String BRAND_COLLECT = "collect/brandCollect";
	/**
	 * 注入品牌收藏service
	 */
	@Resource(name = "brandCollectService")
	private IBrandCollectService brandCollectService;

	/**
	 * 根据查询条件分页查询我收藏的品牌
	 * 
	 * @Method_Name : getBrandCollect
	 * @param key
	 *            查询条件
	 * @param pageBounds
	 *            分页参数
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月29日 上午11:04:20
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getBrandCollect")
	public String getBrandCollect(String key, PageBounds pageBounds,
			ModelMap map) {
		log.debug("getBrandCollect handle start ... key = " + key
				+ " pageBounds=" + pageBounds.toString());
		Long userId = SessionUtil.getSessionData().getId();
		pageBounds.setLimit(20);
		List<MemBrandCollect> brandList = null;
		if (StringUtils.isBlank(key)) {
			// 查询条件为空时
			brandList = brandCollectService.getPagiBrandCollectListByUserId(
					userId, pageBounds);
		} else {
			brandList = brandCollectService
					.getPagiBrandCollectListByUserIdAndName(userId, key,
							pageBounds);
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageList<MemBrandCollect> pageBrand = (PageList) brandList;
		// 收藏品牌总记录数
		int brandAllCount = pageBrand.getPaginator().getTotalCount();
		map.put("brandAllCount", brandAllCount);
		map.put("brandPage", pageBounds.getPage());
		// 收藏品牌总页数
		int brandAllPage = (brandAllCount - 1) / 20 + 1;
		map.put("brandAllPage", brandAllPage);
		map.put("brandList", brandList);
		map.put("key", key);
		log.debug("getBrandCollect handle end ");
		return BRAND_COLLECT;
	}

	/**
	 * 根据品牌收藏ID 和当前登录用户ID进行删除操作
	 * 
	 * @Method_Name : deleteBrandCollect
	 * @param id
	 *            品牌收藏ID
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月29日 上午11:10:56
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteBrandCollect")
	public String deleteBrandCollect(String ids) {
		log.debug("deleteBrandCollect handle start , ids=" + ids);
		Long userId = SessionUtil.getSessionData().getId();
		boolean result = brandCollectService
				.deleteBrandCollectById(ids, userId);
		log.debug("deleteBrandCollect handle end , result=" + result);
		return "redirect:/collect/getBrandCollect.htm";
	}

	/**
	 * 添加品牌到品牌收藏中
	 * 
	 * @Method_Name : addBrandCollect
	 * @param commodity
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月30日 上午10:45:40
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping(value = "addBrandCollect", method = RequestMethod.POST)
	public String addBrandCollect(MemBrandCollect brand, ModelMap map) {
		log.debug("MemBrandCollect = " + brand);
		int result = brandCollectService.addBrandCollect(brand);
		map.put("result", result);
		return "";
	}
}
