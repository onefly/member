package com.qianqian.common.aop;

import java.io.Serializable;

/**
 * 保存账户变化的配置情况，以及用户已经使用限额
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.common.aop.AccountChange.java
 * @ClassName : AccountChange
 * @Author : caozhifei
 * @CreateDate : 2014年4月24日 下午1:38:14
 */
public class AccountChange implements Serializable {
	/**
	 * @Fields serialVersionUID :
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = -3797214378964728351L;
	/**
	 * 基本配置信息开始
	 */
	private String action;// 用户动作
	private long score;// 账户积分变化
	private long experience;// 账户体验值变化
	private long ingot;// 账户体验宝变化
	private long medal;// 账户大牌勋章变化
	private long socreDayLimit;// 账户积分变化每日上限
	private long socreMonthLimit;// 账户积分变化每月上限
	private long experienceDayLimit;// 体验值每日增加上限
	private long experienceMonthLimit;// 体验值每月增加上限
	private long ingotDayLimit;// 体验宝每日增加上限
	private long ingotMonthLimit;// 体验宝每月增加上限
	private long medalDayLimit;// 勋章每日增加上限
	private long medalMonthLimit;// 勋章每月增加上限
	/**
	 * 基本配置信息结束
	 */

	/**
	 * 已经使用的限额
	 */
	private long scoreDayUsed;// 积分日限额已经使用限额
	private long scoreMonthUsed;// 积分月限额已经使用限额
	private long experienceDayUsed;// 体验值每日增加上限已经使用限额
	private long experienceMonthUsed;// 体验值每月增加上限已经使用限额
	private long ingotDayUsed;// 体验宝每日增加上限已使用限额
	private long ingotMonthUsed;// 体验宝每月增加上限已使用限额
	private long medalDayUsed;// 勋章每日增加上限已经使用限额
	private long medalMonthUsed;// 勋章每月增加上限已经使用限额

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getExperience() {
		return experience;
	}

	public void setExperience(long experience) {
		this.experience = experience;
	}

	public long getIngot() {
		return ingot;
	}

	public void setIngot(long ingot) {
		this.ingot = ingot;
	}

	public long getMedal() {
		return medal;
	}

	public void setMedal(long medal) {
		this.medal = medal;
	}

	public long getSocreDayLimit() {
		return socreDayLimit;
	}

	public void setSocreDayLimit(long socreDayLimit) {
		this.socreDayLimit = socreDayLimit;
	}

	public long getSocreMonthLimit() {
		return socreMonthLimit;
	}

	public void setSocreMonthLimit(long socreMonthLimit) {
		this.socreMonthLimit = socreMonthLimit;
	}

	public long getExperienceDayLimit() {
		return experienceDayLimit;
	}

	public void setExperienceDayLimit(long experienceDayLimit) {
		this.experienceDayLimit = experienceDayLimit;
	}

	public long getExperienceMonthLimit() {
		return experienceMonthLimit;
	}

	public void setExperienceMonthLimit(long experienceMonthLimit) {
		this.experienceMonthLimit = experienceMonthLimit;
	}

	public long getIngotDayLimit() {
		return ingotDayLimit;
	}

	public void setIngotDayLimit(long ingotDayLimit) {
		this.ingotDayLimit = ingotDayLimit;
	}

	public long getIngotMonthLimit() {
		return ingotMonthLimit;
	}

	public void setIngotMonthLimit(long ingotMonthLimit) {
		this.ingotMonthLimit = ingotMonthLimit;
	}

	public long getMedalDayLimit() {
		return medalDayLimit;
	}

	public void setMedalDayLimit(long medalDayLimit) {
		this.medalDayLimit = medalDayLimit;
	}

	public long getMedalMonthLimit() {
		return medalMonthLimit;
	}

	public void setMedalMonthLimit(long medalMonthLimit) {
		this.medalMonthLimit = medalMonthLimit;
	}

	public long getScoreDayUsed() {
		return scoreDayUsed;
	}

	public void setScoreDayUsed(long scoreDayUsed) {
		this.scoreDayUsed = scoreDayUsed;
	}

	public long getScoreMonthUsed() {
		return scoreMonthUsed;
	}

	public void setScoreMonthUsed(long scoreMonthUsed) {
		this.scoreMonthUsed = scoreMonthUsed;
	}

	public long getExperienceDayUsed() {
		return experienceDayUsed;
	}

	public void setExperienceDayUsed(long experienceDayUsed) {
		this.experienceDayUsed = experienceDayUsed;
	}

	public long getExperienceMonthUsed() {
		return experienceMonthUsed;
	}

	public void setExperienceMonthUsed(long experienceMonthUsed) {
		this.experienceMonthUsed = experienceMonthUsed;
	}

	public long getIngotDayUsed() {
		return ingotDayUsed;
	}

	public void setIngotDayUsed(long ingotDayUsed) {
		this.ingotDayUsed = ingotDayUsed;
	}

	public long getIngotMonthUsed() {
		return ingotMonthUsed;
	}

	public void setIngotMonthUsed(long ingotMonthUsed) {
		this.ingotMonthUsed = ingotMonthUsed;
	}

	public long getMedalDayUsed() {
		return medalDayUsed;
	}

	public void setMedalDayUsed(long medalDayUsed) {
		this.medalDayUsed = medalDayUsed;
	}

	public long getMedalMonthUsed() {
		return medalMonthUsed;
	}

	public void setMedalMonthUsed(long medalMonthUsed) {
		this.medalMonthUsed = medalMonthUsed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountChange [action=" + action + ", score=" + score
				+ ", experience=" + experience + ", ingot=" + ingot
				+ ", medal=" + medal + ", socreDayLimit=" + socreDayLimit
				+ ", socreMonthLimit=" + socreMonthLimit
				+ ", experienceDayLimit=" + experienceDayLimit
				+ ", experienceMonthLimit=" + experienceMonthLimit
				+ ", ingotDayLimit=" + ingotDayLimit + ", ingotMonthLimit="
				+ ingotMonthLimit + ", medalDayLimit=" + medalDayLimit
				+ ", medalMonthLimit=" + medalMonthLimit + ", scoreDayUsed="
				+ scoreDayUsed + ", scoreMonthUsed=" + scoreMonthUsed
				+ ", experienceDayUsed=" + experienceDayUsed
				+ ", experienceMonthUsed=" + experienceMonthUsed
				+ ", ingotDayUsed=" + ingotDayUsed + ", ingotMonthUsed="
				+ ingotMonthUsed + ", medalDayUsed=" + medalDayUsed
				+ ", medalMonthUsed=" + medalMonthUsed + "]";
	}

	
}
