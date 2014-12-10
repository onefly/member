package com.qianqian.common.utils;

import java.util.Properties;
import com.framelib.utils.ConfigUtils;


/**
 * 系统常量类
 * Title:Constants
 * Description:
 * @Create_by:Zhangy Yan
 * @Create_date:2014-04-04
 * @Last_Edit_By:
 * @Edit_Description
 * @version: 1.0
 *
 */
public class Constants {
	
	//redis-key属性文件
	protected final static Properties REDIS_KEY_PROPS = ConfigUtils.getPropertiesFile("conf/redis-key.properties");
	
	//des秘钥属性文件
	protected final static Properties DES_KEY_PROPS = ConfigUtils.getPropertiesFile("conf/deskey.properties");
		
	
    //redis list test key name
    public static final String REIDS_LIST_TEST_KEY = (String) REDIS_KEY_PROPS.get("reids.list.test.key");
    
    //des加密秘钥，用于修改密码
    public static final String DESKEY_UPDPWD_KEY = (String) DES_KEY_PROPS.get("deskey.updpwd.key");
}

