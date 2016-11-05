package com.ai.yc.order.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class OrdOdProdExtendCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdProdExtendCriteria() {
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

        public Criteria andProdDetalExtendIdIsNull() {
            addCriterion("PROD_DETAL_EXTEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdIsNotNull() {
            addCriterion("PROD_DETAL_EXTEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdEqualTo(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID =", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdNotEqualTo(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID <>", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdGreaterThan(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID >", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID >=", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdLessThan(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID <", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_DETAL_EXTEND_ID <=", value, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdIn(List<Long> values) {
            addCriterion("PROD_DETAL_EXTEND_ID in", values, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdNotIn(List<Long> values) {
            addCriterion("PROD_DETAL_EXTEND_ID not in", values, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdBetween(Long value1, Long value2) {
            addCriterion("PROD_DETAL_EXTEND_ID between", value1, value2, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_DETAL_EXTEND_ID not between", value1, value2, "prodDetalExtendId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdIsNull() {
            addCriterion("PROD_DETAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdIsNotNull() {
            addCriterion("PROD_DETAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdEqualTo(Long value) {
            addCriterion("PROD_DETAL_ID =", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdNotEqualTo(Long value) {
            addCriterion("PROD_DETAL_ID <>", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdGreaterThan(Long value) {
            addCriterion("PROD_DETAL_ID >", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROD_DETAL_ID >=", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdLessThan(Long value) {
            addCriterion("PROD_DETAL_ID <", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdLessThanOrEqualTo(Long value) {
            addCriterion("PROD_DETAL_ID <=", value, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdIn(List<Long> values) {
            addCriterion("PROD_DETAL_ID in", values, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdNotIn(List<Long> values) {
            addCriterion("PROD_DETAL_ID not in", values, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdBetween(Long value1, Long value2) {
            addCriterion("PROD_DETAL_ID between", value1, value2, "prodDetalId");
            return (Criteria) this;
        }

        public Criteria andProdDetalIdNotBetween(Long value1, Long value2) {
            addCriterion("PROD_DETAL_ID not between", value1, value2, "prodDetalId");
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

        public Criteria andLangungePairIsNull() {
            addCriterion("LANGUNGE_PAIR is null");
            return (Criteria) this;
        }

        public Criteria andLangungePairIsNotNull() {
            addCriterion("LANGUNGE_PAIR is not null");
            return (Criteria) this;
        }

        public Criteria andLangungePairEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR =", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairNotEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR <>", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairGreaterThan(String value) {
            addCriterion("LANGUNGE_PAIR >", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR >=", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairLessThan(String value) {
            addCriterion("LANGUNGE_PAIR <", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairLessThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR <=", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairLike(String value) {
            addCriterion("LANGUNGE_PAIR like", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairNotLike(String value) {
            addCriterion("LANGUNGE_PAIR not like", value, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR in", values, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairNotIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR not in", values, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR between", value1, value2, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairNotBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR not between", value1, value2, "langungePair");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIsNull() {
            addCriterion("LANGUNGE_PAIR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIsNotNull() {
            addCriterion("LANGUNGE_PAIR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME =", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <>", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameGreaterThan(String value) {
            addCriterion("LANGUNGE_PAIR_NAME >", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME >=", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLessThan(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLessThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_PAIR_NAME <=", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameLike(String value) {
            addCriterion("LANGUNGE_PAIR_NAME like", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotLike(String value) {
            addCriterion("LANGUNGE_PAIR_NAME not like", value, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR_NAME in", values, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotIn(List<String> values) {
            addCriterion("LANGUNGE_PAIR_NAME not in", values, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR_NAME between", value1, value2, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andLangungePairNameNotBetween(String value1, String value2) {
            addCriterion("LANGUNGE_PAIR_NAME not between", value1, value2, "langungePairName");
            return (Criteria) this;
        }

        public Criteria andInfoJsonIsNull() {
            addCriterion("INFO_JSON is null");
            return (Criteria) this;
        }

        public Criteria andInfoJsonIsNotNull() {
            addCriterion("INFO_JSON is not null");
            return (Criteria) this;
        }

        public Criteria andInfoJsonEqualTo(String value) {
            addCriterion("INFO_JSON =", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonNotEqualTo(String value) {
            addCriterion("INFO_JSON <>", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonGreaterThan(String value) {
            addCriterion("INFO_JSON >", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_JSON >=", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonLessThan(String value) {
            addCriterion("INFO_JSON <", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonLessThanOrEqualTo(String value) {
            addCriterion("INFO_JSON <=", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonLike(String value) {
            addCriterion("INFO_JSON like", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonNotLike(String value) {
            addCriterion("INFO_JSON not like", value, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonIn(List<String> values) {
            addCriterion("INFO_JSON in", values, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonNotIn(List<String> values) {
            addCriterion("INFO_JSON not in", values, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonBetween(String value1, String value2) {
            addCriterion("INFO_JSON between", value1, value2, "infoJson");
            return (Criteria) this;
        }

        public Criteria andInfoJsonNotBetween(String value1, String value2) {
            addCriterion("INFO_JSON not between", value1, value2, "infoJson");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnIsNull() {
            addCriterion("LANGUNGE_NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnIsNotNull() {
            addCriterion("LANGUNGE_NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnEqualTo(String value) {
            addCriterion("LANGUNGE_NAME_EN =", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnNotEqualTo(String value) {
            addCriterion("LANGUNGE_NAME_EN <>", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnGreaterThan(String value) {
            addCriterion("LANGUNGE_NAME_EN >", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_NAME_EN >=", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnLessThan(String value) {
            addCriterion("LANGUNGE_NAME_EN <", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnLessThanOrEqualTo(String value) {
            addCriterion("LANGUNGE_NAME_EN <=", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnLike(String value) {
            addCriterion("LANGUNGE_NAME_EN like", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnNotLike(String value) {
            addCriterion("LANGUNGE_NAME_EN not like", value, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnIn(List<String> values) {
            addCriterion("LANGUNGE_NAME_EN in", values, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnNotIn(List<String> values) {
            addCriterion("LANGUNGE_NAME_EN not in", values, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnBetween(String value1, String value2) {
            addCriterion("LANGUNGE_NAME_EN between", value1, value2, "langungeNameEn");
            return (Criteria) this;
        }

        public Criteria andLangungeNameEnNotBetween(String value1, String value2) {
            addCriterion("LANGUNGE_NAME_EN not between", value1, value2, "langungeNameEn");
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