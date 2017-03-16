package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;

public class OrdAllocationePersonRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 领取状态
	 */
	private String receiveState;
	/**
	 * 译员id
	 */
	private String interperId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
	}

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

}
