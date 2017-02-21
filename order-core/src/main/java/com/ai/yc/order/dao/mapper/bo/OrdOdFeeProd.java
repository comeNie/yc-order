package com.ai.yc.order.dao.mapper.bo;

public class OrdOdFeeProd {
    private Long feeProdId;

    private Long orderId;

    private String payStyle;

    private Long paidFee;

    private Long couponFee;

    public Long getFeeProdId() {
        return feeProdId;
    }

    public void setFeeProdId(Long feeProdId) {
        this.feeProdId = feeProdId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(String payStyle) {
        this.payStyle = payStyle == null ? null : payStyle.trim();
    }

    public Long getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(Long paidFee) {
        this.paidFee = paidFee;
    }

    public Long getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Long couponFee) {
        this.couponFee = couponFee;
    }
}