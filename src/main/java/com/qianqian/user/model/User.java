package com.qianqian.user.model;

import java.util.Date;

public class User {
    private long userId;

    private int level;

    private int role;

    private String email;

    private String phone;

    private String name;

    private String nickname;

    private String identification;

    private String password;

    private int gender;

    private String smallHeadImage;

    private int status;

    private int active;

    private long experienceValue;

    private long score;

    private long medalCount;

    private long ingot;

    private Date lastLoginTime;
    
    private String lastLoginTimStr;

    public String getLastLoginTimStr() {
		return lastLoginTimStr;
	}

	public void setLastLoginTimStr(String lastLoginTimStr) {
		this.lastLoginTimStr = lastLoginTimStr;
	}

	private int passwdStrength;

    private Date lastModifiedTime;

    private Date createTime;

    private int enableEmailSubscription;

    private int enablePhoneSubscription;

    private String middleHeadUrl;

    private String bigHeadUrl;

    private String qq;

    private String weixin;

    private int education;

    private Date brithday;

    private int profession;

    private int province;

    private int city;

    private int district;

    private String interest;

    private Date lastModifyDistrictTime;

    private String address;

    private int inviteCount;

    private Date expiredTime;

    private String provinceName;

    private String cityName;

    private String districtName;

    private String professionName;
    
    private String brithdayStr;
    
    private String lastLoginTimeStr;
    
    private int canModifyRegion;
    
    public int getCanModifyRegion() {
		return canModifyRegion;
	}

	public void setCanModifyRegion(int canModifyRegion) {
		this.canModifyRegion = canModifyRegion;
	}

	public String getLastLoginTimeStr() {
		return lastLoginTimeStr;
	}

	public void setLastLoginTimeStr(String lastLoginTimeStr) {
		this.lastLoginTimeStr = lastLoginTimeStr;
	}

	public String getBrithdayStr(){
    	return brithdayStr;
    }
    
    public void setBrithdayStr(String brithdayStr){
    	this.brithdayStr=brithdayStr;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSmallHeadImage() {
        return smallHeadImage;
    }

    public void setSmallHeadImage(String smallHeadImage) {
        this.smallHeadImage = smallHeadImage == null ? null : smallHeadImage.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public long getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(long experienceValue) {
        this.experienceValue = experienceValue;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getMedalCount() {
        return medalCount;
    }

    public void setMedalCount(long medalCount) {
        this.medalCount = medalCount;
    }

    public long getIngot() {
        return ingot;
    }

    public void setIngot(long ingot) {
        this.ingot = ingot;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getPasswdStrength() {
        return passwdStrength;
    }

    public void setPasswdStrength(int passwdStrength) {
        this.passwdStrength = passwdStrength;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getEnableEmailSubscription() {
        return enableEmailSubscription;
    }

    public void setEnableEmailSubscription(int enableEmailSubscription) {
        this.enableEmailSubscription = enableEmailSubscription;
    }

    public int getEnablePhoneSubscription() {
        return enablePhoneSubscription;
    }

    public void setEnablePhoneSubscription(int enablePhoneSubscription) {
        this.enablePhoneSubscription = enablePhoneSubscription;
    }

    public String getMiddleHeadUrl() {
        return middleHeadUrl;
    }

    public void setMiddleHeadUrl(String middleHeadUrl) {
        this.middleHeadUrl = middleHeadUrl == null ? null : middleHeadUrl.trim();
    }

    public String getBigHeadUrl() {
        return bigHeadUrl;
    }

    public void setBigHeadUrl(String bigHeadUrl) {
        this.bigHeadUrl = bigHeadUrl == null ? null : bigHeadUrl.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public Date getLastModifyDistrictTime() {
        return lastModifyDistrictTime;
    }

    public void setLastModifyDistrictTime(Date lastModifyDistrictTime) {
        this.lastModifyDistrictTime = lastModifyDistrictTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public int getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(int inviteCount) {
        this.inviteCount = inviteCount;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName == null ? null : professionName.trim();
    }
}