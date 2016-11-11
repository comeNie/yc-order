package com.ai.yc.order.api.orderpay.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrderPayProcessedResultResponse extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
