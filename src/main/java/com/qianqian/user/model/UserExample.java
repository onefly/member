package com.qianqian.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Short value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Short value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Short value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Short value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Short value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Short value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Short> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Short> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Short value1, Short value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Short value1, Short value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNull() {
            addCriterion("identification is null");
            return (Criteria) this;
        }

        public Criteria andIdentificationIsNotNull() {
            addCriterion("identification is not null");
            return (Criteria) this;
        }

        public Criteria andIdentificationEqualTo(String value) {
            addCriterion("identification =", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotEqualTo(String value) {
            addCriterion("identification <>", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThan(String value) {
            addCriterion("identification >", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("identification >=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThan(String value) {
            addCriterion("identification <", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLessThanOrEqualTo(String value) {
            addCriterion("identification <=", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationLike(String value) {
            addCriterion("identification like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotLike(String value) {
            addCriterion("identification not like", value, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationIn(List<String> values) {
            addCriterion("identification in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotIn(List<String> values) {
            addCriterion("identification not in", values, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationBetween(String value1, String value2) {
            addCriterion("identification between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andIdentificationNotBetween(String value1, String value2) {
            addCriterion("identification not between", value1, value2, "identification");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageIsNull() {
            addCriterion("small_head_image is null");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageIsNotNull() {
            addCriterion("small_head_image is not null");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageEqualTo(String value) {
            addCriterion("small_head_image =", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageNotEqualTo(String value) {
            addCriterion("small_head_image <>", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageGreaterThan(String value) {
            addCriterion("small_head_image >", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageGreaterThanOrEqualTo(String value) {
            addCriterion("small_head_image >=", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageLessThan(String value) {
            addCriterion("small_head_image <", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageLessThanOrEqualTo(String value) {
            addCriterion("small_head_image <=", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageLike(String value) {
            addCriterion("small_head_image like", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageNotLike(String value) {
            addCriterion("small_head_image not like", value, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageIn(List<String> values) {
            addCriterion("small_head_image in", values, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageNotIn(List<String> values) {
            addCriterion("small_head_image not in", values, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageBetween(String value1, String value2) {
            addCriterion("small_head_image between", value1, value2, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andSmallHeadImageNotBetween(String value1, String value2) {
            addCriterion("small_head_image not between", value1, value2, "smallHeadImage");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Byte value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Byte value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Byte value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Byte value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Byte value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Byte> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Byte> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Byte value1, Byte value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Byte value1, Byte value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andExperienceValueIsNull() {
            addCriterion("experience_value is null");
            return (Criteria) this;
        }

        public Criteria andExperienceValueIsNotNull() {
            addCriterion("experience_value is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceValueEqualTo(Long value) {
            addCriterion("experience_value =", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotEqualTo(Long value) {
            addCriterion("experience_value <>", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueGreaterThan(Long value) {
            addCriterion("experience_value >", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueGreaterThanOrEqualTo(Long value) {
            addCriterion("experience_value >=", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueLessThan(Long value) {
            addCriterion("experience_value <", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueLessThanOrEqualTo(Long value) {
            addCriterion("experience_value <=", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueIn(List<Long> values) {
            addCriterion("experience_value in", values, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotIn(List<Long> values) {
            addCriterion("experience_value not in", values, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueBetween(Long value1, Long value2) {
            addCriterion("experience_value between", value1, value2, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotBetween(Long value1, Long value2) {
            addCriterion("experience_value not between", value1, value2, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Long value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Long value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Long value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Long value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Long value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Long> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Long> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Long value1, Long value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Long value1, Long value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andMedalCountIsNull() {
            addCriterion("medal_count is null");
            return (Criteria) this;
        }

        public Criteria andMedalCountIsNotNull() {
            addCriterion("medal_count is not null");
            return (Criteria) this;
        }

        public Criteria andMedalCountEqualTo(Long value) {
            addCriterion("medal_count =", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotEqualTo(Long value) {
            addCriterion("medal_count <>", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountGreaterThan(Long value) {
            addCriterion("medal_count >", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountGreaterThanOrEqualTo(Long value) {
            addCriterion("medal_count >=", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountLessThan(Long value) {
            addCriterion("medal_count <", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountLessThanOrEqualTo(Long value) {
            addCriterion("medal_count <=", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountIn(List<Long> values) {
            addCriterion("medal_count in", values, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotIn(List<Long> values) {
            addCriterion("medal_count not in", values, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountBetween(Long value1, Long value2) {
            addCriterion("medal_count between", value1, value2, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotBetween(Long value1, Long value2) {
            addCriterion("medal_count not between", value1, value2, "medalCount");
            return (Criteria) this;
        }

        public Criteria andIngotIsNull() {
            addCriterion("ingot is null");
            return (Criteria) this;
        }

        public Criteria andIngotIsNotNull() {
            addCriterion("ingot is not null");
            return (Criteria) this;
        }

        public Criteria andIngotEqualTo(Long value) {
            addCriterion("ingot =", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotEqualTo(Long value) {
            addCriterion("ingot <>", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotGreaterThan(Long value) {
            addCriterion("ingot >", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotGreaterThanOrEqualTo(Long value) {
            addCriterion("ingot >=", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotLessThan(Long value) {
            addCriterion("ingot <", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotLessThanOrEqualTo(Long value) {
            addCriterion("ingot <=", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotIn(List<Long> values) {
            addCriterion("ingot in", values, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotIn(List<Long> values) {
            addCriterion("ingot not in", values, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotBetween(Long value1, Long value2) {
            addCriterion("ingot between", value1, value2, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotBetween(Long value1, Long value2) {
            addCriterion("ingot not between", value1, value2, "ingot");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthIsNull() {
            addCriterion("passwd_strength is null");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthIsNotNull() {
            addCriterion("passwd_strength is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthEqualTo(Byte value) {
            addCriterion("passwd_strength =", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthNotEqualTo(Byte value) {
            addCriterion("passwd_strength <>", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthGreaterThan(Byte value) {
            addCriterion("passwd_strength >", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthGreaterThanOrEqualTo(Byte value) {
            addCriterion("passwd_strength >=", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthLessThan(Byte value) {
            addCriterion("passwd_strength <", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthLessThanOrEqualTo(Byte value) {
            addCriterion("passwd_strength <=", value, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthIn(List<Byte> values) {
            addCriterion("passwd_strength in", values, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthNotIn(List<Byte> values) {
            addCriterion("passwd_strength not in", values, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthBetween(Byte value1, Byte value2) {
            addCriterion("passwd_strength between", value1, value2, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andPasswdStrengthNotBetween(Byte value1, Byte value2) {
            addCriterion("passwd_strength not between", value1, value2, "passwdStrength");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIsNull() {
            addCriterion("last_modified_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIsNotNull() {
            addCriterion("last_modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeEqualTo(Date value) {
            addCriterion("last_modified_time =", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotEqualTo(Date value) {
            addCriterion("last_modified_time <>", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeGreaterThan(Date value) {
            addCriterion("last_modified_time >", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modified_time >=", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeLessThan(Date value) {
            addCriterion("last_modified_time <", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modified_time <=", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIn(List<Date> values) {
            addCriterion("last_modified_time in", values, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotIn(List<Date> values) {
            addCriterion("last_modified_time not in", values, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("last_modified_time between", value1, value2, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modified_time not between", value1, value2, "lastModifiedTime");
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

        public Criteria andEnableEmailSubscriptionIsNull() {
            addCriterion("enable_email_subscription is null");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionIsNotNull() {
            addCriterion("enable_email_subscription is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionEqualTo(Byte value) {
            addCriterion("enable_email_subscription =", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionNotEqualTo(Byte value) {
            addCriterion("enable_email_subscription <>", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionGreaterThan(Byte value) {
            addCriterion("enable_email_subscription >", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionGreaterThanOrEqualTo(Byte value) {
            addCriterion("enable_email_subscription >=", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionLessThan(Byte value) {
            addCriterion("enable_email_subscription <", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionLessThanOrEqualTo(Byte value) {
            addCriterion("enable_email_subscription <=", value, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionIn(List<Byte> values) {
            addCriterion("enable_email_subscription in", values, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionNotIn(List<Byte> values) {
            addCriterion("enable_email_subscription not in", values, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionBetween(Byte value1, Byte value2) {
            addCriterion("enable_email_subscription between", value1, value2, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnableEmailSubscriptionNotBetween(Byte value1, Byte value2) {
            addCriterion("enable_email_subscription not between", value1, value2, "enableEmailSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionIsNull() {
            addCriterion("enable_phone_subscription is null");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionIsNotNull() {
            addCriterion("enable_phone_subscription is not null");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionEqualTo(Byte value) {
            addCriterion("enable_phone_subscription =", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionNotEqualTo(Byte value) {
            addCriterion("enable_phone_subscription <>", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionGreaterThan(Byte value) {
            addCriterion("enable_phone_subscription >", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionGreaterThanOrEqualTo(Byte value) {
            addCriterion("enable_phone_subscription >=", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionLessThan(Byte value) {
            addCriterion("enable_phone_subscription <", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionLessThanOrEqualTo(Byte value) {
            addCriterion("enable_phone_subscription <=", value, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionIn(List<Byte> values) {
            addCriterion("enable_phone_subscription in", values, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionNotIn(List<Byte> values) {
            addCriterion("enable_phone_subscription not in", values, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionBetween(Byte value1, Byte value2) {
            addCriterion("enable_phone_subscription between", value1, value2, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andEnablePhoneSubscriptionNotBetween(Byte value1, Byte value2) {
            addCriterion("enable_phone_subscription not between", value1, value2, "enablePhoneSubscription");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlIsNull() {
            addCriterion("middle_head_url is null");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlIsNotNull() {
            addCriterion("middle_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlEqualTo(String value) {
            addCriterion("middle_head_url =", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlNotEqualTo(String value) {
            addCriterion("middle_head_url <>", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlGreaterThan(String value) {
            addCriterion("middle_head_url >", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("middle_head_url >=", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlLessThan(String value) {
            addCriterion("middle_head_url <", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("middle_head_url <=", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlLike(String value) {
            addCriterion("middle_head_url like", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlNotLike(String value) {
            addCriterion("middle_head_url not like", value, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlIn(List<String> values) {
            addCriterion("middle_head_url in", values, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlNotIn(List<String> values) {
            addCriterion("middle_head_url not in", values, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlBetween(String value1, String value2) {
            addCriterion("middle_head_url between", value1, value2, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andMiddleHeadUrlNotBetween(String value1, String value2) {
            addCriterion("middle_head_url not between", value1, value2, "middleHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlIsNull() {
            addCriterion("big_head_url is null");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlIsNotNull() {
            addCriterion("big_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlEqualTo(String value) {
            addCriterion("big_head_url =", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlNotEqualTo(String value) {
            addCriterion("big_head_url <>", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlGreaterThan(String value) {
            addCriterion("big_head_url >", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("big_head_url >=", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlLessThan(String value) {
            addCriterion("big_head_url <", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("big_head_url <=", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlLike(String value) {
            addCriterion("big_head_url like", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlNotLike(String value) {
            addCriterion("big_head_url not like", value, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlIn(List<String> values) {
            addCriterion("big_head_url in", values, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlNotIn(List<String> values) {
            addCriterion("big_head_url not in", values, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlBetween(String value1, String value2) {
            addCriterion("big_head_url between", value1, value2, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andBigHeadUrlNotBetween(String value1, String value2) {
            addCriterion("big_head_url not between", value1, value2, "bigHeadUrl");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNull() {
            addCriterion("weixin is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNotNull() {
            addCriterion("weixin is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEqualTo(String value) {
            addCriterion("weixin =", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("weixin <>", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("weixin >", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("weixin >=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThan(String value) {
            addCriterion("weixin <", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("weixin <=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLike(String value) {
            addCriterion("weixin like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotLike(String value) {
            addCriterion("weixin not like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinIn(List<String> values) {
            addCriterion("weixin in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("weixin not in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("weixin not between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Byte value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Byte value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Byte value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Byte value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Byte value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Byte value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Byte> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Byte> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Byte value1, Byte value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Byte value1, Byte value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNull() {
            addCriterion("brithday is null");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNotNull() {
            addCriterion("brithday is not null");
            return (Criteria) this;
        }

        public Criteria andBrithdayEqualTo(Date value) {
            addCriterionForJDBCDate("brithday =", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("brithday <>", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThan(Date value) {
            addCriterionForJDBCDate("brithday >", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("brithday >=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThan(Date value) {
            addCriterionForJDBCDate("brithday <", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("brithday <=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayIn(List<Date> values) {
            addCriterionForJDBCDate("brithday in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("brithday not in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("brithday between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("brithday not between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(Integer value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(Integer value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(Integer value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(Integer value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(Integer value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(Integer value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<Integer> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<Integer> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(Integer value1, Integer value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(Integer value1, Integer value2) {
            addCriterion("profession not between", value1, value2, "profession");
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

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeIsNull() {
            addCriterion("last_modify_district_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeIsNotNull() {
            addCriterion("last_modify_district_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeEqualTo(Date value) {
            addCriterionForJDBCDate("last_modify_district_time =", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_modify_district_time <>", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("last_modify_district_time >", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_modify_district_time >=", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeLessThan(Date value) {
            addCriterionForJDBCDate("last_modify_district_time <", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_modify_district_time <=", value, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeIn(List<Date> values) {
            addCriterionForJDBCDate("last_modify_district_time in", values, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_modify_district_time not in", values, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_modify_district_time between", value1, value2, "lastModifyDistrictTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyDistrictTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_modify_district_time not between", value1, value2, "lastModifyDistrictTime");
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

        public Criteria andInviteCountIsNull() {
            addCriterion("invite_count is null");
            return (Criteria) this;
        }

        public Criteria andInviteCountIsNotNull() {
            addCriterion("invite_count is not null");
            return (Criteria) this;
        }

        public Criteria andInviteCountEqualTo(Integer value) {
            addCriterion("invite_count =", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountNotEqualTo(Integer value) {
            addCriterion("invite_count <>", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountGreaterThan(Integer value) {
            addCriterion("invite_count >", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_count >=", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountLessThan(Integer value) {
            addCriterion("invite_count <", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountLessThanOrEqualTo(Integer value) {
            addCriterion("invite_count <=", value, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountIn(List<Integer> values) {
            addCriterion("invite_count in", values, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountNotIn(List<Integer> values) {
            addCriterion("invite_count not in", values, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountBetween(Integer value1, Integer value2) {
            addCriterion("invite_count between", value1, value2, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andInviteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_count not between", value1, value2, "inviteCount");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(Date value) {
            addCriterion("expired_time =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(Date value) {
            addCriterion("expired_time <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(Date value) {
            addCriterion("expired_time >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expired_time >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(Date value) {
            addCriterion("expired_time <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("expired_time <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<Date> values) {
            addCriterion("expired_time in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<Date> values) {
            addCriterion("expired_time not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("expired_time between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("expired_time not between", value1, value2, "expiredTime");
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

        public Criteria andProfessionNameIsNull() {
            addCriterion("profession_name is null");
            return (Criteria) this;
        }

        public Criteria andProfessionNameIsNotNull() {
            addCriterion("profession_name is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionNameEqualTo(String value) {
            addCriterion("profession_name =", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameNotEqualTo(String value) {
            addCriterion("profession_name <>", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameGreaterThan(String value) {
            addCriterion("profession_name >", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameGreaterThanOrEqualTo(String value) {
            addCriterion("profession_name >=", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameLessThan(String value) {
            addCriterion("profession_name <", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameLessThanOrEqualTo(String value) {
            addCriterion("profession_name <=", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameLike(String value) {
            addCriterion("profession_name like", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameNotLike(String value) {
            addCriterion("profession_name not like", value, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameIn(List<String> values) {
            addCriterion("profession_name in", values, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameNotIn(List<String> values) {
            addCriterion("profession_name not in", values, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameBetween(String value1, String value2) {
            addCriterion("profession_name between", value1, value2, "professionName");
            return (Criteria) this;
        }

        public Criteria andProfessionNameNotBetween(String value1, String value2) {
            addCriterion("profession_name not between", value1, value2, "professionName");
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