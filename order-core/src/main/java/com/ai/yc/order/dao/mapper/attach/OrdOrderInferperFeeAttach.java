package com.ai.yc.order.dao.mapper.attach;

import com.ai.opt.base.vo.BaseInfo;

public class OrdOrderInferperFeeAttach extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 一个订单对应的译员总佣金
	 */
	private long interperFee;

	public long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(long interperFee) {
		this.interperFee = interperFee;
	}

}
