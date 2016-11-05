package com.ai.yc.order.dao.mapper.bo;

public class OrdOdProdExtend {
    private Long prodDetalExtendId;

    private Long prodDetalId;

    private Long orderId;

    private String langungePair;

    private String langungePairName;

    private String infoJson;

    private String langungeNameEn;

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

    public String getLangungePair() {
        return langungePair;
    }

    public void setLangungePair(String langungePair) {
        this.langungePair = langungePair == null ? null : langungePair.trim();
    }

    public String getLangungePairName() {
        return langungePairName;
    }

    public void setLangungePairName(String langungePairName) {
        this.langungePairName = langungePairName == null ? null : langungePairName.trim();
    }

    public String getInfoJson() {
        return infoJson;
    }

    public void setInfoJson(String infoJson) {
        this.infoJson = infoJson == null ? null : infoJson.trim();
    }

    public String getLangungeNameEn() {
        return langungeNameEn;
    }

    public void setLangungeNameEn(String langungeNameEn) {
        this.langungeNameEn = langungeNameEn == null ? null : langungeNameEn.trim();
    }
}