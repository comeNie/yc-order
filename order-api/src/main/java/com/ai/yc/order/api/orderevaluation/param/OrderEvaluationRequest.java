package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;

public class OrderEvaluationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单基本信息
	 */
	private OrderEvaluationBaseInfo baseInfo;
	/**
	 * 评价基本信息
	 */
	private OrderEvaluationExtendInfo extendInfo;

	public OrderEvaluationBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(OrderEvaluationBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public OrderEvaluationExtendInfo getExtendInfo() {
		return extendInfo;
	}

	public void setExtendInfo(OrderEvaluationExtendInfo extendInfo) {
		this.extendInfo = extendInfo;
	}
}
