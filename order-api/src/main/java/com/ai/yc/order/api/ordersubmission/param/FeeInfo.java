package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;
/**
 * 订单下单费用信息
 * @author zhangzd
 *
 */
public class FeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  币种
	 *  "1：RMB
		2：$"
	 */
	private String currencyUnit;// CURRENCY_UNIT
	/**
	 *  总费用
	 *  单位厘
	 */
	private Long totalFee;// TOTAL_FEE;
	/**
	 *  总优惠金额 一期不需要此字段
	 *  单位厘
	 */
	private Long discountFee;// DISCOUNT_FEE
	/**
	 * 总减免费用 一期不需要此字段
	 * 单位厘
	 */
	private Long operDiscountFee;// OPER_DISCOUNT_FEE
	/**
	 *  减免原因
	 */
	private String operDiscountDesc;// OPER_DISCOUNT_DESC
	/**
	 *  总应收费用
	 *  单位厘
	 */
	private Long adjustFee;// ADJUST_FEE
	/**
	 *  总实收费用
	 *  单位厘
	 */
	private Long paidFee;// PAID_FEE
	// 总已收费用
	/**
	 *  赠送积分
	 */
	private Long totalJf;// TOTAL_JF

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

	public Long getTotalJf() {
		return totalJf;
	}

	public void setTotalJf(Long totalJf) {
		this.totalJf = totalJf;
	}

}
