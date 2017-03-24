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
	private OrderAllocationReceiveFollowInfo orderAllocationReceiveFollowInfo;

	/**
	 * 订单分配人员信息
	 */
	private List<OrdAllocationPersonInfo> ordAllocationPersonInfoList;

	public OrderAllocationBaseInfo getOrderAllocationBaseInfo() {
		return orderAllocationBaseInfo;
	}

	public void setOrderAllocationBaseInfo(OrderAllocationBaseInfo orderAllocationBaseInfo) {
		this.orderAllocationBaseInfo = orderAllocationBaseInfo;
	}

	public OrderAllocationReceiveFollowInfo getOrderAllocationReceiveFollowInfo() {
		return orderAllocationReceiveFollowInfo;
	}

	public void setOrderAllocationReceiveFollowInfo(OrderAllocationReceiveFollowInfo orderAllocationReceiveFollowInfo) {
		this.orderAllocationReceiveFollowInfo = orderAllocationReceiveFollowInfo;
	}

	public List<OrdAllocationPersonInfo> getOrdAllocationPersonInfoList() {
		return ordAllocationPersonInfoList;
	}

	public void setOrdAllocationPersonInfoList(List<OrdAllocationPersonInfo> ordAllocationPersonInfoList) {
		this.ordAllocationPersonInfoList = ordAllocationPersonInfoList;
	}

}
