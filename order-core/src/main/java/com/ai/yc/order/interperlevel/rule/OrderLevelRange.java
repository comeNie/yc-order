package com.ai.yc.order.interperlevel.rule;

public class OrderLevelRange {
	/**
	 * 订单级别范围 最小值
	 */
	private String minValue;
	/**
	 * 订单级别范围最大值
	 */
	private String maxValue;

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
}
