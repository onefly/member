package com.qianqian.safety.controller;

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
import java.util.concurrent.TimeoutException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.common.CommonConstants;
import com.framelib.common.SessionData;
import com.framelib.utils.DESUtil;
import com.framelib.utils.DateUtil;
import com.framelib.utils.MD5Util;
import com.framelib.utils.SessionUtil;
import com.framelib.utils.StringUtil;
import com.framelib.utils.mail.MailUtil;
import com.qianqian.common.utils.Constants;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;

import freemarker.template.TemplateException;

/**
 * 操作安全中心模块的控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.controller.SafetyController.java
 * @ClassName	: SafetyController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014年5月8日 上午9:34:46
 */
@RequestMapping("/safety")
@Controller
public class SafetyController {
	private static Logger log = LoggerFactory.getLogger(SafetyController.class);
	@Autowired
	private IUserService userService;
	
	/**
	 * 进入安全中心页面
	 *  @Method_Name    : toSafety
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月8日 上午9:37:29
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/toSafety")
	public String toSafety(HttpServletRequest request, Model model){
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
		Long userId = sd.getId();
		log.info("SessionData中获取的userId = "+userId);
		
		User user = this.userService.getUser(userId);
		//处理用户手机，邮箱，身份证的显示*化
		String handledPhone = StringUtil.replaceMobile(user.getPhone());
		String handledEmail = StringUtil.replaceEamil(user.getEmail());
		String handledIdCard = StringUtil.replaceIdCard(user.getIdentification());
		
		//时间的处理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(user.getLastLoginTime()!=null){
			user.setLastLoginTimeStr(sdf.format(user.getLastLoginTime()));
		}
		
		//将处理过的数据放入user对象
		user.setPhone(handledPhone);
		user.setEmail(handledEmail);
		user.setIdentification(handledIdCard);
		
		//将user放入session
		request.getSession(true).setAttribute("handledUser", user);
		
		model.addAttribute("user", user);
		
		return "safety/Individual_safety";
	}
	
	/**
	 * 跳转到修改密码页面的控制器
	 *  @Method_Name    : changePassword
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月8日 下午3:14:55
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/changePassword")
	public String changePassword(HttpServletRequest request, Model model){
		User handledUser = (User) request.getSession().getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		return "safety/changePassword_stepOne";
	}
	
	/**
	 * 跳转到修改密码的第二步，发送邮件验证身份
	 *  @Method_Name    : sendValidateCodeEmail
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月9日 上午10:06:40
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/sendCodeEmail")
	public String sendValidateCodeEmail(HttpServletRequest request, Model model){
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
		
		User handledUser = (User) request.getSession()
								.getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		Long id = sd.getId();
		User user = this.userService.getUser(id);
		StringBuffer text = new StringBuffer();
		text.append("您本次操作的验证码为：");
		String code = RandomStringUtils.randomNumeric(6);
		
		request.getSession(true).setAttribute("emailValidateCode", code);
		
		text.append(code+"，验证码有效期为30分钟，请及时完成操作。");
		
		String subject = CommonConstants.MAIL_VALIDATE_CODE_SUBJECT;
		String templateName = CommonConstants.MAIL_VALIDATE_CODE_TEMPLATE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("validateCode", text.toString());
		
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
		return "safety/changePassword_stepTwo";
	}
	
	/**
	 * 邮箱验证码的验证控制器
	 *  @Method_Name    : codeVerify
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月9日 上午10:28:03
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/submitCode")
	public String codeVerify(String code, Model model, HttpServletRequest request){
		String realCode = (String) request.getSession()
							.getAttribute("emailValidateCode");
		log.info("存在session中的验证码为："+realCode);
		log.info("用户输入的验证码为："+code);
		
		if(realCode.equals(code)){
			model.addAttribute("isCodeRight", true);
			return "safety/changePassword_stepThree";
		}else{
			model.addAttribute("isCodeRight", false);
			return "";
		}
	}
	
	/**
	 * 执行修改密码功能
	 *  @Method_Name    : updatePasswd
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月14日 下午1:15:30
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/update")
	public String updatePasswd(String newPasswd, int passwordStrength){
		log.info("用户新密码为："+newPasswd);
		
		SessionData sd = SessionUtil.getSessionData();
		Long id = sd.getId();
		log.info("需要修改的用户id为："+id);
		
		User record = new User();
		record.setUserId(id);
		record.setPassword(MD5Util.encode(newPasswd));
		record.setPasswdStrength(passwordStrength);
		
		this.userService.updateUser(record);
		
		return "safety/changePassword_stepFour";
	}
	
	/**
	 * 跳转到修改手机页面的控制器
	 *  @Method_Name    : changePhone
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月20日 下午2:24:51
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/changePhone")
	public String changePhone(HttpServletRequest request, Model model){
		User handledUser = (User) request.getSession().getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		return "safety/changePhone_stepOne";
	}
	
	/**
	 * 跳转到修改手机的第2步，发送邮箱验证码
	 *  @Method_Name    : sendCodeEmail
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月20日 下午2:42:28
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getEmailCode")
	public String sendCodeEmail(HttpServletRequest request, Model model){
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
		
		User handledUser = (User) request.getSession()
								.getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		Long id = sd.getId();
		User user = this.userService.getUser(id);
		StringBuffer text = new StringBuffer();
		text.append("您本次操作的验证码为：");
		String code = RandomStringUtils.randomNumeric(6);
		
		request.getSession(true).setAttribute("emailValidateCode", code);
		
		text.append(code+"，验证码有效期为30分钟，请及时完成操作。");
		
		String subject = CommonConstants.MAIL_VALIDATE_CODE_SUBJECT;
		String templateName = CommonConstants.MAIL_VALIDATE_CODE_TEMPLATE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("validateCode", text.toString());
		
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
		return "safety/changePhone_stepTwo";
	}
	
	/**
	 * 修改手机号时进行的邮箱验证码的校验
	 *  @Method_Name    : codeVerify4changePhone
	 *  @param code
	 *  @param model
	 *  @param request
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月20日 下午4:07:53
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/submitCode_changePhone")
	public String codeVerify4changePhone(String code, Model model, HttpServletRequest request){
		String realCode = (String) request.getSession()
							.getAttribute("emailValidateCode");
		log.info("存在session中的验证码为："+realCode);
		log.info("用户输入的验证码为："+code);
		
		if(realCode.equals(code)){
			model.addAttribute("isCodeRight", true);
			return "safety/changePhone_stepThree";
		}else{
			model.addAttribute("isCodeRight", false);
			return "";
		}
	}
	
	/**
	 * 接收ajax请求，用于提示验证码是否输入正确
	 *  @Method_Name    : checkTimes
	 *  @param request
	 *  @param model
	 *  @param validateCode
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月21日 上午11:53:34
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/validateCodeVerify")
	public String checkTimes(HttpServletRequest request,
							Model model, String validateCode){
		log.info("用户输入的验证码为："+validateCode);
		
		String realCode = (String)request.getSession().getAttribute(CommonConstants.SMS_CODE_KEY);
		log.info("手机发送的验证码为："+realCode);
		
		if(realCode.equals(validateCode)){
			model.addAttribute("checkFlag", true);
			return "";
		}else{
			model.addAttribute("checkFlag", false);
			return "";
		}
	}
	
	/**
	 * 处理修改手机号的表单控制器
	 *  @Method_Name    : updatePhone
	 *  @param request
	 *  @param iptChance
	 *  @param model
	 *  @param validateCode
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月21日 上午10:32:08
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/formSubmit")
	public String updatePhone(HttpServletRequest request, int iptChance,
				Model model, String newPhone){
		log.info("还可以输入的次数为："+iptChance);
		
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
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
		Long id = sd.getId();
		log.info("要修改的用户ID为："+id);
		
		if(iptChance <= 0){
			return "common/errors/error";
		}else{
			this.userService.updatePhone(id, newPhone);
			return "safety/changePhone_stepFour";
		}
	}
	
	/**
	 * 接收重新发送邮件的ajax请求控制器
	 *  @Method_Name    : reSendCodeEmail
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月22日 上午10:39:34
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/reSend")
	public String reSendCodeEmail(HttpServletRequest request, Model model){
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
		User handledUser = (User) request.getSession()
								.getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		Long id = sd.getId();
		User user = this.userService.getUser(id);
		StringBuffer text = new StringBuffer();
		text.append("您本次操作的验证码为：");
		String code = RandomStringUtils.randomNumeric(6);
		
		request.getSession(true).setAttribute("emailValidateCode", code);
		
		text.append(code+"，验证码有效期为30分钟，请及时完成操作。");
		
		String subject = CommonConstants.MAIL_VALIDATE_CODE_SUBJECT;
		String templateName = CommonConstants.MAIL_VALIDATE_CODE_TEMPLATE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("validateCode", text.toString());
		
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
	
	/**
	 * 跳转到密保邮箱修改页面
	 *  @Method_Name    : changeEmail
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月22日 上午11:05:01
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/changeEmail")
	public String changeEmail(HttpServletRequest request, Model model){
		User handledUser = (User) request.getSession().getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		return "safety/changeEmail_stepOne";
	}
	
	/**
	 * 修改密保邮箱页面的发送邮箱验证码
	 *  @Method_Name    : sendCodeEmail_email
	 *  @param request
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月22日 上午11:10:56
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/getEmailCode_email")
	public String sendCodeEmail_email(HttpServletRequest request, Model model){
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
		
		User handledUser = (User) request.getSession()
								.getAttribute("handledUser");
		model.addAttribute("user", handledUser);
		
		Long id = sd.getId();
		User user = this.userService.getUser(id);
		StringBuffer text = new StringBuffer();
		text.append("您本次操作的验证码为：");
		String code = RandomStringUtils.randomNumeric(6);
		
		request.getSession(true).setAttribute("emailValidateCode", code);
		
		text.append(code+"，验证码有效期为30分钟，请及时完成操作。");
		
		String subject = CommonConstants.MAIL_VALIDATE_CODE_SUBJECT;
		String templateName = CommonConstants.MAIL_VALIDATE_CODE_TEMPLATE;
		Map<String, String> map = new HashMap<String, String>();
		map.put("validateCode", text.toString());
		
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
		return "safety/changeEmail_stepTwo";
	}
	
	/**
	 * 修改密保邮箱时进行的邮箱验证码的校验
	 *  @Method_Name    : codeVerify4changeEmail
	 *  @param code
	 *  @param model
	 *  @param request
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月22日 上午11:33:01
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/submitCode_changeEmail")
	public String codeVerify4changeEmail(String code, Model model, HttpServletRequest request){
		String realCode = (String) request.getSession()
							.getAttribute("emailValidateCode");
		log.info("存在session中的验证码为："+realCode);
		log.info("用户输入的验证码为："+code);
		
		if(realCode.equals(code)){
			model.addAttribute("isCodeRight", true);
			return "safety/changeEmail_stepThree";
		}else{
			model.addAttribute("isCodeRight", false);
			return "";
		}
	}
	
	/**
	 * 接收用户的ajax请求发送修改邮件的激活链接
	 *  @Method_Name    : sendEmailLink
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月26日 下午1:39:58
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/sendEmail_changeEmail")
	public String sendEmailLink(HttpServletRequest request, String newEmail){
		//拼上链接的域名，端口，上下文
		StringBuffer text = new StringBuffer();
		String realm_port = CommonConstants.MAIL_LINK;
		text.append(realm_port);
		String contextPath = request.getContextPath();
		text.append(contextPath);
		String contentRoot = "/safety/toLink_changeEmail.htm?uid=";
		text.append(contentRoot);
		
		SessionData sd = null;
		try {
			sd = SessionUtil.getSessionData(request);
		} catch (TimeoutException e1) {
			log.error(e1.toString());
		} catch (InterruptedException e1) {
			log.error(e1.toString());
		} catch (MemcachedException e1) {
			log.error(e1.toString());
		}
		Long userId = sd.getId();
		log.info("请求启用的ID为："+userId);
		
		//对称加密准备
		DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);
		
		//设置日期的一些属性，以便判断链接是否过期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(new Date());
		String encode_userId = "";
		String encode_newEmail = "";
		String encode_dateStr = "";
		//加密日期,用户ID,用户新邮箱
		try {
			encode_userId = des.encryptMode(userId.toString());
			log.info("加密后的ID为："+encode_userId);
			encode_newEmail = des.encryptMode(newEmail);
			log.info("加密后的邮箱为："+encode_newEmail);
			encode_dateStr = des.encryptMode(dateStr);
			log.info("加密后的日期为："+encode_dateStr);
			
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
		//拼上加密后用户ID和日期
		text.append(encode_userId);
		text.append("&email="+encode_newEmail);
		text.append("&dat="+encode_dateStr);
		
		//生成uuid
		String uuidStr = UUID.randomUUID().toString();
		request.getSession().setAttribute("uuid_changeEmail", uuidStr);
		
		//拼上uuid
		text.append("&uuid="+uuidStr);
		
		//发送邮件及准备工作
		String link_str = text.toString();
		String templateName = CommonConstants.MAIL_UPDATE_PASSWORD_TEMPLATE;
		String subject = CommonConstants.MAIL_UPDATE_PASSWORD_SUBJECT;
		Map<String, String> map = new HashMap<String, String>();
		map.put("updatePassword", link_str);
		try {
			MailUtil.sendMailByTemplate(newEmail, subject, map, templateName);
		} catch (IOException e) {
			log.info(e.toString());
		} catch (TemplateException e) {
			log.info(e.toString());
		} catch (MessagingException e) {
			log.info(e.toString());
		}
		
		return "";
	}
	
	/**
	 * 点击链接跳转到成功页面
	 *  @Method_Name    : changeEmailOK
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月26日 下午3:02:06
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/toLink_changeEmail")
	public String changeEmailOK(String uid, HttpServletRequest request,
					String email, String dat, String uuid){
		
		//解密及日期格式准备
		DESUtil des = new DESUtil(Constants.DESKEY_UPDPWD_KEY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String desEncode_uid = "";
		String desEncode_email = "";
		String desEncode_datStr = "";
		//解密用户ID，邮箱，日期
		try {
			desEncode_uid = des.decryptMode(uid);
			log.info("解密后的ID为："+desEncode_uid);
			desEncode_email = des.decryptMode(email);
			log.info("解密后的邮箱为："+desEncode_email);
			desEncode_datStr = des.decryptMode(dat);
			log.info("解密后的日期为："+desEncode_datStr);
		} catch (Exception e) {
			log.error(e.toString(), e);
			return "test/emailTimeOut";
		}
		
		Date desEncode_date = null;
		try {
			desEncode_date = sdf.parse(desEncode_datStr);
		} catch (ParseException e) {
			log.error(e.toString(), e);
		}
		
		//获取存入Session中的uuid
		String session_uuid = (String) request.getSession().getAttribute("uuid_changeEmail");
		if(!uuid.equals(session_uuid)){//已经处理过的请求
			return "test/emailTimeOut";
		}else{
			if(DateUtil.getDistMins(desEncode_date, new Date())>30){//链接有效期为30分钟
				return "test/emailTimeOut";
			}else{
				Long userId = Long.valueOf(desEncode_uid);
				this.userService.updateEmail(userId, desEncode_email);
				
				request.getSession().setAttribute("uuid_changeEmail", null);
				
				return "safety/changeEmail_stepFour";
			}
		}	
	}
}
