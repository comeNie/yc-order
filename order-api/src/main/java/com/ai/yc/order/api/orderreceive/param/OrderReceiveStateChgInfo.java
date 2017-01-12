package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;

public class OrderReceiveStateChgInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 操作者名称，下单的时候前台登录的用户名
	 */
	private String operName;

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

}
