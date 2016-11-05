package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;

public class TranslateLevelInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 翻译级别
	 */
	private String translateLevel;
	/**
	 * 扩展信息 
	 */
	private String infoJson;

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}

	public String getInfoJson() {
		return infoJson;
	}

	public void setInfoJson(String infoJson) {
		this.infoJson = infoJson;
	}

}
