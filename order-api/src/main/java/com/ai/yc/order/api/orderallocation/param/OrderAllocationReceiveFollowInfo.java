package com.ai.yc.order.api.orderallocation.param;

import java.io.Serializable;
import java.util.List;

public class OrderAllocationReceiveFollowInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 任务跟踪id用于修改时判断使用
	 */
	private Long followId;
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
	/**
	 * 订单分配人员信息
	 */
	private List<OrdAllocationPersonInfo> ordAllocationPersonInfoList;

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

	public List<OrdAllocationPersonInfo> getOrdAllocationPersonInfoList() {
		return ordAllocationPersonInfoList;
	}

	public void setOrdAllocationPersonInfoList(List<OrdAllocationPersonInfo> ordAllocationPersonInfoList) {
		this.ordAllocationPersonInfoList = ordAllocationPersonInfoList;
	}

	public Long getFollowId() {
		return followId;
	}

	public void setFollowId(Long followId) {
		this.followId = followId;
	}

}
