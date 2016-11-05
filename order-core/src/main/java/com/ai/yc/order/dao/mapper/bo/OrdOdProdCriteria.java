package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdOdProdCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdProdCriteria() {
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

        public Criteria andMeetingSumIsNull() {
            addCriterion("MEETING_SUM is null");
            return (Criteria) this;
        }

        public Criteria andMeetingSumIsNotNull() {
            addCriterion("MEETING_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingSumEqualTo(Long value) {
            addCriterion("MEETING_SUM =", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumNotEqualTo(Long value) {
            addCriterion("MEETING_SUM <>", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumGreaterThan(Long value) {
            addCriterion("MEETING_SUM >", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumGreaterThanOrEqualTo(Long value) {
            addCriterion("MEETING_SUM >=", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumLessThan(Long value) {
            addCriterion("MEETING_SUM <", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumLessThanOrEqualTo(Long value) {
            addCriterion("MEETING_SUM <=", value, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumIn(List<Long> values) {
            addCriterion("MEETING_SUM in", values, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumNotIn(List<Long> values) {
            addCriterion("MEETING_SUM not in", values, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumBetween(Long value1, Long value2) {
            addCriterion("MEETING_SUM between", value1, value2, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andMeetingSumNotBetween(Long value1, Long value2) {
            addCriterion("MEETING_SUM not between", value1, value2, "meetingSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumIsNull() {
            addCriterion("TRANSLATE_SUM is null");
            return (Criteria) this;
        }

        public Criteria andTranslateSumIsNotNull() {
            addCriterion("TRANSLATE_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andTranslateSumEqualTo(String value) {
            addCriterion("TRANSLATE_SUM =", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumNotEqualTo(String value) {
            addCriterion("TRANSLATE_SUM <>", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumGreaterThan(String value) {
            addCriterion("TRANSLATE_SUM >", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_SUM >=", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumLessThan(String value) {
            addCriterion("TRANSLATE_SUM <", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumLessThanOrEqualTo(String value) {
            addCriterion("TRANSLATE_SUM <=", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumLike(String value) {
            addCriterion("TRANSLATE_SUM like", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumNotLike(String value) {
            addCriterion("TRANSLATE_SUM not like", value, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumIn(List<String> values) {
            addCriterion("TRANSLATE_SUM in", values, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumNotIn(List<String> values) {
            addCriterion("TRANSLATE_SUM not in", values, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumBetween(String value1, String value2) {
            addCriterion("TRANSLATE_SUM between", value1, value2, "translateSum");
            return (Criteria) this;
        }

        public Criteria andTranslateSumNotBetween(String value1, String value2) {
            addCriterion("TRANSLATE_SUM not between", value1, value2, "translateSum");
            return (Criteria) this;
        }

        public Criteria andInterperGenIsNull() {
            addCriterion("INTERPER_GEN is null");
            return (Criteria) this;
        }

        public Criteria andInterperGenIsNotNull() {
            addCriterion("INTERPER_GEN is not null");
            return (Criteria) this;
        }

        public Criteria andInterperGenEqualTo(String value) {
            addCriterion("INTERPER_GEN =", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenNotEqualTo(String value) {
            addCriterion("INTERPER_GEN <>", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenGreaterThan(String value) {
            addCriterion("INTERPER_GEN >", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenGreaterThanOrEqualTo(String value) {
            addCriterion("INTERPER_GEN >=", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenLessThan(String value) {
            addCriterion("INTERPER_GEN <", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenLessThanOrEqualTo(String value) {
            addCriterion("INTERPER_GEN <=", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenLike(String value) {
            addCriterion("INTERPER_GEN like", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenNotLike(String value) {
            addCriterion("INTERPER_GEN not like", value, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenIn(List<String> values) {
            addCriterion("INTERPER_GEN in", values, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenNotIn(List<String> values) {
            addCriterion("INTERPER_GEN not in", values, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenBetween(String value1, String value2) {
            addCriterion("INTERPER_GEN between", value1, value2, "interperGen");
            return (Criteria) this;
        }

        public Criteria andInterperGenNotBetween(String value1, String value2) {
            addCriterion("INTERPER_GEN not between", value1, value2, "interperGen");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressIsNull() {
            addCriterion("MEETING_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressIsNotNull() {
            addCriterion("MEETING_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressEqualTo(String value) {
            addCriterion("MEETING_ADDRESS =", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressNotEqualTo(String value) {
            addCriterion("MEETING_ADDRESS <>", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressGreaterThan(String value) {
            addCriterion("MEETING_ADDRESS >", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MEETING_ADDRESS >=", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressLessThan(String value) {
            addCriterion("MEETING_ADDRESS <", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressLessThanOrEqualTo(String value) {
            addCriterion("MEETING_ADDRESS <=", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressLike(String value) {
            addCriterion("MEETING_ADDRESS like", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressNotLike(String value) {
            addCriterion("MEETING_ADDRESS not like", value, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressIn(List<String> values) {
            addCriterion("MEETING_ADDRESS in", values, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressNotIn(List<String> values) {
            addCriterion("MEETING_ADDRESS not in", values, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressBetween(String value1, String value2) {
            addCriterion("MEETING_ADDRESS between", value1, value2, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andMeetingAddressNotBetween(String value1, String value2) {
            addCriterion("MEETING_ADDRESS not between", value1, value2, "meetingAddress");
            return (Criteria) this;
        }

        public Criteria andInterperSumIsNull() {
            addCriterion("INTERPER_SUM is null");
            return (Criteria) this;
        }

        public Criteria andInterperSumIsNotNull() {
            addCriterion("INTERPER_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andInterperSumEqualTo(Long value) {
            addCriterion("INTERPER_SUM =", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumNotEqualTo(Long value) {
            addCriterion("INTERPER_SUM <>", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumGreaterThan(Long value) {
            addCriterion("INTERPER_SUM >", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumGreaterThanOrEqualTo(Long value) {
            addCriterion("INTERPER_SUM >=", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumLessThan(Long value) {
            addCriterion("INTERPER_SUM <", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumLessThanOrEqualTo(Long value) {
            addCriterion("INTERPER_SUM <=", value, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumIn(List<Long> values) {
            addCriterion("INTERPER_SUM in", values, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumNotIn(List<Long> values) {
            addCriterion("INTERPER_SUM not in", values, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumBetween(Long value1, Long value2) {
            addCriterion("INTERPER_SUM between", value1, value2, "interperSum");
            return (Criteria) this;
        }

        public Criteria andInterperSumNotBetween(Long value1, Long value2) {
            addCriterion("INTERPER_SUM not between", value1, value2, "interperSum");
            return (Criteria) this;
        }

        public Criteria andUseCodeIsNull() {
            addCriterion("USE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andUseCodeIsNotNull() {
            addCriterion("USE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andUseCodeEqualTo(String value) {
            addCriterion("USE_CODE =", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotEqualTo(String value) {
            addCriterion("USE_CODE <>", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeGreaterThan(String value) {
            addCriterion("USE_CODE >", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("USE_CODE >=", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLessThan(String value) {
            addCriterion("USE_CODE <", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLessThanOrEqualTo(String value) {
            addCriterion("USE_CODE <=", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeLike(String value) {
            addCriterion("USE_CODE like", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotLike(String value) {
            addCriterion("USE_CODE not like", value, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeIn(List<String> values) {
            addCriterion("USE_CODE in", values, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotIn(List<String> values) {
            addCriterion("USE_CODE not in", values, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeBetween(String value1, String value2) {
            addCriterion("USE_CODE between", value1, value2, "useCode");
            return (Criteria) this;
        }

        public Criteria andUseCodeNotBetween(String value1, String value2) {
            addCriterion("USE_CODE not between", value1, value2, "useCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNull() {
            addCriterion("FIELD_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIsNotNull() {
            addCriterion("FIELD_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFieldCodeEqualTo(String value) {
            addCriterion("FIELD_CODE =", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotEqualTo(String value) {
            addCriterion("FIELD_CODE <>", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThan(String value) {
            addCriterion("FIELD_CODE >", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_CODE >=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThan(String value) {
            addCriterion("FIELD_CODE <", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLessThanOrEqualTo(String value) {
            addCriterion("FIELD_CODE <=", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeLike(String value) {
            addCriterion("FIELD_CODE like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotLike(String value) {
            addCriterion("FIELD_CODE not like", value, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeIn(List<String> values) {
            addCriterion("FIELD_CODE in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotIn(List<String> values) {
            addCriterion("FIELD_CODE not in", values, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeBetween(String value1, String value2) {
            addCriterion("FIELD_CODE between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andFieldCodeNotBetween(String value1, String value2) {
            addCriterion("FIELD_CODE not between", value1, value2, "fieldCode");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeIsNull() {
            addCriterion("IS_SET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeIsNotNull() {
            addCriterion("IS_SET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeEqualTo(String value) {
            addCriterion("IS_SET_TYPE =", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeNotEqualTo(String value) {
            addCriterion("IS_SET_TYPE <>", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeGreaterThan(String value) {
            addCriterion("IS_SET_TYPE >", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SET_TYPE >=", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeLessThan(String value) {
            addCriterion("IS_SET_TYPE <", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeLessThanOrEqualTo(String value) {
            addCriterion("IS_SET_TYPE <=", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeLike(String value) {
            addCriterion("IS_SET_TYPE like", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeNotLike(String value) {
            addCriterion("IS_SET_TYPE not like", value, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeIn(List<String> values) {
            addCriterion("IS_SET_TYPE in", values, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeNotIn(List<String> values) {
            addCriterion("IS_SET_TYPE not in", values, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeBetween(String value1, String value2) {
            addCriterion("IS_SET_TYPE between", value1, value2, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsSetTypeNotBetween(String value1, String value2) {
            addCriterion("IS_SET_TYPE not between", value1, value2, "isSetType");
            return (Criteria) this;
        }

        public Criteria andIsUrgentIsNull() {
            addCriterion("IS_URGENT is null");
            return (Criteria) this;
        }

        public Criteria andIsUrgentIsNotNull() {
            addCriterion("IS_URGENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsUrgentEqualTo(String value) {
            addCriterion("IS_URGENT =", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentNotEqualTo(String value) {
            addCriterion("IS_URGENT <>", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentGreaterThan(String value) {
            addCriterion("IS_URGENT >", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentGreaterThanOrEqualTo(String value) {
            addCriterion("IS_URGENT >=", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentLessThan(String value) {
            addCriterion("IS_URGENT <", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentLessThanOrEqualTo(String value) {
            addCriterion("IS_URGENT <=", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentLike(String value) {
            addCriterion("IS_URGENT like", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentNotLike(String value) {
            addCriterion("IS_URGENT not like", value, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentIn(List<String> values) {
            addCriterion("IS_URGENT in", values, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentNotIn(List<String> values) {
            addCriterion("IS_URGENT not in", values, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentBetween(String value1, String value2) {
            addCriterion("IS_URGENT between", value1, value2, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andIsUrgentNotBetween(String value1, String value2) {
            addCriterion("IS_URGENT not between", value1, value2, "isUrgent");
            return (Criteria) this;
        }

        public Criteria andStateTimeIsNull() {
            addCriterion("STATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateTimeIsNotNull() {
            addCriterion("STATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateTimeEqualTo(Timestamp value) {
            addCriterion("STATE_TIME =", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotEqualTo(Timestamp value) {
            addCriterion("STATE_TIME <>", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThan(Timestamp value) {
            addCriterion("STATE_TIME >", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_TIME >=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThan(Timestamp value) {
            addCriterion("STATE_TIME <", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_TIME <=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeIn(List<Timestamp> values) {
            addCriterion("STATE_TIME in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotIn(List<Timestamp> values) {
            addCriterion("STATE_TIME not in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_TIME between", value1, value2, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_TIME not between", value1, value2, "stateTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Timestamp value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Timestamp value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Timestamp value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Timestamp value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Timestamp> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Timestamp> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateIsNull() {
            addCriterion("PROD_DETAL_STATE is null");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateIsNotNull() {
            addCriterion("PROD_DETAL_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateEqualTo(String value) {
            addCriterion("PROD_DETAL_STATE =", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateNotEqualTo(String value) {
            addCriterion("PROD_DETAL_STATE <>", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateGreaterThan(String value) {
            addCriterion("PROD_DETAL_STATE >", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_DETAL_STATE >=", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateLessThan(String value) {
            addCriterion("PROD_DETAL_STATE <", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateLessThanOrEqualTo(String value) {
            addCriterion("PROD_DETAL_STATE <=", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateLike(String value) {
            addCriterion("PROD_DETAL_STATE like", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateNotLike(String value) {
            addCriterion("PROD_DETAL_STATE not like", value, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateIn(List<String> values) {
            addCriterion("PROD_DETAL_STATE in", values, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateNotIn(List<String> values) {
            addCriterion("PROD_DETAL_STATE not in", values, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateBetween(String value1, String value2) {
            addCriterion("PROD_DETAL_STATE between", value1, value2, "prodDetalState");
            return (Criteria) this;
        }

        public Criteria andProdDetalStateNotBetween(String value1, String value2) {
            addCriterion("PROD_DETAL_STATE not between", value1, value2, "prodDetalState");
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

        public Criteria andLookStateIsNull() {
            addCriterion("LOOK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andLookStateIsNotNull() {
            addCriterion("LOOK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andLookStateEqualTo(String value) {
            addCriterion("LOOK_STATE =", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotEqualTo(String value) {
            addCriterion("LOOK_STATE <>", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThan(String value) {
            addCriterion("LOOK_STATE >", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateGreaterThanOrEqualTo(String value) {
            addCriterion("LOOK_STATE >=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThan(String value) {
            addCriterion("LOOK_STATE <", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLessThanOrEqualTo(String value) {
            addCriterion("LOOK_STATE <=", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateLike(String value) {
            addCriterion("LOOK_STATE like", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotLike(String value) {
            addCriterion("LOOK_STATE not like", value, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateIn(List<String> values) {
            addCriterion("LOOK_STATE in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotIn(List<String> values) {
            addCriterion("LOOK_STATE not in", values, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateBetween(String value1, String value2) {
            addCriterion("LOOK_STATE between", value1, value2, "lookState");
            return (Criteria) this;
        }

        public Criteria andLookStateNotBetween(String value1, String value2) {
            addCriterion("LOOK_STATE not between", value1, value2, "lookState");
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

        public Criteria andIsInvoiceIsNull() {
            addCriterion("IS_INVOICE is null");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceIsNotNull() {
            addCriterion("IS_INVOICE is not null");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceEqualTo(String value) {
            addCriterion("IS_INVOICE =", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceNotEqualTo(String value) {
            addCriterion("IS_INVOICE <>", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceGreaterThan(String value) {
            addCriterion("IS_INVOICE >", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceGreaterThanOrEqualTo(String value) {
            addCriterion("IS_INVOICE >=", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceLessThan(String value) {
            addCriterion("IS_INVOICE <", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceLessThanOrEqualTo(String value) {
            addCriterion("IS_INVOICE <=", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceLike(String value) {
            addCriterion("IS_INVOICE like", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceNotLike(String value) {
            addCriterion("IS_INVOICE not like", value, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceIn(List<String> values) {
            addCriterion("IS_INVOICE in", values, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceNotIn(List<String> values) {
            addCriterion("IS_INVOICE not in", values, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceBetween(String value1, String value2) {
            addCriterion("IS_INVOICE between", value1, value2, "isInvoice");
            return (Criteria) this;
        }

        public Criteria andIsInvoiceNotBetween(String value1, String value2) {
            addCriterion("IS_INVOICE not between", value1, value2, "isInvoice");
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

        public Criteria andUpdateInterperIdIsNull() {
            addCriterion("UPDATE_INTERPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdIsNotNull() {
            addCriterion("UPDATE_INTERPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdEqualTo(String value) {
            addCriterion("UPDATE_INTERPER_ID =", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdNotEqualTo(String value) {
            addCriterion("UPDATE_INTERPER_ID <>", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdGreaterThan(String value) {
            addCriterion("UPDATE_INTERPER_ID >", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_INTERPER_ID >=", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdLessThan(String value) {
            addCriterion("UPDATE_INTERPER_ID <", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_INTERPER_ID <=", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdLike(String value) {
            addCriterion("UPDATE_INTERPER_ID like", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdNotLike(String value) {
            addCriterion("UPDATE_INTERPER_ID not like", value, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdIn(List<String> values) {
            addCriterion("UPDATE_INTERPER_ID in", values, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdNotIn(List<String> values) {
            addCriterion("UPDATE_INTERPER_ID not in", values, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdBetween(String value1, String value2) {
            addCriterion("UPDATE_INTERPER_ID between", value1, value2, "updateInterperId");
            return (Criteria) this;
        }

        public Criteria andUpdateInterperIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_INTERPER_ID not between", value1, value2, "updateInterperId");
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

        public Criteria andTypeDescIsNull() {
            addCriterion("TYPE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andTypeDescIsNotNull() {
            addCriterion("TYPE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andTypeDescEqualTo(String value) {
            addCriterion("TYPE_DESC =", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotEqualTo(String value) {
            addCriterion("TYPE_DESC <>", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThan(String value) {
            addCriterion("TYPE_DESC >", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC >=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThan(String value) {
            addCriterion("TYPE_DESC <", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLessThanOrEqualTo(String value) {
            addCriterion("TYPE_DESC <=", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescLike(String value) {
            addCriterion("TYPE_DESC like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotLike(String value) {
            addCriterion("TYPE_DESC not like", value, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescIn(List<String> values) {
            addCriterion("TYPE_DESC in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotIn(List<String> values) {
            addCriterion("TYPE_DESC not in", values, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescBetween(String value1, String value2) {
            addCriterion("TYPE_DESC between", value1, value2, "typeDesc");
            return (Criteria) this;
        }

        public Criteria andTypeDescNotBetween(String value1, String value2) {
            addCriterion("TYPE_DESC not between", value1, value2, "typeDesc");
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