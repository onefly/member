package com.qianqian.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.framelib.common.CommonConstants;
import com.framelib.common.SessionData;
import com.framelib.utils.CookieUtils;
import com.framelib.utils.MD5Util;
import com.framelib.utils.SessionUtil;
import com.qianqian.user.mapper.UserMapper;
import com.qianqian.user.model.AccountRecord;
import com.qianqian.user.model.RecieveAddress;
import com.qianqian.user.model.User;
import com.qianqian.user.model.UserExample;
import com.qianqian.user.model.UserExample.Criteria;
import com.qianqian.user.service.IAccountRecordService;
import com.qianqian.user.service.IUserService;
import com.qianqian.user.service.support.ValidateResult;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户业务层实现类
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.service.impl.UserServiceImpl.java
 * @ClassName	: UserServiceImpl 
 * @Author 		: shensheng peichunting
 * @CreateDate  : 2014-4-15 下午6:04:10
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	private static Logger log = Logger.getLogger(UserServiceImpl.class);

	/**
	 * 
	 */
	//@Autowired
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Resource
	private IAccountRecordService accountRecordService;
	
	
	/**
	 * 
	 */
	private static final HashMap<String,String> nameMap=new HashMap<String,String>();
	static{
		nameMap.put("nickname","昵称");
		nameMap.put("indentification","身份证");
		nameMap.put("phone","手机号码");
		nameMap.put("email","邮箱");
	}
	
	
	/**
	 * 
	 */
	private ThreadLocal<HashMap<String,String>> localMap=new ThreadLocal<HashMap<String,String>>(){
		@Override protected HashMap<String,String> initialValue() {
            return new HashMap<String,String>();
		}
	};
	
	
	
	/**
	 * 用户注册方法
	 * @author peichunting
	 *
	 * @param user 新注册的用户实体类
	 * @return 返回值为true新注册用户保存成功，如果为false表示新注册用户失败
	 */
	@Override
	public boolean register(User user) {
		
		checkUser(user);
		encreptUserPasswd(user);
		System.out.println(userMapper.insert(user));
		saveSession();
		return true;
	}
	
	
	/**
	 * 
	 * @param user 被检查的用户对象
	 */
	public void checkUser(User user){
		
	}
	
	
	/**
	 * 
	 */
	public void saveSession(){
	}

		
	/**
	 * @author peichunting
	 * @param filedName 被检查的数据库字段名   value 当前被检查的值
	 * @return ValidateResult 保存检查结果
	 */
    @Override
	public ValidateResult validateDuplicateField(String fieldName,String value)
    {
		Map<String,String> criterias=localMap.get();
		criterias.put(fieldName,value);
		Long id=userMapper.selectExists(criterias);
		criterias.clear();
		if(id!=null&&id>0)
			return new ValidateResult(false,"已注册");
		
		return new ValidateResult(true,"可以使用");
	}

    
    public boolean isExists(String name,String value){
    	
    	return false;
    }

	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		ApplicationContext ac=new ClassPathXmlApplicationContext(new String[] {"spring/applicationContext.xml"});
		IUserService userService=ac.getBean("userService",IUserService.class);
		ValidateResult rs=userService.validateDuplicateField("nickName", "ok");
		System.out.println(rs.getMessage());
	}



	@Override
	public void encreptUserPasswd(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Util.encode(user.getPassword()));
	}
	
	/**
	 * @author shensheng
	 * 根据手机号和密码登陆
	 */
	@Override
	public User selectByPhoneAndPassword(String phone, String password) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		criteria.andPasswordEqualTo(password);
		List<User> list = this.userMapper.selectByExample(example);
		if(list.size()!=0){
			User user = list.get(0);
			return user;
		}
		return null;
	}
	
	/**
	 * @author shensheng
	 * 根据邮箱找回密码
	 */
	@Override
	public User selectByEmail(String email) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> list = this.userMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}
		User user = list.get(0);
		return user;
	}
	
	/**
	 * @author shensheng
	 * 通过手机号查询用户信息（实现自动登陆）
	 */
	@Override
	public User selectByPhone(String phone) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> list = this.userMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}else{
			User user = list.get(0);
			return user;
		}
	}

	@Override
	public User getUser(long id) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		List<User> list = this.userMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}else{
			User user = list.get(0);
			return user;
		}
	}

	@Override
	public RecieveAddress getRecieveAddress(long id) {
		
		return null;
	}
	
	/**
	 * 用来修改String类型的参数
	 *  @Method_Name    : updatePassword
	 *  @param userId
	 *  @param newPassword 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月26日 下午4:23:52
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@Override
	public void updatePassword(Long userId, String newPassword) {
		
		User record = new User();
		
		record.setPassword(newPassword);
		record.setUserId(userId);
		
		this.userMapper.updateByPrimaryKeySelective(record);
		
	}
	/**
	 * @author shenzhenxing
	 * 更新用户信息
	 */
	@Override
	public int updateUser(User user) {
		return  userMapper.updateByPrimaryKeySelective(user);
	
	}

	/**
	 * 增加推荐人积分
	 * @author peichunting
	 */
	@Override
	public boolean benefitFromInviteFriend(Long id) {
		User user=getUser(id);
		user.setScore(user.getScore()+100);
		AccountRecord ar=new AccountRecord();
		ar.setScore("+100");
		ar.setUserId(id);
		accountRecordService.addAccountRecord(ar);
		return false;
	}

	
	
	@Override
	public boolean canModifyDistrict(long id) {
		User user=this.getUser(id);
		Date lastModifyTime=user.getLastModifyDistrictTime();
		Date now=new Date();
		if(lastModifyTime!=null){
			if(lastModifyTime.getMonth()==now.getMonth()&&lastModifyTime.getYear()==now.getYear())
				return false;
		}
		return true;
	}

	/**
	 * 修改手机号码
	 * author: shensheng
	 */
	@Override
	public void updatePhone(Long id, String phone) {
		User record = new User();
		
		record.setPhone(phone);
		record.setUserId(id);
		
		this.userMapper.updateByPrimaryKeySelective(record);
		
	}

	/**
	 * 修改密保邮箱
	 */
	@Override
	public void updateEmail(Long id, String email) {
		User record = new User();
		
		record.setEmail(email);
		record.setUserId(id);
		
		this.userMapper.updateByPrimaryKeySelective(record);
		
	}
	
}
