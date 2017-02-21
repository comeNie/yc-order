package com.ai.yc.order.dao.mapper.bo;

public class OrdOdProdWithBLOBs extends OrdOdProd {
    private String needTranslateInfo;

    private String translateInfo;

    public String getNeedTranslateInfo() {
        return needTranslateInfo;
    }

    public void setNeedTranslateInfo(String needTranslateInfo) {
        this.needTranslateInfo = needTranslateInfo == null ? null : needTranslateInfo.trim();
    }

    public String getTranslateInfo() {
        return translateInfo;
    }

    public void setTranslateInfo(String translateInfo) {
        this.translateInfo = translateInfo == null ? null : translateInfo.trim();
    }
}