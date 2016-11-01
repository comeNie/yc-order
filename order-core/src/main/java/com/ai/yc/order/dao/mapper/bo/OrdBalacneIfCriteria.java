package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdBalacneIfCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdBalacneIfCriteria() {
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

        public Criteria andBalacneIfIdIsNull() {
            addCriterion("BALACNE_IF_ID is null");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdIsNotNull() {
            addCriterion("BALACNE_IF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdEqualTo(Long value) {
            addCriterion("BALACNE_IF_ID =", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdNotEqualTo(Long value) {
            addCriterion("BALACNE_IF_ID <>", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdGreaterThan(Long value) {
            addCriterion("BALACNE_IF_ID >", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BALACNE_IF_ID >=", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdLessThan(Long value) {
            addCriterion("BALACNE_IF_ID <", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdLessThanOrEqualTo(Long value) {
            addCriterion("BALACNE_IF_ID <=", value, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdIn(List<Long> values) {
            addCriterion("BALACNE_IF_ID in", values, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdNotIn(List<Long> values) {
            addCriterion("BALACNE_IF_ID not in", values, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdBetween(Long value1, Long value2) {
            addCriterion("BALACNE_IF_ID between", value1, value2, "balacneIfId");
            return (Criteria) this;
        }

        public Criteria andBalacneIfIdNotBetween(Long value1, Long value2) {
            addCriterion("BALACNE_IF_ID not between", value1, value2, "balacneIfId");
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

        public Criteria andPaySystemIdIsNull() {
            addCriterion("PAY_SYSTEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdIsNotNull() {
            addCriterion("PAY_SYSTEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdEqualTo(String value) {
            addCriterion("PAY_SYSTEM_ID =", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdNotEqualTo(String value) {
            addCriterion("PAY_SYSTEM_ID <>", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdGreaterThan(String value) {
            addCriterion("PAY_SYSTEM_ID >", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_SYSTEM_ID >=", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdLessThan(String value) {
            addCriterion("PAY_SYSTEM_ID <", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdLessThanOrEqualTo(String value) {
            addCriterion("PAY_SYSTEM_ID <=", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdLike(String value) {
            addCriterion("PAY_SYSTEM_ID like", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdNotLike(String value) {
            addCriterion("PAY_SYSTEM_ID not like", value, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdIn(List<String> values) {
            addCriterion("PAY_SYSTEM_ID in", values, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdNotIn(List<String> values) {
            addCriterion("PAY_SYSTEM_ID not in", values, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdBetween(String value1, String value2) {
            addCriterion("PAY_SYSTEM_ID between", value1, value2, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andPaySystemIdNotBetween(String value1, String value2) {
            addCriterion("PAY_SYSTEM_ID not between", value1, value2, "paySystemId");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNull() {
            addCriterion("EXTERNAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNotNull() {
            addCriterion("EXTERNAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExternalIdEqualTo(String value) {
            addCriterion("EXTERNAL_ID =", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotEqualTo(String value) {
            addCriterion("EXTERNAL_ID <>", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThan(String value) {
            addCriterion("EXTERNAL_ID >", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ID >=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThan(String value) {
            addCriterion("EXTERNAL_ID <", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_ID <=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLike(String value) {
            addCriterion("EXTERNAL_ID like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotLike(String value) {
            addCriterion("EXTERNAL_ID not like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdIn(List<String> values) {
            addCriterion("EXTERNAL_ID in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotIn(List<String> values) {
            addCriterion("EXTERNAL_ID not in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ID between", value1, value2, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_ID not between", value1, value2, "externalId");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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