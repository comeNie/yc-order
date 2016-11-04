package com.ai.yc.order.api.orderquery.param;

import com.ai.opt.base.vo.BaseResponse;

public class QueryOrdCountResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单条数
	 */
	private int countNumber;

	public int getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}

}
