package com.qianqian.order.controller;

import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.order.dto.Result;
import com.qianqian.order.model.OrderChild;
import com.qianqian.order.model.Orders;
import com.qianqian.order.service.IOrderDubboService;
import com.qianqian.order.utils.OrderConstants;

/**
 * 操作订单的控制器
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.myFeeling.controller.OrderController.java
 * @ClassName : OrderController
 * @Author : shenzhenxing
 * @CreateDate : 2014年7月4日 上午11:15:55
 */
@Controller
public class MemOrderController {
	private static Logger log = LoggerFactory
			.getLogger(MemOrderController.class);
	@Resource
	private IOrderDubboService orderDubboService;
	@Resource
	private IUserDubboService userDubboService;

	/**
	 * 关闭订单
	 * 
	 * @Method_Name : closeOrder
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月4日 上午11:38:38
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("/closeOrder")
	public String closeOrder(Model model, String msg, Long orderId,
			HttpServletRequest request) {
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.error(e.toString(), e);

		} catch (InterruptedException e) {
			log.error(e.toString(), e);

		} catch (MemcachedException e) {
			log.error(e.toString(), e);

		}
		Long userId = sd.getId();

		Result result = orderDubboService.closeOrder(orderId, msg,
				OrderConstants.OPERATOR_TYPE_BUYER, userId);
		// TODO

		model.addAttribute("result", result);
		return null;
	}

	/**
	 * 确认收货
	 * 
	 * @Method_Name : confirmRecieve
	 * @param orderId
	 * @param orderChildId
	 * @param model
	 * @param request
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月8日 上午10:57:00
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("/confirmRecieve")
	public String confirmRecieve(Long[] orderChildId, Model model,
			HttpServletRequest request) {
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
		} catch (Exception e) {
			log.error(e.toString());
		}
		OrderChild child = orderDubboService.getOrderChild(orderChildId[0]);
		Long userId = sd.getId();
		Result result = new Result();
		try {
			result = orderDubboService.confirmReceive(child.getId(),
					orderChildId, userId, OrderConstants.OPERATOR_TYPE_BUYER,
					"用户确认收货", OrderConstants.OPERATION_TYPE_CONFIRM_RECIEVE);
		} catch (Exception e) {
			result.setFlag(false);
			result.setResult("系统出错");
			log.debug(e.toString()+e);
		}
		model.addAttribute("result", result);

		return null;
	}
	/**
	 * 延时收货
	 *  @Method_Name    : deley
	 *  @param id        订单id
	 *  @param model
	 *  @return 
	 *  @return       : String
	 *  @Creation Date  : 2014年7月31日 上午9:42:19
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/delaySignIn")
	public String deley(Long id ,Model model){
		Result r=new Result();
		try {
			r = orderDubboService.updateSignInTime(id);
		} catch (Exception e) {
			r.setFlag(false);
			r.setResult("延时收货失败");
			log.error(e.toString()+e);
		}
		model.addAttribute("result", r);
		return null;
	}

}
