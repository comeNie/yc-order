package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOdProd {
    private Long prodDetalId;

    private Long orderId;

    private String translateType;

    private String translateName;

    private Long meetingSum;

    private String translateSum;

    private String interperGen;

    private String meetingAddress;

    private Long interperSum;

    private String useCode;

    private String fieldCode;

    private String isSetType;

    private String isUrgent;

    private Timestamp stateTime;

    private Timestamp endTime;

    private String prodDetalState;

    private String state;

    private String lookState;

    private Long interperFee;

    private String isInvoice;

    private String updateChlId;

    private String interperId;

    private String updateInterperId;

    private Timestamp updateTime;

    private String typeDesc;

    private String takeDay;

    private String takeTime;

    public Long getProdDetalId() {
        return prodDetalId;
    }

    public void setProdDetalId(Long prodDetalId) {
        this.prodDetalId = prodDetalId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTranslateType() {
        return translateType;
    }

    public void setTranslateType(String translateType) {
        this.translateType = translateType == null ? null : translateType.trim();
    }

    public String getTranslateName() {
        return translateName;
    }

    public void setTranslateName(String translateName) {
        this.translateName = translateName == null ? null : translateName.trim();
    }

    public Long getMeetingSum() {
        return meetingSum;
    }

    public void setMeetingSum(Long meetingSum) {
        this.meetingSum = meetingSum;
    }

    public String getTranslateSum() {
        return translateSum;
    }

    public void setTranslateSum(String translateSum) {
        this.translateSum = translateSum == null ? null : translateSum.trim();
    }

    public String getInterperGen() {
        return interperGen;
    }

    public void setInterperGen(String interperGen) {
        this.interperGen = interperGen == null ? null : interperGen.trim();
    }

    public String getMeetingAddress() {
        return meetingAddress;
    }

    public void setMeetingAddress(String meetingAddress) {
        this.meetingAddress = meetingAddress == null ? null : meetingAddress.trim();
    }

    public Long getInterperSum() {
        return interperSum;
    }

    public void setInterperSum(Long interperSum) {
        this.interperSum = interperSum;
    }

    public String getUseCode() {
        return useCode;
    }

    public void setUseCode(String useCode) {
        this.useCode = useCode == null ? null : useCode.trim();
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    public String getIsSetType() {
        return isSetType;
    }

    public void setIsSetType(String isSetType) {
        this.isSetType = isSetType == null ? null : isSetType.trim();
    }

    public String getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent == null ? null : isUrgent.trim();
    }

    public Timestamp getStateTime() {
        return stateTime;
    }

    public void setStateTime(Timestamp stateTime) {
        this.stateTime = stateTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getProdDetalState() {
        return prodDetalState;
    }

    public void setProdDetalState(String prodDetalState) {
        this.prodDetalState = prodDetalState == null ? null : prodDetalState.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getLookState() {
        return lookState;
    }

    public void setLookState(String lookState) {
        this.lookState = lookState == null ? null : lookState.trim();
    }

    public Long getInterperFee() {
        return interperFee;
    }

    public void setInterperFee(Long interperFee) {
        this.interperFee = interperFee;
    }

    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice == null ? null : isInvoice.trim();
    }

    public String getUpdateChlId() {
        return updateChlId;
    }

    public void setUpdateChlId(String updateChlId) {
        this.updateChlId = updateChlId == null ? null : updateChlId.trim();
    }

    public String getInterperId() {
        return interperId;
    }

    public void setInterperId(String interperId) {
        this.interperId = interperId == null ? null : interperId.trim();
    }

    public String getUpdateInterperId() {
        return updateInterperId;
    }

    public void setUpdateInterperId(String updateInterperId) {
        this.updateInterperId = updateInterperId == null ? null : updateInterperId.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    public String getTakeDay() {
        return takeDay;
    }

    public void setTakeDay(String takeDay) {
        this.takeDay = takeDay == null ? null : takeDay.trim();
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime == null ? null : takeTime.trim();
    }
}