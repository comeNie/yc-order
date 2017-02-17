package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderEvaluationExtendInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 评论等级 评价信息 evaluateSun
	/**
	 * 服务质量 评价信息
	 */
	private Long serveQuality;
	/**
	 * 服务速度 评价信息
	 */
	private Long serveSpeen;
	/**
	 * 服务态度 评价信息
	 */
	private Long serveManner;
	/**
	 * 评论内容 评价信息
	 */
	private String evaluateContent;
	/**
	 * 状态 评价信息
	 */
	private String state;
	/**
	 * 评论时间 评价信息
	 */
	private Timestamp evaluateTime;
	/**
	 * 备注 评价信息
	 */
	private String remark;

	public Long getServeQuality() {
		return serveQuality;
	}

	public void setServeQuality(Long serveQuality) {
		this.serveQuality = serveQuality;
	}

	public Long getServeSpeen() {
		return serveSpeen;
	}

	public void setServeSpeen(Long serveSpeen) {
		this.serveSpeen = serveSpeen;
	}

	public Long getServeManner() {
		return serveManner;
	}

	public void setServeManner(Long serveManner) {
		this.serveManner = serveManner;
	}

	public String getEvaluateContent() {
		return evaluateContent;
	}

	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
