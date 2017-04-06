package com.ai.yc.order.api.orderallocation.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrdAllocationCountResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;
	/**
	 * 订单数量
	 */
	private int orderCount;
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

}
