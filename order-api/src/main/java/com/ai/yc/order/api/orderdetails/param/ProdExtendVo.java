package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;

/**
 * @Description:语言对
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:34:23 
 * @version V1.0
 */
public class ProdExtendVo implements Serializable {
	
	private static final long serialVersionUID = -4673019765882755432L;

	/**
	 * 语言对ID
	 */
	private String langungePair;
	
	/**
	 * 中文名称
	 */
	private String langungePairName;
	
	/**
	 * 英文名称
	 */
	private String langungeNameEn;
	
	/**
	 * 扩展信息
	 */
	private String infoJson;

	public String getLangungePair() {
		return langungePair;
	}

	public void setLangungePair(String langungePair) {
		this.langungePair = langungePair;
	}

	public String getInfoJson() {
		return infoJson;
	}

	public void setInfoJson(String infoJson) {
		this.infoJson = infoJson;
	}

	public String getLangungePairName() {
		return langungePairName;
	}

	public void setLangungePairName(String langungePairName) {
		this.langungePairName = langungePairName;
	}

	public String getLangungeNameEn() {
		return langungeNameEn;
	}

	public void setLangungeNameEn(String langungeNameEn) {
		this.langungeNameEn = langungeNameEn;
	}
	
	

}
