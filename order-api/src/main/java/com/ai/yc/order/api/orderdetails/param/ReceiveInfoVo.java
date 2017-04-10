package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReceiveInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 译员id
	 */
	private String interperId;
	/**
	 * 译员名称
	 */
	private String interperName;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 操作类型
	 */
	private String operType;
	/**
	 * 译员佣金
	 */
	private long interperFee;
	/**
	 * 领取时间
	 */
	private Timestamp receiveTime;
	/**
	 * 联系方式
	 */
	private String tel;

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

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(long interperFee) {
		this.interperFee = interperFee;
	}

	public Timestamp getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
