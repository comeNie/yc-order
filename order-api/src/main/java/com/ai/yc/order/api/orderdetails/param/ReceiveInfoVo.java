package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;

public class ReceiveInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 译员id
	 */
	private String interperId;

	public String getInterperId() {
		return interperId;
	}

	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}

}
