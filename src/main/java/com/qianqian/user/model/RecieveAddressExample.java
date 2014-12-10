package com.qianqian.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecieveAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecieveAddressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRecieveAddressIdIsNull() {
            addCriterion("recieve_address_id is null");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdIsNotNull() {
            addCriterion("recieve_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdEqualTo(Long value) {
            addCriterion("recieve_address_id =", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdNotEqualTo(Long value) {
            addCriterion("recieve_address_id <>", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdGreaterThan(Long value) {
            addCriterion("recieve_address_id >", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recieve_address_id >=", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdLessThan(Long value) {
            addCriterion("recieve_address_id <", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdLessThanOrEqualTo(Long value) {
            addCriterion("recieve_address_id <=", value, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdIn(List<Long> values) {
            addCriterion("recieve_address_id in", values, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdNotIn(List<Long> values) {
            addCriterion("recieve_address_id not in", values, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdBetween(Long value1, Long value2) {
            addCriterion("recieve_address_id between", value1, value2, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andRecieveAddressIdNotBetween(Long value1, Long value2) {
            addCriterion("recieve_address_id not between", value1, value2, "recieveAddressId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Byte value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Byte value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Byte value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Byte value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Byte value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Byte value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Byte> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Byte> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Byte value1, Byte value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Byte value1, Byte value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Short value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Short value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Short value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Short value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Short value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Short value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Short> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Short> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Short value1, Short value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Short value1, Short value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(Integer value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(Integer value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(Integer value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(Integer value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(Integer value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(Integer value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<Integer> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<Integer> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(Integer value1, Integer value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(Integer value1, Integer value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRecieveNameIsNull() {
            addCriterion("recieve_name is null");
            return (Criteria) this;
        }

        public Criteria andRecieveNameIsNotNull() {
            addCriterion("recieve_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecieveNameEqualTo(String value) {
            addCriterion("recieve_name =", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameNotEqualTo(String value) {
            addCriterion("recieve_name <>", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameGreaterThan(String value) {
            addCriterion("recieve_name >", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameGreaterThanOrEqualTo(String value) {
            addCriterion("recieve_name >=", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameLessThan(String value) {
            addCriterion("recieve_name <", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameLessThanOrEqualTo(String value) {
            addCriterion("recieve_name <=", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameLike(String value) {
            addCriterion("recieve_name like", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameNotLike(String value) {
            addCriterion("recieve_name not like", value, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameIn(List<String> values) {
            addCriterion("recieve_name in", values, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameNotIn(List<String> values) {
            addCriterion("recieve_name not in", values, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameBetween(String value1, String value2) {
            addCriterion("recieve_name between", value1, value2, "recieveName");
            return (Criteria) this;
        }

        public Criteria andRecieveNameNotBetween(String value1, String value2) {
            addCriterion("recieve_name not between", value1, value2, "recieveName");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(String value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLike(String value) {
            addCriterion("zip_code like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotLike(String value) {
            addCriterion("zip_code not like", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<String> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneIsNull() {
            addCriterion("recieve_mobilephone is null");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneIsNotNull() {
            addCriterion("recieve_mobilephone is not null");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneEqualTo(String value) {
            addCriterion("recieve_mobilephone =", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneNotEqualTo(String value) {
            addCriterion("recieve_mobilephone <>", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneGreaterThan(String value) {
            addCriterion("recieve_mobilephone >", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("recieve_mobilephone >=", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneLessThan(String value) {
            addCriterion("recieve_mobilephone <", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("recieve_mobilephone <=", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneLike(String value) {
            addCriterion("recieve_mobilephone like", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneNotLike(String value) {
            addCriterion("recieve_mobilephone not like", value, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneIn(List<String> values) {
            addCriterion("recieve_mobilephone in", values, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneNotIn(List<String> values) {
            addCriterion("recieve_mobilephone not in", values, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneBetween(String value1, String value2) {
            addCriterion("recieve_mobilephone between", value1, value2, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveMobilephoneNotBetween(String value1, String value2) {
            addCriterion("recieve_mobilephone not between", value1, value2, "recieveMobilephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneIsNull() {
            addCriterion("recieve_telephone is null");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneIsNotNull() {
            addCriterion("recieve_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneEqualTo(String value) {
            addCriterion("recieve_telephone =", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneNotEqualTo(String value) {
            addCriterion("recieve_telephone <>", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneGreaterThan(String value) {
            addCriterion("recieve_telephone >", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("recieve_telephone >=", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneLessThan(String value) {
            addCriterion("recieve_telephone <", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneLessThanOrEqualTo(String value) {
            addCriterion("recieve_telephone <=", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneLike(String value) {
            addCriterion("recieve_telephone like", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneNotLike(String value) {
            addCriterion("recieve_telephone not like", value, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneIn(List<String> values) {
            addCriterion("recieve_telephone in", values, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneNotIn(List<String> values) {
            addCriterion("recieve_telephone not in", values, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneBetween(String value1, String value2) {
            addCriterion("recieve_telephone between", value1, value2, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andRecieveTelephoneNotBetween(String value1, String value2) {
            addCriterion("recieve_telephone not between", value1, value2, "recieveTelephone");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressIsNull() {
            addCriterion("is_default_address is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressIsNotNull() {
            addCriterion("is_default_address is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressEqualTo(Byte value) {
            addCriterion("is_default_address =", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressNotEqualTo(Byte value) {
            addCriterion("is_default_address <>", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressGreaterThan(Byte value) {
            addCriterion("is_default_address >", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_default_address >=", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressLessThan(Byte value) {
            addCriterion("is_default_address <", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressLessThanOrEqualTo(Byte value) {
            addCriterion("is_default_address <=", value, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressIn(List<Byte> values) {
            addCriterion("is_default_address in", values, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressNotIn(List<Byte> values) {
            addCriterion("is_default_address not in", values, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressBetween(Byte value1, Byte value2) {
            addCriterion("is_default_address between", value1, value2, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andIsDefaultAddressNotBetween(Byte value1, Byte value2) {
            addCriterion("is_default_address not between", value1, value2, "isDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Byte value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Byte value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Byte value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Byte value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Byte value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Byte> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Byte> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("province_name is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("province_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("province_name =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("province_name <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("province_name >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_name >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("province_name <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_name <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("province_name like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("province_name not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("province_name in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("province_name not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNull() {
            addCriterion("district_name is null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNotNull() {
            addCriterion("district_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameEqualTo(String value) {
            addCriterion("district_name =", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotEqualTo(String value) {
            addCriterion("district_name <>", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThan(String value) {
            addCriterion("district_name >", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("district_name >=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThan(String value) {
            addCriterion("district_name <", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("district_name <=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLike(String value) {
            addCriterion("district_name like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotLike(String value) {
            addCriterion("district_name not like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIn(List<String> values) {
            addCriterion("district_name in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotIn(List<String> values) {
            addCriterion("district_name not in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameBetween(String value1, String value2) {
            addCriterion("district_name between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotBetween(String value1, String value2) {
            addCriterion("district_name not between", value1, value2, "districtName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}