package com.qianqian.common.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framelib.common.CommonConstants;
import com.framelib.utils.ImageCodeUtil;
import com.qianqian.user.controller.PasswordForgetController;

/**
 * 将登陆验证码以图片的形式打回页面
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.LoginValidcodeController.java
 * @ClassName	: LoginValidcodeController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014-4-16 下午2:46:53
 */
@Controller
@RequestMapping("/image")
public class ValidcodeController {
	private static Logger log = LoggerFactory.getLogger(PasswordForgetController.class);
	
	/**
	 * 生成验证码图片
	 *  @Method_Name    : vode 
	 *  @return         : void
	 *  @Creation Date  : 2014-4-16 下午2:48:11
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/validcode")
	@ResponseBody
	public void vode(HttpServletRequest request,HttpServletResponse response){
		//调用工具类，生成图片跟验证码
		ImageCodeUtil imageCode = new ImageCodeUtil();
		BufferedImage image = imageCode.getImage(60, 20);
		String code = imageCode.getCode();
		//将生成的验证码放入session
		request.getSession(true).setAttribute(CommonConstants.VALIDATE_LOGIN_CODE_KEY, code);
		log.info("验证码为："+code);
		
		OutputStream os = null;
		try{
			os = response.getOutputStream();
			//写图片
			ImageIO.write(image, "jpeg", os);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				os.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取随机生成的验证码
	 *  @Method_Name    : getValidcode
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-16 上午3:05:51
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getCode")
	public String getValidcode(HttpServletRequest request,Model model){
		model.addAttribute("code", (String)request.getSession().getAttribute(CommonConstants.VALIDATE_LOGIN_CODE_KEY));
		return null;
	}
}
