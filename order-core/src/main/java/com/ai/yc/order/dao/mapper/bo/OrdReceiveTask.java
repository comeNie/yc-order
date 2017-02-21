package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdReceiveTask {
    private Long id;

    private Long orderId;

    private Long personId;

    private String operType;

    private String interperId;

    private String interperName;

    private String tel;

    private Timestamp receiveTime;

    private String step;

    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}