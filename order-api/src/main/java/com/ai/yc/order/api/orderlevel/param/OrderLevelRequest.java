package com.ai.yc.order.api.orderlevel.param;

import java.io.Serializable;

public class OrderLevelRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 总费用
	 */
	private Integer totalFee;
	/**
	 * 翻译级别
	 */
	private String translateLevel;
	/**
	 * 翻译类型
	 */
	private String translateType;
	/**
	 * 是否加急
	 */
	private String isUrgent;

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}

	public String getTranslateType() {
		return translateType;
	}

	public void setTranslateType(String translateType) {
		this.translateType = translateType;
	}

	public String getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(String isUrgent) {
		this.isUrgent = isUrgent;
	}

}
