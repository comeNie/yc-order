package com.ai.yc.order.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOdReceive {
    private Long id;

    private Long personId;

    private Long receiveFollowId;

    private String interperId;

    private String interperName;

    private Long interperFee;

    private String tel;

    private Timestamp receiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getReceiveFollowId() {
        return receiveFollowId;
    }

    public void setReceiveFollowId(Long receiveFollowId) {
        this.receiveFollowId = receiveFollowId;
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

    public Long getInterperFee() {
        return interperFee;
    }

    public void setInterperFee(Long interperFee) {
        this.interperFee = interperFee;
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
}