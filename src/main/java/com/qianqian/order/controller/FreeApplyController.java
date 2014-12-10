package com.qianqian.order.controller;


import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.apply.bo.ApplyBO;
import com.qianqian.apply.service.IApplyDubboService;

/**
 * 申请单操作控制器
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.myOrder.controller.ApplyController.java
 * @ClassName : ApplyController
 * @Author : caozhifei
 * @CreateDate : 2014年7月11日 上午9:12:49
 */
@Controller
@RequestMapping("apply")
public class FreeApplyController {
	/**
	 * 日志记录对象
	 */
	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 申请单列表jsp页面
	 */
	private static final String APPLY_LIST = "order/myApply";
	/**
	 * 申请单列表DIV页面
	 */
	private static final String APPLY_DIV = "order/applyListDiv";
	/**
	 * 订单系统提供的dubbo服务接口
	 */
	@Resource
	private IApplyDubboService applyDubboService;

	/**
	 * 根据查询条件查询申请单列表
	 * 
	 * @Method_Name : getApplyList
	 * @param applyBO
	 *            查询申请单列表的查询条件封装对象，包括分页参数
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月11日 上午9:21:49
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getApplyList")
	public String getApplyList(ApplyBO applyBO, Model model) {
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		applyBO.setUserId(userId);
		applyBO = applyDubboService.getMemApplyList(applyBO);
		log.debug("getApplyList ==>" + applyBO.toString());
		model.addAttribute("applyList", applyBO.getApplyList());
		model.addAttribute("page", applyBO.getPage());
		return APPLY_LIST;
	}
	/**
	 * 根据查询条件查询申请单列表,返回DIV
	 * 
	 * @Method_Name : getApplyDiv
	 * @param applyBO
	 *            查询申请单列表的查询条件封装对象，包括分页参数
	 * @param map
	 * @return
	 * @return : String
	 * @Creation Date : 2014年7月11日 上午9:21:49
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getApplyDiv")
	public String getApplyDiv(ApplyBO applyBO, Model model) {
		SessionData session = SessionUtil.getSessionData();
		long userId = session == null ? 110 : session.getId();
		applyBO.setUserId(userId);
		applyBO = applyDubboService.getMemApplyList(applyBO);
		log.debug("getApplyDiv ==>" + applyBO.toString());
		model.addAttribute("applyList", applyBO.getApplyList());
		model.addAttribute("page", applyBO.getPage());
		return APPLY_DIV;
	}

}
