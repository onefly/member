package com.qianqian.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
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

        public Criteria andExperienceValueEqualTo(String value) {
            addCriterion("experience_value =", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotEqualTo(String value) {
            addCriterion("experience_value <>", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueGreaterThan(String value) {
            addCriterion("experience_value >", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueGreaterThanOrEqualTo(String value) {
            addCriterion("experience_value >=", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueLessThan(String value) {
            addCriterion("experience_value <", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueLessThanOrEqualTo(String value) {
            addCriterion("experience_value <=", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueLike(String value) {
            addCriterion("experience_value like", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotLike(String value) {
            addCriterion("experience_value not like", value, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueIn(List<String> values) {
            addCriterion("experience_value in", values, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotIn(List<String> values) {
            addCriterion("experience_value not in", values, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueBetween(String value1, String value2) {
            addCriterion("experience_value between", value1, value2, "experienceValue");
            return (Criteria) this;
        }

        public Criteria andExperienceValueNotBetween(String value1, String value2) {
            addCriterion("experience_value not between", value1, value2, "experienceValue");
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

        public Criteria andIngotEqualTo(String value) {
            addCriterion("ingot =", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotEqualTo(String value) {
            addCriterion("ingot <>", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotGreaterThan(String value) {
            addCriterion("ingot >", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotGreaterThanOrEqualTo(String value) {
            addCriterion("ingot >=", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotLessThan(String value) {
            addCriterion("ingot <", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotLessThanOrEqualTo(String value) {
            addCriterion("ingot <=", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotLike(String value) {
            addCriterion("ingot like", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotLike(String value) {
            addCriterion("ingot not like", value, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotIn(List<String> values) {
            addCriterion("ingot in", values, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotIn(List<String> values) {
            addCriterion("ingot not in", values, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotBetween(String value1, String value2) {
            addCriterion("ingot between", value1, value2, "ingot");
            return (Criteria) this;
        }

        public Criteria andIngotNotBetween(String value1, String value2) {
            addCriterion("ingot not between", value1, value2, "ingot");
            return (Criteria) this;
        }

        public Criteria andMedalIsNull() {
            addCriterion("medal is null");
            return (Criteria) this;
        }

        public Criteria andMedalIsNotNull() {
            addCriterion("medal is not null");
            return (Criteria) this;
        }

        public Criteria andMedalEqualTo(String value) {
            addCriterion("medal =", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalNotEqualTo(String value) {
            addCriterion("medal <>", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalGreaterThan(String value) {
            addCriterion("medal >", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalGreaterThanOrEqualTo(String value) {
            addCriterion("medal >=", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalLessThan(String value) {
            addCriterion("medal <", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalLessThanOrEqualTo(String value) {
            addCriterion("medal <=", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalLike(String value) {
            addCriterion("medal like", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalNotLike(String value) {
            addCriterion("medal not like", value, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalIn(List<String> values) {
            addCriterion("medal in", values, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalNotIn(List<String> values) {
            addCriterion("medal not in", values, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalBetween(String value1, String value2) {
            addCriterion("medal between", value1, value2, "medal");
            return (Criteria) this;
        }

        public Criteria andMedalNotBetween(String value1, String value2) {
            addCriterion("medal not between", value1, value2, "medal");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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