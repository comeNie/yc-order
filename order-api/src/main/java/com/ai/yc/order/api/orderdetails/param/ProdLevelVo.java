package com.ai.yc.order.api.orderdetails.param;

import java.io.Serializable;

/**
 * @Description: 翻译级别
 * @author hougang@asiainfo.com
 * @date 2016年11月4日 下午8:38:35 
 * @version V1.0
 */
public class ProdLevelVo implements Serializable{

	private static final long serialVersionUID = -6357481227056438113L;
	
	/**
	 * 100110：陪同翻译
     * 100120：交替传译
     * 100130：同声翻译
     * 100210：标准级
     * 100220：专业级
     * 100230：出版级
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
