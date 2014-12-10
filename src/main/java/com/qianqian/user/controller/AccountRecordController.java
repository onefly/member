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
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.service.IAccountRecordService;

/**
 * 账户记录的controller
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.controller.AccountRecordController.java
 * @ClassName : AccountRecordController
 * @Author : shenzhenxing
 * @CreateDate : 2014年4月16日 下午1:27:10
 */
@Controller
@RequestMapping("/user/accountRecord")
public class AccountRecordController {

	@Resource
	private IAccountRecordService accountRecordService;
	private static Logger logger = LoggerFactory.getLogger(AccountRecordController.class);
	private static int PAGEZISE=8;
/**
 * 查找当前用户的账户记录
 *  @Method_Name    : getAll
 *  @param request
 *  @param date     ：日期
 *  @param page		：页码
 *  @param pageSize ：每页显示的条数
 *  @param model
 *  @return 
 *  @return         : String
 *  @Creation Date  : 2014年5月8日 下午2:24:30
 *  @version        : v1.00
 *  @Author         : shenzhenxing 
 *  @Update Date    : 
 *  @Update Author  :
 */
	@RequestMapping("getRecord")
	public String getAll( HttpServletRequest request, String date, int page, Model model) {
		
		SessionData session;
		try {
			logger.debug(date);
			session = SessionUtil.getSessionData(request);
			long userId=session.getId();
			logger.debug("用户id："+userId+"当前页数："+page);
			//String sortString = "id.asc";// 排序的话逗号分隔可以排序多列,
			PageBounds pageBounds = new PageBounds(page, PAGEZISE);
			List<AccountRecord> list=null;
			if(StringUtils.isBlank(date)){
				list = accountRecordService.getAll(userId,
						pageBounds);
			}else{
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date1=format.parse(date);
					list = accountRecordService.getAllByDate(userId, pageBounds, date1);
					
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			}
			

		
				PageList<AccountRecord> pageList = (PageList<AccountRecord>) list;
				//System.out.println("currentPages:" + pageList.getPaginator().getPage());
				
				model.addAttribute("list", pageList);
				model.addAttribute("currentPage", pageList.getPaginator().getPage());
				model.addAttribute("totalPages", pageList.getPaginator()
						.getTotalPages());
			
				model.addAttribute("date", date);

			
		} catch (TimeoutException e) {
			logger.error(e.toString(), e);
			
		} catch (InterruptedException e) {
			logger.error(e.toString(), e);
			
		} catch (MemcachedException e) {
			logger.error(e.toString(), e);
			
		}
		return "/account/individual_account";
	}
	
	
	
}
