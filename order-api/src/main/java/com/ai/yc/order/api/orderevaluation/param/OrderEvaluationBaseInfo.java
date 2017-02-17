package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;

public class OrderEvaluationBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID 订单基础信息
	 */
	private Long orderId;
	/**
	 * 订单状态 订单基础信息
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
