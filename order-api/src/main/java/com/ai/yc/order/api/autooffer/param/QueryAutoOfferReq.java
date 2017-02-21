package com.ai.yc.order.api.autooffer.param;

import java.io.Serializable;

/**
 * @author hougang@asiainfo.com
 * @date 2016年11月2日 下午1:49:36 
 * @version V1.0
 */
public class QueryAutoOfferReq implements Serializable{
	
	private static final long serialVersionUID = -6127403387982254076L;
	
	public final static String LANGUAGE_ZH_CN = "zh_CN";
	
	public final static String LANGUAGE_US_EN = "us_EN";
	
	/**
	 * 标准级
	 */
	public final static String STANDARD = "100210";
	
	/**
	 * 专业级
	 */
	public final static String PERFESSION = "100220";
	
	/**
	 * 出版集
	 */
	public final static String PUBLISH = "100230";
	
	/**
	 * 语言zh_CN us_EN
	 */
	private String language;

	/**
	 * 字数(必填)
	 */
	private int wordNum;
	
	/**
	 * 语言对ID(必填)
	 */
	private String duadId;
	
	/**
	 * 用途ID(必填)
	 */
	private String purposeId;
	
	 /**
	  * 翻译级别(必填)
      * 100210：标准级
      * 100220：专业级
      * 100230：出版级
	 */
	private String translateLevel;
	
	/**
	 * 是否加急(必填)
	 */
	private boolean isUrgent;

	public int getWordNum() {
		return wordNum;
	}

	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

	public String getDuadId() {
		return duadId;
	}

	public void setDuadId(String duadId) {
		this.duadId = duadId;
	}

	public String getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(String purposeId) {
		this.purposeId = purposeId;
	}

	public String getTranslateLevel() {
		return translateLevel;
	}

	public void setTranslateLevel(String translateLevel) {
		this.translateLevel = translateLevel;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}
