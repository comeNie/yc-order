package com.ai.yc.order.api.orderpay.param;

import java.io.Serializable;

public class OrderPayProcessedResultStateChgInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 操作者名称，前台登录的用户名
	 */
	private String operName;

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

}
