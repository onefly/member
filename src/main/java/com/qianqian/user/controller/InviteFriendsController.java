package com.qianqian.user.controller;

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
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;
/**
 * 点击邀请好友链接跳转的控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.InviteFriendsController.java
 * @ClassName	: InviteFriendsController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月29日 上午9:21:18
 */
@Controller
public class InviteFriendsController {
	
	@Resource
	private IUserService userService;
	
	private static Logger log = LoggerFactory.getLogger(InviteFriendsController.class);
	@RequestMapping("/user/inviteFriends")
	public String inviteFriends(HttpServletRequest request,Model model){
		try {
			SessionData session=SessionUtil.getSessionData(request);
			//从sessionDate里得到当前用户的Id，返回页面展示，生成动态邀请链接
			long userId=session.getId();
			User user=userService.getUser(userId);
			log.debug("用户 :"+user);
			int count=0;
			if(user!=null){
				count=user.getInviteCount();
			}
			model.addAttribute("count", count);
			model.addAttribute("userId", userId);
		} catch (TimeoutException e) {
			log.error(e.toString(),e);
			
		} catch (InterruptedException e) {
		
			log.error(e.toString(),e);
		} catch (MemcachedException e) {
			
			log.error(e.toString(),e);
		}
		
		return "/user/individual_friend";
	}
	@RequestMapping("/user/inviteRecord")
	public String inviteRecord(HttpServletRequest request,Model model){
		
		try {
			SessionData session=SessionUtil.getSessionData(request);
			//从sessionDate里得到当前用户的Id
			long userId=session.getId();
			User user=userService.getUser(userId);
			log.debug("用户 :"+user);
			int count=0;
			if(user!=null){
				count=user.getInviteCount();
			}
			model.addAttribute("pcount", count);
			//当前页码currentPage
			model.addAttribute("currentPage", 0);
			//总共页数totalPages
			model.addAttribute("totalPages", 0);
			//总共的条数count
			model.addAttribute("count",0);
			//totalCount 总记录数
			model.addAttribute("totalCount", 0);
		} catch (TimeoutException e) {
			log.error(e.toString(),e);
			
		} catch (InterruptedException e) {
		
			log.error(e.toString(),e);
		} catch (MemcachedException e) {
			
			log.error(e.toString(),e);
		}
		
		return "/user/inviteRecord";
		
	}
}
