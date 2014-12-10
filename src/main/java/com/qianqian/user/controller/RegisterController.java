package com.qianqian.user.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.framelib.common.CommonConstants;
import com.framelib.utils.AjaxUtils;
import com.framelib.utils.ImageCodeUtil;
import com.framelib.utils.ResponseUtils;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;
import com.qianqian.user.service.support.ValidateResult;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author peichunting
 * 用于处理用户注册的控制器
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Resource
	private IUserService userService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	
	@RequestMapping("check/nickname")
	@ResponseBody
	public String validateNickName(){
		return null;
	}
	
	/**
	 * 前往注册页面
	 * @author peichunting
	 * @param user
	 * @return 返回用户注册表单页面
	 */
	@RequestMapping("forward")
	public String forward(String userId,ModelMap map){
		if(StringUtils.isNotEmpty(userId)){
			map.put("inviteUserId", userId);
		}
		return "/user/register";
	}
	
	
	/**
	 * 验证码校验
	 * @author peichunting
	 * @param request url请求，response url响应
	 * @return 
	 */
	@RequestMapping("validcode")
	public void getValicode(HttpServletRequest request,HttpServletResponse response){
		ImageCodeUtil icu=new ImageCodeUtil();
		
		BufferedImage img=icu.getImage(80, 30);
		System.out.println(icu.getCode());
		request.getSession().setAttribute(CommonConstants.VALIDATE_CODE_KEY, icu.getCode());
		OutputStream outputStream;
		System.out.println(icu.getCode());
		try {
			
			outputStream = response.getOutputStream();
			ImageIO.write(img, "jpeg", outputStream);
			
			response.flushBuffer();
			outputStream.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			
				
		}		 
	}
	
	/**
	 * 注册提交表单
	 * @param request
	 * @param user 
	 * @param checkNumber
	 * @return 
	 */
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public ModelAndView post(HttpServletRequest request,User user,String checkNumber,String inviteUserId){
		ModelAndView mav=new ModelAndView();
		
		//if(checkNumber.trim().equalsIgnoreCase((String)request.getSession().getAttribute(CommonConstants.VALIDATE_CODE_KEY)))
		//{
		
		user.setCreateTime(new Date());
		user.setLastModifiedTime(new Date());
		user.setScore(1000l);
		user.setExperienceValue(10l);
		user.setIngot(30l);
	
		if(userService.register(user)){
			if(StringUtils.isNotEmpty(inviteUserId)){
				User cUser=userService.getUser(Long.valueOf(inviteUserId));
				if(cUser!=null){
					cUser.setInviteCount(cUser.getInviteCount()+1);
					cUser.setScore(cUser.getScore()+1000);
					userService.updateUser(cUser);
				}
			}
			mav.setViewName("/user/registerSucess");
		}
		//}else{
			//mav.addObject("message","验证码错误");
			//mav.addObject("user", user);
			//mav.setViewName("/user/register");
			//return mav;
			/*ModelAndView mav=new ModelAndView();
			mav.setViewName("/user/registerSucess");
			return "redirect:/register/forward.htm";*/
	//	}
		//mav.setViewName("/user/registerSucess");
		return mav; //"/user/registerSucess";
	}
	

	
	/**
	 * 验证唯一性，一般为页面通过ajax调用此方法
	 * @param param
	 * @param name
	 * @return 如果返回字符串y，验证成功，字段值在数据库中没有重复，否则返回错误描述
	 * @throws IOException 
	 */
	@RequestMapping(value="/validateDuplicate")
	public void validateDuplicate(String param,String name,HttpServletResponse response) throws IOException{
		ValidateResult result=userService.validateDuplicateField(name, param);
	
		System.out.println(result.getMessage());
		
		if(result.isSuccess()){
			ResponseUtils.renderText(response,"{\"info\":\"\",\"status\":\"y\"}");		
		}
		else
		{
			ResponseUtils.renderText(response,result.getMessage());

		}
	}
	
	@RequestMapping(value="/sendCheckNumber")
	public void sendCheckNumber(){
		
	}
}




