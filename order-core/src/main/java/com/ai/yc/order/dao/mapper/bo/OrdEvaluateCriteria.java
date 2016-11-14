package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdEvaluateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdEvaluateCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andEvaluateIdIsNull() {
            addCriterion("EVALUATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIsNotNull() {
            addCriterion("EVALUATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdEqualTo(Long value) {
            addCriterion("EVALUATE_ID =", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotEqualTo(Long value) {
            addCriterion("EVALUATE_ID <>", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThan(Long value) {
            addCriterion("EVALUATE_ID >", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EVALUATE_ID >=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThan(Long value) {
            addCriterion("EVALUATE_ID <", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThanOrEqualTo(Long value) {
            addCriterion("EVALUATE_ID <=", value, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIn(List<Long> values) {
            addCriterion("EVALUATE_ID in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotIn(List<Long> values) {
            addCriterion("EVALUATE_ID not in", values, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdBetween(Long value1, Long value2) {
            addCriterion("EVALUATE_ID between", value1, value2, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotBetween(Long value1, Long value2) {
            addCriterion("EVALUATE_ID not between", value1, value2, "evaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andServeQualityIsNull() {
            addCriterion("SERVE_QUALITY is null");
            return (Criteria) this;
        }

        public Criteria andServeQualityIsNotNull() {
            addCriterion("SERVE_QUALITY is not null");
            return (Criteria) this;
        }

        public Criteria andServeQualityEqualTo(Long value) {
            addCriterion("SERVE_QUALITY =", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityNotEqualTo(Long value) {
            addCriterion("SERVE_QUALITY <>", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityGreaterThan(Long value) {
            addCriterion("SERVE_QUALITY >", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityGreaterThanOrEqualTo(Long value) {
            addCriterion("SERVE_QUALITY >=", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityLessThan(Long value) {
            addCriterion("SERVE_QUALITY <", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityLessThanOrEqualTo(Long value) {
            addCriterion("SERVE_QUALITY <=", value, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityIn(List<Long> values) {
            addCriterion("SERVE_QUALITY in", values, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityNotIn(List<Long> values) {
            addCriterion("SERVE_QUALITY not in", values, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityBetween(Long value1, Long value2) {
            addCriterion("SERVE_QUALITY between", value1, value2, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeQualityNotBetween(Long value1, Long value2) {
            addCriterion("SERVE_QUALITY not between", value1, value2, "serveQuality");
            return (Criteria) this;
        }

        public Criteria andServeSpeenIsNull() {
            addCriterion("SERVE_SPEEN is null");
            return (Criteria) this;
        }

        public Criteria andServeSpeenIsNotNull() {
            addCriterion("SERVE_SPEEN is not null");
            return (Criteria) this;
        }

        public Criteria andServeSpeenEqualTo(Long value) {
            addCriterion("SERVE_SPEEN =", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenNotEqualTo(Long value) {
            addCriterion("SERVE_SPEEN <>", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenGreaterThan(Long value) {
            addCriterion("SERVE_SPEEN >", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenGreaterThanOrEqualTo(Long value) {
            addCriterion("SERVE_SPEEN >=", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenLessThan(Long value) {
            addCriterion("SERVE_SPEEN <", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenLessThanOrEqualTo(Long value) {
            addCriterion("SERVE_SPEEN <=", value, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenIn(List<Long> values) {
            addCriterion("SERVE_SPEEN in", values, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenNotIn(List<Long> values) {
            addCriterion("SERVE_SPEEN not in", values, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenBetween(Long value1, Long value2) {
            addCriterion("SERVE_SPEEN between", value1, value2, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeSpeenNotBetween(Long value1, Long value2) {
            addCriterion("SERVE_SPEEN not between", value1, value2, "serveSpeen");
            return (Criteria) this;
        }

        public Criteria andServeMannerIsNull() {
            addCriterion("SERVE_MANNER is null");
            return (Criteria) this;
        }

        public Criteria andServeMannerIsNotNull() {
            addCriterion("SERVE_MANNER is not null");
            return (Criteria) this;
        }

        public Criteria andServeMannerEqualTo(Long value) {
            addCriterion("SERVE_MANNER =", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerNotEqualTo(Long value) {
            addCriterion("SERVE_MANNER <>", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerGreaterThan(Long value) {
            addCriterion("SERVE_MANNER >", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerGreaterThanOrEqualTo(Long value) {
            addCriterion("SERVE_MANNER >=", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerLessThan(Long value) {
            addCriterion("SERVE_MANNER <", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerLessThanOrEqualTo(Long value) {
            addCriterion("SERVE_MANNER <=", value, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerIn(List<Long> values) {
            addCriterion("SERVE_MANNER in", values, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerNotIn(List<Long> values) {
            addCriterion("SERVE_MANNER not in", values, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerBetween(Long value1, Long value2) {
            addCriterion("SERVE_MANNER between", value1, value2, "serveManner");
            return (Criteria) this;
        }

        public Criteria andServeMannerNotBetween(Long value1, Long value2) {
            addCriterion("SERVE_MANNER not between", value1, value2, "serveManner");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentIsNull() {
            addCriterion("EVALUATE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentIsNotNull() {
            addCriterion("EVALUATE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentEqualTo(String value) {
            addCriterion("EVALUATE_CONTENT =", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentNotEqualTo(String value) {
            addCriterion("EVALUATE_CONTENT <>", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentGreaterThan(String value) {
            addCriterion("EVALUATE_CONTENT >", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_CONTENT >=", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentLessThan(String value) {
            addCriterion("EVALUATE_CONTENT <", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_CONTENT <=", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentLike(String value) {
            addCriterion("EVALUATE_CONTENT like", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentNotLike(String value) {
            addCriterion("EVALUATE_CONTENT not like", value, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentIn(List<String> values) {
            addCriterion("EVALUATE_CONTENT in", values, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentNotIn(List<String> values) {
            addCriterion("EVALUATE_CONTENT not in", values, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentBetween(String value1, String value2) {
            addCriterion("EVALUATE_CONTENT between", value1, value2, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andEvaluateContentNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_CONTENT not between", value1, value2, "evaluateContent");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNull() {
            addCriterion("EVALUATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIsNotNull() {
            addCriterion("EVALUATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeEqualTo(Timestamp value) {
            addCriterion("EVALUATE_TIME =", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotEqualTo(Timestamp value) {
            addCriterion("EVALUATE_TIME <>", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThan(Timestamp value) {
            addCriterion("EVALUATE_TIME >", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("EVALUATE_TIME >=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThan(Timestamp value) {
            addCriterion("EVALUATE_TIME <", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("EVALUATE_TIME <=", value, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeIn(List<Timestamp> values) {
            addCriterion("EVALUATE_TIME in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotIn(List<Timestamp> values) {
            addCriterion("EVALUATE_TIME not in", values, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EVALUATE_TIME between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("EVALUATE_TIME not between", value1, value2, "evaluateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunIsNull() {
            addCriterion("EVALUATE_SUN is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunIsNotNull() {
            addCriterion("EVALUATE_SUN is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunEqualTo(String value) {
            addCriterion("EVALUATE_SUN =", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunNotEqualTo(String value) {
            addCriterion("EVALUATE_SUN <>", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunGreaterThan(String value) {
            addCriterion("EVALUATE_SUN >", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATE_SUN >=", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunLessThan(String value) {
            addCriterion("EVALUATE_SUN <", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunLessThanOrEqualTo(String value) {
            addCriterion("EVALUATE_SUN <=", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunLike(String value) {
            addCriterion("EVALUATE_SUN like", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunNotLike(String value) {
            addCriterion("EVALUATE_SUN not like", value, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunIn(List<String> values) {
            addCriterion("EVALUATE_SUN in", values, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunNotIn(List<String> values) {
            addCriterion("EVALUATE_SUN not in", values, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunBetween(String value1, String value2) {
            addCriterion("EVALUATE_SUN between", value1, value2, "evaluateSun");
            return (Criteria) this;
        }

        public Criteria andEvaluateSunNotBetween(String value1, String value2) {
            addCriterion("EVALUATE_SUN not between", value1, value2, "evaluateSun");
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