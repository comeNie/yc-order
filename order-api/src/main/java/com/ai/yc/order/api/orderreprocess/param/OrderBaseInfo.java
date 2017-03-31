package com.ai.yc.order.api.orderreprocess.param;

public class OrderBaseInfo {
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 修改原因
	 */
	private String reasonDesc;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
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
