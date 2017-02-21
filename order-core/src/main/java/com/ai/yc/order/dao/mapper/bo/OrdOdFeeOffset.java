package com.ai.yc.order.dao.mapper.bo;

public class OrdOdFeeOffset {
    private Long feeOffsetId;

    private Long balacneIfId;

    private Long orderId;

    private Long prodDetalId;

    private String currencyUnit;

    private Long offsetFee;

    private String remark;

    public Long getFeeOffsetId() {
        return feeOffsetId;
    }

    public void setFeeOffsetId(Long feeOffsetId) {
        this.feeOffsetId = feeOffsetId;
    }

    public Long getBalacneIfId() {
        return balacneIfId;
    }

    public void setBalacneIfId(Long balacneIfId) {
        this.balacneIfId = balacneIfId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProdDetalId() {
        return prodDetalId;
    }

    public void setProdDetalId(Long prodDetalId) {
        this.prodDetalId = prodDetalId;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit == null ? null : currencyUnit.trim();
    }

    public Long getOffsetFee() {
        return offsetFee;
    }

    public void setOffsetFee(Long offsetFee) {
        this.offsetFee = offsetFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}