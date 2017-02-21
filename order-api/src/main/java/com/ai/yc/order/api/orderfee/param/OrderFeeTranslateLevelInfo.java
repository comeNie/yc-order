package com.ai.yc.order.api.orderfee.param;

import java.io.Serializable;

public class OrderFeeTranslateLevelInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 翻译级别
	 */
	private String translateLevel;

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}
}
