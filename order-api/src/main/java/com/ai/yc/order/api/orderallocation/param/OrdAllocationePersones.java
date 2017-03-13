package com.ai.yc.order.api.orderallocation.param;

public class OrdAllocationePersones {
	/**
	 * 订单id
	 */
	private Long orderId;
	
	/**
	 * 译员佣金
	 */
	private Long interperFee;
	/**
	 * 步骤
	 */
	private String step;
	/**
	 * 操作类型
	 */
	private String operType;

	

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getInterperFee() {
		return interperFee;
	}

	public void setInterperFee(Long interperFee) {
		this.interperFee = interperFee;
	}

}
