package com.ai.yc.order.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class OrdOdProdFileCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdOdProdFileCriteria() {
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

        public Criteria andProdFileIdIsNull() {
            addCriterion("PROD_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdFileIdIsNotNull() {
            addCriterion("PROD_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdFileIdEqualTo(String value) {
            addCriterion("PROD_FILE_ID =", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdNotEqualTo(String value) {
            addCriterion("PROD_FILE_ID <>", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdGreaterThan(String value) {
            addCriterion("PROD_FILE_ID >", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_FILE_ID >=", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdLessThan(String value) {
            addCriterion("PROD_FILE_ID <", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_FILE_ID <=", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdLike(String value) {
            addCriterion("PROD_FILE_ID like", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdNotLike(String value) {
            addCriterion("PROD_FILE_ID not like", value, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdIn(List<String> values) {
            addCriterion("PROD_FILE_ID in", values, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdNotIn(List<String> values) {
            addCriterion("PROD_FILE_ID not in", values, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdBetween(String value1, String value2) {
            addCriterion("PROD_FILE_ID between", value1, value2, "prodFileId");
            return (Criteria) this;
        }

        public Criteria andProdFileIdNotBetween(String value1, String value2) {
            addCriterion("PROD_FILE_ID not between", value1, value2, "prodFileId");
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

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdIsNull() {
            addCriterion("FILE_SAVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdIsNotNull() {
            addCriterion("FILE_SAVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdEqualTo(String value) {
            addCriterion("FILE_SAVE_ID =", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdNotEqualTo(String value) {
            addCriterion("FILE_SAVE_ID <>", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdGreaterThan(String value) {
            addCriterion("FILE_SAVE_ID >", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_SAVE_ID >=", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdLessThan(String value) {
            addCriterion("FILE_SAVE_ID <", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdLessThanOrEqualTo(String value) {
            addCriterion("FILE_SAVE_ID <=", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdLike(String value) {
            addCriterion("FILE_SAVE_ID like", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdNotLike(String value) {
            addCriterion("FILE_SAVE_ID not like", value, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdIn(List<String> values) {
            addCriterion("FILE_SAVE_ID in", values, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdNotIn(List<String> values) {
            addCriterion("FILE_SAVE_ID not in", values, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdBetween(String value1, String value2) {
            addCriterion("FILE_SAVE_ID between", value1, value2, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileSaveIdNotBetween(String value1, String value2) {
            addCriterion("FILE_SAVE_ID not between", value1, value2, "fileSaveId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdIsNull() {
            addCriterion("FILE_TRANSLATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdIsNotNull() {
            addCriterion("FILE_TRANSLATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdEqualTo(String value) {
            addCriterion("FILE_TRANSLATE_ID =", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdNotEqualTo(String value) {
            addCriterion("FILE_TRANSLATE_ID <>", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdGreaterThan(String value) {
            addCriterion("FILE_TRANSLATE_ID >", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TRANSLATE_ID >=", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdLessThan(String value) {
            addCriterion("FILE_TRANSLATE_ID <", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdLessThanOrEqualTo(String value) {
            addCriterion("FILE_TRANSLATE_ID <=", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdLike(String value) {
            addCriterion("FILE_TRANSLATE_ID like", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdNotLike(String value) {
            addCriterion("FILE_TRANSLATE_ID not like", value, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdIn(List<String> values) {
            addCriterion("FILE_TRANSLATE_ID in", values, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdNotIn(List<String> values) {
            addCriterion("FILE_TRANSLATE_ID not in", values, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdBetween(String value1, String value2) {
            addCriterion("FILE_TRANSLATE_ID between", value1, value2, "fileTranslateId");
            return (Criteria) this;
        }

        public Criteria andFileTranslateIdNotBetween(String value1, String value2) {
            addCriterion("FILE_TRANSLATE_ID not between", value1, value2, "fileTranslateId");
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