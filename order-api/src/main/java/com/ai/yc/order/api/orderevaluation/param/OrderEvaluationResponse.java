package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseResponse;

public class OrderEvaluationResponse extends BaseResponse implements Serializable {

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
