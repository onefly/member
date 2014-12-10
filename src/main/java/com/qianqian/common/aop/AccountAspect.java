package com.qianqian.common.aop;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.http.impl.cookie.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.framelib.redis.IRedisUtil;
import com.framelib.utils.SessionUtil;
import com.qianqian.user.mapper.AccountRecordMapper;
import com.qianqian.user.mapper.UserMapper;
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.model.User;
/**
 * 切入目标方法进行账户变化的后续操作，以及记录账户日志记录
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.common.aop.AccountAspect.java
 * @ClassName	: AccountAspect 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年4月25日 上午8:57:34
 */
public class AccountAspect {
	/**
	 * 记录日志对象
	 */
	private static Logger log = LoggerFactory.getLogger(AccountAspect.class);
	/**
	 * 某个方法对应的积分，体验值，体验宝，大牌勋章的变化数量
	 */
	private Map<String, AccountChange> methods;
	/**
	 * 数据库访问mapper
	 */
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	/**
	 * 数据库访问mapper
	 */
	@Resource
	private AccountRecordMapper accountRecordMapper;
	/**
	 * 注入redis访问工具类
	 */
	@Resource
	private IRedisUtil redisUtil;

	public void setMethods(Map<String, AccountChange> methods) {
		this.methods = methods;
	}

	/**
	 * 环绕目标方法执行
	 * 
	 * @Method_Name : around
	 * @param pjp
	 * @return : void
	 * @Creation Date : 2014年4月21日 下午1:23:48
	 * @version : v1.00
	 * @throws Throwable
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getDeclaringTypeName() + "."
				+ pjp.getSignature().getName();
		Object retVal = null;
		retVal = pjp.proceed();
		log.debug(" target method:" + method);
		// 判断是否需要处理账户数据
		if (isHandleAccount(method)) {
			if (handleAccount(method) > 0) {
				log.debug(method + " update field success!");
			} else {
				log.debug("no field to change");
			}
		} else {
			log.debug("target method not to handle account");
		}
		return retVal;

	}

	/**
	 * 判断该方法是否需要处理账户数据
	 * 
	 * @Method_Name : isHandleAccount
	 * @param method
	 * @return
	 * @return : boolean
	 * @Creation Date : 2014年4月21日 下午3:04:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	private boolean isHandleAccount(String method) {
		return methods.containsKey(method);
	}

	/**
	 * 根据配置文件对数据库账户进行对应操作
	 * 
	 * @Method_Name : handleAccount
	 * @param method
	 * @return
	 * @return : int
	 * @Creation Date : 2014年4月21日 下午3:30:37
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	private int handleAccount(String method) {
		AccountChange account = methods.get(method);
		User user = new User();// 用户对象
		AccountRecord record = new AccountRecord();// 账户流水记录
		long userId = SessionUtil.getSessionData().getId();
		user.setUserId(userId);
		user.setScore(account.getScore());
		user.setExperienceValue(account.getExperience());
		user.setIngot(account.getIngot());
		user.setMedalCount(account.getIngot());
		// 积分不为0
		if (account.getScore() != 0) {
			String socre = account.getScore() > 0 ? ("+" + account.getScore())
					: ("" + account.getScore());
			record.setScore(socre);
		}
		// 体验值不为0
		if (account.getExperience() != 0) {
			String experience = account.getExperience() >= 0 ? ("+" + account
					.getExperience()) : ("" + account.getExperience());
			record.setExperienceValue(experience);
		}
		// 体验宝不为0
		if (account.getIngot() != 0) {
			String ingot = account.getIngot() >= 0 ? ("+" + account.getIngot())
					: ("" + account.getIngot());
			record.setIngot(ingot);
		}
		// 勋章不为0
		if (account.getMedal() != 0) {
			String medal = account.getMedal() >= 0 ? ("+" + account.getMedal())
					: ("" + account.getMedal());
			record.setMedal(medal);
		}
		log.debug(user.getUserId()+" filter user before :"+user);
		log.debug(user.getUserId()+" filter record before :"+record);
		log.debug(user.getUserId()+" account settings :"+account);
		// 过滤掉那些已经超出日限额或者月限额的数据
		AccountResult result = filterLimited(user, record, account);
		AccountRecord filterRecord = result.getRecord();
		User filterUser = result.getUser();
		int r = 0;
		if (filterUser.getScore() != 0 || filterUser.getExperienceValue() != 0
				|| filterUser.getIngot() != 0
				|| filterUser.getMedalCount() != 0) {
			filterRecord.setUserId(userId);
			filterRecord.setSource(account.getAction());
			filterRecord.setId(10L);// 保证id不为空即可，sql中采用uuid_short() 生成主键
			filterRecord.setRecordTime(new Date());
			userMapper.updateByPrimaryKeySelective(filterUser);
			r = accountRecordMapper.insertSelective(filterRecord);
			if (r > 0) {
				// 更新已经使用的限额到redis中
				saveToRedis(user, account);
			}
		}
		return r;

	}
	/**
	 * 根据配置文件中的bean
	 * 过滤掉超出日限额和月限额的属性数据
	 *  @Method_Name    : filterLimited
	 *  @param user
	 *  @param record
	 *  @param limitedAccount
	 *  @return 
	 *  @return         : AccountResult
	 *  @Creation Date  : 2014年4月25日 上午9:01:22
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	private AccountResult filterLimited(User user, AccountRecord record,
			AccountChange limitedAccount) {
		// 已经使用的日限额key
		String dayUsedKey = user.getUserId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM-dd")+limitedAccount.getAction();
		// 已经使用的月限额key
		String monthUsedKey = user.getUserId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM")+limitedAccount.getAction();
		AccountChange dayUsed = (AccountChange) redisUtil.getObject(dayUsedKey);// 获取redis中保存的已使用日限额对象
		dayUsed = dayUsed == null ? new AccountChange() : dayUsed;
		log.debug(user.getUserId() + " used day limit object from redis:" + dayUsed);
		AccountChange monthUsed = (AccountChange) redisUtil
				.getObject(monthUsedKey);// 获取redis中保存的已使用月限额对象
		monthUsed = monthUsed == null ? new AccountChange() : monthUsed;
		log.debug(user.getUserId() + " used month limit object from redis:" + monthUsed);
		// 积分日限额大于0时表示有日限额
		if (limitedAccount.getSocreDayLimit() > 0) {
			if ((user.getScore() + dayUsed.getScoreDayUsed()) > limitedAccount
					.getSocreDayLimit()) {
				// 已经使用的限额+本次的变化值，大于设置的日限额，则设为0，不修改积分的值
				user.setScore(0L);
				record.setScore(null);
				log.debug(user.getUserId() + " beyond the score day limit");
			}
		}
		// 积分月限额大于0时表示有月限额
		if (limitedAccount.getSocreMonthLimit() > 0) {
			if ((user.getScore() + monthUsed.getScoreMonthUsed()) > limitedAccount
					.getSocreMonthLimit()) {
				// 已经使用的限额+本次的变化值，大于设置的月限额，则设为0，不修改积分的值
				user.setScore(0L);
				record.setScore(null);
				log.debug(user.getUserId() + " beyond the score month limit");
			}
		}
		// 体验值日限额大于0时表示有日限额
		if (limitedAccount.getExperienceDayLimit() > 0) {
			if ((user.getExperienceValue() + dayUsed.getExperience()) > limitedAccount
					.getExperienceDayLimit()) {
				// 已经使用的限额+本次的变化值，大于设置的限额，则设为0，不修改体验值的值
				user.setExperienceValue(0L);
				record.setExperienceValue(null);
				log.debug(user.getUserId() + " beyond the experience day limit");
			}
		}
		// 体验值月限额大于0时表示有月限额
		if (limitedAccount.getExperienceMonthLimit() > 0) {
			if ((user.getExperienceValue() + monthUsed.getExperience()) > limitedAccount
					.getExperienceMonthLimit()) {
				// 已经使用的限额+本次的变化值，大于设置的月限额，则设为0，不修改体验值的值
				user.setExperienceValue(0L);
				record.setExperienceValue(null);
				log.debug(user.getUserId()
						+ " beyond the experience month limit");
			}
		}
		// 体验宝日限额大于0时表示有日限额
		if (limitedAccount.getIngotDayLimit() > 0) {
			if ((user.getIngot() + dayUsed.getIngotDayUsed()) > limitedAccount
					.getIngotDayLimit()) {
				user.setIngot(0L);
				record.setIngot(null);
				log.debug(user.getUserId() + " beyond the ingot day limit");
			}
		}
		// 体验宝月限额大于0时表示有月限额
		if (limitedAccount.getIngotMonthLimit() > 0) {
			if ((user.getIngot() + monthUsed.getIngotMonthUsed()) > limitedAccount
					.getIngotMonthLimit()) {
				user.setIngot(0L);
				record.setIngot(null);
				log.debug(user.getUserId() + " beyond the ingot month limit");
			}
		}
		// 勋章日限额大于0表示有日限额
		if (limitedAccount.getMedalDayLimit() > 0) {
			if ((user.getMedalCount() + dayUsed.getMedalDayUsed()) > limitedAccount
					.getMedalDayLimit()) {
				user.setMedalCount(0L);
				record.setMedal(null);
				log.debug(user.getUserId() + " beyond the medal day limit");
			}
		}
		// 勋章月限额大于0表示有月限额
		if (limitedAccount.getMedalMonthLimit() > 0) {
			if ((user.getMedalCount() + monthUsed.getMedalMonthUsed()) > limitedAccount
					.getMedalMonthLimit()) {
				user.setMedalCount(0L);
				record.setMedal(null);
				log.debug(user.getUserId() + " beyond the medal month limit");
			}
		}
		return new AccountResult(user, record);
	}

	/**
	 * 异常处理
	 * 
	 * @Method_Name : doThrowing
	 * @param jp
	 * @param ex
	 * @return : void
	 * @Creation Date : 2014年4月22日 下午1:54:54
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public void doThrowing(JoinPoint jp, Throwable ex) {
		// log.error("程序执行异常," + jp.getTarget().getClass().getName() + "."
		// + jp.getSignature().getName(), ex);

	}

	/**
	 * 将账户变化情况保存或更新到redis中 保存用户的限额使用情况，包括日限额和月限额
	 * 
	 * @Method_Name : saveToRedis
	 * @param user
	 * @param account
	 * @return : void
	 * @Creation Date : 2014年4月22日 下午4:12:12
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	private void saveToRedis(User user, AccountChange account) {
		// 已经使用的日限额key
		String dayUsedKey = user.getUserId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM-dd")+account.getAction();
		// 已经使用的月限额key
		String monthUsedKey = user.getUserId()
				+ DateUtils.formatDate(new Date(), "yyyy-MM")+account.getAction();
		int dayExtireTime = 60 * 60 * 24 + 5;// 24小时+5秒
		int monthExtireTime = 60 * 60 * 24 * 31 + 5;// 31天+5秒
		AccountChange dayUsed = (AccountChange) redisUtil.getObject(dayUsedKey);// 从redis中取出已经使用的日限额信息对象
		if (dayUsed == null) {
			dayUsed = new AccountChange();
		}
		AccountChange monthUsed = (AccountChange) redisUtil
				.getObject(monthUsedKey);// 从redis中取出已经使用的月限额信息对象
		if (monthUsed == null) {
			monthUsed = new AccountChange();
		}
		// 积分日限额大于0，表示有日限额
		if (account.getSocreDayLimit() > 0) {
			dayUsed.setScoreDayUsed(dayUsed.getScoreDayUsed()
					+ user.getScore());// 在已经使用的积分日限额基础上累计相加
		}
		// 积分月限额大于0，表示有月限额
		if (account.getSocreMonthLimit() > 0) {
			monthUsed.setScoreMonthUsed(monthUsed.getScoreMonthUsed()
					+ user.getScore());// 在已经使用的积分月限额基础上累计相加
		}
		// 当体验值日限额大于0
		if (account.getExperienceDayLimit() > 0) {
			dayUsed.setExperienceDayUsed(dayUsed.getExperienceDayUsed()
					+ user.getExperienceValue());
		}
		// 当体验值月限额大于0
		if (account.getExperienceMonthLimit() > 0) {
			monthUsed.setExperienceMonthUsed(monthUsed.getExperienceMonthUsed()
					+ user.getExperienceValue());
		}
		// 体验宝日限额大于0
		if (account.getIngotDayLimit() > 0) {
			dayUsed.setIngotDayUsed(dayUsed.getIngotDayUsed()
					+ user.getIngot());
		}
		// 体验宝月限额大于0
		if (account.getIngotMonthLimit() > 0) {
			monthUsed.setIngotMonthUsed(monthUsed.getIngotMonthUsed()
					+ user.getIngot());
		}
		// 勋章日限额大于0
		if (account.getMedalDayLimit() > 0) {
			dayUsed.setMedalDayUsed(dayUsed.getMedalDayUsed()
					+ user.getMedalCount());
		}
		// 勋章月限额大于0
		if (account.getMedalMonthLimit() > 0) {
			monthUsed.setMedalMonthUsed(monthUsed.getMedalMonthUsed()
					+ user.getMedalCount());
		}
		log.debug(user.getUserId() + " redis dayUsed :" + dayUsed);
		if (dayUsed.getScoreDayUsed() > 0 || dayUsed.getExperienceDayUsed() > 0
				|| dayUsed.getIngotDayUsed() > 0
				|| dayUsed.getMedalDayUsed() > 0) {
			// 保存已经使用的日限额对象,并设置过期时间
			redisUtil.setObject(dayUsedKey, dayUsed);
			redisUtil.expire(dayUsedKey, dayExtireTime);
			log.debug("save dayUsed to redis success");
		}
		log.debug(user.getUserId() + " redis monthUsed :" + monthUsed);
		if (monthUsed.getScoreMonthUsed() > 0
				|| monthUsed.getExperienceMonthUsed() > 0
				|| monthUsed.getIngotMonthUsed() > 0
				|| monthUsed.getMedalMonthUsed() > 0) {
			// 保存已经使用的月限额对象,并设置过期时间
			redisUtil.setObject(monthUsedKey, monthUsed);
			redisUtil.expire(monthUsedKey, monthExtireTime);
			log.debug("save monthUsed to redis success");
		}

	}
	/**
	 * User 和 AccountRecord 的载体
	 * @Project 	: member.maxtp
	 * @Program Name: com.qianqian.common.aop.AccountAspect.java
	 * @ClassName	: AccountResult 
	 * @Author 		: caozhifei 
	 * @CreateDate  : 2014年4月25日 上午9:02:16
	 */
	class AccountResult {
		private User user;
		private AccountRecord record;

		public AccountResult(User user, AccountRecord record) {
			super();
			this.user = user;
			this.record = record;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public AccountRecord getRecord() {
			return record;
		}

		public void setRecord(AccountRecord record) {
			this.record = record;
		}

	}
}
