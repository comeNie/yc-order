package com.ai.yc.order.api.orderquery.param;

import java.io.Serializable;

public class OrdProdLevelVo implements Serializable{
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
