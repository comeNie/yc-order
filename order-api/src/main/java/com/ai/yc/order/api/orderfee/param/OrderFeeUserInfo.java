package com.ai.yc.order.api.orderfee.param;

import java.io.Serializable;

public class OrderFeeUserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String operId;

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}
}
