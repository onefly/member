package com.qianqian.user.service.support;


/**
 * 
 * @author peichunting
 * 验证结果类，用来保存验证是否成功，及验证结果消息
 *
 */
public class ValidateResult {
	
	private String message;
	private boolean success;
	
	public ValidateResult(boolean success,String message)
	{
		this.message=message;
		this.success=success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
