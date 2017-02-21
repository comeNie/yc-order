package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOdPersonInfo {
    private Long personId;

    private Long orderId;

    private String operType;

    private String interperId;

    private String interperName;

    private String tel;

    private Long interperFee;

    private Timestamp creartTime;

    private String remark;

    private String step;

    private String receiveState;

    private Timestamp expectEndTime;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getInterperId() {
        return interperId;
    }

    public void setInterperId(String interperId) {
        this.interperId = interperId == null ? null : interperId.trim();
    }

    public String getInterperName() {
        return interperName;
    }

    public void setInterperName(String interperName) {
        this.interperName = interperName == null ? null : interperName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Long getInterperFee() {
        return interperFee;
    }

    public void setInterperFee(Long interperFee) {
        this.interperFee = interperFee;
    }

    public Timestamp getCreartTime() {
        return creartTime;
    }

    public void setCreartTime(Timestamp creartTime) {
        this.creartTime = creartTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(String receiveState) {
        this.receiveState = receiveState == null ? null : receiveState.trim();
    }

    public Timestamp getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Timestamp expectEndTime) {
        this.expectEndTime = expectEndTime;
    }
}