package com.qianqian.order.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.SessionData;
import com.framelib.utils.DateUtil;
import com.framelib.utils.Page;
import com.framelib.utils.SessionUtil;
import com.qianqian.order.dto.OrderBO;
import com.qianqian.order.dto.OrderListDTO;
import com.qianqian.order.dto.Query;
import com.qianqian.order.model.OrderChild;
import com.qianqian.order.service.IOrderDubboService;
import com.qianqian.order.utils.OrderConstants;

/**
 * 裸价体验订单列表展示的控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.order.controller.NakedController.java
 * @ClassName	: NakedController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014年7月16日 下午5:13:08
 */
@Controller
@RequestMapping("/nakedOrder")
public class NakedController {
	
	private static final Logger log = LoggerFactory.getLogger(NakedController.class);
	
	@Autowired
	private IOrderDubboService orderService;
	
	private static int pagasize = 10;
	
	private static final int TYPE = OrderConstants.NAKED_TYPE;
	
	private static final String NAKED_LIST = "order/myNake";
	
	private static final String NAKED_DIV = "order/nakedListDiv";
	
	/**
	 * 访问裸价体验列表的方法
	 *  @Method_Name    : getNakedList
	 *  @param model
	 *  @param query
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月16日 下午5:41:40
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getNakedOrderList")
	public String getNakedList(Model model, Query query){
		SessionData sd = SessionUtil.getSessionData();
		long userId = sd == null ? 5 : sd.getId();
		log.info("userId------->"+userId);
		
		query.setUserId(userId);
		query.setType(TYPE);
		query.setPageSize(pagasize);
		
		OrderBO orderBO = this.orderService.getOrderByQuery(query);
		Page page = orderBO.getPage();
		
		List<OrderListDTO> nakedOrderDTOs = orderBO.getOrderList();
		log.info("list size------>"+nakedOrderDTOs.size());
		for (OrderListDTO orderListDTO : nakedOrderDTOs) {
			List<OrderChild> orders = orderListDTO.getOrderChilds();
			for (OrderChild orderChild : orders) {
				//未付款状态
				if(orderChild.getState() == 200){
					//付款截止日期为下单时间加上3天
					Date endPayTime = DateUtil.afterNMinutesDate(orderChild.getOrderCreateTime(), 30);
					orderChild.setOrderCreateTime(endPayTime);
				}
			}
		}
		log.info("totalCount------->"+page.getTotalCount());
		model.addAttribute("nakedOrderDTOList", nakedOrderDTOs);
		model.addAttribute("page", page);
		return NAKED_LIST;
	}
	
	/**
	 * 授受页面ajax请求，返回用户实价体验列表展示
	 *  @Method_Name    : getNakedDiv
	 *  @param model
	 *  @param query
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月16日 下午5:45:27
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getNakedOrderDiv")
	public String getNakedDiv(Model model, Query query){
		SessionData sd = SessionUtil.getSessionData();
		long userId = sd == null ? 5 : sd.getId();
		log.info("userId------->"+userId);
		query.setUserId(userId);
		query.setPageSize(pagasize);
		query.setType(TYPE);
		
		OrderBO orderBO = this.orderService.getOrderByQuery(query);
		Page page = orderBO.getPage();
		
		List<OrderListDTO> nakedOrderDTOs = orderBO.getOrderList();
		for (OrderListDTO orderListDTO : nakedOrderDTOs) {
			List<OrderChild> orderChlid = orderListDTO.getOrderChilds();
			for (OrderChild orderChild : orderChlid) {
				//未付款状态
				if(orderChild.getState() == 200){
					//付款截止日期为下单时间加上3天
					Date endPayTime = DateUtil.afterNMinutesDate(orderChild.getOrderCreateTime(), 30);
					orderChild.setOrderCreateTime(endPayTime);
				}
			}
		}
		log.info("totalCount----->"+page.getTotalCount());
		model.addAttribute("page", page);
		model.addAttribute("nakedOrderDTOList", nakedOrderDTOs);
		return NAKED_DIV;
	}
	
}
