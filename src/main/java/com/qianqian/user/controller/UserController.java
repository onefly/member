package com.qianqian.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.SessionData;
import com.framelib.utils.SessionUtil;
import com.framelib.utils.StringUtil;
import com.qianqian.collect.service.IBrandCollectService;
import com.qianqian.collect.service.ICommodityCollectService;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;

import javax.annotation.Resource;

/**
 * 
 * @author peichunting
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	
	@Resource(name = "brandCollectService")
	private IBrandCollectService brandCollectService;
	/**
	 * 注入商品收藏service
	 */
	@Resource(name = "commodityCollectService")
	private ICommodityCollectService commodityCollectService;
	/**
	 * 前往个人首页
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 * @author peichunting
	 */
	@RequestMapping("/index")
	public String goIndex(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws TimeoutException, InterruptedException, MemcachedException{
		SessionData session=SessionUtil.getSessionData(request);
		if(session==null){
			return "/user/login";
		}
		long id=session.getId();
		User user=userService.getUser(id);
		int commodityCount=commodityCollectService.getCommodityCollectCountByUser(id);
		int brandCount=brandCollectService.getBrandCollectCountByUser(id);
		map.put("commodityCount", commodityCount);
		map.put("brandCount", brandCount);
		return "/user/userIndex";
	}
	
	/**
	 * 前往个人兑换
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 * @author peichunting
	 */
	@RequestMapping("/exchange")
	public String goExchange(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws TimeoutException, InterruptedException, MemcachedException{
		SessionData session=SessionUtil.getSessionData(request);
		if(session==null){
			return "/user/login";
		}
		long id=session.getId();
		User user=userService.getUser(id);
		return "/user/userExchange";
	}
	
	
	
	/**
	 * 前往个人中心资料页面
	 * @return
	 * @throws MemcachedException 
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/profile")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws TimeoutException, InterruptedException, MemcachedException, IOException{
		//try {
			SessionData session=SessionUtil.getSessionData(request);
			if(session==null){
				return "/user/login";
			}
			long id=session.getId();
			User user=userService.getUser(id);
			user.setEmail(StringUtil.replaceEamil(user.getEmail()));
			user.setIdentification(StringUtil.replaceIdCard(user.getIdentification()));
			user.setPhone(StringUtil.replaceMobile(user.getPhone()));
			user.setCanModifyRegion(userService.canModifyDistrict(id)?1:0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date brithday=user.getBrithday();
			if(brithday!=null)
				user.setBrithdayStr(dateFormat.format(brithday));
			dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			if(user.getLastLoginTime()!=null)
				user.setLastLoginTimeStr(dateFormat.format(user.getLastLoginTime()));
			map.put("user", user);
			return "/user/userprofile";
	}
	
	
	/**
	 * 用户中心通用首部
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws MemcachedException
	 * @author peichunting
	 */
	@RequestMapping("/usertop")
	public String getUserTop(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws TimeoutException, InterruptedException, MemcachedException{
		SessionData session=SessionUtil.getSessionData(request);
		if(session==null){
			return "/user/login";
		}
		long id=session.getId();
		User user=userService.getUser(id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		if(user.getLastLoginTime()!=null)
			user.setLastLoginTimeStr(dateFormat.format(user.getLastLoginTime()));
		map.put("user", user);
		return "/user/usertop";
	}
	
	
	
	/**
	 * 修改个人资料
	 * @param request
	 * @param user
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/update")
	public void udpateUser(HttpServletRequest request,User user,HttpServletResponse response) throws IOException{
		User savedUser=userService.getUser(user.getUserId());
		String province=savedUser.getProvinceName();
		String city=savedUser.getCityName();
		province=province!=null?province:"";
		city=city!=null?city:"";
		if(user.getProvinceName()!=null && user.getCityName()!=null){
			if(!userService.canModifyDistrict(user.getUserId())){
				user.setProvinceName(province);
				user.setCityName(city);
			}else if(!user.getCityName().equals(city)||!user.getProvinceName().equals(province)){
				user.setLastModifyDistrictTime(new Date());
			}
		}
		user.setIngot(savedUser.getIngot());
		user.setExperienceValue(savedUser.getExperienceValue());
		user.setScore(savedUser.getScore());
		userService.updateUser(user);
		response.sendRedirect(request.getContextPath()+"/user/profile.htm");
	}

}
