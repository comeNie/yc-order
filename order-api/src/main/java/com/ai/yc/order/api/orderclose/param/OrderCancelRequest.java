package com.ai.yc.order.api.orderclose.param;

import com.ai.opt.base.vo.BaseInfo;

public class OrderCancelRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID,必填
	 */
	private Long orderId;
	/**
	 * 原因描述
	 */
	private String reasonDesc;
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

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
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
