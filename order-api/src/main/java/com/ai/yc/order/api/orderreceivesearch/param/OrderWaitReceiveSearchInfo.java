package com.ai.yc.order.api.orderreceivesearch.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderWaitReceiveSearchInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 业务标识
	 */
	private String flag;
	/**
	 * 订单级别
	 */
	private String orderLevel;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 翻译主题
	 */
	private String translateName;
	/**
	 * 语言对ID
	 */
	private String languagePair;// LANGUNGE_PAIR;
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
	 * 支付时间
	 */
	private Timestamp payTime;
	/**
	 * 需耗天
	 */
	private String takeDay;
	/**
	 * 需耗时
	 */
	private String takeTime;
	
	/**
	 *  币种
	 *  "1：RMB
		2：$"
	 */
	private String currencyUnit;// CURRENCY_UNIT

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
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

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public String getTakeDay() {
		return takeDay;
	}

	public void setTakeDay(String takeDay) {
		this.takeDay = takeDay;
	}

	public String getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

}
