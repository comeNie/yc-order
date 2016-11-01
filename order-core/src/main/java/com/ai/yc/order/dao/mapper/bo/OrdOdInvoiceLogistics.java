package com.ai.yc.order.dao.mapper.bo;

public class OrdOdInvoiceLogistics {
    private Long logisticsId;

    private String invoiceInfoId;

    private Long orderId;

    private String contactCompany;

    private String contactName;

    private String contactTel;

    private String contactEmail;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String postcode;

    private String areaCode;

    private String expressOddBigint;

    private String expressId;

    private String logisticsTimeId;

    private String remark;

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getInvoiceInfoId() {
        return invoiceInfoId;
    }

    public void setInvoiceInfoId(String invoiceInfoId) {
        this.invoiceInfoId = invoiceInfoId == null ? null : invoiceInfoId.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getContactCompany() {
        return contactCompany;
    }

    public void setContactCompany(String contactCompany) {
        this.contactCompany = contactCompany == null ? null : contactCompany.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getExpressOddBigint() {
        return expressOddBigint;
    }

    public void setExpressOddBigint(String expressOddBigint) {
        this.expressOddBigint = expressOddBigint == null ? null : expressOddBigint.trim();
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    public String getLogisticsTimeId() {
        return logisticsTimeId;
    }

    public void setLogisticsTimeId(String logisticsTimeId) {
        this.logisticsTimeId = logisticsTimeId == null ? null : logisticsTimeId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}