package com.qianqian.user.controller;

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
import com.qianqian.user.model.Medal;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IMedalService;
import com.qianqian.user.service.IUserService;
/**
 * 大牌勋章的控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.MedalController.java
 * @ClassName	: MedalController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月28日 下午5:58:55
 */
@Controller
@RequestMapping("/user/medal")
public class MedalController {
	/** 每页显示20条**/
	private static int PAGESIZE=20;
	@Resource
	private IMedalService medalService;
	@Resource
	private IUserService userService;
	private static Logger log = LoggerFactory.getLogger(MedalController.class);
	/**
	 * 根据分页条件查找当前用户的大牌勋章，并分页显示
	 *  @Method_Name    : getAll
	 *  @param request   ：从sessionData中获取用户userId
	 *  @param model
	 *  @param page		：第几页
	 *  @param pageSize	：每页显示的条数
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年4月29日 上午9:50:23
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getAllMedal")
	public String getAll(String key,Model model,int page){
		
		
			SessionData session=SessionUtil.getSessionData();
			long userId=session.getId();
			
			PageBounds pageBounds=new PageBounds(page,PAGESIZE);
			List<Medal> list=null;
			//假如没有关键字
			if(StringUtils.isBlank(key)){
				list=medalService.getAllMedal(userId, pageBounds);
			}
			else{
				list=medalService.getPagiMedalByKeyword(userId, key, pageBounds);
			}
			User user =userService.getUser(userId);
			log.debug("用户 :"+user);
			long totalCount=0;;
			if(user!=null){
				 totalCount=user.getMedalCount();
			}
			
			PageList<Medal> pageList = (PageList<Medal>) list;
			model.addAttribute("list", pageList);
			//当前页码currentPage
			model.addAttribute("currentPage", pageList.getPaginator().getPage());
			//总共页数totalPages
			model.addAttribute("totalPages", pageList.getPaginator()
					.getTotalPages());
			//总共的条数count
			model.addAttribute("count",pageList.getPaginator().getTotalCount());
			//totalCount 用户的总勋章个数 
			model.addAttribute("totalCount", totalCount);
			//回显key
			model.addAttribute("key",key);
		return "/user/individual_medal";//返回显示界面
	}
}
