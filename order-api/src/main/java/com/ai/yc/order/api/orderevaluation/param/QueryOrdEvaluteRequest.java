package com.ai.yc.order.api.orderevaluation.param;

import com.ai.opt.base.vo.BaseInfo;

public class QueryOrdEvaluteRequest extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	

}
