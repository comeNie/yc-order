package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdOrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOrderCriteria() {
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

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNull() {
            addCriterion("CHL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNotNull() {
            addCriterion("CHL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChlIdEqualTo(String value) {
            addCriterion("CHL_ID =", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotEqualTo(String value) {
            addCriterion("CHL_ID <>", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThan(String value) {
            addCriterion("CHL_ID >", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHL_ID >=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThan(String value) {
            addCriterion("CHL_ID <", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThanOrEqualTo(String value) {
            addCriterion("CHL_ID <=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLike(String value) {
            addCriterion("CHL_ID like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotLike(String value) {
            addCriterion("CHL_ID not like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdIn(List<String> values) {
            addCriterion("CHL_ID in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotIn(List<String> values) {
            addCriterion("CHL_ID not in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdBetween(String value1, String value2) {
            addCriterion("CHL_ID between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotBetween(String value1, String value2) {
            addCriterion("CHL_ID not between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("ORDER_TYPE =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("ORDER_TYPE <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("ORDER_TYPE >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("ORDER_TYPE <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("ORDER_TYPE like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("ORDER_TYPE not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("ORDER_TYPE in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("ORDER_TYPE not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNull() {
            addCriterion("BUSI_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("BUSI_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(String value) {
            addCriterion("BUSI_TYPE =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(String value) {
            addCriterion("BUSI_TYPE <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(String value) {
            addCriterion("BUSI_TYPE >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(String value) {
            addCriterion("BUSI_TYPE <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSI_TYPE <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLike(String value) {
            addCriterion("BUSI_TYPE like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotLike(String value) {
            addCriterion("BUSI_TYPE not like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<String> values) {
            addCriterion("BUSI_TYPE in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<String> values) {
            addCriterion("BUSI_TYPE not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(String value1, String value2) {
            addCriterion("BUSI_TYPE not between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIsNull() {
            addCriterion("ORDER_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIsNotNull() {
            addCriterion("ORDER_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLevelEqualTo(String value) {
            addCriterion("ORDER_LEVEL =", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotEqualTo(String value) {
            addCriterion("ORDER_LEVEL <>", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelGreaterThan(String value) {
            addCriterion("ORDER_LEVEL >", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_LEVEL >=", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLessThan(String value) {
            addCriterion("ORDER_LEVEL <", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLessThanOrEqualTo(String value) {
            addCriterion("ORDER_LEVEL <=", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelLike(String value) {
            addCriterion("ORDER_LEVEL like", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotLike(String value) {
            addCriterion("ORDER_LEVEL not like", value, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelIn(List<String> values) {
            addCriterion("ORDER_LEVEL in", values, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotIn(List<String> values) {
            addCriterion("ORDER_LEVEL not in", values, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelBetween(String value1, String value2) {
            addCriterion("ORDER_LEVEL between", value1, value2, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andOrderLevelNotBetween(String value1, String value2) {
            addCriterion("ORDER_LEVEL not between", value1, value2, "orderLevel");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeIsNull() {
            addCriterion("TRANSLATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeIsNotNull() {
            addCriterion("TRANSLATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeEqualTo(String value) {
            addCriterion("TRANSLATE_TYPE =", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeNotEqualTo(String value) {
            addCriterion("TRANSLATE_TYPE <>", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeGreaterThan(String value) {
            addCriterion("TRANSLATE_TYPE >", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_TYPE >=", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeLessThan(String value) {
            addCriterion("TRANSLATE_TYPE <", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeLessThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_TYPE <=", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeLike(String value) {
            addCriterion("TRANSLATE_TYPE like", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeNotLike(String value) {
            addCriterion("TRANSLATE_TYPE not like", value, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeIn(List<String> values) {
            addCriterion("TRANSLATE_TYPE in", values, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeNotIn(List<String> values) {
            addCriterion("TRANSLATE_TYPE not in", values, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeBetween(String value1, String value2) {
            addCriterion("TRANSLATE_TYPE between", value1, value2, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateTypeNotBetween(String value1, String value2) {
            addCriterion("TRANSLATE_TYPE not between", value1, value2, "translateType");
            return (Criteria) this;
        }

        public Criteria andTranslateNameIsNull() {
            addCriterion("TRANSLATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTranslateNameIsNotNull() {
            addCriterion("TRANSLATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTranslateNameEqualTo(String value) {
            addCriterion("TRANSLATE_NAME =", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameNotEqualTo(String value) {
            addCriterion("TRANSLATE_NAME <>", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameGreaterThan(String value) {
            addCriterion("TRANSLATE_NAME >", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_NAME >=", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameLessThan(String value) {
            addCriterion("TRANSLATE_NAME <", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameLessThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_NAME <=", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameLike(String value) {
            addCriterion("TRANSLATE_NAME like", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameNotLike(String value) {
            addCriterion("TRANSLATE_NAME not like", value, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameIn(List<String> values) {
            addCriterion("TRANSLATE_NAME in", values, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameNotIn(List<String> values) {
            addCriterion("TRANSLATE_NAME not in", values, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameBetween(String value1, String value2) {
            addCriterion("TRANSLATE_NAME between", value1, value2, "translateName");
            return (Criteria) this;
        }

        public Criteria andTranslateNameNotBetween(String value1, String value2) {
            addCriterion("TRANSLATE_NAME not between", value1, value2, "translateName");
            return (Criteria) this;
        }

        public Criteria andSubFlagIsNull() {
            addCriterion("SUB_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSubFlagIsNotNull() {
            addCriterion("SUB_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSubFlagEqualTo(String value) {
            addCriterion("SUB_FLAG =", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagNotEqualTo(String value) {
            addCriterion("SUB_FLAG <>", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagGreaterThan(String value) {
            addCriterion("SUB_FLAG >", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_FLAG >=", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagLessThan(String value) {
            addCriterion("SUB_FLAG <", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagLessThanOrEqualTo(String value) {
            addCriterion("SUB_FLAG <=", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagLike(String value) {
            addCriterion("SUB_FLAG like", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagNotLike(String value) {
            addCriterion("SUB_FLAG not like", value, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagIn(List<String> values) {
            addCriterion("SUB_FLAG in", values, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagNotIn(List<String> values) {
            addCriterion("SUB_FLAG not in", values, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagBetween(String value1, String value2) {
            addCriterion("SUB_FLAG between", value1, value2, "subFlag");
            return (Criteria) this;
        }

        public Criteria andSubFlagNotBetween(String value1, String value2) {
            addCriterion("SUB_FLAG not between", value1, value2, "subFlag");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("USER_TYPE like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("USER_TYPE not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdIsNull() {
            addCriterion("CORPORA_ID is null");
            return (Criteria) this;
        }

        public Criteria andCorporaIdIsNotNull() {
            addCriterion("CORPORA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCorporaIdEqualTo(String value) {
            addCriterion("CORPORA_ID =", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdNotEqualTo(String value) {
            addCriterion("CORPORA_ID <>", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdGreaterThan(String value) {
            addCriterion("CORPORA_ID >", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORA_ID >=", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdLessThan(String value) {
            addCriterion("CORPORA_ID <", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdLessThanOrEqualTo(String value) {
            addCriterion("CORPORA_ID <=", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdLike(String value) {
            addCriterion("CORPORA_ID like", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdNotLike(String value) {
            addCriterion("CORPORA_ID not like", value, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdIn(List<String> values) {
            addCriterion("CORPORA_ID in", values, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdNotIn(List<String> values) {
            addCriterion("CORPORA_ID not in", values, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdBetween(String value1, String value2) {
            addCriterion("CORPORA_ID between", value1, value2, "corporaId");
            return (Criteria) this;
        }

        public Criteria andCorporaIdNotBetween(String value1, String value2) {
            addCriterion("CORPORA_ID not between", value1, value2, "corporaId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIsNull() {
            addCriterion("TIME_ZONE is null");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIsNotNull() {
            addCriterion("TIME_ZONE is not null");
            return (Criteria) this;
        }

        public Criteria andTimeZoneEqualTo(String value) {
            addCriterion("TIME_ZONE =", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotEqualTo(String value) {
            addCriterion("TIME_ZONE <>", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneGreaterThan(String value) {
            addCriterion("TIME_ZONE >", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_ZONE >=", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLessThan(String value) {
            addCriterion("TIME_ZONE <", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLessThanOrEqualTo(String value) {
            addCriterion("TIME_ZONE <=", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLike(String value) {
            addCriterion("TIME_ZONE like", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotLike(String value) {
            addCriterion("TIME_ZONE not like", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIn(List<String> values) {
            addCriterion("TIME_ZONE in", values, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotIn(List<String> values) {
            addCriterion("TIME_ZONE not in", values, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneBetween(String value1, String value2) {
            addCriterion("TIME_ZONE between", value1, value2, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotBetween(String value1, String value2) {
            addCriterion("TIME_ZONE not between", value1, value2, "timeZone");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Timestamp value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Timestamp value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Timestamp> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Timestamp> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
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

        public Criteria andStateChgTimeIsNull() {
            addCriterion("STATE_CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIsNotNull() {
            addCriterion("STATE_CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME =", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <>", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME >", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME >=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME <", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME not in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME between", value1, value2, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME not between", value1, value2, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIsNull() {
            addCriterion("DISPLAY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIsNotNull() {
            addCriterion("DISPLAY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagEqualTo(String value) {
            addCriterion("DISPLAY_FLAG =", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotEqualTo(String value) {
            addCriterion("DISPLAY_FLAG <>", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagGreaterThan(String value) {
            addCriterion("DISPLAY_FLAG >", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DISPLAY_FLAG >=", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLessThan(String value) {
            addCriterion("DISPLAY_FLAG <", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLessThanOrEqualTo(String value) {
            addCriterion("DISPLAY_FLAG <=", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagLike(String value) {
            addCriterion("DISPLAY_FLAG like", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotLike(String value) {
            addCriterion("DISPLAY_FLAG not like", value, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagIn(List<String> values) {
            addCriterion("DISPLAY_FLAG in", values, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotIn(List<String> values) {
            addCriterion("DISPLAY_FLAG not in", values, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagBetween(String value1, String value2) {
            addCriterion("DISPLAY_FLAG between", value1, value2, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagNotBetween(String value1, String value2) {
            addCriterion("DISPLAY_FLAG not between", value1, value2, "displayFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeIsNull() {
            addCriterion("DISPLAY_FLAG_CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeIsNotNull() {
            addCriterion("DISPLAY_FLAG_CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeEqualTo(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME =", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeNotEqualTo(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME <>", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeGreaterThan(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME >", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME >=", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeLessThan(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME <", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("DISPLAY_FLAG_CHG_TIME <=", value, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeIn(List<Timestamp> values) {
            addCriterion("DISPLAY_FLAG_CHG_TIME in", values, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeNotIn(List<Timestamp> values) {
            addCriterion("DISPLAY_FLAG_CHG_TIME not in", values, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("DISPLAY_FLAG_CHG_TIME between", value1, value2, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andDisplayFlagChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("DISPLAY_FLAG_CHG_TIME not between", value1, value2, "displayFlagChgTime");
            return (Criteria) this;
        }

        public Criteria andInterperTypeIsNull() {
            addCriterion("INTERPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInterperTypeIsNotNull() {
            addCriterion("INTERPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInterperTypeEqualTo(String value) {
            addCriterion("INTERPER_TYPE =", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeNotEqualTo(String value) {
            addCriterion("INTERPER_TYPE <>", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeGreaterThan(String value) {
            addCriterion("INTERPER_TYPE >", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INTERPER_TYPE >=", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeLessThan(String value) {
            addCriterion("INTERPER_TYPE <", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeLessThanOrEqualTo(String value) {
            addCriterion("INTERPER_TYPE <=", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeLike(String value) {
            addCriterion("INTERPER_TYPE like", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeNotLike(String value) {
            addCriterion("INTERPER_TYPE not like", value, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeIn(List<String> values) {
            addCriterion("INTERPER_TYPE in", values, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeNotIn(List<String> values) {
            addCriterion("INTERPER_TYPE not in", values, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeBetween(String value1, String value2) {
            addCriterion("INTERPER_TYPE between", value1, value2, "interperType");
            return (Criteria) this;
        }

        public Criteria andInterperTypeNotBetween(String value1, String value2) {
            addCriterion("INTERPER_TYPE not between", value1, value2, "interperType");
            return (Criteria) this;
        }

        public Criteria andLspIdIsNull() {
            addCriterion("LSP_ID is null");
            return (Criteria) this;
        }

        public Criteria andLspIdIsNotNull() {
            addCriterion("LSP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLspIdEqualTo(String value) {
            addCriterion("LSP_ID =", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotEqualTo(String value) {
            addCriterion("LSP_ID <>", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdGreaterThan(String value) {
            addCriterion("LSP_ID >", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdGreaterThanOrEqualTo(String value) {
            addCriterion("LSP_ID >=", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLessThan(String value) {
            addCriterion("LSP_ID <", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLessThanOrEqualTo(String value) {
            addCriterion("LSP_ID <=", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdLike(String value) {
            addCriterion("LSP_ID like", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotLike(String value) {
            addCriterion("LSP_ID not like", value, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdIn(List<String> values) {
            addCriterion("LSP_ID in", values, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotIn(List<String> values) {
            addCriterion("LSP_ID not in", values, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdBetween(String value1, String value2) {
            addCriterion("LSP_ID between", value1, value2, "lspId");
            return (Criteria) this;
        }

        public Criteria andLspIdNotBetween(String value1, String value2) {
            addCriterion("LSP_ID not between", value1, value2, "lspId");
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

        public Criteria andLockTimeIsNull() {
            addCriterion("LOCK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNotNull() {
            addCriterion("LOCK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLockTimeEqualTo(Timestamp value) {
            addCriterion("LOCK_TIME =", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotEqualTo(Timestamp value) {
            addCriterion("LOCK_TIME <>", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThan(Timestamp value) {
            addCriterion("LOCK_TIME >", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("LOCK_TIME >=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThan(Timestamp value) {
            addCriterion("LOCK_TIME <", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("LOCK_TIME <=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeIn(List<Timestamp> values) {
            addCriterion("LOCK_TIME in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotIn(List<Timestamp> values) {
            addCriterion("LOCK_TIME not in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LOCK_TIME between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LOCK_TIME not between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(String value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(String value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(String value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(String value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(String value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLike(String value) {
            addCriterion("OPER_ID like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotLike(String value) {
            addCriterion("OPER_ID not like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<String> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<String> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(String value1, String value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(String value1, String value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagIsNull() {
            addCriterion("UPDATE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagIsNotNull() {
            addCriterion("UPDATE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagEqualTo(String value) {
            addCriterion("UPDATE_FLAG =", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagNotEqualTo(String value) {
            addCriterion("UPDATE_FLAG <>", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagGreaterThan(String value) {
            addCriterion("UPDATE_FLAG >", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_FLAG >=", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagLessThan(String value) {
            addCriterion("UPDATE_FLAG <", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_FLAG <=", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagLike(String value) {
            addCriterion("UPDATE_FLAG like", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagNotLike(String value) {
            addCriterion("UPDATE_FLAG not like", value, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagIn(List<String> values) {
            addCriterion("UPDATE_FLAG in", values, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagNotIn(List<String> values) {
            addCriterion("UPDATE_FLAG not in", values, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagBetween(String value1, String value2) {
            addCriterion("UPDATE_FLAG between", value1, value2, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andUpdateFlagNotBetween(String value1, String value2) {
            addCriterion("UPDATE_FLAG not between", value1, value2, "updateFlag");
            return (Criteria) this;
        }

        public Criteria andReasonDescIsNull() {
            addCriterion("REASON_DESC is null");
            return (Criteria) this;
        }

        public Criteria andReasonDescIsNotNull() {
            addCriterion("REASON_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andReasonDescEqualTo(String value) {
            addCriterion("REASON_DESC =", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescNotEqualTo(String value) {
            addCriterion("REASON_DESC <>", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescGreaterThan(String value) {
            addCriterion("REASON_DESC >", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescGreaterThanOrEqualTo(String value) {
            addCriterion("REASON_DESC >=", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescLessThan(String value) {
            addCriterion("REASON_DESC <", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescLessThanOrEqualTo(String value) {
            addCriterion("REASON_DESC <=", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescLike(String value) {
            addCriterion("REASON_DESC like", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescNotLike(String value) {
            addCriterion("REASON_DESC not like", value, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescIn(List<String> values) {
            addCriterion("REASON_DESC in", values, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescNotIn(List<String> values) {
            addCriterion("REASON_DESC not in", values, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescBetween(String value1, String value2) {
            addCriterion("REASON_DESC between", value1, value2, "reasonDesc");
            return (Criteria) this;
        }

        public Criteria andReasonDescNotBetween(String value1, String value2) {
            addCriterion("REASON_DESC not between", value1, value2, "reasonDesc");
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

        public Criteria andFinishTimeIsNull() {
            addCriterion("FINISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("FINISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Timestamp value) {
            addCriterion("FINISH_TIME =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Timestamp value) {
            addCriterion("FINISH_TIME <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Timestamp value) {
            addCriterion("FINISH_TIME >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("FINISH_TIME >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Timestamp value) {
            addCriterion("FINISH_TIME <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("FINISH_TIME <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Timestamp> values) {
            addCriterion("FINISH_TIME in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Timestamp> values) {
            addCriterion("FINISH_TIME not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("FINISH_TIME between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("FINISH_TIME not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNull() {
            addCriterion("ORDER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOrderDescIsNotNull() {
            addCriterion("ORDER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDescEqualTo(String value) {
            addCriterion("ORDER_DESC =", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotEqualTo(String value) {
            addCriterion("ORDER_DESC <>", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThan(String value) {
            addCriterion("ORDER_DESC >", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DESC >=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThan(String value) {
            addCriterion("ORDER_DESC <", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DESC <=", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescLike(String value) {
            addCriterion("ORDER_DESC like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotLike(String value) {
            addCriterion("ORDER_DESC not like", value, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescIn(List<String> values) {
            addCriterion("ORDER_DESC in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotIn(List<String> values) {
            addCriterion("ORDER_DESC not in", values, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescBetween(String value1, String value2) {
            addCriterion("ORDER_DESC between", value1, value2, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andOrderDescNotBetween(String value1, String value2) {
            addCriterion("ORDER_DESC not between", value1, value2, "orderDesc");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("KEYWORDS is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("KEYWORDS is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("KEYWORDS =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("KEYWORDS <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("KEYWORDS >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("KEYWORDS >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("KEYWORDS <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("KEYWORDS <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("KEYWORDS like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("KEYWORDS not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("KEYWORDS in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("KEYWORDS not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("KEYWORDS between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("KEYWORDS not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andIfWarningIsNull() {
            addCriterion("IF_WARNING is null");
            return (Criteria) this;
        }

        public Criteria andIfWarningIsNotNull() {
            addCriterion("IF_WARNING is not null");
            return (Criteria) this;
        }

        public Criteria andIfWarningEqualTo(String value) {
            addCriterion("IF_WARNING =", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningNotEqualTo(String value) {
            addCriterion("IF_WARNING <>", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningGreaterThan(String value) {
            addCriterion("IF_WARNING >", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningGreaterThanOrEqualTo(String value) {
            addCriterion("IF_WARNING >=", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningLessThan(String value) {
            addCriterion("IF_WARNING <", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningLessThanOrEqualTo(String value) {
            addCriterion("IF_WARNING <=", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningLike(String value) {
            addCriterion("IF_WARNING like", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningNotLike(String value) {
            addCriterion("IF_WARNING not like", value, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningIn(List<String> values) {
            addCriterion("IF_WARNING in", values, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningNotIn(List<String> values) {
            addCriterion("IF_WARNING not in", values, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningBetween(String value1, String value2) {
            addCriterion("IF_WARNING between", value1, value2, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andIfWarningNotBetween(String value1, String value2) {
            addCriterion("IF_WARNING not between", value1, value2, "ifWarning");
            return (Criteria) this;
        }

        public Criteria andWarningTypeIsNull() {
            addCriterion("WARNING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWarningTypeIsNotNull() {
            addCriterion("WARNING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWarningTypeEqualTo(String value) {
            addCriterion("WARNING_TYPE =", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeNotEqualTo(String value) {
            addCriterion("WARNING_TYPE <>", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeGreaterThan(String value) {
            addCriterion("WARNING_TYPE >", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WARNING_TYPE >=", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeLessThan(String value) {
            addCriterion("WARNING_TYPE <", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeLessThanOrEqualTo(String value) {
            addCriterion("WARNING_TYPE <=", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeLike(String value) {
            addCriterion("WARNING_TYPE like", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeNotLike(String value) {
            addCriterion("WARNING_TYPE not like", value, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeIn(List<String> values) {
            addCriterion("WARNING_TYPE in", values, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeNotIn(List<String> values) {
            addCriterion("WARNING_TYPE not in", values, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeBetween(String value1, String value2) {
            addCriterion("WARNING_TYPE between", value1, value2, "warningType");
            return (Criteria) this;
        }

        public Criteria andWarningTypeNotBetween(String value1, String value2) {
            addCriterion("WARNING_TYPE not between", value1, value2, "warningType");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNull() {
            addCriterion("IP_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("IP_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("IP_ADDRESS =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("IP_ADDRESS <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("IP_ADDRESS >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("IP_ADDRESS >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("IP_ADDRESS <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("IP_ADDRESS <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("IP_ADDRESS like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("IP_ADDRESS not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("IP_ADDRESS in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("IP_ADDRESS not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("IP_ADDRESS between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("IP_ADDRESS not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIsNull() {
            addCriterion("PAY_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIsNotNull() {
            addCriterion("PAY_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andPayRemarkEqualTo(String value) {
            addCriterion("PAY_REMARK =", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotEqualTo(String value) {
            addCriterion("PAY_REMARK <>", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkGreaterThan(String value) {
            addCriterion("PAY_REMARK >", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_REMARK >=", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLessThan(String value) {
            addCriterion("PAY_REMARK <", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLessThanOrEqualTo(String value) {
            addCriterion("PAY_REMARK <=", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLike(String value) {
            addCriterion("PAY_REMARK like", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotLike(String value) {
            addCriterion("PAY_REMARK not like", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIn(List<String> values) {
            addCriterion("PAY_REMARK in", values, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotIn(List<String> values) {
            addCriterion("PAY_REMARK not in", values, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkBetween(String value1, String value2) {
            addCriterion("PAY_REMARK between", value1, value2, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotBetween(String value1, String value2) {
            addCriterion("PAY_REMARK not between", value1, value2, "payRemark");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeIsNull() {
            addCriterion("END_CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeIsNotNull() {
            addCriterion("END_CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeEqualTo(Timestamp value) {
            addCriterion("END_CHG_TIME =", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeNotEqualTo(Timestamp value) {
            addCriterion("END_CHG_TIME <>", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeGreaterThan(Timestamp value) {
            addCriterion("END_CHG_TIME >", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("END_CHG_TIME >=", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeLessThan(Timestamp value) {
            addCriterion("END_CHG_TIME <", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("END_CHG_TIME <=", value, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeIn(List<Timestamp> values) {
            addCriterion("END_CHG_TIME in", values, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeNotIn(List<Timestamp> values) {
            addCriterion("END_CHG_TIME not in", values, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_CHG_TIME between", value1, value2, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andEndChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_CHG_TIME not between", value1, value2, "endChgTime");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNull() {
            addCriterion("PARENT_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNotNull() {
            addCriterion("PARENT_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdEqualTo(String value) {
            addCriterion("PARENT_ORDER_ID =", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotEqualTo(String value) {
            addCriterion("PARENT_ORDER_ID <>", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThan(String value) {
            addCriterion("PARENT_ORDER_ID >", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ORDER_ID >=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThan(String value) {
            addCriterion("PARENT_ORDER_ID <", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ORDER_ID <=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLike(String value) {
            addCriterion("PARENT_ORDER_ID like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotLike(String value) {
            addCriterion("PARENT_ORDER_ID not like", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIn(List<String> values) {
            addCriterion("PARENT_ORDER_ID in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotIn(List<String> values) {
            addCriterion("PARENT_ORDER_ID not in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdBetween(String value1, String value2) {
            addCriterion("PARENT_ORDER_ID between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ORDER_ID not between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagIsNull() {
            addCriterion("DELAYED_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagIsNotNull() {
            addCriterion("DELAYED_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagEqualTo(String value) {
            addCriterion("DELAYED_FLAG =", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagNotEqualTo(String value) {
            addCriterion("DELAYED_FLAG <>", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagGreaterThan(String value) {
            addCriterion("DELAYED_FLAG >", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DELAYED_FLAG >=", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagLessThan(String value) {
            addCriterion("DELAYED_FLAG <", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagLessThanOrEqualTo(String value) {
            addCriterion("DELAYED_FLAG <=", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagLike(String value) {
            addCriterion("DELAYED_FLAG like", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagNotLike(String value) {
            addCriterion("DELAYED_FLAG not like", value, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagIn(List<String> values) {
            addCriterion("DELAYED_FLAG in", values, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagNotIn(List<String> values) {
            addCriterion("DELAYED_FLAG not in", values, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagBetween(String value1, String value2) {
            addCriterion("DELAYED_FLAG between", value1, value2, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andDelayedFlagNotBetween(String value1, String value2) {
            addCriterion("DELAYED_FLAG not between", value1, value2, "delayedFlag");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdIsNull() {
            addCriterion("OPER_INTERPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdIsNotNull() {
            addCriterion("OPER_INTERPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdEqualTo(String value) {
            addCriterion("OPER_INTERPER_ID =", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdNotEqualTo(String value) {
            addCriterion("OPER_INTERPER_ID <>", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdGreaterThan(String value) {
            addCriterion("OPER_INTERPER_ID >", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_INTERPER_ID >=", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdLessThan(String value) {
            addCriterion("OPER_INTERPER_ID <", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdLessThanOrEqualTo(String value) {
            addCriterion("OPER_INTERPER_ID <=", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdLike(String value) {
            addCriterion("OPER_INTERPER_ID like", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdNotLike(String value) {
            addCriterion("OPER_INTERPER_ID not like", value, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdIn(List<String> values) {
            addCriterion("OPER_INTERPER_ID in", values, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdNotIn(List<String> values) {
            addCriterion("OPER_INTERPER_ID not in", values, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdBetween(String value1, String value2) {
            addCriterion("OPER_INTERPER_ID between", value1, value2, "operInterperId");
            return (Criteria) this;
        }

        public Criteria andOperInterperIdNotBetween(String value1, String value2) {
            addCriterion("OPER_INTERPER_ID not between", value1, value2, "operInterperId");
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