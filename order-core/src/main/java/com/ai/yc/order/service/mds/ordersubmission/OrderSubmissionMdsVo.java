package com.ai.yc.order.service.mds.ordersubmission;

import com.ai.yc.order.api.ordersubmission.param.OrderSubmissionRequest;

public class OrderSubmissionMdsVo {
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderSubmissionRequest getOrderSubmissionRequest() {
		return orderSubmissionRequest;
	}

	public void setOrderSubmissionRequest(OrderSubmissionRequest orderSubmissionRequest) {
		this.orderSubmissionRequest = orderSubmissionRequest;
	}

	private OrderSubmissionRequest orderSubmissionRequest;
}
