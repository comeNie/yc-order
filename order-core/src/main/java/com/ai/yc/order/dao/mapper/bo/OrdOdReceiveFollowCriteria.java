package com.ai.yc.order.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class OrdOdReceiveFollowCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdReceiveFollowCriteria() {
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

        public Criteria andReceiveFollowIdIsNull() {
            addCriterion("RECEIVE_FOLLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdIsNotNull() {
            addCriterion("RECEIVE_FOLLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdEqualTo(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID =", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdNotEqualTo(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID <>", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdGreaterThan(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID >", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID >=", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdLessThan(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID <", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdLessThanOrEqualTo(Long value) {
            addCriterion("RECEIVE_FOLLOW_ID <=", value, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdIn(List<Long> values) {
            addCriterion("RECEIVE_FOLLOW_ID in", values, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdNotIn(List<Long> values) {
            addCriterion("RECEIVE_FOLLOW_ID not in", values, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdBetween(Long value1, Long value2) {
            addCriterion("RECEIVE_FOLLOW_ID between", value1, value2, "receiveFollowId");
            return (Criteria) this;
        }

        public Criteria andReceiveFollowIdNotBetween(Long value1, Long value2) {
            addCriterion("RECEIVE_FOLLOW_ID not between", value1, value2, "receiveFollowId");
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

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("STEP is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("STEP is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("STEP =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("STEP <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("STEP >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("STEP >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("STEP <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("STEP <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("STEP like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("STEP not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("STEP in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("STEP not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("STEP between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("STEP not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andReceiveStateIsNull() {
            addCriterion("RECEIVE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveStateIsNotNull() {
            addCriterion("RECEIVE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveStateEqualTo(String value) {
            addCriterion("RECEIVE_STATE =", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateNotEqualTo(String value) {
            addCriterion("RECEIVE_STATE <>", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateGreaterThan(String value) {
            addCriterion("RECEIVE_STATE >", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_STATE >=", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateLessThan(String value) {
            addCriterion("RECEIVE_STATE <", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_STATE <=", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateLike(String value) {
            addCriterion("RECEIVE_STATE like", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateNotLike(String value) {
            addCriterion("RECEIVE_STATE not like", value, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateIn(List<String> values) {
            addCriterion("RECEIVE_STATE in", values, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateNotIn(List<String> values) {
            addCriterion("RECEIVE_STATE not in", values, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateBetween(String value1, String value2) {
            addCriterion("RECEIVE_STATE between", value1, value2, "receiveState");
            return (Criteria) this;
        }

        public Criteria andReceiveStateNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_STATE not between", value1, value2, "receiveState");
            return (Criteria) this;
        }

        public Criteria andFinishStateIsNull() {
            addCriterion("FINISH_STATE is null");
            return (Criteria) this;
        }

        public Criteria andFinishStateIsNotNull() {
            addCriterion("FINISH_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andFinishStateEqualTo(String value) {
            addCriterion("FINISH_STATE =", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateNotEqualTo(String value) {
            addCriterion("FINISH_STATE <>", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateGreaterThan(String value) {
            addCriterion("FINISH_STATE >", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateGreaterThanOrEqualTo(String value) {
            addCriterion("FINISH_STATE >=", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateLessThan(String value) {
            addCriterion("FINISH_STATE <", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateLessThanOrEqualTo(String value) {
            addCriterion("FINISH_STATE <=", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateLike(String value) {
            addCriterion("FINISH_STATE like", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateNotLike(String value) {
            addCriterion("FINISH_STATE not like", value, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateIn(List<String> values) {
            addCriterion("FINISH_STATE in", values, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateNotIn(List<String> values) {
            addCriterion("FINISH_STATE not in", values, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateBetween(String value1, String value2) {
            addCriterion("FINISH_STATE between", value1, value2, "finishState");
            return (Criteria) this;
        }

        public Criteria andFinishStateNotBetween(String value1, String value2) {
            addCriterion("FINISH_STATE not between", value1, value2, "finishState");
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