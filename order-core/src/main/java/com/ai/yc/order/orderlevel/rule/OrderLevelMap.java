package com.ai.yc.order.orderlevel.rule;

import java.util.Map;

public class OrderLevelMap {
	/**
	 * 订单级别分类
	 */
	private Map<String, String> orderLevelMap;
	/**
	 * 价格区间map 
	 * 0~99
	 * 100~499
	 * 500~1999
	 * 2000+
	 */
	private Map<String, OrderLevelPrice> orderLevelPriceMap;
	
	public Map<String, OrderLevelPrice> getOrderLevelPriceMap() {
		return orderLevelPriceMap;
	}

	public void setOrderLevelPriceMap(Map<String, OrderLevelPrice> orderLevelPriceMap) {
		this.orderLevelPriceMap = orderLevelPriceMap;
	}

	public Map<String, String> getOrderLevelMap() {
		return orderLevelMap;
	}

	public void setOrderLevelMap(Map<String, String> orderLevelMap) {
		this.orderLevelMap = orderLevelMap;
	}

}
