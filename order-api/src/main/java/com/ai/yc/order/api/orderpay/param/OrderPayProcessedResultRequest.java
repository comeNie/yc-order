package com.ai.yc.order.api.orderpay.param;

import java.io.Serializable;

public class OrderPayProcessedResultRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 基本信息
	 */
	private OrderPayProcessedResultBaseInfo baseInfo;
	/**
	 * 费用信息
	 */
	private OrderPayProcessedResultFeeInfo feeInfo;
	/**
	 * 产品信息
	 */
	private OrderPayProcessedResultProdInfo prodInfo;
	/**
	 * 用户信息
	 */
	private OrderPayProcessedResultStateChgInfo stateChgInfo;

	public OrderPayProcessedResultBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(OrderPayProcessedResultBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public OrderPayProcessedResultFeeInfo getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(OrderPayProcessedResultFeeInfo feeInfo) {
		this.feeInfo = feeInfo;
	}

	public OrderPayProcessedResultProdInfo getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(OrderPayProcessedResultProdInfo prodInfo) {
		this.prodInfo = prodInfo;
	}

	public OrderPayProcessedResultStateChgInfo getStateChgInfo() {
		return stateChgInfo;
	}

	public void setStateChgInfo(OrderPayProcessedResultStateChgInfo stateChgInfo) {
		this.stateChgInfo = stateChgInfo;
	}

}
