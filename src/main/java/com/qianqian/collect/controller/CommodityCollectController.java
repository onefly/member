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
import com.qianqian.collect.model.MemCommodityCollect;
import com.qianqian.collect.service.IBrandCollectService;
import com.qianqian.collect.service.ICommodityCollectService;

/**
 * 我的商品收藏控制器
 * 
 * @Project : member.maxtp
 * @Program Name:
 *          com.qianqian.collect.controller.CommodityCollectController.java
 * @ClassName : CommodityCollectController
 * @Author : caozhifei
 * @CreateDate : 2014年5月4日 上午11:01:14
 */
@Controller
@RequestMapping("/collect")
public class CommodityCollectController {
	private static Logger log = LoggerFactory
			.getLogger(CommodityCollectController.class);
	/**
	 * 我的收藏商品展示链接
	 */
	private static final String COMMODITY_COLLECT = "collect/commodityCollect";
	/**
	 * 注入品牌收藏service
	 */
	@Resource(name = "brandCollectService")
	private IBrandCollectService brandCollectService;
	/**
	 * 注入商品收藏service
	 */
	@Resource(name = "commodityCollectService")
	private ICommodityCollectService commodityCollectService;

	/**
	 * 根据查询条件分页查询我收藏的商品
	 * 
	 * @Method_Name : getCommodityCollect
	 * @param key
	 * @param pageBounds
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月29日 上午11:51:50
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getCommodityCollect")
	public String getCommodityCollect(String key, PageBounds pageBounds,
			ModelMap map) {
		log.debug("getCommodityCollect handle start ... key = " + key
				+ " pageBounds=" + pageBounds.toString());
		Long userId = SessionUtil.getSessionData().getId();
		List<MemCommodityCollect> commodityList;
		// 每页记录数
		pageBounds.setLimit(20);
		if (StringUtils.isBlank(key)) {
			// 查询条件为空时
			commodityList = commodityCollectService
					.getPagiCommodityCollectListByUserId(userId, pageBounds);
		} else {
			commodityList = commodityCollectService
					.getPagiCommodityCollectListByUserIdAndName(userId, key,
							pageBounds);
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageList<MemCommodityCollect> pageCommodity = (PageList) commodityList;
		// 总记录数
		int comAllCount = pageCommodity.getPaginator().getTotalCount();
		map.put("commodityList", commodityList);
		map.put("comAllCount", comAllCount);
		map.put("comPage", pageBounds.getPage());
		// 总页数
		int comAllPage = (comAllCount - 1) / 20 + 1;
		map.put("comAllPage", comAllPage);
		map.put("key", key);
		log.debug("getCommodityCollect handle end ,the all count is "
				+ comAllCount);
		return COMMODITY_COLLECT;
	}

	/**
	 * 根据商品收藏ID 和当前登录用户ID进行删除操作
	 * 
	 * @Method_Name : deleteCommodityCollect
	 * @param id
	 *            商品收藏ID
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月29日 上午11:10:56
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteCommodityCollect")
	public String deleteCommodityCollect(String ids) {
		log.debug("deleteCommodityCollect handle start , ids=" + ids);
		Long userId = SessionUtil.getSessionData().getId();
		boolean result = commodityCollectService.deleteCommodityCollectById(
				ids, userId);
		log.debug("deleteCommodityCollect handle end , result=" + result);
		return "redirect:/collect/getCommodityCollect.htm";
	}

	/**
	 * 添加商品到商品收藏中
	 * 
	 * @Method_Name : addCommodityCollect
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
	@RequestMapping(value = "addCommodityCollect", method = RequestMethod.POST)
	public String addCommodityCollect(MemCommodityCollect commodity,
			ModelMap map) {
		log.debug("MemCommodityCollect = " + commodity);
		int result = commodityCollectService.addCommodityCollect(commodity);
		map.put("result", result);
		return "";
	}
}
