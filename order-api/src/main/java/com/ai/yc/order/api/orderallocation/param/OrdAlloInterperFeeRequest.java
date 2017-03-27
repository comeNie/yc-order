package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;

public class OrdAlloInterperFeeRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	

}
