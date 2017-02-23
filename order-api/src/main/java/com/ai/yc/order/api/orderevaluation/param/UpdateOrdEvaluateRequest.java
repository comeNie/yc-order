package com.ai.yc.order.api.orderevaluation.param;

import com.ai.opt.base.vo.BaseInfo;

public class UpdateOrdEvaluateRequest extends BaseInfo{
	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 业务评价ID
	 */
	private Long evaluateId;
	/**
	 * 状态
	 */

	private String state;
	/**
	 * 评论等级
	 */
	private String evaluateSun;
	/**
	 * 评论内容
	 */
	private String evaluateContent;
	/**
	 * 备注
	 */
	private String remark;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(Long evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEvaluateSun() {
		return evaluateSun;
	}

	public void setEvaluateSun(String evaluateSun) {
		this.evaluateSun = evaluateSun;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
