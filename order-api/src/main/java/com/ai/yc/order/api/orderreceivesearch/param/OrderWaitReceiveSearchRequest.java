package com.ai.yc.order.api.orderreceivesearch.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class OrderWaitReceiveSearchRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 业务标识
	 */
	private String flag;
	/**
	 * 译员等级
	 */
	private String interperLevel;
	/**
	 * 译员类型
	 */
	private String interperType;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 订单状态
	 */
	private String state;
	/**
	 * 语言对ID
	 */
	private List<Object> languageIds;
	/**
	 * 用途ID
	 */
	private String useCode;
	/**
	 * 领域ID
	 */
	private String fieldCode;
	/**
	 * 订单主题
	 */
	private String translateName;
	/**
	 * 开始时间(es_end_time)
	 */
	private Timestamp startStateTime;
	/**
	 * 结束时间(es_end_time)
	 */
	private Timestamp endStateTime;
	// 是否分页
	// 请求查询页码
	// 每页显示条数
	/**
	 * 升降序标记
	 */
	private String sortFlag;
	/**
	 * 升降序字段
	 */
	private String sortField;
	/**
	 * 页码，必填
	 */
	private Integer pageNo;

	/**
	 * 每页大小，必填
	 */
	private Integer pageSize;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getInterperLevel() {
		return interperLevel;
	}

	public void setInterperLevel(String interperLevel) {
		this.interperLevel = interperLevel;
	}

	public String getInterperType() {
		return interperType;
	}

	public void setInterperType(String interperType) {
		this.interperType = interperType;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUseCode() {
		return useCode;
	}

	public void setUseCode(String useCode) {
		this.useCode = useCode;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public Timestamp getStartStateTime() {
		return startStateTime;
	}

	public void setStartStateTime(Timestamp startStateTime) {
		this.startStateTime = startStateTime;
	}

	public Timestamp getEndStateTime() {
		return endStateTime;
	}

	public void setEndStateTime(Timestamp endStateTime) {
		this.endStateTime = endStateTime;
	}

	public String getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(String sortFlag) {
		this.sortFlag = sortFlag;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<Object> getLanguageIds() {
		return languageIds;
	}

	public void setLanguageIds(List<Object> languageIds) {
		this.languageIds = languageIds;
	}

}
