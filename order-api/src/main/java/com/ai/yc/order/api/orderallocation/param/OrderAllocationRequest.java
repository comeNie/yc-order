package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.util.List;

public class OrderAllocationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单基本信息
	 */
	private OrderAllocationBaseInfo orderAllocationBaseInfo;
	/**
	 * 任务跟踪信息
	 */
	private List<OrderAllocationReceiveFollowInfo> orderAllocationReceiveFollowList;

	public OrderAllocationBaseInfo getOrderAllocationBaseInfo() {
		return orderAllocationBaseInfo;
	}

	public void setOrderAllocationBaseInfo(OrderAllocationBaseInfo orderAllocationBaseInfo) {
		this.orderAllocationBaseInfo = orderAllocationBaseInfo;
	}

	public List<OrderAllocationReceiveFollowInfo> getOrderAllocationReceiveFollowList() {
		return orderAllocationReceiveFollowList;
	}

	public void setOrderAllocationReceiveFollowList(
			List<OrderAllocationReceiveFollowInfo> orderAllocationReceiveFollowList) {
		this.orderAllocationReceiveFollowList = orderAllocationReceiveFollowList;
	}

}
