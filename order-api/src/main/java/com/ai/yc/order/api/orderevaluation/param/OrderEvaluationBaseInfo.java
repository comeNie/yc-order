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
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 操作者昵称
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
}
