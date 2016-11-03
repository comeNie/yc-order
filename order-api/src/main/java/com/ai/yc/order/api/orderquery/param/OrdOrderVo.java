package com.ai.yc.order.api.orderquery.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class OrdOrderVo extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 账号ID
	 */
	private Long acountId;
	/**
	 * 订单来源
	 */
	private String chlId;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 业务类型
	 */
	private String busiType;
	/**
	 * 订单级别
	 */
	private String orderLevel;
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 企业ID
	 */
	private String corporaId;
	/**
	 * 下单时间
	 */
	private Timestamp orderTime;
	/**
	 * 客户端显示状态
	 */
	private String displayFlag;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 语言对ID
	 */
	private String langungePair;
	/**
	 * 语言对名称
	 */
	private String langungePairName;
	/**
	 * 翻译主题
	 */
	private String translateName;
	/**
	 * 币种
	 */
	private String currencyUnit;
	/**
	 * 总费用
	 */
	private Long totalFee;
	/**
	 * 总优惠金额
	 */
	private Long discountFee;

	/**
	 * 减免费用
	 */
	private Long operDiscountFee;

	/**
	 * 总应收费用
	 */
	private Long adjustFee;

	/**
	 * 总实收费用
	 */
	private Long paidFee;

	/**
	 * 总待收费用
	 */
	private Long payFee;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getAcountId() {
		return acountId;
	}

	public void setAcountId(Long acountId) {
		this.acountId = acountId;
	}

	public String getChlId() {
		return chlId;
	}

	public void setChlId(String chlId) {
		this.chlId = chlId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getLangungePair() {
		return langungePair;
	}

	public void setLangungePair(String langungePair) {
		this.langungePair = langungePair;
	}

	public String getLangungePairName() {
		return langungePairName;
	}

	public void setLangungePairName(String langungePairName) {
		this.langungePairName = langungePairName;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public Long getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	public Long getOperDiscountFee() {
		return operDiscountFee;
	}

	public void setOperDiscountFee(Long operDiscountFee) {
		this.operDiscountFee = operDiscountFee;
	}

	public Long getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(Long adjustFee) {
		this.adjustFee = adjustFee;
	}

	public Long getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Long paidFee) {
		this.paidFee = paidFee;
	}

	public Long getPayFee() {
		return payFee;
	}

	public void setPayFee(Long payFee) {
		this.payFee = payFee;
	}

}
