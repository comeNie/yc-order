package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAllocationSearchRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 译员ID
	 */
	private String interperId;
	/**
	 * 操作类型
	 */
	private String operType;
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
	 * 开始时间
	 */
	private Timestamp startStateTime;
	/**
	 * 结束时间
	 */
	private Timestamp endStateTime;
	/**
	 * lsp编号
	 */
	private String lspId;
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

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
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

	public String getLspId() {
		return lspId;
	}

	public void setLspId(String lspId) {
		this.lspId = lspId;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

}
