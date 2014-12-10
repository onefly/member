package com.qianqian.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;




import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;















import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.qianqian.user.model.RechargeRecord;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IRechargeRecordService;
import com.qianqian.user.service.IUserService;

/**
 * 充值记录的controller
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.controller.RechargeRecordController.java
 * @ClassName : RechargeRecordController
 * @Author : shenzhenxing
 * @CreateDate : 2014年4月16日 下午1:26:19
 */
@Controller
@RequestMapping("/user/rechargeRecord")
public class RechargeRecordController {

	@Resource
	private IRechargeRecordService rechargeRecordService;
	@Resource
	private IUserService userService;
	private static  Logger log=LoggerFactory.getLogger(RechargeRecordController.class);
	private static int PAGESIZE=10;
	/**
	 * 获取充值记录的方法
	 * 
	 * @Method_Name : getRecord
	 * @param uid
	 *            : 用户id
	 * @param page
	 *            ：页数
	 * @param pageSize
	 *            ：每页显示的条数
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月15日 下午5:09:11
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getRecord")
	public String getAll( int page, String date ,HttpServletRequest request, Model model) {
		SessionData session;
		try {
			session = SessionUtil.getSessionData(request);
			long userId=session.getId();
			log.debug("用户id："+userId+"当前页数："+page);
			//String sortString = "record_id.asc";// 排序的话逗号分隔可以排序多列,
			
			PageBounds pageBounds = new PageBounds(page,  PAGESIZE);
			List<RechargeRecord> list =null;
			if(StringUtils.isBlank(date)){
				list = rechargeRecordService.getAll(userId,
						pageBounds);
			}else{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date1=format.parse(date);
					list = rechargeRecordService.getAll(userId,
							pageBounds,date1);
				} catch (ParseException e) {
					log.error(e.toString());
					e.printStackTrace();
				}
			}
			
			User user=userService.getUser(userId);
			
			PageList<RechargeRecord> pageList = (PageList<RechargeRecord>) list;
			model.addAttribute("list", pageList);
			model.addAttribute("currentPage", pageList.getPaginator().getPage());
			model.addAttribute("totalPages", pageList.getPaginator()
					.getTotalPages());
			model.addAttribute("date", date);
			model.addAttribute("user", user);
			log.debug(user.getPhone()+"---"+user.getNickname());
		} catch (TimeoutException e) {
			log.error(e.toString(), e);
		
		} catch (InterruptedException e) {
			log.error(e.toString(), e);
			
		} catch (MemcachedException e) {
			log.error(e.toString(), e);
			
		}
		
		return "/account/individual_recharge";
	}

}
