package com.qianqian.user.model;

import java.util.Date;

public class RecieveAddress {
    /** 主键*/
    private Long recieveAddressId;

    private Long userId;

    private Byte province;

    private Short city;

    /** 区*/
    private Integer district;

    /** 地址*/
    private String address;

    /** 收件人姓名*/
    private String recieveName;

    /** 邮编*/
    private String zipCode;

    /** 手机*/
    private String recieveMobilephone;

    /** 固定电话*/
    private String recieveTelephone;

    /** 是否默认地址 1是，0否 默认0*/
    private Byte isDefaultAddress;

    /** 是否删除 1是，0否，默认0*/
    private Byte deleteFlag;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date modifyTime;

    private String provinceName;

    private String cityName;

    /** 区名称*/
    private String districtName;
    
    public Long getRecieveAddressId() {
        return recieveAddressId;
    }

    public void setRecieveAddressId(Long recieveAddressId) {
        this.recieveAddressId = recieveAddressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getProvince() {
        return province;
    }

    public void setProvince(Byte province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRecieveName() {
        return recieveName;
    }

    public void setRecieveName(String recieveName) {
        this.recieveName = recieveName == null ? null : recieveName.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getRecieveMobilephone() {
        return recieveMobilephone;
    }

    public void setRecieveMobilephone(String recieveMobilephone) {
        this.recieveMobilephone = recieveMobilephone == null ? null : recieveMobilephone.trim();
    }

    public String getRecieveTelephone() {
        return recieveTelephone;
    }

    public void setRecieveTelephone(String recieveTelephone) {
        this.recieveTelephone = recieveTelephone == null ? null : recieveTelephone.trim();
    }

    public Byte getIsDefaultAddress() {
        return isDefaultAddress;
    }

    public void setIsDefaultAddress(Byte isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
}