package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;

public class OrderAllocationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单基本信息
	 */
	private OrderAllocationBaseInfo orderAllocationBaseInfo;
	/**
	 * 订单分配信息
	 */
	private OrderAllocationExtendInfo orderAllocationExtendInfo;

	public OrderAllocationBaseInfo getOrderAllocationBaseInfo() {
		return orderAllocationBaseInfo;
	}

	public void setOrderAllocationBaseInfo(OrderAllocationBaseInfo orderAllocationBaseInfo) {
		this.orderAllocationBaseInfo = orderAllocationBaseInfo;
	}

	public OrderAllocationExtendInfo getOrderAllocationExtendInfo() {
		return orderAllocationExtendInfo;
	}

	public void setOrderAllocationExtendInfo(OrderAllocationExtendInfo orderAllocationExtendInfo) {
		this.orderAllocationExtendInfo = orderAllocationExtendInfo;
	}
}
