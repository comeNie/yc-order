package com.ai.yc.order.api.orderevaluation.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

public class QueryOrdEvaluteResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 评论等级
	 */
	private String evaluateSun;
	/**
	 * 服务质量
	 */
	private String serveQuality;
	/**
	 * 服务速度
	 */
	private String serveSpeed;
	/**
	 * 服务态度
	 */
	private String serveManner;
	/**
	 * 评论内容
	 */
	private String evaluateContent;
	/**
	 * 评论时间
	 */
	private Timestamp evaluateTime;
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

	public String getEvaluateSun() {
		return evaluateSun;
	}

	public void setEvaluateSun(String evaluateSun) {
		this.evaluateSun = evaluateSun;
	}

	public String getServeQuality() {
		return serveQuality;
	}

	public void setServeQuality(String serveQuality) {
		this.serveQuality = serveQuality;
	}

	public String getServeSpeed() {
		return serveSpeed;
	}

	public void setServeSpeed(String serveSpeed) {
		this.serveSpeed = serveSpeed;
	}

	public String getServeManner() {
		return serveManner;
	}

	public void setServeManner(String serveManner) {
		this.serveManner = serveManner;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public Timestamp getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Timestamp evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
