package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdOdReceiveCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdReceiveCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("PERSON_ID is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("PERSON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Long value) {
            addCriterion("PERSON_ID =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Long value) {
            addCriterion("PERSON_ID <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Long value) {
            addCriterion("PERSON_ID >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PERSON_ID >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Long value) {
            addCriterion("PERSON_ID <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("PERSON_ID <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Long> values) {
            addCriterion("PERSON_ID in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Long> values) {
            addCriterion("PERSON_ID not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Long value1, Long value2) {
            addCriterion("PERSON_ID between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("PERSON_ID not between", value1, value2, "personId");
            return (Criteria) this;
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

        public Criteria andInterperIdIsNull() {
            addCriterion("INTERPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterperIdIsNotNull() {
            addCriterion("INTERPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterperIdEqualTo(String value) {
            addCriterion("INTERPER_ID =", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdNotEqualTo(String value) {
            addCriterion("INTERPER_ID <>", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdGreaterThan(String value) {
            addCriterion("INTERPER_ID >", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdGreaterThanOrEqualTo(String value) {
            addCriterion("INTERPER_ID >=", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdLessThan(String value) {
            addCriterion("INTERPER_ID <", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdLessThanOrEqualTo(String value) {
            addCriterion("INTERPER_ID <=", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdLike(String value) {
            addCriterion("INTERPER_ID like", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdNotLike(String value) {
            addCriterion("INTERPER_ID not like", value, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdIn(List<String> values) {
            addCriterion("INTERPER_ID in", values, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdNotIn(List<String> values) {
            addCriterion("INTERPER_ID not in", values, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdBetween(String value1, String value2) {
            addCriterion("INTERPER_ID between", value1, value2, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperIdNotBetween(String value1, String value2) {
            addCriterion("INTERPER_ID not between", value1, value2, "interperId");
            return (Criteria) this;
        }

        public Criteria andInterperNameIsNull() {
            addCriterion("INTERPER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInterperNameIsNotNull() {
            addCriterion("INTERPER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInterperNameEqualTo(String value) {
            addCriterion("INTERPER_NAME =", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameNotEqualTo(String value) {
            addCriterion("INTERPER_NAME <>", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameGreaterThan(String value) {
            addCriterion("INTERPER_NAME >", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameGreaterThanOrEqualTo(String value) {
            addCriterion("INTERPER_NAME >=", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameLessThan(String value) {
            addCriterion("INTERPER_NAME <", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameLessThanOrEqualTo(String value) {
            addCriterion("INTERPER_NAME <=", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameLike(String value) {
            addCriterion("INTERPER_NAME like", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameNotLike(String value) {
            addCriterion("INTERPER_NAME not like", value, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameIn(List<String> values) {
            addCriterion("INTERPER_NAME in", values, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameNotIn(List<String> values) {
            addCriterion("INTERPER_NAME not in", values, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameBetween(String value1, String value2) {
            addCriterion("INTERPER_NAME between", value1, value2, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperNameNotBetween(String value1, String value2) {
            addCriterion("INTERPER_NAME not between", value1, value2, "interperName");
            return (Criteria) this;
        }

        public Criteria andInterperFeeIsNull() {
            addCriterion("INTERPER_FEE is null");
            return (Criteria) this;
        }

        public Criteria andInterperFeeIsNotNull() {
            addCriterion("INTERPER_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andInterperFeeEqualTo(Long value) {
            addCriterion("INTERPER_FEE =", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotEqualTo(Long value) {
            addCriterion("INTERPER_FEE <>", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeGreaterThan(Long value) {
            addCriterion("INTERPER_FEE >", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("INTERPER_FEE >=", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeLessThan(Long value) {
            addCriterion("INTERPER_FEE <", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeLessThanOrEqualTo(Long value) {
            addCriterion("INTERPER_FEE <=", value, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeIn(List<Long> values) {
            addCriterion("INTERPER_FEE in", values, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotIn(List<Long> values) {
            addCriterion("INTERPER_FEE not in", values, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeBetween(Long value1, Long value2) {
            addCriterion("INTERPER_FEE between", value1, value2, "interperFee");
            return (Criteria) this;
        }

        public Criteria andInterperFeeNotBetween(Long value1, Long value2) {
            addCriterion("INTERPER_FEE not between", value1, value2, "interperFee");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("RECEIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("RECEIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Timestamp value) {
            addCriterion("RECEIVE_TIME =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Timestamp value) {
            addCriterion("RECEIVE_TIME <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Timestamp value) {
            addCriterion("RECEIVE_TIME >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("RECEIVE_TIME >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Timestamp value) {
            addCriterion("RECEIVE_TIME <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("RECEIVE_TIME <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Timestamp> values) {
            addCriterion("RECEIVE_TIME in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Timestamp> values) {
            addCriterion("RECEIVE_TIME not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("RECEIVE_TIME between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("RECEIVE_TIME not between", value1, value2, "receiveTime");
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