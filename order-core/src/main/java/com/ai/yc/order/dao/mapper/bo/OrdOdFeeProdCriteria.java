package com.ai.yc.order.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class OrdOdFeeProdCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdFeeProdCriteria() {
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

        public Criteria andFeeProdIdIsNull() {
            addCriterion("FEE_PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdIsNotNull() {
            addCriterion("FEE_PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdEqualTo(Long value) {
            addCriterion("FEE_PROD_ID =", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdNotEqualTo(Long value) {
            addCriterion("FEE_PROD_ID <>", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdGreaterThan(Long value) {
            addCriterion("FEE_PROD_ID >", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FEE_PROD_ID >=", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdLessThan(Long value) {
            addCriterion("FEE_PROD_ID <", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdLessThanOrEqualTo(Long value) {
            addCriterion("FEE_PROD_ID <=", value, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdIn(List<Long> values) {
            addCriterion("FEE_PROD_ID in", values, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdNotIn(List<Long> values) {
            addCriterion("FEE_PROD_ID not in", values, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdBetween(Long value1, Long value2) {
            addCriterion("FEE_PROD_ID between", value1, value2, "feeProdId");
            return (Criteria) this;
        }

        public Criteria andFeeProdIdNotBetween(Long value1, Long value2) {
            addCriterion("FEE_PROD_ID not between", value1, value2, "feeProdId");
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

        public Criteria andPayStyleIsNull() {
            addCriterion("PAY_STYLE is null");
            return (Criteria) this;
        }

        public Criteria andPayStyleIsNotNull() {
            addCriterion("PAY_STYLE is not null");
            return (Criteria) this;
        }

        public Criteria andPayStyleEqualTo(String value) {
            addCriterion("PAY_STYLE =", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleNotEqualTo(String value) {
            addCriterion("PAY_STYLE <>", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleGreaterThan(String value) {
            addCriterion("PAY_STYLE >", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_STYLE >=", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleLessThan(String value) {
            addCriterion("PAY_STYLE <", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleLessThanOrEqualTo(String value) {
            addCriterion("PAY_STYLE <=", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleLike(String value) {
            addCriterion("PAY_STYLE like", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleNotLike(String value) {
            addCriterion("PAY_STYLE not like", value, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleIn(List<String> values) {
            addCriterion("PAY_STYLE in", values, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleNotIn(List<String> values) {
            addCriterion("PAY_STYLE not in", values, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleBetween(String value1, String value2) {
            addCriterion("PAY_STYLE between", value1, value2, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPayStyleNotBetween(String value1, String value2) {
            addCriterion("PAY_STYLE not between", value1, value2, "payStyle");
            return (Criteria) this;
        }

        public Criteria andPaidFeeIsNull() {
            addCriterion("PAID_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPaidFeeIsNotNull() {
            addCriterion("PAID_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPaidFeeEqualTo(Long value) {
            addCriterion("PAID_FEE =", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeNotEqualTo(Long value) {
            addCriterion("PAID_FEE <>", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeGreaterThan(Long value) {
            addCriterion("PAID_FEE >", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PAID_FEE >=", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeLessThan(Long value) {
            addCriterion("PAID_FEE <", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeLessThanOrEqualTo(Long value) {
            addCriterion("PAID_FEE <=", value, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeIn(List<Long> values) {
            addCriterion("PAID_FEE in", values, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeNotIn(List<Long> values) {
            addCriterion("PAID_FEE not in", values, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeBetween(Long value1, Long value2) {
            addCriterion("PAID_FEE between", value1, value2, "paidFee");
            return (Criteria) this;
        }

        public Criteria andPaidFeeNotBetween(Long value1, Long value2) {
            addCriterion("PAID_FEE not between", value1, value2, "paidFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIsNull() {
            addCriterion("COUPON_FEE is null");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIsNotNull() {
            addCriterion("COUPON_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andCouponFeeEqualTo(Long value) {
            addCriterion("COUPON_FEE =", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotEqualTo(Long value) {
            addCriterion("COUPON_FEE <>", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeGreaterThan(Long value) {
            addCriterion("COUPON_FEE >", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("COUPON_FEE >=", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeLessThan(Long value) {
            addCriterion("COUPON_FEE <", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeLessThanOrEqualTo(Long value) {
            addCriterion("COUPON_FEE <=", value, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeIn(List<Long> values) {
            addCriterion("COUPON_FEE in", values, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotIn(List<Long> values) {
            addCriterion("COUPON_FEE not in", values, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeBetween(Long value1, Long value2) {
            addCriterion("COUPON_FEE between", value1, value2, "couponFee");
            return (Criteria) this;
        }

        public Criteria andCouponFeeNotBetween(Long value1, Long value2) {
            addCriterion("COUPON_FEE not between", value1, value2, "couponFee");
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