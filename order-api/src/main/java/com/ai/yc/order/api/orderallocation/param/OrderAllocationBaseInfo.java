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
	 * 用户id
	 */
	private String userId;
	/**
	 * 操作者昵称
	 */
	private String operName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
