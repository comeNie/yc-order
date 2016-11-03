package com.ai.yc.order.api.orderquery.param;

import java.io.Serializable;

public class OrdProdExtendVo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 语言对ID
	 */
	private String langungePair;
	/**
	 * 语言对名称
	 */
	private String langungePairName;

	public String getLangungePair() {
		return langungePair;
	}

	public void setLangungePair(String langungePair) {
		this.langungePair = langungePair;
	}

	public String getLangungePairName() {
		return langungePairName;
	}

	public void setLangungePairName(String langungePairName) {
		this.langungePairName = langungePairName;
	}

}
