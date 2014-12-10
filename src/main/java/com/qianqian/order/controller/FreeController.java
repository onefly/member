package com.qianqian.order.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
 * 免费试用订单的控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.order.controller.NakedController.java
 * @ClassName	: NakedController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014年7月11日 上午11:34:53
 */
@Controller
@RequestMapping("/freeOrder")
public class FreeController {
	
	private static Logger log = LoggerFactory.getLogger(FreeController.class);
	
	private static int pagesize = 10;
	
	//裸价体验状态
	private static final int TYPE = OrderConstants.FREE_TYPE;
	
	private static final String FREE_LIST = "order/myFree";
	
	private static final String FREE_DIV = "order/freeListDiv";
	
	@Autowired
	private IOrderDubboService orderService;
	
	/**
	 * 展示用户免费试用订单的方法
	 *  @Method_Name    : getNakedList
	 *  @param request
	 *  @param model
	 *  @param page
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月11日 下午1:54:56
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getFreeOrderList")
	public String getFreeList(Model model, Query query){
		SessionData sd = SessionUtil.getSessionData();
		long userId = sd == null ? 5 : sd.getId();
		query.setUserId(userId);
		log.info("-------userId = "+userId);
		query.setType(TYPE);
		query.setPageSize(pagesize);
		log.info("页数："+query.getPageNum()+"-------"+"每页："+query.getPageSize()+"条");
		
		OrderBO orderBO = orderService.getOrderByQuery(query);
		Page page = orderBO.getPage();
		
		List<OrderListDTO> freeOrderDTOs = orderBO.getOrderList();
		for (OrderListDTO orderListDTO : freeOrderDTOs) {
			List<OrderChild> orderChildList = orderListDTO.getOrderChilds();
			for (OrderChild orderChild : orderChildList) {
				//未付款状态
				if(orderChild.getState() == 200){
					//付款截止日期为下单时间加上3天
					Date endPayTime = DateUtil.addDay(orderChild.getOrderCreateTime(), 3);
					orderChild.setOrderCreateTime(endPayTime);
				}
			}
		}
		log.info("order totalCount----->"+page.getTotalCount());
		log.info("order totalPage------>"+page.getTotalPage());
		model.addAttribute("page", page);
		log.info(page.toString());
		model.addAttribute("freeOrderDTOList", freeOrderDTOs);
		
		return FREE_LIST;
	}
	
	/**
	 * 接收页面ajax请求，返回免费试用的列表展示页面
	 *  @Method_Name    : getNakedDiv
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年7月15日 下午4:18:38
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getFreeOrderDiv")
	public String getFreedDiv(Model model, Query query){
		log.info("进入getNakedOrderDiv");
		SessionData sd = SessionUtil.getSessionData();
		long userId = sd == null ? 5 : sd.getId();
		query.setUserId(userId);
		query.setType(TYPE);
		query.setPageSize(pagesize);
		log.info("pageNum--------->"+query.getPageNum());
		OrderBO orderBO = this.orderService.getOrderByQuery(query);
		
		Page page = orderBO.getPage();
		
		List<OrderListDTO> freeOrderDTOs = orderBO.getOrderList();
		for (OrderListDTO orderListDTO : freeOrderDTOs) {
			List<OrderChild> orderChildList = orderListDTO.getOrderChilds();
			for (OrderChild orderChild : orderChildList) {
				//未付款状态
				if(orderChild.getState() == 200){
					//付款截止日期为下单时间加上3天
					Date endPayTime = DateUtil.addDay(orderChild.getOrderCreateTime(), 3);
					orderChild.setOrderCreateTime(endPayTime);
				}
			}
		}
		log.info("order totalCount----->"+page.getTotalCount());
		log.info("order totalPage------>"+page.getTotalPage());
		log.info("pageNum--------->"+page.getPageNum());
		model.addAttribute("page", page);
		model.addAttribute("freeOrderDTOList", freeOrderDTOs);
		return FREE_DIV;
	}
}
