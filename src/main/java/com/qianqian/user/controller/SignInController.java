package com.qianqian.user.controller;

import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.qianqian.user.service.ISignInService;

/**
 * 用户签到操作 判断用户当天是否已经签到
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.controller.SignInController.java
 * @ClassName : SignInController
 * @Author : caozhifei
 * @CreateDate : 2014年4月18日 上午10:01:10
 */
@Controller
@RequestMapping("/user")
public class SignInController {
	/**
	 * 记录日志对象
	 */
	private static Logger log = LoggerFactory.getLogger(SignInController.class);
	/**
	 * 注入签到service类
	 */
	@Resource
	private ISignInService signInService;

	/**
	 * 用户签到操作
	 * 
	 * @Method_Name : signIn
	 * @param request
	 * @param map
	 * @return true = 签到成功 / false = 签到失败
	 * @return : String
	 * @Creation Date : 2014年4月18日 上午10:14:51
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("signIn")
	public String signIn(HttpServletRequest request, ModelMap map) {
		try {
			SessionData sessionData = SessionUtil.getSessionData(request);
			if (sessionData == null) {
				// 找不到用户登录信息
				map.put("result", "找不到用户登录信息");
			} else {
				boolean result = false;
				// 判断用户是否已经签到，true表示已经签到， fasle表示还未签到
				if (!signInService.isSignIn(sessionData)) {
					result = signInService.saveSignIn(sessionData);
					map.put("result", result);
				} else {
					map.put("result", result);
				}
			}
		} catch (TimeoutException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		} catch (InterruptedException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		} catch (MemcachedException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		}
		return "";
	}

	/**
	 * 判断用户是否已经签到
	 * 
	 * @Method_Name : isSignIn
	 * @param request
	 * @param map
	 * @return true = 已经签到 / false = 未签到
	 * @return : String
	 * @Creation Date : 2014年4月18日 上午10:16:43
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("isSignIn")
	public String isSignIn(HttpServletRequest request, ModelMap map) {
		System.out.println(request.getMethod());
		try {
			SessionData sessionData = SessionUtil.getSessionData(request);
			if (sessionData == null) {
				sessionData = new SessionData();
				sessionData.setId(123);
				signInService.isSignIn(sessionData);
				// 找不到用户登录信息
				map.put("result", "找不到用户登录信息");
			} else {
				boolean result = signInService.isSignIn(sessionData);
				map.put("result", result);
			}
		} catch (TimeoutException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		} catch (InterruptedException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		} catch (MemcachedException e) {
			map.put("result", "找不到用户登录信息");
			log.error(e.toString(), e);
		}
		return "";
	}
}
