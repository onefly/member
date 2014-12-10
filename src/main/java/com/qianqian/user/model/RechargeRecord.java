package com.qianqian.user.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 充值记录
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.model.RechargeRecord.java
 * @ClassName	: RechargeRecord 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月15日 下午4:07:20
 */
public class RechargeRecord {
	/**
	 * 充值记录id
	 */
    private Long recordId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 充值时间
     */
    private Date rechargeTime;
    /**
     * 充值数量
     */
    private Integer rechargeCount;
    /**
     * 充值金额
     */
    private BigDecimal rechargeMoney;
    /**
     * 当前余额
     */
    private Integer currentBalance;
    /**
     * 充值项目
     */
    private String rechargeProject;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public Integer getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getRechargeProject() {
        return rechargeProject;
    }

    public void setRechargeProject(String rechargeProject) {
        this.rechargeProject = rechargeProject == null ? null : rechargeProject.trim();
    }
}