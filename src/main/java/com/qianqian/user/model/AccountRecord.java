package com.qianqian.user.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 账户记录
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.user.model.AccountRecord.java
 * @ClassName	: AccountRecord 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年4月15日 下午4:09:03
 */
public class AccountRecord implements Serializable{
	
	private static final long serialVersionUID = -5941024405859177615L;
	/**
	 * 账户记录id
	 */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 积分 变化（"+100","-10"）
     */
    private String score;
    /**
     * 体验值变化
     */
    private String experienceValue;
    /**
     * 体验宝变化
     */
    private String ingot;
    /**
     * 大牌胸章变化
     */
    private String medal;
	/**
	 * 记录时间
	 */
    private Date recordTime;
    /**
     * 来源
     */
    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(String experienceValue) {
        this.experienceValue = experienceValue == null ? null : experienceValue.trim();
    }

    public String getIngot() {
        return ingot;
    }

    public void setIngot(String ingot) {
        this.ingot = ingot == null ? null : ingot.trim();
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal == null ? null : medal.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

	@Override
	public String toString() {
		return "AccountRecord [id=" + id + ", userId=" + userId + ", score="
				+ score + ", experienceValue=" + experienceValue + ", ingot="
				+ ingot + ", medal=" + medal + ", recordTime=" + recordTime
				+ ", source=" + source + "]";
	}
    
}