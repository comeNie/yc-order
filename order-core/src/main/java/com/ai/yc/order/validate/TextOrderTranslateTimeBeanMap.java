package com.ai.yc.order.validate;

import java.util.Map;

public class TextOrderTranslateTimeBeanMap {
	/**
	 * 翻译级别 map
	 */
	private Map<String, TextOrderTranslateTimeBean> translateLevelMap;

	public Map<String, TextOrderTranslateTimeBean> getTranslateLevelMap() {
		return translateLevelMap;
	}

	public void setTranslateLevelMap(Map<String, TextOrderTranslateTimeBean> translateLevelMap) {
		this.translateLevelMap = translateLevelMap;
	}

}
