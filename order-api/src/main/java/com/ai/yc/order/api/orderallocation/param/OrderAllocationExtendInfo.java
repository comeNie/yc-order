package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAllocationExtendInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作类型 分配信息
	 */
	private String operType;
	/**
	 * 译员ID 分配信息
	 */
	private String interperId;
	/**
	 * 译员姓名 分配信息
	 */
	private String interperName;
	/**
	 * 联系方式 分配信息
	 */
	private String tel;
	/**
	 * 译员佣金 分配信息
	 */
	private Long interperFee;
	/**
	 * 分配时间 分配信息
	 */
	private Timestamp creartTime;
	/**
	 * 备注 分配信息
	 */
	private String remark;
	/**
	 * 步骤 1/2/3/4/5
	 */
	private String step;

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

	public String getInterperName() {
		return interperName;
	}

	public void setInterperName(String interperName) {
		this.interperName = interperName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

	public Timestamp getCreartTime() {
		return creartTime;
	}

	public void setCreartTime(Timestamp creartTime) {
		this.creartTime = creartTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

}
