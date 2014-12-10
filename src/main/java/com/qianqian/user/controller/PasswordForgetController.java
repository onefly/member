package com.qianqian.user.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.CommonConstants;
import com.framelib.utils.DESUtil;
import com.framelib.utils.DateUtil;
import com.framelib.utils.MD5Util;
import com.framelib.utils.SMSUtil;
import com.framelib.utils.StringUtil;
import com.framelib.utils.mail.MailUtil;
import com.qianqian.common.utils.Constants;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;

import freemarker.template.TemplateException;

/**
 * 根据用户提供的信息帮助用户找回密码
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.PasswordForgetController.java
 * @ClassName	: PasswordForgetController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014-4-17 下午3:06:40
 */
@Controller
@RequestMapping("/pwdForget")
public class PasswordForgetController {
	private static Logger log = LoggerFactory.getLogger(PasswordForgetController.class);
	@Autowired
	private IUserService userService;
	
	/**
	 * 通过邮箱找回密码
	 *  @Method_Name    : useEmail
	 *  @param email 
	 *  @return         : void
	 *  @Creation Date  : 2014-4-17 下午3:11:49
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/email")
	public String useEmail(String email,HttpServletRequest request){
		String linkStr = CommonConstants.MAIL_LINK+request.getContextPath()+"/pwdForget/toLink.htm?uid=";
		log.info(email);
		User user = this.userService.selectByEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);//对称加密准备
		if(user!=null){
			//拼上加密后的userId
			String idStr = String.valueOf(user.getUserId());
			String encode_idStr = "";
			try {
				encode_idStr = des.encryptMode(idStr);
			} catch (InvalidKeyException e1) {
				log.error(e1.toString(), e1);
			} catch (UnsupportedEncodingException e1) {
				log.error(e1.toString(), e1);
			} catch (NoSuchAlgorithmException e1) {
				log.error(e1.toString(), e1);
			} catch (NoSuchPaddingException e1) {
				log.error(e1.toString(), e1);
			} catch (IllegalBlockSizeException e1) {
				log.error(e1.toString(), e1);
			} catch (BadPaddingException e1) {
				log.error(e1.toString(), e1);
			}
			linkStr += encode_idStr;
			
			//拼上加密后的日期
			String dateStr = sdf.format(new Date());
			String encode_dateStr = "";
			try {
				encode_dateStr = des.encryptMode(dateStr);
				log.info("加密后日期为："+encode_dateStr);
			} catch (InvalidKeyException e) {
				log.error(e.toString(),e);
			} catch (UnsupportedEncodingException e) {
				log.error(e.toString(),e);
			} catch (NoSuchAlgorithmException e) {
				log.error(e.toString(),e);
			} catch (NoSuchPaddingException e) {
				log.error(e.toString(),e);
			} catch (IllegalBlockSizeException e) {
				log.error(e.toString(),e);
			} catch (BadPaddingException e) {
				log.error(e.toString(),e);
			}
			linkStr += "&dat="+encode_dateStr;
			
			//拼上生成的uuid
			String uuid = UUID.randomUUID().toString();
			request.getSession().setAttribute(CommonConstants.SESSION_UPDATE_PASSWORD_KEY, uuid);
			linkStr += "&uuid="+uuid;
			
			log.info("uid = "+idStr);
			log.info("加密后的eid = "+encode_idStr);
			log.info("dat = "+dateStr);
			log.info("加密后的dat = "+encode_dateStr);
			
			String templateName = CommonConstants.MAIL_UPDATE_PASSWORD_TEMPLATE;
			String subject = CommonConstants.MAIL_UPDATE_PASSWORD_SUBJECT;
			Map<String, String> map = new HashMap<String, String>();
			map.put("updatePassword", linkStr);
			try {
				MailUtil.sendMailByTemplate(email, subject, map, templateName);
			} catch (IOException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (TemplateException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (MessagingException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			}
			return "/test/emailSend";
		}
			
		return "/test/errorEmail";
	}
	
	/**
	 * 用户点击邮件发送的链接
	 *  @Method_Name    : emailUpdatePwd
	 *  @param user
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-29 下午3:40:40
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/toLink")
	public String emailUpdatePwd(String uid, String dat,
			String uuid, HttpServletRequest request, Model model){
		DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		log.info("uid = "+uid);
		log.info("dat = "+dat);
		log.info("uuid = "+uuid);
		
		//解密uid
		String desEncode_uid;
		try {
			desEncode_uid = des.decryptMode(uid);
			log.info("解密后的uid = "+desEncode_uid);
		} catch (Exception e) {
			log.error(e.toString(), e);
			return "test/emailTimeOut";
		} 
		
		//解密日期字符串
		String deEncodeDateStr;
		try {
			deEncodeDateStr = des.decryptMode(dat);
			log.info("deEncodeDat = "+deEncodeDateStr);
			
		} catch (Exception e) {
			log.error(e.toString(), e);
			return "test/emailTimeOut";
		}
		
		//从session中获取存入 的uuid
		String session_uuid = (String)request.getSession().getAttribute(CommonConstants.SESSION_UPDATE_PASSWORD_KEY);
		
		model.addAttribute("userId", desEncode_uid);
		
		Date deEncodeDate = null;
		try {
			//将String类型的日期转为Date类型
			deEncodeDate = sdf.parse(deEncodeDateStr);
		} catch (ParseException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		}
		if(DateUtil.getDistMins(deEncodeDate, new Date())>30){//链接有效期为30分钟
			return "test/emailTimeOut";
		}else if(!uuid.equals(session_uuid)){//重复提交请求
			return "test/emailTimeOut";
		}else{
			return "test/emailLink";
		}
	}
	
	/**
	 * 用于判断用户输入的手机号是否注册
	 *  @Method_Name    : isRegistedPhone
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-5-5 上午10:48:27
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/judgePhone")
	public String isRegistedPhone(String phone, Model model){
		User user = this.userService.selectByPhone(phone);
		if(user==null){
			model.addAttribute("registFlag", false);
			return "";
		}else{
			model.addAttribute("registFlag", true);
			return "";
		}
	}
	
	/**
	 * 用于发送密保邮箱给用户手机的控制器
	 *  @Method_Name    : sendEmail2Phone
	 *  @param phone
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-5-6 上午10:58:00
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/sendMessage")
	public String sendEmail2Phone(String phone, String massageCode,
			HttpServletRequest request){
		log.info("UserInputCode = "+massageCode);
		String realCode = (String) request.getSession().getAttribute(CommonConstants.SMS_CODE_KEY);
		log.info("realCode = "+realCode);
		User user = this.userService.selectByPhone(phone);
		StringBuffer text = new StringBuffer();
		text.append("美试网通知，您的密保邮箱为：");
		text.append(user.getEmail());
		if(massageCode.equals(realCode)){
			log.info(text.toString());
			SMSUtil.sendMessage(phone, text.toString());
			return "test/sendSMSOK";
		}else{
			return "test/sendSMSError";
		}
	}
	
	/**
	 * 用于跳转到申诉界面的控制器
	 *  @Method_Name    : toState
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-5-4 上午10:25:14
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/userState")
	public String toState(){
		return "user/state";
	}
	
	/**
	 * 用来处理链接修改密码的控制器
	 *  @Method_Name    : updatePwd
	 *  @param uid
	 *  @param eid
	 *  @param dat
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-29 下午5:55:34
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/updatePwd")
	public String updatePwd(HttpServletRequest request, String newPassword){
		String userId = request.getParameter("userId");
		log.info("userId = "+userId);
		
		Long long_uid = Long.valueOf(userId);
		log.info("Long uid = "+long_uid);
		
		log.info(newPassword);
		log.info(MD5Util.encode(newPassword));
		this.userService.updatePassword(long_uid, MD5Util.encode(newPassword));
		//修改成功，清空session中的uuid
		request.getSession().setAttribute(CommonConstants.SESSION_UPDATE_PASSWORD_KEY, null);
		return "test/updateOK";
	}
	
	/**
	 * 用于接收输入完手机号后点击下一步时的onclick事件的ajax请求
	 *  @Method_Name    : emailChange
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014-4-29 下午1:47:29
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/verifyPhone")
	public String emailChange(String phone, Model model){
		log.info("用户输入的手机号为："+phone);
		boolean isRegistedPhone = false;
		User user = this.userService.selectByPhone(phone);
		String handledEmail = "";
		
		if(user!=null){
			isRegistedPhone = true;
			
			//邮箱展示处理
			String email = user.getEmail();
			handledEmail = StringUtil.replaceEamil(email);
		}
		model.addAttribute("isRegistedPhone", isRegistedPhone);
		model.addAttribute("handledEmail", handledEmail);
		return "";
	}
	
	@RequestMapping("/showInfo")
	public String sendEmail(String iptPhone, Model model, HttpServletRequest request){
		log.info("用户输入的手机号为："+iptPhone);
		User user = this.userService.selectByPhone(iptPhone);
		String handledEmail = "";
		
		if(user!=null){
			//处理用户email的显示，增加安全性
			handledEmail = StringUtil.replaceEamil(user.getEmail());
			log.info("用户邮箱为："+user.getEmail());
			
			//发邮件准备
			String linkStr = CommonConstants.MAIL_LINK+request.getContextPath()+"/pwdForget/toLink.htm?uid=";
			
			//日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//对称加密准备
			DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);
			
			//拼上加密后的userId
			String idStr = String.valueOf(user.getUserId());
			String encode_idStr = "";
			try {
				encode_idStr = des.encryptMode(idStr);
			} catch (InvalidKeyException e1) {
				log.error(e1.toString(), e1);
			} catch (UnsupportedEncodingException e1) {
				log.error(e1.toString(), e1);
			} catch (NoSuchAlgorithmException e1) {
				log.error(e1.toString(), e1);
			} catch (NoSuchPaddingException e1) {
				log.error(e1.toString(), e1);
			} catch (IllegalBlockSizeException e1) {
				log.error(e1.toString(), e1);
			} catch (BadPaddingException e1) {
				log.error(e1.toString(), e1);
			}
			linkStr += encode_idStr;
			
			//拼上加密后的日期
			String dateStr = sdf.format(new Date());
			String encode_dateStr = "";
			try {
				encode_dateStr = des.encryptMode(dateStr);
				log.info("加密后日期为："+encode_dateStr);
			} catch (InvalidKeyException e) {
				log.error(e.toString(),e);
			} catch (UnsupportedEncodingException e) {
				log.error(e.toString(),e);
			} catch (NoSuchAlgorithmException e) {
				log.error(e.toString(),e);
			} catch (NoSuchPaddingException e) {
				log.error(e.toString(),e);
			} catch (IllegalBlockSizeException e) {
				log.error(e.toString(),e);
			} catch (BadPaddingException e) {
				log.error(e.toString(),e);
			}
			linkStr += "&dat="+encode_dateStr;
			
			//拼上生成的uuid
			String uuid = UUID.randomUUID().toString();
			request.getSession().setAttribute(CommonConstants.SESSION_UPDATE_PASSWORD_KEY, uuid);
			linkStr += "&uuid="+uuid;
			
			log.info("uid = "+idStr);
			log.info("加密后的eid = "+encode_idStr);
			log.info("dat = "+dateStr);
			log.info("加密后的dat = "+encode_dateStr);
			
			String templateName = CommonConstants.MAIL_UPDATE_PASSWORD_TEMPLATE;
			String subject = CommonConstants.MAIL_UPDATE_PASSWORD_SUBJECT;
			Map<String, String> map = new HashMap<String, String>();
			map.put("updatePassword", linkStr);
			try {
				MailUtil.sendMailByTemplate(user.getEmail(), subject, map, templateName);
			} catch (IOException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (TemplateException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			} catch (MessagingException e) {
				log.error(e.toString(),e);
				e.printStackTrace();
			}
		}
		model.addAttribute("email", user.getEmail());
		model.addAttribute("handledEmail", handledEmail);
		return "user/pwdForget_resend";
	}
	
	/**
	 * 接收”重新发送“按键的ajax请求
	 *  @Method_Name    : resend
	 *  @param email
	 *  @param request
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年6月4日 下午1:37:15
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/resend")
	public String resend(String email, HttpServletRequest request){
		log.info("用户输入的手机号为："+email);
		User user = this.userService.selectByEmail(email);
		
		String linkStr = CommonConstants.MAIL_LINK+request.getContextPath()+"/pwdForget/toLink.htm?uid=";
		
		//日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//对称加密准备
		DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);
		
		//拼上加密后的userId
		String idStr = String.valueOf(user.getUserId());
		String encode_idStr = "";
		try {
			encode_idStr = des.encryptMode(idStr);
		} catch (InvalidKeyException e1) {
			log.error(e1.toString(), e1);
		} catch (UnsupportedEncodingException e1) {
			log.error(e1.toString(), e1);
		} catch (NoSuchAlgorithmException e1) {
			log.error(e1.toString(), e1);
		} catch (NoSuchPaddingException e1) {
			log.error(e1.toString(), e1);
		} catch (IllegalBlockSizeException e1) {
			log.error(e1.toString(), e1);
		} catch (BadPaddingException e1) {
			log.error(e1.toString(), e1);
		}
		linkStr += encode_idStr;
		
		//拼上加密后的日期
		String dateStr = sdf.format(new Date());
		String encode_dateStr = "";
		try {
			encode_dateStr = des.encryptMode(dateStr);
			log.info("加密后日期为："+encode_dateStr);
		} catch (InvalidKeyException e) {
			log.error(e.toString(),e);
		} catch (UnsupportedEncodingException e) {
			log.error(e.toString(),e);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.toString(),e);
		} catch (NoSuchPaddingException e) {
			log.error(e.toString(),e);
		} catch (IllegalBlockSizeException e) {
			log.error(e.toString(),e);
		} catch (BadPaddingException e) {
			log.error(e.toString(),e);
		}
		linkStr += "&dat="+encode_dateStr;
		
		//拼上生成的uuid
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute(CommonConstants.SESSION_UPDATE_PASSWORD_KEY, uuid);
		linkStr += "&uuid="+uuid;
		
		log.info("uid = "+idStr);
		log.info("加密后的eid = "+encode_idStr);
		log.info("dat = "+dateStr);
		log.info("加密后的dat = "+encode_dateStr);
		
		String templateName = CommonConstants.MAIL_UPDATE_PASSWORD_TEMPLATE;
		String subject = CommonConstants.MAIL_UPDATE_PASSWORD_SUBJECT;
		Map<String, String> map = new HashMap<String, String>();
		map.put("updatePassword", linkStr);
		try {
			MailUtil.sendMailByTemplate(user.getEmail(), subject, map, templateName);
		} catch (IOException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		} catch (TemplateException e) {
			log.error(e.toString(),e);
			e.printStackTrace();
		} catch (MessagingException e) { 
			log.error(e.toString(),e);
			e.printStackTrace();
		}
		return "";
	}
}
