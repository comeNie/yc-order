package com.ai.yc.order.dao.mapper.bo;

public class OrdOdReceiveFollow {
    private Long receiveFollowId;

    private Long orderId;

    private String operType;

    private String step;

    private String receiveState;

    private String finishState;

    public Long getReceiveFollowId() {
        return receiveFollowId;
    }

    public void setReceiveFollowId(Long receiveFollowId) {
        this.receiveFollowId = receiveFollowId;
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

    public String getFinishState() {
        return finishState;
    }

    public void setFinishState(String finishState) {
        this.finishState = finishState == null ? null : finishState.trim();
    }
}