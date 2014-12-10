package com.qianqian.user.controller;

import java.util.Date;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framelib.common.CommonConstants;
import com.framelib.common.SessionData;
import com.framelib.utils.CookieUtils;
import com.framelib.utils.MD5Util;
import com.framelib.utils.SessionUtil;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;

/**
 * 单点登陆
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.loginController.java
 * @ClassName	: loginController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014-4-16 上午9:47:32
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
	private static Logger log = LoggerFactory.getLogger(UserLoginController.class);
	@Autowired
	private IUserService userService;
	
	/**
	 * 登陆，成功则将用户信息放入缓存
	 *  @Method_Name    : login
	 *  @param phone
	 *  @param password
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-16 上午10:01:48
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(String phone,HttpServletRequest request,
			String password,HttpServletResponse response,ModelMap modelmap){
		
		log.info(phone+"----------"+password);
		User user = this.userService.selectByPhoneAndPassword(phone, MD5Util.encode(password));
		
		if(user!=null){
			
			modelmap.put("user", user);
			SessionData sd = new SessionData();
			//标记，具体讨论
			sd.setNickName(user.getNickname());
			sd.setId(user.getUserId());
			
			String checkbox_username = request.getParameter(CommonConstants.CHECKBOX_REMEMBER_USERNAME);
			String checkbox_autologin = request.getParameter(CommonConstants.CHECKBOX_AUTO_LOGIN);
			if(checkbox_autologin!=null){
				log.info("记住账号，自动登陆");
				CookieUtils.addCookie(response, CommonConstants.COOKIE_USERNAME, phone, CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
				CookieUtils.addCookie(response, CommonConstants.COOKIE_AUTOLOGIN_MARK, CommonConstants.AUTOLOGIN_YES, CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
			}else if(checkbox_autologin==null&&checkbox_username!=null){
				log.info("记住账号，不自动登陆");
				CookieUtils.addCookie(response, CommonConstants.COOKIE_USERNAME, phone, CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
				CookieUtils.addCookie(response, CommonConstants.COOKIE_AUTOLOGIN_MARK, CommonConstants.AUTOLOGIN_NO, CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
			}else{
				log.info("不记账号，不自动登陆");
				CookieUtils.delCookie(response, CommonConstants.COOKIE_USERNAME, CommonConstants.COOKIE_PATH);
				CookieUtils.addCookie(response, CommonConstants.COOKIE_AUTOLOGIN_MARK, CommonConstants.AUTOLOGIN_NO, CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
			}
			user.setLastLoginTime(new Date());
			userService.updateUser(user);
			try {//将登陆成功的用户放入memcatch
				SessionUtil.ssoLogin(request, response, sd);
			} catch (TimeoutException e) {
				log.error(e.toString(), e);
				e.printStackTrace();
			} catch (InterruptedException e) {
				log.error(e.toString(), e);
				e.printStackTrace();
			} catch (MemcachedException e) {
				log.error(e.toString(), e);
				e.printStackTrace();
			}
			
			return "test/testTop";
		}
		
		return "test/loginError";
	}
	
	/**
	 * 
	 *  @Method_Name    : getTopData
	 *  @param request
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-5-7 上午10:10:28
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getTopData")
	public String getTopData(HttpServletRequest request, Model model){
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
		} catch (TimeoutException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		} catch (InterruptedException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		} catch (MemcachedException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		}
		if(sd!=null){
			String nickname = sd.getNickName();
			model.addAttribute("nickname", nickname);
		}else{
			model.addAttribute("nickname", "");
		}
		return "";
	}
	
	/**
	 * 	为页面“忘记密码”提供的链接跳转
	 *  @Method_Name    : forgetPassword
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-21 上午10:50:51
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/forgetpwd")
	public String forgetPassword(){
		return "user/pwdForget";
	}
	
	/**
	 * 	用于跳转到登陆界面的请求
	 *  @Method_Name    : login2JSP
	 *  @param request
	 *  @param response
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-22 上午11:18:10
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/toLogin")
	public String login2JSP(HttpServletRequest request,Model model){
		Cookie cookie_username = CookieUtils.getCookieByName(request, CommonConstants.COOKIE_USERNAME);
		String val_username = "";
		if(cookie_username!=null){
			val_username = cookie_username.getValue();
		}
		log.info(val_username);
   		model.addAttribute("uname", val_username);
   		
		return "user/login";
	}
	
	/**
	 * 用户注销的控制器
	 *  @Method_Name    : logout
	 *  @param request
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-28 下午2:45:38
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		if(loginStatus(request)){
			//删除缓存
			try {
				SessionUtil.ssoLogout(request, response);
			} catch (TimeoutException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (InterruptedException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (MemcachedException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			}
			//删除原先的cookie再创建新的cookie
			CookieUtils.delCookie(response, CommonConstants.COOKIE_AUTOLOGIN_MARK, CommonConstants.COOKIE_PATH);
			CookieUtils.addCookie(response, CommonConstants.COOKIE_AUTOLOGIN_MARK, CommonConstants.AUTOLOGIN_NO, 
					CommonConstants.COOKIE_MAXAGE, CommonConstants.COOKIE_PATH);
			
			return new ModelAndView("redirect:/user/toLogin.htm");
		}
		
		return new ModelAndView("redirect:/user/toLogin.htm");
	}
	
	/**
	 * 判断用户是否登陆
	 *  @Method_Name    : loginStatus
	 *  @param request
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2014-4-25 下午2:02:03
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	private boolean loginStatus(HttpServletRequest request) {
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
		if (sd == null) {
			return false;
		} else {
			return true;
		}
	}
}
