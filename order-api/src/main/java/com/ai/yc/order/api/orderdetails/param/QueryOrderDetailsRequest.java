package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;

public class QueryOrderDetailsRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long orderId;
	private String chgStateFlag;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getChgStateFlag() {
		return chgStateFlag;
	}

	public void setChgStateFlag(String chgStateFlag) {
		this.chgStateFlag = chgStateFlag;
	}
}
