package com.qianqian.user.service;

import com.framelib.common.SessionData;

/**
 * 进行签到操作
 * 判断签到状态
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.SignInService.java
 * @ClassName	: SignInService 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年4月18日 上午9:17:45
 */
public interface ISignInService {
	/**
	 * 用户签到
	 *  @Method_Name    : signIn
	 *  @param userId  当前登录用户的userId
	 *  @return 
	 *  @return         : boolean true = 签到成功 / false = 签到失败
	 *  @Creation Date  : 2014年4月18日 上午9:18:27
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	boolean saveSignIn(SessionData sessionData);
	/**
	 * 判断用户是否已经签到
	 *  @Method_Name    : isSignIn
	 *  @param userId 用户的userId
	 *  @return 
	 *  @return         : boolean true = 已经签到 / false = 未签到
	 *  @Creation Date  : 2014年4月18日 上午9:21:23
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	boolean isSignIn(SessionData sessionData);
}
