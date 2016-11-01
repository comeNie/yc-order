package com.ai.yc.order.dao.mapper.bo;

public class OrdOdProdExtend {
    private Long prodDetalExtendId;

    private Long prodDetalId;

    private Long orderId;

    private String infoJson;

    private String batchFlag;

    public Long getProdDetalExtendId() {
        return prodDetalExtendId;
    }

    public void setProdDetalExtendId(Long prodDetalExtendId) {
        this.prodDetalExtendId = prodDetalExtendId;
    }

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

    public String getInfoJson() {
        return infoJson;
    }

    public void setInfoJson(String infoJson) {
        this.infoJson = infoJson == null ? null : infoJson.trim();
    }

    public String getBatchFlag() {
        return batchFlag;
    }

    public void setBatchFlag(String batchFlag) {
        this.batchFlag = batchFlag == null ? null : batchFlag.trim();
    }
}