package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.util.List;

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
	private List<OrderAllocationExtendInfo> orderAllocationExtendInfoList;

	public OrderAllocationBaseInfo getOrderAllocationBaseInfo() {
		return orderAllocationBaseInfo;
	}

	public void setOrderAllocationBaseInfo(OrderAllocationBaseInfo orderAllocationBaseInfo) {
		this.orderAllocationBaseInfo = orderAllocationBaseInfo;
	}

	public List<OrderAllocationExtendInfo> getOrderAllocationExtendInfoList() {
		return orderAllocationExtendInfoList;
	}

	public void setOrderAllocationExtendInfoList(List<OrderAllocationExtendInfo> orderAllocationExtendInfoList) {
		this.orderAllocationExtendInfoList = orderAllocationExtendInfoList;
	}

}
