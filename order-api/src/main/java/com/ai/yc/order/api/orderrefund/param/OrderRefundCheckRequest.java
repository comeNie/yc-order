package com.ai.yc.order.api.orderrefund.param;

import java.io.Serializable;

public class OrderRefundCheckRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 前端状态
	 */

	private String displayFlag;
	/**
	 * 操作者ID
	 */
	private String operId;
	/**
	 * 操作者名称
	 */
	private String operName;
	/**
	 * 原因
	 */
	private String reasonDesc;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDisplayFlag() {
		return displayFlag;
	}
	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
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
	public String getReasonDesc() {
		return reasonDesc;
	}
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}
	
}
