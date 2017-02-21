package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;


public class OrderReceiveRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 订单基本信息
	 */
	private OrderReceiveBaseInfo baseInfo;
	/**
	 * 订单费用信息
	 */
	private OrderReceiveFeeInfo feeInfo;
	/**
	 * 轨迹信息,目前包括operName属性，需要前台登录用户传递
	 */
	private OrderReceiveStateChgInfo stateChgInfo;
	public OrderReceiveBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(OrderReceiveBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public OrderReceiveFeeInfo getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(OrderReceiveFeeInfo feeInfo) {
		this.feeInfo = feeInfo;
	}

	public OrderReceiveStateChgInfo getStateChgInfo() {
		return stateChgInfo;
	}

	public void setStateChgInfo(OrderReceiveStateChgInfo stateChgInfo) {
		this.stateChgInfo = stateChgInfo;
	}

}
