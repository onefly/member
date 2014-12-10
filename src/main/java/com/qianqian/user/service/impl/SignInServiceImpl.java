package com.qianqian.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.framelib.common.SessionData;
import com.framelib.redis.IRedisUtil;
import com.qianqian.user.mapper.UserMapper;
import com.qianqian.user.service.ISignInService;

/**
 * 进行签到操作 判断签到状态
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.service.SignInService.java
 * @ClassName : SignInService
 * @Author : caozhifei
 * @CreateDate : 2014年4月18日 上午9:17:45
 */
@Service("signInService")
public class SignInServiceImpl implements ISignInService {
	private static final String SIGN_IN_KEY = "signInKey";
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	/**
	 * 记录日志对象
	 */
	private static Logger log = LoggerFactory
			.getLogger(SignInServiceImpl.class);
	/**
	 * 注入redis访问工具类
	 */
	@Resource
	private IRedisUtil redisUtil;

	/**
	 * 用户签到
	 * 
	 * @Method_Name : signIn
	 * @param userId
	 *            当前登录用户的userId
	 * @return
	 * @return : boolean true = 签到成功 / false = 签到失败
	 * @Creation Date : 2014年4月18日 上午9:18:27
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean saveSignIn(SessionData sessionData) {
		log.debug("userId:" + sessionData.getId());
		// 签到成功后在redis中保存签到记录并设置过期时间，到第二天签到记录自动清除，防止当天重复签到
		String key = SIGN_IN_KEY + sessionData.getId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		// 计算key过期时间
		int extireTime = 60 * 60 * 24 + 5;// 24小时+5秒
		String result = redisUtil.setex(key, extireTime, SIGN_IN_KEY);
		if (StringUtils.equals(result, "OK")) {
			log.debug(sessionData.getId() + "实际还剩余：" + redisUtil.ttl(key) + "秒");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断用户是否已经签到
	 * 
	 * @Method_Name : isSignIn
	 * @param userId
	 *            用户的userId
	 * @return
	 * @return : boolean true = 已经签到 / false = 未签到
	 * @Creation Date : 2014年4月18日 上午9:21:23
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public boolean isSignIn(SessionData sessionData) {
		log.debug("userId:" + sessionData.getId());
		String key = SIGN_IN_KEY + sessionData.getId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		String flag = redisUtil.get(key);
		// 当根据key在redis中没有取到值时，flag为null说明还没有签到，则回复false
		boolean result = StringUtils.equals(SIGN_IN_KEY, flag);
		log.debug(sessionData.getId() + "还剩余：" + redisUtil.ttl(key) + "秒");
		return result;
	}

}
