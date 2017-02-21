package com.ai.yc.order.api.orderlevel.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrderLevelResponse extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderLevel;

	public String getOrderLevel() {
		return orderLevel;
	}

	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}

}
