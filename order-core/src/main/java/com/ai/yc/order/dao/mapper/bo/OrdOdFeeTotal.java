package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOdFeeTotal {
    private Long orderId;

    private String payFlag;

    private String currencyUnit;

    private Long totalFee;

    private Long discountFee;

    private Long operDiscountFee;

    private String operDiscountDesc;

    private Long adjustFee;

    private Long paidFee;

    private Long payFee;

    private Long platFee;

    private Long interperFee;

    private String payStyle;

    private String updateOperId;

    private Timestamp updateTime;

    private String updateChlId;

    private Long totalJf;

    private Timestamp payTime;

    private Long setTypeFee;

    private Long urgentFee;

    private Long descTypeFee;

    private String remark;

    private String discountSum;

    private Long couponFee;

    private Long jfCouponFee;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag == null ? null : payFlag.trim();
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
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
        this.operDiscountDesc = operDiscountDesc == null ? null : operDiscountDesc.trim();
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

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle == null ? null : payStyle.trim();
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId == null ? null : updateChlId.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(String discountSum) {
        this.discountSum = discountSum == null ? null : discountSum.trim();
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
}