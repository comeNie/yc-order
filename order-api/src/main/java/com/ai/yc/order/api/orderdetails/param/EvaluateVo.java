package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class EvaluateVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Long evaluateId;
	/**
	 * 评论等级
	 */
	private String evaluateSun;
	/**
	 * 服务质量
	 */
	private Long serveQuality;
	/**
	 * 服务速度
	 */
	private Long serveSpeed;
	/**
	 * 服务态度
	 */
	private Long serveManner;
	/**
	 * 评论内容
	 */
	private String evaluateContent;
	/**
	 * 评论时间
	 */
	private Timestamp evaluateTime;
	/**
	 * 评价状态
	 */
	private String state;
	/**
	 * 备注
	 */
	private String remark;

	public Long getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(Long evaluateId) {
		this.evaluateId = evaluateId;
	}

	public String getEvaluateSun() {
		return evaluateSun;
	}

	public void setEvaluateSun(String evaluateSun) {
		this.evaluateSun = evaluateSun;
	}

	public Long getServeQuality() {
		return serveQuality;
	}

	public void setServeQuality(Long serveQuality) {
		this.serveQuality = serveQuality;
	}

	public Long getServeSpeed() {
		return serveSpeed;
	}

	public void setServeSpeed(Long serveSpeed) {
		this.serveSpeed = serveSpeed;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
