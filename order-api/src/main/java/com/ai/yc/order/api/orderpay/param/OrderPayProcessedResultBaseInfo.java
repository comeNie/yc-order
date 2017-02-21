package com.ai.yc.order.api.orderpay.param;

import java.io.Serializable;

public class OrderPayProcessedResultBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单类型 "订单类型： 1：个人订单 2：企业订单 "
	 */
	private String orderType;

	/**
	 * 用户类型 "10：个人 11：企业 12：代理人 "
	 * 
	 */
	private String userType;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 企业ID
	 */
	private String corporaId;
	/**
	 * 账户ID
	 */
	private Long accountId;
	/**
	 * 订单状态
	 */
	private String state;
	/**
	 * 客户端显示状态
	 */
	private String displayFlag;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCorporaId() {
		return corporaId;
	}

	public void setCorporaId(String corporaId) {
		this.corporaId = corporaId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

}
