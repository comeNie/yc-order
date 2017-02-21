package com.ai.yc.order.api.orderallocation.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrderAllocationResponse extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单编号
	 */
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
