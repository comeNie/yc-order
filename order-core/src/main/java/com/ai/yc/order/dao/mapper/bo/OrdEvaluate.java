package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdEvaluate {
    private Long evaluateId;

    private Long orderId;

    private Long serveQuality;

    private Long serveSpeen;

    private Long serveManner;

    private String evaluateContent;

    private String state;

    private Timestamp evaluateTime;

    private String remark;

    private String evaluateSun;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getServeQuality() {
        return serveQuality;
    }

    public void setServeQuality(Long serveQuality) {
        this.serveQuality = serveQuality;
    }

    public Long getServeSpeen() {
        return serveSpeen;
    }

    public void setServeSpeen(Long serveSpeen) {
        this.serveSpeen = serveSpeen;
    }

    public Long getServeManner() {
        return serveManner;
    }

    public void setServeManner(Long serveManner) {
        this.serveManner = serveManner;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Timestamp getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Timestamp evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEvaluateSun() {
        return evaluateSun;
    }

    public void setEvaluateSun(String evaluateSun) {
        this.evaluateSun = evaluateSun == null ? null : evaluateSun.trim();
    }
}