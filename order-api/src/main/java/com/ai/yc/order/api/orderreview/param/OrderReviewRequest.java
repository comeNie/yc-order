package com.ai.yc.order.api.orderreview.param;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class OrderReviewRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID，必填
	 */
	private List<Long> orderIdList;
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

	public List<Long> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<Long> orderIdList) {
		this.orderIdList = orderIdList;
	}

}
