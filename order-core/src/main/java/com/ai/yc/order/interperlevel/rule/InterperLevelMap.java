package com.ai.yc.order.interperlevel.rule;

import java.util.Map;
/**
 * 译员级别map
 * @author zhangzd
 *
 */
public class InterperLevelMap {
	private Map<String, OrderLevelRange> interperLevelMap;

	public Map<String, OrderLevelRange> getInterperLevelMap() {
		return interperLevelMap;
	}

	public void setInterperLevelMap(Map<String, OrderLevelRange> interperLevelMap) {
		this.interperLevelMap = interperLevelMap;
	}

}
