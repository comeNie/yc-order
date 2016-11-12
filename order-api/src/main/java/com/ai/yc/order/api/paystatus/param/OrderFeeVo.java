package com.ai.yc.order.api.paystatus.param;

import java.io.Serializable;

/**
 * @Description: 费用信息
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:21:33 
 * @version V1.0
 */
public class OrderFeeVo implements Serializable {
	
	private static final long serialVersionUID = 3088846179937025370L;


    /**
     * 
     * 币种  1：RMB 2：$ (必填)
     */
    private String currencyUnit;

    /**
     * 总费用  单位厘 (必填)
     */
    private Long totalFee;

    /**
     * 总优惠金额  单位厘 (必填)
     */
    private Long discountFee;

    /**
     * 减免费用  单位厘(必填)
     */
    private Long operDiscountFee;

    /**
     * 总应收费用  单位厘(必填)
     */
    private Long adjustFee;

    /**
     * 总实收费用  单位厘(必填)
     */
    private Long paidFee;

    /**
     * 总待收费用  单位厘(必填)
     */
    private Long payFee;

    /**
     * 支付方式 (必填)
     * 0：余额
     *1：支付宝
     *2：网银
     *3：pay pal
     *5：后付
     *6：积分
     *7：优惠劵
     *11：银行汇款/转账
     */
    private String payStyle;
    
    /**
     * 支付备注(必填)
     */
    private String remark;
    
    /**
     * 订单折扣
     */
    private String discountSum;

    /**
     * 优惠券抵扣金额
     */
    private Long couponFee;

    /**
     * 积分抵扣金额
     */
    private Long jfCouponFee;
    
    


	public String getDiscountSum() {
		return discountSum;
	}

	public void setDiscountSum(String discountSum) {
		this.discountSum = discountSum;
	}

	public Long getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Long couponFee) {
		this.couponFee = couponFee;
	}

	public Long getJfCouponFee() {
		return jfCouponFee;
	}

	public void setJfCouponFee(Long jfCouponFee) {
		this.jfCouponFee = jfCouponFee;
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

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
