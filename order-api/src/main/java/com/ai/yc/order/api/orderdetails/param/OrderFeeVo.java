package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 费用信息
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:21:33 
 * @version V1.0
 */
public class OrderFeeVo implements Serializable {
	
	private static final long serialVersionUID = 3088846179937025370L;


	/**
	 * 订单ID
	 */
	private Long orderId;
  

    /**
     * 
     * 币种  1：RMB 2：$
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

    /**
     * 平台佣金
     */
    private Long platFee;

    /**
     * 译员佣金
     */
    private Long interperFee;
    
    /**
     * 排版费用
     */
    private Long setTypeFee;
    
    /**
     * 加急费用
     */
    private Long urgentFee;
    
    /**
     * 转换格式费用
     */
    private Long descTypeFee;

    /**
     * 支付方式
     */
    private String payStyle;

    /**
     * 操作工号
     */
    private String updateOperId;
    
    /**
     * 操作工姓名
     */
    private String updateOperName;

    /**
     * 变更时间
     */
    private Timestamp updateTime;

    /**
     * 赠送积分
     */
    private Long totalJf;
    
    /**
     * 支付时间
     */
    private Timestamp payTime;
    
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Long getSetTypeFee() {
		return setTypeFee;
	}

	public void setSetTypeFee(Long setTypeFee) {
		this.setTypeFee = setTypeFee;
	}

	public Long getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Long urgentFee) {
		this.urgentFee = urgentFee;
	}

	public Long getDescTypeFee() {
		return descTypeFee;
	}

	public void setDescTypeFee(Long descTypeFee) {
		this.descTypeFee = descTypeFee;
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public String getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getTotalJf() {
		return totalJf;
	}

	public void setTotalJf(Long totalJf) {
		this.totalJf = totalJf;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

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

	public String getUpdateOperName() {
		return updateOperName;
	}

	public void setUpdateOperName(String updateOperName) {
		this.updateOperName = updateOperName;
	}
    
    


}
