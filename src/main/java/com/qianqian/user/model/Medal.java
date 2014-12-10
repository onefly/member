package com.qianqian.user.model;

public class Medal {
    private Long userMedalId;

    private Long userId;

    private Long brandId;

    private String medalCount;

    private String brandName;

    private String logoUrl;

    private Byte showLevel;

    public Long getUserMedalId() {
        return userMedalId;
    }

    public void setUserMedalId(Long userMedalId) {
        this.userMedalId = userMedalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getMedalCount() {
        return medalCount;
    }

    public void setMedalCount(String medalCount) {
        this.medalCount = medalCount == null ? null : medalCount.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public Byte getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(Byte showLevel) {
        this.showLevel = showLevel;
    }
}