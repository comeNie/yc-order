package com.ai.yc.order.api.orderfee.param;

import java.io.Serializable;

public class OrderFeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 支付方式
	 */
	private String payStyle;
	/**
	 * 币种
	 */
	private String currencyUnit;
	/**
	 * 总费用
	 */
	private Long totalFee;// TOTAL_FEE;
	/**
	 * 总优惠金额 一期不需要此字段 单位厘
	 */
	private Long discountFee;// DISCOUNT_FEE
	/**
	 * 总减免费用 一期不需要此字段 单位厘
	 */
	private Long operDiscountFee;// OPER_DISCOUNT_FEE
	/**
	 * 减免原因
	 */
	private String operDiscountDesc;// OPER_DISCOUNT_DESC
	/**
	 * 总应收费用 单位厘
	 */
	private Long adjustFee;// ADJUST_FEE
	/**
	 * 总实收费用 单位厘
	 */
	private Long paidFee;// PAID_FEE
	// 总待收费用

	/**
	 * 平台佣金
	 */
	private Long platFee;
	/**
	 * 译员佣金
	 */
	private Long interperFee;

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
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

	public String getOperDiscountDesc() {
		return operDiscountDesc;
	}

	public void setOperDiscountDesc(String operDiscountDesc) {
		this.operDiscountDesc = operDiscountDesc;
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

	public Long getPlatFee() {
		return platFee;
	}

	public void setPlatFee(Long platFee) {
		this.platFee = platFee;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

}
