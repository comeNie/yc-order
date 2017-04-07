package com.ai.yc.order.api.orderreceive.param;

import java.io.Serializable;

public class OrderAlloReceiveRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 译员id
	 */
	private String interperId;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 操作人姓名
	 */
	private String operName;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getInterperId() {
		return interperId;
	}
	public void setInterperId(String interperId) {
		this.interperId = interperId;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}

	

}
