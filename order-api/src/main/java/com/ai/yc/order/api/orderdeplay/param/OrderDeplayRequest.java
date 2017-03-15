package com.ai.yc.order.api.orderdeplay.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class OrderDeplayRequest extends BaseInfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 状态变化时间
	 */
	private Timestamp endChgTime;
	/**
	 * 操作工号,必填
	 */
	private String operId;
	/**
	 * 操作人员名称
	 */
	private String operName;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Timestamp getEndChgTime() {
		return endChgTime;
	}

	public void setEndChgTime(Timestamp endChgTime) {
		this.endChgTime = endChgTime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

}
