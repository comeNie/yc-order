package com.ai.yc.order.api.orderpay.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderPayProcessedResultProdInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 开始时间 状态时间
	 */
	private Timestamp stateTime;

	public Timestamp getStateTime() {
		return stateTime;
	}

	public void setStateTime(Timestamp stateTime) {
		this.stateTime = stateTime;
	}

}
