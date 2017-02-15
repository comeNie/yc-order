package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;

public class OrderAllocationBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单状态
	 */
	private String state;

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

}
