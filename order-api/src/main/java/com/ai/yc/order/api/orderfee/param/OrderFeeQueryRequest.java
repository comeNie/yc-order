package com.ai.yc.order.api.orderfee.param;

import java.io.Serializable;

public class OrderFeeQueryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
