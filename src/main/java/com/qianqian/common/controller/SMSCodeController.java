package com.qianqian.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.CommonConstants;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.SMSUtil;

/**
 * 发送短信验证码
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.common.controller.MessageCodeController.java
 * @ClassName : MessageCodeController
 * @Author : shenzhenxing
 * @CreateDate : 2014年4月17日 下午4:35:30
 */
@Controller
public class SMSCodeController {
	@Resource
	private IRedisUtil redisUtil;

	/**
	 * ajax 请求 根据手机号发送验证码，并返回json,{"result":false}||{"result":true}
	 * 
	 * @Method_Name : getSMSCode
	 * @param request
	 * @param phone
	 *            ：手机号
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年4月17日 下午4:35:51
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getSMSCode")
	public String getMessageCode(HttpServletRequest request, String phone,
			Model model) {
		String ipKey = CommonConstants.SMS_CODE_KEY + request.getRemoteAddr()
				+ phone;
		String code = RandomStringUtils.randomNumeric(6);// 6位验证码
		StringBuffer text = new StringBuffer();
		text.append("美试网通知，您的短信验证码为：");
		text.append(code);
		text.append("，该验证码30分钟内有效。【美试网】");
		String flag = redisUtil.get(ipKey);
		// smsResult 短信是否发送成功
		boolean smsResult = false;
		if (!StringUtils.equals("ok", flag)) {
			smsResult = SMSUtil.sendMessage(phone, text.toString());
			String key = CommonConstants.SMS_CODE_KEY;
			request.getSession(true).setAttribute(key, code);// 把验证码放入session
		}
		if (smsResult) {			
			redisUtil.setex(ipKey, 60, "ok");//redis 中保存 60 秒 ，确保60秒之内同一个ip和手机号不能重复发送验证码
		}
		model.addAttribute("result", smsResult);
		return null;
	}

}
