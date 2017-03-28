package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderAlloReceiveRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */

	private Long orderId;
	/**
	 * 人员信息id
	 */
	private Long personId;
	/**
	 * 操作类型
	 */
	private String operType;
	/**
	 * 译员id
	 */
	private String interperId;
	/**
	 * 译员名称
	 */
	private String interperName;
	/**
	 * 联系方式
	 */
	private String tel;
	/**
	 * 领取时间
	 */
	private Timestamp receiveTime;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 译员佣金
	 */
	private Long interperFee;
	/**
	 * 操作人id
	 */
	private String operId;
	/**
	 * 操作人姓名
	 */
	private String operName;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

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

	public Timestamp getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

}
