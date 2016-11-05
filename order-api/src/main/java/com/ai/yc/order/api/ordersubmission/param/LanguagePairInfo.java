package com.ai.yc.order.api.ordersubmission.param;

import java.io.Serializable;

public class LanguagePairInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 语言对编号
	 */
	private String languagePairId;
	/**
	 * 语言对名称
	 */
	private String languagePairName;
	/**
	 * 语言对名称英文
	 */
	private String languageNameEn;
	/**
	 * 扩展信息
	 */
	private String infoJson;

	public String getLanguageNameEn() {
		return languageNameEn;
	}

	public void setLanguageNameEn(String languageNameEn) {
		this.languageNameEn = languageNameEn;
	}

	public String getInfoJson() {
		return infoJson;
	}

	public void setInfoJson(String infoJson) {
		this.infoJson = infoJson;
	}

	public String getLanguagePairId() {
		return languagePairId;
	}

	public void setLanguagePairId(String languagePairId) {
		this.languagePairId = languagePairId;
	}

	public String getLanguagePairName() {
		return languagePairName;
	}

	public void setLanguagePairName(String languagePairName) {
		this.languagePairName = languagePairName;
	}
}
