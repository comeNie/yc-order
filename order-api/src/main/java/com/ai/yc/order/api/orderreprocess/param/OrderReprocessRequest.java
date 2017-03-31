package com.ai.yc.order.api.orderreprocess.param;

import java.io.Serializable;

public class OrderReprocessRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 产品信息
	 */
	private OrdProductInfo productInfo;
	/**
	 * 基础信息
	 */
	private OrderBaseInfo baseInfo;

	public OrdProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(OrdProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public OrderBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(OrderBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

}
