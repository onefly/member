package com.qianqian.user.service.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidate {
	
	public static final ValidateResult validatePhone(String phoneNumber)
	{
		
		return null;
	}
	
	public static final ValidateResult  validateNickName(String nickName){
		return null;
	}
	
	public static final ValidateResult  validateEmail(String email){
		return null;
	}
	
	public static final boolean isEmail(String email)
	{
		Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);  
        return m.matches();  
	}
	
	public static final ValidateResult  validateIndetification(String identification){
		return null;
	}
	
	public static final ValidateResult validateName(String name){
		return null;
	}
	

	

}
