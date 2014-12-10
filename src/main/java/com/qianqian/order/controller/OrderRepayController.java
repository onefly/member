package com.qianqian.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.utils.SessionUtil;
import com.qianqian.order.dto.OrderOvertimeDTO;
import com.qianqian.order.dto.Query;
import com.qianqian.order.dto.RepayDetailDTO;
import com.qianqian.order.service.IOrderOvertimeDubboService;
import com.qianqian.order.utils.PageBean;

/**
 * 发货赔偿
 * @Project member.maxtp
 * @Package  com.qianqian.order.controller
 * @ClassName OrderRepayController
 * @Author chengshuang
 * @CreateDate 2014-8-18 下午3:32:19
 */
@Controller
@RequestMapping("/repay")
public class OrderRepayController {
	
	private final static String REPAY = "repay/free_repay";
	
	private final static String REPAY_DETAIL = "repay/repay_detail";
	
	/**
	 * 分页每页数据条数
	 */
	private final static int pageSize = 20;
	
	/**
	 * 个人中心 发货赔偿列表
	 * @Method_Name getOrderRepay
	 * @Creation Date 2014-8-19 下午3:07:32
	 * @version 
	 * @Author chengshuang
	 * @Update Date 
	 * @Update Author 
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping("/getOrderRepay")
	public String getOrderRepay(Query query, ModelMap map) {
		//设置查询条件
		query.setUserId(SessionUtil.getSessionData().getId());
		query.setPageSize(pageSize);
		
		PageBean<OrderOvertimeDTO> pageBean = orderOvertimeDubboService.findOrderOvertimePage(query);
		
		map.put("pageBean", pageBean);
		map.put("page", pageBean.getPage());
		map.put("query", query);
		return REPAY;
	}
	
	/**
	 * 赔付详细
	 * @Method_Name repayDetail
	 * @Creation Date 2014-8-21 下午2:13:15
	 * @version 
	 * @Author chengshuang
	 * @Update Date 
	 * @Update Author 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/repayDetail")
	public String repayDetail(Long id, ModelMap map) {
		RepayDetailDTO repayDetail = orderOvertimeDubboService.getRepayDetail(id);
		
		map.put("repayDetail", repayDetail);
		return REPAY_DETAIL;
	}
	
	@Resource
	private IOrderOvertimeDubboService orderOvertimeDubboService;
}
