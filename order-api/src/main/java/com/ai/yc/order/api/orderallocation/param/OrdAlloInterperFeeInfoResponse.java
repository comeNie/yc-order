package com.ai.yc.order.api.orderallocation.param;

import com.ai.opt.base.vo.BaseResponse;

public class OrdAlloInterperFeeInfoResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单对应的译员佣金总和
	 */
	private long interperFee;

	public long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(long interperFee) {
		this.interperFee = interperFee;
	}
	

}
