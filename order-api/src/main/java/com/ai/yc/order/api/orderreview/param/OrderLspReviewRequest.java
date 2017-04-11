package com.ai.yc.order.api.orderreview.param;

import com.ai.opt.base.vo.BaseInfo;

public class OrderLspReviewRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID，必填
	 */
	private Long orderId;
	/**
	 * 审核结果(41 已审核(通过),42 审核失败(不通过))
	 */
	private String state;
	/**
	 * 原因描述
	 */
	private String reasonDesc;
	/**
	 * 操作工号,必填
	 */
	private String operId;
	/**
	 * 操作名
	 */
	private String operName;


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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
