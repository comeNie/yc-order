package com.ai.yc.order.api.updateorder.param;

import java.io.Serializable;

/**
 * @Description: 费用信息
 * @author hougang@asiainfo.com
 * @date 2016年11月5日 上午9:21:33 
 * @version V1.0
 */
public class UOrderFeeVo implements Serializable {
	
	private static final long serialVersionUID = 3088846179937025370L;


    /**
     * 
     * 币种  1：RMB 2：$ (必填)
     */
    private String currencyUnit;

    /**
     * 总费用(必填)
     */
    private Long totalFee;

    /**
     * 总优惠金额(必填)
     */
    private Long discountFee;

    /**
     * 减免费用(必填)
     */
    private Long operDiscountFee;
    
    /**
     * 减免原因
     */
    private String operDiscountDesc;

    /**
     * 总应收费用(必填)
     */
    private Long adjustFee;

    /**
     * 总实收费用(必填)
     */
    private Long paidFee;

    /**
     * 总待收费用(必填)
     */
    private Long payFee;
    
    /**
     * 排版费用(必填)
     */
    private Long setTypeFee;
    
    /**
     * 加急费用(必填)
     */
    private Long urgentFee;
    
    /**
     * 转换格式费用(必填)
     */
    private Long descTypeFee;

    /**
     * 支付方式
     */
    private String payStyle;

    /**
     * 操作工号(必填)
     */
    private String updateOperId;
    
    /**
     * 备注
     */
    private String remark;
    
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public Long getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Long discountFee) {
		this.discountFee = discountFee;
	}

	public Long getOperDiscountFee() {
		return operDiscountFee;
	}

	public void setOperDiscountFee(Long operDiscountFee) {
		this.operDiscountFee = operDiscountFee;
	}

	public Long getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(Long adjustFee) {
		this.adjustFee = adjustFee;
	}

	public Long getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(Long paidFee) {
		this.paidFee = paidFee;
	}

	public Long getPayFee() {
		return payFee;
	}

	public void setPayFee(Long payFee) {
		this.payFee = payFee;
	}

	
	public Long getSetTypeFee() {
		return setTypeFee;
	}

	public void setSetTypeFee(Long setTypeFee) {
		this.setTypeFee = setTypeFee;
	}

	

	public Long getUrgentFee() {
		return urgentFee;
	}

	public void setUrgentFee(Long urgentFee) {
		this.urgentFee = urgentFee;
	}

	public Long getDescTypeFee() {
		return descTypeFee;
	}

	public void setDescTypeFee(Long descTypeFee) {
		this.descTypeFee = descTypeFee;
	}

	public String getPayStyle() {
		return payStyle;
	}

	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	public String getUpdateOperId() {
		return updateOperId;
	}

	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
	}

	public String getOperDiscountDesc() {
		return operDiscountDesc;
	}

	public void setOperDiscountDesc(String operDiscountDesc) {
		this.operDiscountDesc = operDiscountDesc;
	}

	

}
