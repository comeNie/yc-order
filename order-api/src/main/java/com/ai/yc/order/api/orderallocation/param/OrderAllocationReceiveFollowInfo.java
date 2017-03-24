package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;

public class OrderAllocationReceiveFollowInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 操作类型 分配信息
	 */
	private String operType;

	/**
	 * 步骤 1/2/3/4/5
	 */
	private String step;
	/**
	 * 领取状态 0-未领取 1-已领取
	 */
	private String receiveState;
	/**
	 * 完成状态0：未开始1：进行中2：已完成
	 */
	private String finishState;

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
	}

	public String getFinishState() {
		return finishState;
	}

	public void setFinishState(String finishState) {
		this.finishState = finishState;
	}

}
