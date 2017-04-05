package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdOdFeeTotalCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdFeeTotalCriteria() {
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

        public Criteria andPayFlagIsNull() {
            addCriterion("PAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPayFlagIsNotNull() {
            addCriterion("PAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPayFlagEqualTo(String value) {
            addCriterion("PAY_FLAG =", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotEqualTo(String value) {
            addCriterion("PAY_FLAG <>", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagGreaterThan(String value) {
            addCriterion("PAY_FLAG >", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_FLAG >=", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLessThan(String value) {
            addCriterion("PAY_FLAG <", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLessThanOrEqualTo(String value) {
            addCriterion("PAY_FLAG <=", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagLike(String value) {
            addCriterion("PAY_FLAG like", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotLike(String value) {
            addCriterion("PAY_FLAG not like", value, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagIn(List<String> values) {
            addCriterion("PAY_FLAG in", values, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotIn(List<String> values) {
            addCriterion("PAY_FLAG not in", values, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagBetween(String value1, String value2) {
            addCriterion("PAY_FLAG between", value1, value2, "payFlag");
            return (Criteria) this;
        }

        public Criteria andPayFlagNotBetween(String value1, String value2) {
            addCriterion("PAY_FLAG not between", value1, value2, "payFlag");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNull() {
            addCriterion("CURRENCY_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNotNull() {
            addCriterion("CURRENCY_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitEqualTo(String value) {
            addCriterion("CURRENCY_UNIT =", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <>", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThan(String value) {
            addCriterion("CURRENCY_UNIT >", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT >=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThan(String value) {
            addCriterion("CURRENCY_UNIT <", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLike(String value) {
            addCriterion("CURRENCY_UNIT like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotLike(String value) {
            addCriterion("CURRENCY_UNIT not like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIn(List<String> values) {
            addCriterion("CURRENCY_UNIT in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotIn(List<String> values) {
            addCriterion("CURRENCY_UNIT not in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT not between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNull() {
            addCriterion("DISCOUNT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIsNotNull() {
            addCriterion("DISCOUNT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeEqualTo(Long value) {
            addCriterion("DISCOUNT_FEE =", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotEqualTo(Long value) {
            addCriterion("DISCOUNT_FEE <>", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThan(Long value) {
            addCriterion("DISCOUNT_FEE >", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_FEE >=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThan(Long value) {
            addCriterion("DISCOUNT_FEE <", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeLessThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_FEE <=", value, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeIn(List<Long> values) {
            addCriterion("DISCOUNT_FEE in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotIn(List<Long> values) {
            addCriterion("DISCOUNT_FEE not in", values, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_FEE between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andDiscountFeeNotBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_FEE not between", value1, value2, "discountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeIsNull() {
            addCriterion("OPER_DISCOUNT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeIsNotNull() {
            addCriterion("OPER_DISCOUNT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeEqualTo(Long value) {
            addCriterion("OPER_DISCOUNT_FEE =", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeNotEqualTo(Long value) {
            addCriterion("OPER_DISCOUNT_FEE <>", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeGreaterThan(Long value) {
            addCriterion("OPER_DISCOUNT_FEE >", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("OPER_DISCOUNT_FEE >=", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeLessThan(Long value) {
            addCriterion("OPER_DISCOUNT_FEE <", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeLessThanOrEqualTo(Long value) {
            addCriterion("OPER_DISCOUNT_FEE <=", value, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeIn(List<Long> values) {
            addCriterion("OPER_DISCOUNT_FEE in", values, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeNotIn(List<Long> values) {
            addCriterion("OPER_DISCOUNT_FEE not in", values, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeBetween(Long value1, Long value2) {
            addCriterion("OPER_DISCOUNT_FEE between", value1, value2, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountFeeNotBetween(Long value1, Long value2) {
            addCriterion("OPER_DISCOUNT_FEE not between", value1, value2, "operDiscountFee");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescIsNull() {
            addCriterion("OPER_DISCOUNT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescIsNotNull() {
            addCriterion("OPER_DISCOUNT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescEqualTo(String value) {
            addCriterion("OPER_DISCOUNT_DESC =", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescNotEqualTo(String value) {
            addCriterion("OPER_DISCOUNT_DESC <>", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescGreaterThan(String value) {
            addCriterion("OPER_DISCOUNT_DESC >", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_DISCOUNT_DESC >=", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescLessThan(String value) {
            addCriterion("OPER_DISCOUNT_DESC <", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescLessThanOrEqualTo(String value) {
            addCriterion("OPER_DISCOUNT_DESC <=", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescLike(String value) {
            addCriterion("OPER_DISCOUNT_DESC like", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescNotLike(String value) {
            addCriterion("OPER_DISCOUNT_DESC not like", value, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescIn(List<String> values) {
            addCriterion("OPER_DISCOUNT_DESC in", values, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescNotIn(List<String> values) {
            addCriterion("OPER_DISCOUNT_DESC not in", values, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescBetween(String value1, String value2) {
            addCriterion("OPER_DISCOUNT_DESC between", value1, value2, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andOperDiscountDescNotBetween(String value1, String value2) {
            addCriterion("OPER_DISCOUNT_DESC not between", value1, value2, "operDiscountDesc");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNull() {
            addCriterion("ADJUST_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIsNotNull() {
            addCriterion("ADJUST_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeEqualTo(Long value) {
            addCriterion("ADJUST_FEE =", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotEqualTo(Long value) {
            addCriterion("ADJUST_FEE <>", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThan(Long value) {
            addCriterion("ADJUST_FEE >", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("ADJUST_FEE >=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThan(Long value) {
            addCriterion("ADJUST_FEE <", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeLessThanOrEqualTo(Long value) {
            addCriterion("ADJUST_FEE <=", value, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeIn(List<Long> values) {
            addCriterion("ADJUST_FEE in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotIn(List<Long> values) {
            addCriterion("ADJUST_FEE not in", values, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeBetween(Long value1, Long value2) {
            addCriterion("ADJUST_FEE between", value1, value2, "adjustFee");
            return (Criteria) this;
        }

        public Criteria andAdjustFeeNotBetween(Long value1, Long value2) {
            addCriterion("ADJUST_FEE not between", value1, value2, "adjustFee");
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

        public Criteria andPayFeeIsNull() {
            addCriterion("PAY_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPayFeeIsNotNull() {
            addCriterion("PAY_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayFeeEqualTo(Long value) {
            addCriterion("PAY_FEE =", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeNotEqualTo(Long value) {
            addCriterion("PAY_FEE <>", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeGreaterThan(Long value) {
            addCriterion("PAY_FEE >", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PAY_FEE >=", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeLessThan(Long value) {
            addCriterion("PAY_FEE <", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeLessThanOrEqualTo(Long value) {
            addCriterion("PAY_FEE <=", value, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeIn(List<Long> values) {
            addCriterion("PAY_FEE in", values, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeNotIn(List<Long> values) {
            addCriterion("PAY_FEE not in", values, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeBetween(Long value1, Long value2) {
            addCriterion("PAY_FEE between", value1, value2, "payFee");
            return (Criteria) this;
        }

        public Criteria andPayFeeNotBetween(Long value1, Long value2) {
            addCriterion("PAY_FEE not between", value1, value2, "payFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIsNull() {
            addCriterion("PLAT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIsNotNull() {
            addCriterion("PLAT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFeeEqualTo(Long value) {
            addCriterion("PLAT_FEE =", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotEqualTo(Long value) {
            addCriterion("PLAT_FEE <>", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeGreaterThan(Long value) {
            addCriterion("PLAT_FEE >", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PLAT_FEE >=", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeLessThan(Long value) {
            addCriterion("PLAT_FEE <", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeLessThanOrEqualTo(Long value) {
            addCriterion("PLAT_FEE <=", value, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeIn(List<Long> values) {
            addCriterion("PLAT_FEE in", values, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotIn(List<Long> values) {
            addCriterion("PLAT_FEE not in", values, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeBetween(Long value1, Long value2) {
            addCriterion("PLAT_FEE between", value1, value2, "platFee");
            return (Criteria) this;
        }

        public Criteria andPlatFeeNotBetween(Long value1, Long value2) {
            addCriterion("PLAT_FEE not between", value1, value2, "platFee");
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

        public Criteria andUpdateOperIdIsNull() {
            addCriterion("UPDATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNotNull() {
            addCriterion("UPDATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(String value) {
            addCriterion("UPDATE_OPER_ID >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(String value) {
            addCriterion("UPDATE_OPER_ID <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLike(String value) {
            addCriterion("UPDATE_OPER_ID like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotLike(String value) {
            addCriterion("UPDATE_OPER_ID not like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID not between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIsNull() {
            addCriterion("UPDATE_CHL_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIsNotNull() {
            addCriterion("UPDATE_CHL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID =", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID <>", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdGreaterThan(String value) {
            addCriterion("UPDATE_CHL_ID >", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID >=", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLessThan(String value) {
            addCriterion("UPDATE_CHL_ID <", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID <=", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLike(String value) {
            addCriterion("UPDATE_CHL_ID like", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotLike(String value) {
            addCriterion("UPDATE_CHL_ID not like", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIn(List<String> values) {
            addCriterion("UPDATE_CHL_ID in", values, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotIn(List<String> values) {
            addCriterion("UPDATE_CHL_ID not in", values, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdBetween(String value1, String value2) {
            addCriterion("UPDATE_CHL_ID between", value1, value2, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_CHL_ID not between", value1, value2, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andTotalJfIsNull() {
            addCriterion("TOTAL_JF is null");
            return (Criteria) this;
        }

        public Criteria andTotalJfIsNotNull() {
            addCriterion("TOTAL_JF is not null");
            return (Criteria) this;
        }

        public Criteria andTotalJfEqualTo(Long value) {
            addCriterion("TOTAL_JF =", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfNotEqualTo(Long value) {
            addCriterion("TOTAL_JF <>", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfGreaterThan(Long value) {
            addCriterion("TOTAL_JF >", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_JF >=", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfLessThan(Long value) {
            addCriterion("TOTAL_JF <", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_JF <=", value, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfIn(List<Long> values) {
            addCriterion("TOTAL_JF in", values, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfNotIn(List<Long> values) {
            addCriterion("TOTAL_JF not in", values, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfBetween(Long value1, Long value2) {
            addCriterion("TOTAL_JF between", value1, value2, "totalJf");
            return (Criteria) this;
        }

        public Criteria andTotalJfNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_JF not between", value1, value2, "totalJf");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("PAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("PAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Timestamp value) {
            addCriterion("PAY_TIME =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Timestamp value) {
            addCriterion("PAY_TIME <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Timestamp value) {
            addCriterion("PAY_TIME >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("PAY_TIME >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Timestamp value) {
            addCriterion("PAY_TIME <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("PAY_TIME <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Timestamp> values) {
            addCriterion("PAY_TIME in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Timestamp> values) {
            addCriterion("PAY_TIME not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PAY_TIME between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("PAY_TIME not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeIsNull() {
            addCriterion("SET_TYPE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeIsNotNull() {
            addCriterion("SET_TYPE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeEqualTo(Long value) {
            addCriterion("SET_TYPE_FEE =", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeNotEqualTo(Long value) {
            addCriterion("SET_TYPE_FEE <>", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeGreaterThan(Long value) {
            addCriterion("SET_TYPE_FEE >", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("SET_TYPE_FEE >=", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeLessThan(Long value) {
            addCriterion("SET_TYPE_FEE <", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeLessThanOrEqualTo(Long value) {
            addCriterion("SET_TYPE_FEE <=", value, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeIn(List<Long> values) {
            addCriterion("SET_TYPE_FEE in", values, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeNotIn(List<Long> values) {
            addCriterion("SET_TYPE_FEE not in", values, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeBetween(Long value1, Long value2) {
            addCriterion("SET_TYPE_FEE between", value1, value2, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andSetTypeFeeNotBetween(Long value1, Long value2) {
            addCriterion("SET_TYPE_FEE not between", value1, value2, "setTypeFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeIsNull() {
            addCriterion("URGENT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeIsNotNull() {
            addCriterion("URGENT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeEqualTo(Long value) {
            addCriterion("URGENT_FEE =", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeNotEqualTo(Long value) {
            addCriterion("URGENT_FEE <>", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeGreaterThan(Long value) {
            addCriterion("URGENT_FEE >", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("URGENT_FEE >=", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeLessThan(Long value) {
            addCriterion("URGENT_FEE <", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeLessThanOrEqualTo(Long value) {
            addCriterion("URGENT_FEE <=", value, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeIn(List<Long> values) {
            addCriterion("URGENT_FEE in", values, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeNotIn(List<Long> values) {
            addCriterion("URGENT_FEE not in", values, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeBetween(Long value1, Long value2) {
            addCriterion("URGENT_FEE between", value1, value2, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andUrgentFeeNotBetween(Long value1, Long value2) {
            addCriterion("URGENT_FEE not between", value1, value2, "urgentFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeIsNull() {
            addCriterion("DESC_TYPE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeIsNotNull() {
            addCriterion("DESC_TYPE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeEqualTo(Long value) {
            addCriterion("DESC_TYPE_FEE =", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeNotEqualTo(Long value) {
            addCriterion("DESC_TYPE_FEE <>", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeGreaterThan(Long value) {
            addCriterion("DESC_TYPE_FEE >", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("DESC_TYPE_FEE >=", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeLessThan(Long value) {
            addCriterion("DESC_TYPE_FEE <", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeLessThanOrEqualTo(Long value) {
            addCriterion("DESC_TYPE_FEE <=", value, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeIn(List<Long> values) {
            addCriterion("DESC_TYPE_FEE in", values, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeNotIn(List<Long> values) {
            addCriterion("DESC_TYPE_FEE not in", values, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeBetween(Long value1, Long value2) {
            addCriterion("DESC_TYPE_FEE between", value1, value2, "descTypeFee");
            return (Criteria) this;
        }

        public Criteria andDescTypeFeeNotBetween(Long value1, Long value2) {
            addCriterion("DESC_TYPE_FEE not between", value1, value2, "descTypeFee");
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

        public Criteria andDiscountSumIsNull() {
            addCriterion("DISCOUNT_SUM is null");
            return (Criteria) this;
        }

        public Criteria andDiscountSumIsNotNull() {
            addCriterion("DISCOUNT_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountSumEqualTo(Long value) {
            addCriterion("DISCOUNT_SUM =", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumNotEqualTo(Long value) {
            addCriterion("DISCOUNT_SUM <>", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumGreaterThan(Long value) {
            addCriterion("DISCOUNT_SUM >", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumGreaterThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_SUM >=", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumLessThan(Long value) {
            addCriterion("DISCOUNT_SUM <", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumLessThanOrEqualTo(Long value) {
            addCriterion("DISCOUNT_SUM <=", value, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumIn(List<Long> values) {
            addCriterion("DISCOUNT_SUM in", values, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumNotIn(List<Long> values) {
            addCriterion("DISCOUNT_SUM not in", values, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_SUM between", value1, value2, "discountSum");
            return (Criteria) this;
        }

        public Criteria andDiscountSumNotBetween(Long value1, Long value2) {
            addCriterion("DISCOUNT_SUM not between", value1, value2, "discountSum");
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

        public Criteria andJfCouponFeeIsNull() {
            addCriterion("JF_COUPON_FEE is null");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeIsNotNull() {
            addCriterion("JF_COUPON_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeEqualTo(Long value) {
            addCriterion("JF_COUPON_FEE =", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeNotEqualTo(Long value) {
            addCriterion("JF_COUPON_FEE <>", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeGreaterThan(Long value) {
            addCriterion("JF_COUPON_FEE >", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("JF_COUPON_FEE >=", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeLessThan(Long value) {
            addCriterion("JF_COUPON_FEE <", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeLessThanOrEqualTo(Long value) {
            addCriterion("JF_COUPON_FEE <=", value, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeIn(List<Long> values) {
            addCriterion("JF_COUPON_FEE in", values, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeNotIn(List<Long> values) {
            addCriterion("JF_COUPON_FEE not in", values, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeBetween(Long value1, Long value2) {
            addCriterion("JF_COUPON_FEE between", value1, value2, "jfCouponFee");
            return (Criteria) this;
        }

        public Criteria andJfCouponFeeNotBetween(Long value1, Long value2) {
            addCriterion("JF_COUPON_FEE not between", value1, value2, "jfCouponFee");
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