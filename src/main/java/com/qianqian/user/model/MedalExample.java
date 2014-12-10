package com.qianqian.user.model;

import java.util.ArrayList;
import java.util.List;

public class MedalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedalExample() {
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

        public Criteria andUserMedalIdIsNull() {
            addCriterion("user_medal_id is null");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdIsNotNull() {
            addCriterion("user_medal_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdEqualTo(Long value) {
            addCriterion("user_medal_id =", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdNotEqualTo(Long value) {
            addCriterion("user_medal_id <>", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdGreaterThan(Long value) {
            addCriterion("user_medal_id >", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_medal_id >=", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdLessThan(Long value) {
            addCriterion("user_medal_id <", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdLessThanOrEqualTo(Long value) {
            addCriterion("user_medal_id <=", value, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdIn(List<Long> values) {
            addCriterion("user_medal_id in", values, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdNotIn(List<Long> values) {
            addCriterion("user_medal_id not in", values, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdBetween(Long value1, Long value2) {
            addCriterion("user_medal_id between", value1, value2, "userMedalId");
            return (Criteria) this;
        }

        public Criteria andUserMedalIdNotBetween(Long value1, Long value2) {
            addCriterion("user_medal_id not between", value1, value2, "userMedalId");
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
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

        public Criteria andMedalCountEqualTo(String value) {
            addCriterion("medal_count =", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotEqualTo(String value) {
            addCriterion("medal_count <>", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountGreaterThan(String value) {
            addCriterion("medal_count >", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountGreaterThanOrEqualTo(String value) {
            addCriterion("medal_count >=", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountLessThan(String value) {
            addCriterion("medal_count <", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountLessThanOrEqualTo(String value) {
            addCriterion("medal_count <=", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountLike(String value) {
            addCriterion("medal_count like", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotLike(String value) {
            addCriterion("medal_count not like", value, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountIn(List<String> values) {
            addCriterion("medal_count in", values, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotIn(List<String> values) {
            addCriterion("medal_count not in", values, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountBetween(String value1, String value2) {
            addCriterion("medal_count between", value1, value2, "medalCount");
            return (Criteria) this;
        }

        public Criteria andMedalCountNotBetween(String value1, String value2) {
            addCriterion("medal_count not between", value1, value2, "medalCount");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andShowLevelIsNull() {
            addCriterion("show_level is null");
            return (Criteria) this;
        }

        public Criteria andShowLevelIsNotNull() {
            addCriterion("show_level is not null");
            return (Criteria) this;
        }

        public Criteria andShowLevelEqualTo(Byte value) {
            addCriterion("show_level =", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelNotEqualTo(Byte value) {
            addCriterion("show_level <>", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelGreaterThan(Byte value) {
            addCriterion("show_level >", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_level >=", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelLessThan(Byte value) {
            addCriterion("show_level <", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelLessThanOrEqualTo(Byte value) {
            addCriterion("show_level <=", value, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelIn(List<Byte> values) {
            addCriterion("show_level in", values, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelNotIn(List<Byte> values) {
            addCriterion("show_level not in", values, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelBetween(Byte value1, Byte value2) {
            addCriterion("show_level between", value1, value2, "showLevel");
            return (Criteria) this;
        }

        public Criteria andShowLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("show_level not between", value1, value2, "showLevel");
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