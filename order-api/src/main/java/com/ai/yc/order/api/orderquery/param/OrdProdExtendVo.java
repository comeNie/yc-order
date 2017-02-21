package com.ai.yc.order.api.orderquery.param;

import java.io.Serializable;

public class OrdProdExtendVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 语言对ID
	 */
	private String langungePair;
	/**
	 * 语言对中文名称
	 */
	private String langungePairChName;
	/**
	 * 语言对英文名称
	 */
	private String langungePairEnName;

	public String getLangungePair() {
		return langungePair;
	}

	public void setLangungePair(String langungePair) {
		this.langungePair = langungePair;
	}

	public String getLangungePairChName() {
		return langungePairChName;
	}

	public void setLangungePairChName(String langungePairChName) {
		this.langungePairChName = langungePairChName;
	}

	public String getLangungePairEnName() {
		return langungePairEnName;
	}

	public void setLangungePairEnName(String langungePairEnName) {
		this.langungePairEnName = langungePairEnName;
	}

}
