package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAllocationSearchInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 翻译主题
	 */
	private String translateName;
	/**
	 * 操作类型(阶段)
	 */
	private String operType;
	/**
	 * 语言对ID
	 */
	private String languagePair;
	/**
	 * 语言对中文名称
	 */
	private String languagePairName;
	/**
	 * 语言对英文名称
	 */
	private String languageNameEn;
	/**
	 * 下单时间
	 */
	private Timestamp orderTime;
	/**
	 * 订单金额
	 */
	private Long totalFee;
	/**
	 * 币种 "1：RMB 2：$"
	 */
	private String currencyUnit;
	/**
	 * 剩余时间
	 */
	private Timestamp esEndTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getLanguagePair() {
		return languagePair;
	}

	public void setLanguagePair(String languagePair) {
		this.languagePair = languagePair;
	}

	public String getLanguagePairName() {
		return languagePairName;
	}

	public void setLanguagePairName(String languagePairName) {
		this.languagePairName = languagePairName;
	}

	public String getLanguageNameEn() {
		return languageNameEn;
	}

	public void setLanguageNameEn(String languageNameEn) {
		this.languageNameEn = languageNameEn;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Timestamp getEsEndTime() {
		return esEndTime;
	}

	public void setEsEndTime(Timestamp esEndTime) {
		this.esEndTime = esEndTime;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

}
