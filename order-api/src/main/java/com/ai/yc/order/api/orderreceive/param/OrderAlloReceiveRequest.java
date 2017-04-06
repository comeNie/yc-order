package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;

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
	 * 操作人id
	 */
	private String operId;
	/**
	 * 操作人姓名
	 */
	private String operName;
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
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
