package com.qianqian.user.service;

import com.qianqian.user.model.RecieveAddress;
import com.qianqian.user.model.User;
import com.qianqian.user.service.support.ValidateResult;

public interface IUserService {

	/**
	 * 注册新用户
	 *  @Method_Name    : register
	 *  @param user  新注册的用户实体对象
	 *  @return         : 是否注册成功
	 *  @Creation Date  :
	 *  @version        : 
	 *  @Author         : peichunting
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public boolean register(User user);
	
	
	/**
	 * 验证数据一致性
	 *  @Method_Name    : validateDuplicateField
	 *  @param fieldName 要验证的数据字段名
	 *  @param value     数据字段值
	 *  @return         : ValidateResult
	 *  @Creation Date  :
	 *  @version        : 
	 *  @Author         : peichunting
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public ValidateResult validateDuplicateField(String fieldName,String value);
	
	
	/**
	 * 根据ID取得用户对象
	 *  @Method_Name    : getUser
	 *  @param long 用户id
	 *  @return  User 用户对象
	 *  @Creation Date  :
	 *  @version        : 
	 *  @Author         : peichunting
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public User getUser(long id);
	
	public RecieveAddress getRecieveAddress(long id);
	
	/**
	 * 通过手机号，密码查询，验证登陆
	 *  @Method_Name    : selectByPhoneAndPassword
	 *  @param phone
	 *  @param password
	 *  @return 
	 *  @return         : User
	 *  @Creation Date  : 2014-4-28 上午11:54:46
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public User selectByPhoneAndPassword(String phone,String password);
	
	/**
	 * 加密用户密码
	 *  @Method_Name    : encreptUserPasswd
	 *  @param 
	 *  @return 
	 *  @return 
	 *  @Creation 
	 *  @version        
	 *  @Author         : peichunting
	 *  @Update Date    
	 *  @Update Author 
	 */
	public void encreptUserPasswd(User user);
	
	
	/**
	 * 通过邮箱查询用户
	 *  @Method_Name    : selectByEmail
	 *  @param email
	 *  @return 
	 *  @return         : boolean
	 *  @Creation Date  : 2014-4-28 上午11:53:55
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public User selectByEmail(String email);
	
	
	/**
	 * 通过储存在cookie中的手机号来查询出用户信息
	 *  @Method_Name    : selectByPhone
	 *  @param phone
	 *  @return 
	 *  @return         : User
	 *  @Creation Date  : 2014-4-28 上午11:53:05
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public User selectByPhone(String phone);
	
	/**
	 * 用户修改密码
	 *  @Method_Name    : updatePassword
	 *  @param id
	 *  @param newPassword 
	 *  @return         : void
	 *  @Creation Date  : 2014-4-30 上午11:58:43
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public void updatePassword(Long id, String newPassword);
	
	/**
	 *  更新用户表
	 *  @Method_Name    : updateUser
	 *  @param user
	 *  @return 
	 *  @return         : int 受影响的行数
	 *  @Creation Date  : 2014年4月29日 下午4:17:13
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public int updateUser(User user);
	
	
	/**
	 * 通过用户推荐注册，给予相应的推荐人积分等操作
	 * @param id 推荐人用户id
	 * @return 是否操作成功
	 * @Auth peichuntin
	 */
	public boolean benefitFromInviteFriend(Long id);
	
	/**
	 * 用户是否可以修改地址
	 * @param 用户id
	 * @return
	 */
	public boolean canModifyDistrict(long id);
	
	/**
	 * 修改手机
	 *  @Method_Name    : updatePhone
	 *  @param id
	 *  @param phone 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月26日 下午4:32:46
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public void updatePhone(Long id, String phone);
	
	/**
	 * 修改邮箱
	 *  @Method_Name    : updateEmail
	 *  @param id
	 *  @param Email 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月26日 下午4:33:23
	 *  @version        : v1.00
	 *  @Author         : shensheng 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public void updateEmail(Long id, String email);
	
}
