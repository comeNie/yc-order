package com.ai.yc.order.api.orderevaluation.param;

import java.io.Serializable;

public class OrdEvaluationRuleRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 质量
	 */
	private Integer serveQuality;
	/**
	 * 速度
	 */

	private Integer serveSpeen;
	/**
	 * 态度
	 */

	private Integer serveManner;

	public Integer getServeQuality() {
		return serveQuality;
	}

	public void setServeQuality(Integer serveQuality) {
		this.serveQuality = serveQuality;
	}

	public Integer getServeSpeen() {
		return serveSpeen;
	}

	public void setServeSpeen(Integer serveSpeen) {
		this.serveSpeen = serveSpeen;
	}

	public Integer getServeManner() {
		return serveManner;
	}

	public void setServeManner(Integer serveManner) {
		this.serveManner = serveManner;
	}

}
