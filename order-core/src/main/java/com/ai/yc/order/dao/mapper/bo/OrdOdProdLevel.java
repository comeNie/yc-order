package com.ai.yc.order.dao.mapper.bo;

public class OrdOdProdLevel {
    private Long prodDetalExtendId;

    private Long prodDetalId;

    private Long orderId;

    private String translateLevel;

    private String infoJson;

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

    public String getTranslateLevel() {
        return translateLevel;
    }

    public void setTranslateLevel(String translateLevel) {
        this.translateLevel = translateLevel == null ? null : translateLevel.trim();
    }

    public String getInfoJson() {
        return infoJson;
    }

    public void setInfoJson(String infoJson) {
        this.infoJson = infoJson == null ? null : infoJson.trim();
    }
}